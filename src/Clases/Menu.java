package Clases;

import java.util.Scanner;

public class Menu {

    static Scanner scanner = new Scanner(System.in);
    private int misionesCompletadas = 0;

    public Menu(int misionesCompletadas) {
        this.misionesCompletadas = misionesCompletadas;
    }

    public void mostrarMenu() {
        int opcion;

        do {
            System.out.println("    MENÚ PRINCIPAL    ");

            switch (misionesCompletadas) {
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
                    System.out.println("1. Reiniciar Misión Final");
                    System.out.println("2. Guardar estado");
                    System.out.println("3. Cargar estado");
                    System.out.println("4. Salir");
                    System.out.print("Tu elección: ");
                    break;
            }

            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, ingresa un número válido.");
                scanner.next();
            }
            opcion = scanner.nextInt();

            if (misionesCompletadas != 0) {
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
        // Determina qué misión iniciar según las misiones completadas del jugador
        if (misionesCompletadas == 0) {
            Mision mision = new MisionIntermedia(1);
            mision.iniciar();
        } else if (misionesCompletadas == 1) {
            Mision mision = new MisionIntermedia(2);
            mision.iniciar();
        } else {
            Mision mision = new MisionFinal();
            mision.iniciar();
        }
    }

    private void guardarEstado() {
        String codigo = generarCodigoDeEstado(misionesCompletadas);
        System.out.println("Tu código de estado es: " + codigo);
    }

    private String generarCodigoDeEstado(int misionesCompletadas) {
        return "NVL" + (misionesCompletadas);
    }

    private void cargarEstado() {   
        System.out.println("Ingresá tu código de estado: ");
        String codigo = scanner.next();

        switch (codigo) {
            case "NVL1":
                System.out.println("Estado cargado correctamente. Misiones completadas: 1");
                misionesCompletadas = 1;
                Mision mision = new MisionIntermedia(2);
                mision.iniciar();
                break;
            case "NVL2":
                System.out.println("Estado cargado correctamente. Misiones completadas: 2");
                misionesCompletadas = 2;
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
