package Clases;

public interface Enemigo {
    void patrullar(Mapa mapa);
    boolean atrapar(Posicion snake);
    void atacar(Snake jugador);
}
