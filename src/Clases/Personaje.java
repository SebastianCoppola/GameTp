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
}
