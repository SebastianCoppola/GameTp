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

    /**
     * Asigna nuevos valores a la posición.
     *
     * @param x con la cantidad a sumar a x.
     * @param y con la cantidad a sumar a y.
     */
    public void mover(int x, int y) {
        this.x += x;
        this.y += y;
    }

    /**
     * Evalua si una posición está a más de dos celdas de distancia de this.
     *
     * @param posicion con la posicion a evaluar.
     * @return Boolean true/false segun corresponda.
     */
    public Boolean isSeparacionInicialCorrecta(Posicion posicion){
        int distancia = Math.abs(posicion.getX() - x) + Math.abs(posicion.getY() - y);
        return (distancia >= 2);
    }

    /**
     * Evalua si una posición está a una celda de distancia de this.
     *
     * @param posicion con la posicion a evaluar.
     * @return Boolean true/false segun corresponda.
     */
    public Boolean isSeparacionIgualA1(Posicion posicion){
        int dx = Math.abs(posicion.getX() - x);
        int dy = Math.abs(posicion.getY() - y);
        return (dx == 0 && dy == 1) || (dx == 1 && dy == 0);
    }

    /**
     * Evalua si una posición está a por lo menos 3 celdas de distancia de this.
     *
     * @param posicion con la posicion a evaluar.
     * @return Boolean true/false segun corresponda.
     */
    public Boolean isSeparacionMenorA3(Posicion posicion){
        int dx = Math.abs(posicion.getX() - x);
        int dy = Math.abs(posicion.getY() - y);
        return (dx < 3 && dy == 0) || (dx == 0 && dy < 3);
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
