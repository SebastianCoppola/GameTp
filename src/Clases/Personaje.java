package Clases;

public abstract class Personaje {

    protected Posicion posicion;

    public Personaje(Posicion posicion) {
        this.posicion = posicion;
    }

    public Posicion getPosicion() {
        return posicion;
    }
}
