package Clases;

public class Mapa {

    private int filas;
    private int columnas;
    private char[][] matriz;

    private Snake snake;
    private Guardia[] guardias;
    private Objeto[] objetos;

    public Mapa(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.matriz = new char[filas][columnas];
        inicializarMapa();
    }

    private void inicializarMapa() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = '.';
            }
        }
    }

    public void actualizarMapa() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (snake.getPosicion().getX() == i && snake.getPosicion().getY() == j) {
                    System.out.print("S ");
                    continue;
                }
                if (guardias != null && hayGuardiaEnPosicion(i, j)) {
                    System.out.print("G ");
                    continue;
                }
                String iconoObjeto = objetos != null ? hayObjetoEnPosicion(i, j) : null;
                if (iconoObjeto != null) {
                    System.out.print(iconoObjeto + " ");
                    continue;
                }
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    private Boolean hayGuardiaEnPosicion(int x, int y) {
        for (Guardia guardia : guardias) {
            if (guardia.getPosicion().getX() == x && guardia.getPosicion().getY() == y) {
                return true;
            }
        }
        return false;
    }

    private String hayObjetoEnPosicion(int x, int y) {
        for (Objeto objeto : objetos) {
            if (objeto.getPosicion().getX() == x && objeto.getPosicion().getY() == y) {
                return objeto.getIcon();
            }
        }
        return null;
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

    //Getters y Setters
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
    public Objeto[] getObjetos() {
        return objetos;
    }
    public void setObjetos(Objeto[] objetos) {
        this.objetos = objetos;
    }
}
