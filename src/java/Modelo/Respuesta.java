
package Modelo;

public class Respuesta {
    
    private int idR;
    private String nombre;
    private  int idV;
    private String opinion;

    public int getIdR() {
        return idR;
    }

    public void setIdR(int idR) {
        this.idR = idR;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdV() {
        return idV;
    }

    public void setIdV(int idV) {
        this.idV = idV;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public Respuesta() {
    }

    public Respuesta(int idR, String nombre, int idV, String opinion) {
        this.idR = idR;
        this.nombre = nombre;
        this.idV = idV;
        this.opinion = opinion;
    }
    
}
