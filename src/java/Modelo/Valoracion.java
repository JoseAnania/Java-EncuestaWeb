
package Modelo;

public class Valoracion {
   
    private int idV;
    private int detalle;

    public int getIdV() {
        return idV;
    }

    public void setIdV(int idV) {
        this.idV = idV;
    }

    public int getDetalle() {
        return detalle;
    }

    public void setDetalle(int detalle) {
        this.detalle = detalle;
    }

    public Valoracion() {
    }

    public Valoracion(int idV, int detalle) {
        this.idV = idV;
        this.detalle = detalle;
    }
    
}
