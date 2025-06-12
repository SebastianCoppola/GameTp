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
        int cantidadGuardias = numeroMision == 1 ? 2 : 4;
        Objeto objeto1;
        Objeto objeto2;
        if (numeroMision == 1) {
            objeto1 = new Objeto(
                    "Llave",
                    "L ",
                    "Busca la llave 'L'!",
                    "Haz conseguido la llave!!"
            );
            objeto2 = new Objeto(
                    "Puerta",
                    "H ",
                    "Dirígete al hangar de entrada 'H'!",
                    "Haz encontrado el hangar 'H'!!"
            );
        } else {
            objeto1 = new Objeto(
                    "Explosivo C4",
                    "C4",
                    "Busca el explosivo 'C4'!",
                    "Haz conseguido el explosivo!!"
            );
            objeto2 = new Objeto(
                    "Salida",
                    "P ",
                    "Dirígete hacia la puerta 'P'!",
                    "Haz encontrado la puerta 'P'!!");
        }

        //Creo Mapa, Personajes y Objetos:
        Mapa mapa = new Mapa(filasColumnas, filasColumnas);
        Snake snake = new Snake(mapa.generarPosicionAleatoria());
        mapa.setSnake(snake);
        Guardia[] guardias = new Guardia[cantidadGuardias];
        for (int i = 0; i < cantidadGuardias; i++) {
            Guardia guardia = new Guardia(mapa.generarPosicionAleatoria());
            guardias[i] = guardia;
        }
        mapa.setGuardias(guardias);
        objeto1.setPosicion(mapa.generarPosicionAleatoria());
        mapa.setObjeto(objeto1);

        //Inicio la misión:
        Scanner scanner = new Scanner(System.in);
        boolean isPlaying = true;
        while (isPlaying) {
            mapa.actualizarMapa();
            System.out.println(mapa.getObjeto().getMensajeInstruccion());
            System.out.println("Mover (w: arriba, a: izquierda, s: abajo, d: derecha, x: salir): ");
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
                g.patrullar(mapa);
            }
            for (Guardia g : guardias) {
                if (g.atrapar(snake.getPosicion())) {
                mapa.actualizarMapa();
                System.out.println("¡Snake ha sido atrapado por un guardia!");
                System.out.println("Fin de la misión.");
                isPlaying = false;
                continue;
                }
            }
            if (snake.getPosicion().equals(mapa.getObjeto().getPosicion())) {
                if (objeto1.getPosicion() == null) {
                    if (numeroMision == 1 || (numeroMision == 2 && !snakeEstaCercaDeGuardia(snake, guardias))) {
                        System.out.println(mapa.getObjeto().getMensajeFinalizacion());
                        objeto2.recogerObjeto();
                        mapa.setObjeto(null);
                        isPlaying = false;
                    } else {
                        System.out.println("El explosivo hace mucho ruido! Snake debe estar más lejos de los guardias!!!");
                    }
                } else {
                    System.out.println(mapa.getObjeto().getMensajeFinalizacion());
                    objeto1.recogerObjeto();
                    mapa.setObjeto(null);
                    objeto2.setPosicion(mapa.generarPosicionAleatoria());
                    mapa.setObjeto(objeto2);
                }
            }
        }
        if (mapa.getObjeto() == null) {
            Menu menuIntermedio = new Menu(numeroMision);
            menuIntermedio.mostrarMenu();
        } else {
            if (numeroMision == 1) {
                Menu menuIntermedio = new Menu(0);
                menuIntermedio.mostrarMenu();
            } else {
                Menu menuIntermedio = new Menu(1);
                menuIntermedio.mostrarMenu();
            }
        }
    }

    /**
     * Método para validar si la pocisión de Snake está lo suficientemente lejos de los guardias.
     *
     * @param snake con la pocisión a comparar.
     * @param guardias listado de guardias.
     * @return Boolean true/false si la posición es correcta.
     */
    private Boolean snakeEstaCercaDeGuardia(Snake snake, Guardia[] guardias) {
        for (Guardia guardia : guardias) {
            if (snake.getPosicion().isSeparacionMenorA3(guardia.getPosicion())) {
                return true;
            }
        }
        return false;
    }
}
