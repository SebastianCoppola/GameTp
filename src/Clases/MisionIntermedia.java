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
        if (this.numero == 1) {
            iniciarMision1();
        } else {
            iniciarMision2();
        }
    }

    private void iniciarMision1() {
        //Creo el mapa:
        Mapa mapa = new Mapa(7, 7);
        //Creo a Snake:
        Snake snake = new Snake(new Posicion(3, 3));
        mapa.setSnake(snake);
        //Creo los guardias:
        Guardia[] guardias = new Guardia[1];
        Guardia guardia = new Guardia(new Posicion(5, 5));
        guardias[0] = guardia;
        mapa.setGuardias(guardias);
        //Creo los objetos:
        Objeto[] objetos = new Objeto[2];
        Objeto llave = new Objeto("Llave", "L", new Posicion(1, 1));
        Objeto puerta = new Objeto("Puerta", "H", new Posicion(6, 6));
        objetos[0] = llave;
        objetos[1] = puerta;
        mapa.setObjetos(objetos);
        //Creo el mensaje:
        String mensaje = "Busca la llave ' L '";
        //Inicio la misión:
        Scanner scanner = new Scanner(System.in);
        while (true) {
            mapa.actualizarMapa();
            System.out.println(mensaje);
            System.out.println("Mover (w/a/s/d, x para salir): ");
            String input = scanner.nextLine().trim();
            if (input.length() != 1) {
                System.out.println("Entrada inválida. Ingresá solo una letra.");
                continue; // vuelve a pedir input
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
            if (llave != null && snakeConsiguioObjeto(snake, llave)) {
                System.out.println("¡Snake ha conseguido la llave!");
                mensaje = "¡Ahora dirigete a la puerta ' H '!";
                Objeto[] tempObjetos = new Objeto[1];
                tempObjetos[0] = puerta;
                mapa.setObjetos(tempObjetos);
                llave = null;
            }
            if (snakeConsiguioObjeto(snake, puerta)) {
                System.out.println("¡Snake ha encontrado la puerta! Misión completada.");
                Menu menuIntermedio = new Menu(1);
                menuIntermedio.mostrarMenu();
                break;
            }
        }
    }

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

    private Boolean snakeConsiguioObjeto(Snake snake, Objeto objeto) {
        int xSnake = snake.getPosicion().getX();
        int ySnake = snake.getPosicion().getY();
        int xObjeto = objeto.getPosicion().getX();
        int yObjeto = objeto.getPosicion().getY();
        return (xSnake == xObjeto && ySnake == yObjeto);
    }

    private void iniciarMision2() {
        //Creo el mapa:
        Mapa mapa = new Mapa(9, 9);
        //Creo a Snake:
        Snake snake = new Snake(new Posicion(3, 3));
        mapa.setSnake(snake);
        //Creo los guardias:
        Guardia[] guardias = new Guardia[1];
        Guardia guardia = new Guardia(new Posicion(5, 5));
        guardias[0] = guardia;
        mapa.setGuardias(guardias);
        //Creo los objetos de la misión: C4 y la Salida 'P'
        Objeto[] objetos = new Objeto[2];
        Objeto c4 = new Objeto("Explosivo C4", "C4", new Posicion(1, 1));
        Objeto salidaP = new Objeto("Salida", "P", new Posicion(6, 6));
        objetos[0] = c4;
        objetos[1] = salidaP;
        mapa.setObjetos(objetos);
        //Creo el mensaje:
        String mensaje = "Busca el explosivo 'C4' y dirígete a la puerta de salida 'P'.";
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
            if (input.equalsIgnoreCase("x")) {
                System.out.println("Saliendo de la misión.");
                break;
            }
            snake.moverPersonaje(input, mapa);
            for (Guardia g : guardias) {
                g.moverAleatorio(mapa);
            }
            if (snakeFueAtrapadoPorGuardia(snake, guardias)) {
                mapa.actualizarMapa();
                System.out.println("¡Snake ha sido atrapado por un enemigo!");
                System.out.println("La misión debe comenzar de nuevo.");
                break;
            }
            if (c4 != null && snakeConsiguioObjeto(snake, c4)) {
                System.out.println("¡Snake ha conseguido el explosivo C4!");
                mensaje = "¡Ahora dirigete a la salida 'P'!";
                Objeto[] tempObjetos = new Objeto[1];
                tempObjetos[0] = salidaP;
                mapa.setObjetos(tempObjetos);
                c4 = null;
            }

            if (c4 == null && snakeConsiguioObjeto(snake, salidaP)) {
                mapa.actualizarMapa();
                System.out.println("¡Snake ha llegado a la salida con el C4! Misión completada.");
                Menu menuIntermedio = new Menu(2);
                menuIntermedio.mostrarMenu();
                break;
            }
        }
        scanner.close();
    }
}
