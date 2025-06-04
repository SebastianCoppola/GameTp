package Clases;

public class Mapa {

    private int filas;
    private int columnas;
    private char[][] matriz;

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

    public void mostrar(Snake snake) {
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
