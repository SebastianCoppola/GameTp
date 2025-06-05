import Clases.Mision;
import Clases.MisionFinal;
import Clases.MisionIntermedia;
import java.util.Scanner;

public class Juego {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion;
        while (true) {
            System.out.println("************************");
            System.out.println("*    MENÚ PRINCIPAL    *");
            System.out.println("************************");
            System.out.println("1. Iniciar Misión");
            System.out.println("2. Guardar estado");
            System.out.println("3. Cargar estado");
            System.out.println("4. Salir");
            System.out.print("Tu elección: ");

            opcion = scanner.nextInt();

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
                    System.out.println("\n👋 Gracias por jugar. ¡Hasta pronto!\n");
                    return;
                default:
                    System.out.println("\n❌ Opción invalida\n");
                    break;
            }
        }
    }

    private static void iniciar() {
        Mision mision = new MisionIntermedia(1);
        //Mision mision = new MisionFinal();
        mision.iniciar();
    }

    private static void guardarEstado() {
        System.out.println("Estado guardado");
    }

    private static void cargarEstado() {
        System.out.println("Estado cargado");
    }
}
