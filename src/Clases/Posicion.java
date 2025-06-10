package Clases;

public class Posicion {

    private int x, y;

    //Contructor:
    public Posicion(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //Getters:
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    //Methods:
    public void mover(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public Boolean esSeparacionInicialCorrecta(Posicion posicion){
        int distancia = Math.abs(posicion.getX() - x) + Math.abs(posicion.getY() - y);
        return (distancia >= 2);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Posicion posicion = (Posicion) obj;
        return x == posicion.x && y == posicion.y;
    }

    @Override
    public int hashCode() {
        return 31 * x + y;
    }
}
