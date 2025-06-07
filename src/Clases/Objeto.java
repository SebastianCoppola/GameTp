package Clases;

public class Objeto {

    private String tipo;
    private String icon;
    private Posicion posicion;

    public Objeto(String tipo, String icon, Posicion posicion) {
        this.tipo = tipo;
        this.icon = icon;
        this.posicion = posicion;
    }

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

    private Objeto recogerObjeto() {
        this.posicion = null;
        return this;
    }
}
