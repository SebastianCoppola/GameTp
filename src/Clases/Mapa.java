package Clases;

import java.util.Random;

public class Mapa {

    private int filas;
    private int columnas;
    private String[][] matriz;
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
        this.matriz = new String[filas][columnas];
        inicializarMapa();
    }

    //Methods:
    /**
     * Inicializa el mapa.
     *
     */
    private void inicializarMapa() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = ".";
            }
        }
    }

    /**
     * Imprimer el mapa en pantalla.
     *
     */
    public void actualizarMapa() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                Posicion tempPosition = new Posicion(i, j);
                if (tempPosition.equals(snake.getPosicion())) {
                    System.out.print("S ");
                    continue;
                }
                if (tempPosition.equals(objeto.getPosicion())) {
                    System.out.print(objeto.getIcon());
                    continue;
                }
                if(hayGuardiaEnPosicion(tempPosition)){
                    System.out.print("G ");
                    continue;
                }
                System.out.print(matriz[i][j] + " ");
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
    private Boolean hayGuardiaEnPosicion(Posicion posicion){
        for (Guardia guardia : guardias) {
            if (posicion.equals(guardia.getPosicion())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Genera una nueva pocision separada por al menos dos casillas de las anteriores.
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
        if (snake != null && !pos.esSeparacionInicialCorrecta(snake.getPosicion())) {
            return false;
        }
        if (objeto != null && !pos.esSeparacionInicialCorrecta(objeto.getPosicion())) {
            return false;
        }
        if (guardias != null) {
            for (Guardia guardia : guardias) {
                if (!pos.esSeparacionInicialCorrecta(guardia.getPosicion())) {
                    return false;
                }
            }
        }
        return true;
    }

    public void mostrar(Personaje snake) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (i == snake.getPosicion().getX() && j == snake.getPosicion().getY()) {
                    System.out.print("S ");
                } else {
                    System.out.print(matriz[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public void mostrar(Objeto objeto) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (i == objeto.getPosicion().getX() && j == objeto.getPosicion().getY()) {
                    System.out.print("S ");
                } else {
                    System.out.print(matriz[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public void moverSnake(Snake snake, char direccion) {
        int dx = 0, dy = 0;
        switch (direccion) {
            case 'w': dx = -1; break;
            case 's': dx = 1; break;
            case 'a': dy = -1; break;
            case 'd': dy = 1; break;
            default:
                System.out.println("Dirección inválida.");
                return;
        }

        int nuevaX = snake.getPosicion().getX() + dx;
        int nuevaY = snake.getPosicion().getY() + dy;

        if (nuevaX >= 0 && nuevaX < filas && nuevaY >= 0 && nuevaY < columnas) {
            snake.getPosicion().mover(dx, dy);
        } else {
            System.out.println("Movimiento inválido: fuera del mapa.");
        }
    }
}
