package Clases;

public class Posicion {

    private int x, y;

    public Posicion(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public void mover(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }
}
