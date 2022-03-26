
package Controlador;

import Modelo.Respuesta;
import Modelo.Valoracion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Conexion {
    
    private Connection con;
    private PreparedStatement PS;
    private Statement S;
    private ResultSet RS;

    public void abrirConexion() {
        try {
            String url = "jdbc:sqlserver://DESKTOP-E8FRIUV\\SQLEXPRESS:1433;databaseName=Encuesta";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            con = DriverManager.getConnection(url, "sa", "giandjoe");
            System.out.println("Conexión a la BD");
        } catch (Exception e) {
            System.out.println("Error en la conexión: " + e.getMessage());
        }
    }

    public void cerrarConexion() {
        try {
            con.close();
            System.out.println("Conexión a la BD cerrada");
        } catch (Exception e) {
            System.out.println("Error al cerrar la conexión:" + e.getMessage());
        }
    }
    
    public void agregarRespuesta(Respuesta nuevaRespuesta)
    {
        try {
            abrirConexion();
            PS=con.prepareStatement("INSERT INTO Respuesta (nombre, idValor, opinion) VALUES (?,?,?)");
            
            PS.setString(1, nuevaRespuesta.getNombre());
            PS.setInt(2, nuevaRespuesta.getIdV());
            PS.setString(3, nuevaRespuesta.getOpinion());
            
            PS.execute();
            PS.close();
            cerrarConexion();
            
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Valoracion>llenarCombo()
    {
        ArrayList<Valoracion>lista=new ArrayList<>();
        
        try {
            abrirConexion();
            S=con.createStatement();
            RS=S.executeQuery("SELECT * FROM Valoracion");
            
            while(RS.next())
            {
                Valoracion V=new Valoracion();
                
                V.setIdV(RS.getInt(1));
                V.setDetalle(RS.getInt(2));
                
                lista.add(V);
            }
            
            RS.close();
            S.close();
            cerrarConexion();
            
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
    
    public ArrayList<Respuesta>llenarTabla()
    {
        ArrayList<Respuesta>lista=new ArrayList<>();
        
        try {
            abrirConexion();
            S=con.createStatement();
            RS=S.executeQuery("SELECT * FROM Respuesta ORDER BY idValor DESC");
            
            while(RS.next())
            {
                Respuesta R=new Respuesta();
                
                R.setIdR(RS.getInt(1));
                R.setNombre(RS.getString(2));
                R.setIdV(RS.getInt(3));
                R.setOpinion(RS.getString(4));
                
                lista.add(R);
            }
            
            RS.close();
            S.close();
            cerrarConexion();
        } catch (Exception e) {
        }
        return lista;
    }
    
    public  int Reporte1()
    {
        int cantidad=0;
        
        try {
            abrirConexion();           
            S=con.createStatement();
            RS=S.executeQuery("SELECT COUNT(idValor) FROM Respuesta WHERE (idValor=1)or(idValor=2)or(idValor=3)");
            
            RS.next();
            
            cantidad=RS.getInt(1);
            
            RS.close();
            S.close();
            cerrarConexion();
        } catch (Exception e) {
        }
        return cantidad;
    }
    public  int Reporte2()
    {
        int cantidad=0;
        
        try {
            abrirConexion();           
            S=con.createStatement();
            RS=S.executeQuery("SELECT COUNT(idValor) FROM Respuesta WHERE (idValor=5)");
            
            RS.next();
            
            cantidad=RS.getInt(1);
            
            RS.close();
            S.close();
            cerrarConexion();
        } catch (Exception e) {
        }
        return cantidad;
    }
    
    public ArrayList<Respuesta>Reporte3()
    {
        ArrayList<Respuesta>lista=new ArrayList<>();
        
        try {
            abrirConexion();
            S=con.createStatement();
            RS=S.executeQuery("SELECT idRespuesta, nombre, idValor FROM Respuesta WHERE opinion=''");
            
            while(RS.next())
            {
                Respuesta R=new Respuesta();
                
                R.setIdR(RS.getInt(1));
                R.setNombre(RS.getString(2));
                R.setIdV(RS.getInt(3));
                
                lista.add(R);
            }
            
            RS.close();
            S.close();
            cerrarConexion();
            
        } catch (Exception e) {
        }
        return lista;
    }
}
