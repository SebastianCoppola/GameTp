package Clases;

public class Guardia extends Personaje implements Enemigo {
    public Guardia(Posicion posicion) {
        super(posicion);
    }

    @Override
    public void patrullar(Mapa mapa) {
        String[] direcciones = {"a", "w", "s", "d"};
        String direccionAleatoria = direcciones[(int) (Math.random() * direcciones.length)];
        moverPersonaje(direccionAleatoria, mapa);
    }

    @Override
    public boolean atrapar(Posicion snake) {
        return this.getPosicion().isSeparacionIgualA1(snake);
    }

    @Override
    public void atacar(Snake jugador) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}
