package Clases;

import java.util.Scanner;

public class Menu {

    static Scanner scanner = new Scanner(System.in);
    private int progreso = 0;

    public Menu(int progreso) {
        this.progreso = progreso;
    }

    public void mostrarMenu() {
        int opcion;

        do {
            System.out.println("    MENÚ PRINCIPAL    ");

            switch (progreso) {
                case 0:
                    System.out.println("1. Iniciar Misión Inicial");
                    System.out.println("2. Cargar estado");
                    System.out.println("3. Salir");
                    System.out.print("Tu elección: ");
                    break;
                case 1:
                    System.out.println("1. Iniciar Misión Intermedia");
                    System.out.println("2. Guardar estado");
                    System.out.println("3. Cargar estado");
                    System.out.println("4. Salir");
                    System.out.print("Tu elección: ");
                    break;
                case 2:
                    System.out.println("1. Iniciar Misión Final");
                    System.out.println("2. Guardar estado");
                    System.out.println("3. Cargar estado");
                    System.out.println("4. Salir");
                    System.out.print("Tu elección: ");
                    break;
                case 3: 
                    System.out.println("1. Reiniciar juego desde cero");
                    System.out.println("2. Guardar estado");
                    System.out.println("3. Cargar estado");
                    System.out.println("4. Salir");
                    System.out.print("Tu elección: ");
                    break;
            }

            opcion = scanner.nextInt();

            if (progreso != 0) {
                switch (opcion) {
                    case 1:
                        iniciar();
                        break;
                    case 2:
                        guardarEstado();
                        break;
                    case 3:
                        cargarEstado();
                        break;
                    case 4:
                        System.out.println("¡Hasta luego!");
                        break;
                    default:
                        System.out.println("Opción inválida.");
                        break;
                }
            } else {
                switch (opcion) {
                    case 1:
                        iniciar();
                        break;
                    case 2:
                        cargarEstado();
                        break;
                    case 3:
                        System.out.println("¡Hasta luego!");
                        break;
                    default:
                        System.out.println("Opción inválida.");
                        break;
                }
            }

        } while (opcion != 4);
    }

    private void iniciar() {
        // Determina qué misión iniciar según el progreso del jugador
        if (progreso == 0) {
            Mision mision = new MisionIntermedia(1);
            mision.iniciar();
        } else if (progreso == 1) {
            Mision mision = new MisionIntermedia(2);
            mision.iniciar();
        } else {
            Mision mision = new MisionFinal();
            mision.iniciar();
        }
    }

    private void guardarEstado() {
        String codigo = generarCodigoDeEstado(progreso);
        System.out.println("Tu código de estado es: " + codigo);
    }

    private String generarCodigoDeEstado(int progreso) {
        if(progreso == 0) {
            progreso = progreso + 1;
        }
        return "NVL" + (progreso);
    }

    private void cargarEstado() {
        System.out.println("Ingresá tu código de estado: ");
        String codigo = scanner.next();

        switch (codigo) {
            case "NVL1":
                System.out.println("Estado cargado correctamente. Misiones completadas: 1");
                progreso = 1;
                Mision mision = new MisionIntermedia(2);
                mision.iniciar();
                break;
            case "NVL2":
                System.out.println("Estado cargado correctamente. Misiones completadas: 2");
                progreso = 2;
                Mision misionFinal = new MisionFinal();
                misionFinal.iniciar();
                break;
            case "NVL3":
                System.out.println("Haz superado todas las misiones, Felicidades!!");
                break;
            default:
                System.out.println("Código inválido.");
                break;
        }
    }
}
