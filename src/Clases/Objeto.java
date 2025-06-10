package Clases;

public class Objeto {

    private String tipo;
    private String icon;
    private Posicion posicion;
    private String mensajeInstruccion;
    private String mensajeFinalizacion;

    //Constructor:
    public Objeto(String tipo, String icon, String mensajeInstruccion, String mensajeFinalizacion) {
        this.tipo = tipo;
        this.icon = icon;
        this.mensajeInstruccion = mensajeInstruccion;
        this.mensajeFinalizacion = mensajeFinalizacion;
    }

    //Getters & Setters:
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public Posicion getPosicion() {
        return posicion;
    }
    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }
    public String getIcon() {
        return icon;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }
    public String getMensajeInstruccion() {
        return mensajeInstruccion;
    }
    public void setMensajeInstruccion(String mensajeInstruccion) {
        this.mensajeInstruccion = mensajeInstruccion;
    }
    public String getMensajeFinalizacion() {
        return mensajeFinalizacion;
    }
    public void setMensajeFinalizacion(String mensajeFinalizacion) {
        this.mensajeFinalizacion = mensajeFinalizacion;
    }

    //Methods:
    public Objeto recogerObjeto() {
        this.posicion = null;
        return this;
    }
}
