package Clases;

public interface Enemigo {

    void patrullar(Mapa mapa);

    boolean puedeAtrapar(Posicion snake);

    void atacar(Snake jugador);
}
