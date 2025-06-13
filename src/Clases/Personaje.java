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
        if (hp < 0) {
            hp = 0;
        }
    }

    public void moverPersonaje(String direccion, Mapa mapa) {
        int dx = 0, dy = 0;

        switch (direccion) {
            case "w":
                dx = -1;
                break;
            case "s":
                dx = 1;
                break;
            case "a":
                dy = -1;
                break;
            case "d":
                dy = 1;
                break;
            default:
                System.out.println("Dirección inválida.");
                return;
        }

        int nuevaX = this.getPosicion().getX() + dx;
        int nuevaY = this.getPosicion().getY() + dy;

        if (nuevaX >= 0 && nuevaX < mapa.getFilas() && nuevaY >= 0 && nuevaY < mapa.getColumnas()) {
            this.getPosicion().mover(dx, dy);
        }
    }

    public boolean moverSiPosicionLibre(String direccion, Mapa mapa) {
        int dx = 0, dy = 0;

        switch (direccion) {
            case "w":
                dx = -1;
                break;
            case "s":
                dx = 1;
                break;
            case "a":
                dy = -1;
                break;
            case "d":
                dy = 1;
                break;
            default:
                System.out.println("Dirección inválida.");
                return false;
        }

        int nuevaX = this.getPosicion().getX() + dx;
        int nuevaY = this.getPosicion().getY() + dy;

        if (nuevaX >= 0 && nuevaX < mapa.getFilas() && nuevaY >= 0 && nuevaY < mapa.getColumnas()) {
            Posicion nuevaPos = new Posicion(nuevaX, nuevaY);
            if (!mapa.celdaEstaOcupada(nuevaPos, this)) {
                this.getPosicion().mover(dx, dy);
                return true;
            }
        }
        return false;
    }

    public int extremoMapa(Posicion posicion, int numeroMision) {
        int limite = (numeroMision == 1) ? 6 : 8;
        int x = posicion.getX();
        int y = posicion.getY();

        if (y == 0 && x == 0) {
            return 0;
        } else if (y == 0 && x == limite) {
            return 1;
        } else if (x == 0 && y == limite) {
            return 2;
        } else if (y == limite && x == limite) {
            return 3;
        } else if (y == 0) {
            return 4;
        } else if (y == limite) {
            return 5;
        } else if (x == 0) {
            return 6;
        } else if (x == limite) {
            return 7;
        }
        return -1;
    }
}
