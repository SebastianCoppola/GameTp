package Clases;

public interface Enemigo {

    void patrullar(Mapa mapa);

    boolean atrapado(Posicion snake);

    void atacar(Snake jugador);
}
