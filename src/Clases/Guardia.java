package Clases;

public class Guardia extends Personaje implements Enemigo {

    public Guardia(Posicion posicion) {
        super(posicion);
    }

    @Override
    public void patrullar(Mapa mapa) {
        String[] direcciones = {"a", "w", "s", "d"};

        for (int i = 0; i < 10; i++) {
            String direccion = direcciones[(int) (Math.random() * direcciones.length)];
            if (this.moverSiPosicionLibre(direccion, mapa)) {
                break;
            }
        }
    }

    @Override
    public boolean atrapado(Posicion snake) {
        return this.getPosicion().isSeparacionIgualA1(snake);
    }

    @Override
    public void atacar(Snake jugador) {
        // No puede patrullar
    }

}
