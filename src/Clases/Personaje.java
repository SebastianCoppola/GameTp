package Clases;

public abstract class Personaje {

    protected Posicion posicion;
    protected int hp = 100;

    public Personaje(Posicion posicion) {
        this.posicion = posicion;
    }

    public Posicion getPosicion() {
        return posicion;
    }
    
    public int getHp() {
        return hp;
    }
    
    public int setHp(int hp) {
        this.hp = hp;
        return hp;
    }

    public boolean estaVivo() {
        return hp > 0;
    }

    public void recibirDanio(int danio) {
        hp -= danio;
        if (hp < 0) hp = 0;
    }

    public void moverPersonaje(char direccion, Mapa mapa) {
        int dx = 0, dy = 0;
        switch (direccion) {
            case 'w': dx = -1; break;
            case 's': dx = 1; break;
            case 'a': dy = -1; break;
            case 'd': dy = 1; break;
            default:
                return;
        }
        int nuevaX = this.getPosicion().getX() + dx;
        int nuevaY = this.getPosicion().getY() + dy;
        if (nuevaX >= 0 && nuevaX < mapa.getFilas() && nuevaY >= 0 && nuevaY < mapa.getColumnas()) {
            this.getPosicion().mover(dx, dy);
        }
    }

    public void moverAleatorio(Mapa mapa) {
        char[] direcciones = {'a', 'w', 's', 'd'};
        char direccionAleatoria = direcciones[(int)(Math.random() * direcciones.length)];
        moverPersonaje(direccionAleatoria , mapa);
    }
}
