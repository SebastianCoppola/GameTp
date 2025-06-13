package Clases;

import java.util.Random;

public class Mapa {

    private int filas;
    private int columnas;
    private Celda[][] tablero;
    private Snake snake;
    private Guardia[] guardias;
    private Objeto objeto;

    //Getters y Setters:
    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public Guardia[] getGuardias() {
        return guardias;
    }

    public void setGuardias(Guardia[] guardias) {
        this.guardias = guardias;
    }

    public Objeto getObjeto() {
        return objeto;
    }

    public void setObjeto(Objeto objeto) {
        this.objeto = objeto;
    }

    //Constructor:
    public Mapa(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.tablero = new Celda[filas][columnas];
    }

    /**
     * Actualiza e imprimr el mapa por consola.
     */
    public void mostrarMapa() {
        updateMapa();
        printMapa();
    }

    /**
     * Actualiza las posiciones del mapa.
     */
    private void updateMapa() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                Posicion tempPosition = new Posicion(i, j);
                if (tempPosition.equals(snake.getPosicion())) {
                    tablero[i][j] = new Celda("S ");
                    continue;
                }
                if (tempPosition.equals(objeto.getPosicion())) {
                    tablero[i][j] = new Celda(objeto.getIcon());
                    continue;
                }
                if (hayGuardiaEnPosicion(tempPosition)) {
                    tablero[i][j] = new Celda("G ");
                    continue;
                }
                tablero[i][j] = new Celda(". ");
            }

        }
    }

    /**
     * Imprimer el mapa.
     */
    private void printMapa() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(tablero[i][j].getItem());
            }
            System.out.println();
        }
    }

    /**
     * Devuelve true si hay guardia en la posición solicitada.
     *
     * @param posicion solicitada.
     * @return Boolean true/false segun la posicion de los guardias.
     */
    private Boolean hayGuardiaEnPosicion(Posicion posicion) {
        for (Guardia guardia : guardias) {
            if (posicion.equals(guardia.getPosicion())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Genera una nueva pocision separada por al menos dos casillas de las
     * anteriores.
     *
     * @return Posicion con una nueva posición válida.
     */
    public Posicion generarPosicionAleatoria() {
        Random rand = new Random();
        Posicion nuevaPosicion;
        do {
            int x = rand.nextInt(filas);
            int y = rand.nextInt(columnas);
            nuevaPosicion = new Posicion(x, y);
        } while (!esPosicionValida(nuevaPosicion));
        return nuevaPosicion;
    }

    /**
     * Compara la posicion solicitada con los personajes y objetos del mapa.
     *
     * @param pos con la posición a comparar.
     * @return Boolean true/false si la posición es válida.
     */
    private boolean esPosicionValida(Posicion pos) {
        if (snake != null && !pos.isSeparacionInicialCorrecta(snake.getPosicion())) {
            return false;
        }
        if (objeto != null && !pos.isSeparacionInicialCorrecta(objeto.getPosicion())) {
            return false;
        }
        if (guardias != null) {
            for (Guardia guardia : guardias) {
                if (!pos.isSeparacionInicialCorrecta(guardia.getPosicion())) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean celdaEstaOcupada(Posicion pos, Personaje personaje) {
        if (objeto != null && pos.equals(objeto.getPosicion())) {
            return true;
        }

        if (snake != null && pos.equals(snake.getPosicion())) {
            return true;
        }

        if (guardias != null) {
            for (Guardia guardia : guardias) {
                if (!guardia.equals(personaje) && pos.equals(guardia.getPosicion())) {
                    return true;
                }
            }
        }

        return false;
    }

}
