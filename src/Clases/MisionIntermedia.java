package Clases;

import java.util.Scanner;

public class MisionIntermedia extends Mision {

    public MisionIntermedia(Integer numero) {
        this.numero = numero;
        this.nombre = "Misión " + numero;
        this.descripcion = "Mueve a Snake por el mapa.";
    }

    @Override
    public void iniciar() {
        //Defino valores según misión:
        int numeroMision = this.numero;
        int filasColumnas = numeroMision == 1 ? 7 : 9;
        int cantidadGuardias = numeroMision == 1 ? 1 : 2;
        Objeto objeto1;
        Objeto objeto2;
        if(numeroMision == 1){
            objeto1 = new Objeto("Llave", "L", null);
            objeto2 =  new Objeto("Puerta", "H", null);
        }else{
            objeto1 = new Objeto("Explosivo C4", "C4", new Posicion(1, 1));
            objeto2 = new Objeto("Salida", "P", new Posicion(6, 6));
        }
        //Creo el mapa:
        Mapa mapa = new Mapa(filasColumnas, filasColumnas);
        //Creo a Snake:
        Snake snake = new Snake(new Posicion(3, 3));
        mapa.setSnake(snake);
        //Creo los guardias:
        Guardia[] guardias = new Guardia[cantidadGuardias];
        for (int i = 0; i < cantidadGuardias; i++) {
            Guardia guardia = new Guardia(new Posicion(5, 5));
            guardias[i] = guardia;
        }
        mapa.setGuardias(guardias);
        //Creo los objetos:
        Objeto[] objetos = new Objeto[2];
        objeto1.setPosicion(new Posicion(1, 1));
        objeto2.setPosicion(new Posicion(6, 6));
        objetos[0] = objeto1;
        objetos[1] = objeto2;
        mapa.setObjetos(objetos);
        //Creo el mensaje:
        String mensaje = "Busca el objeto: " + objeto1.getTipo() + " " + objeto1.getIcon();
        //Inicio la misión:
        Scanner scanner = new Scanner(System.in);
        while (true) {
            mapa.actualizarMapa();
            System.out.println(mensaje);
            System.out.println("Mover (w/a/s/d, x para salir): ");
            String input = scanner.nextLine().trim();
            if (input.length() != 1) {
                System.out.println("Entrada inválida. Ingresá solo una letra.");
                continue;
            }
            if (input.equals("x")) {
                break;
            }
            snake.moverPersonaje(input, mapa);
            for (Guardia g : guardias) {
                g.moverAleatorio(mapa);
            }
            if (snakeFueAtrapadoPorGuardia(snake, guardias)) {
                mapa.actualizarMapa();
                System.out.println("¡Snake ha sido atrapado por un guardia!");
                System.out.println("Fin de la misión.");
                break;
            }
            if (objeto1 != null && snakeConsiguioObjeto(snake, objeto1)) {
                System.out.println("¡Snake ha conseguido un objeto: " + objeto1.getTipo() + "!");
                mensaje = "¡Ahora dirigete a la puerta H !";
                Objeto[] tempObjetos = new Objeto[1];
                tempObjetos[0] = objeto2;
                mapa.setObjetos(tempObjetos);
                objeto1 = null;
            }
            if (objeto1 == null && snakeConsiguioObjeto(snake, objeto2)) {
                System.out.println("¡Snake ha encontrado la puerta! Misión completada.");
                Menu menuIntermedio = new Menu(1);
                menuIntermedio.mostrarMenu();
                break;
            }
        }
    }

    /**
     * Método apra validar si la pocisión de Snake coincide con la de algún guardia.
     * @param snake con la pocisión a comparar.
     * @param guardias listado de guardias.
     * @return Boolean true/false si la posición coincide.
     */
    private Boolean snakeFueAtrapadoPorGuardia(Snake snake, Guardia[] guardias) {
        int xSnake = snake.getPosicion().getX();
        int ySnake = snake.getPosicion().getY();
        for (Guardia guardia : guardias) {
            int xGuardia = guardia.getPosicion().getX();
            int yGuardia = guardia.getPosicion().getY();
            int dx = xGuardia - xSnake;
            int dy = yGuardia - ySnake;
            if((dx == 0 && dy == 1) || (dx == 1 && dy == 0) || (dx == 0 && dy == 0) ){
                return true;
            }
        }
        return false;
    }

    /**
     * Método apra validar si la pocisión de Snake coincide con la de un objeto.
     * @param snake con la posición a comparar.
     * @param objeto con la posición a comparar.
     * @return Boolean true/false si la posición coincide.
     */
    private Boolean snakeConsiguioObjeto(Snake snake, Objeto objeto) {
        int xSnake = snake.getPosicion().getX();
        int ySnake = snake.getPosicion().getY();
        int xObjeto = objeto.getPosicion().getX();
        int yObjeto = objeto.getPosicion().getY();
        return (xSnake == xObjeto && ySnake == yObjeto);
    }
}
