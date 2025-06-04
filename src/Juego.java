import java.util.Scanner;

public class Juego {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("************************");
            System.out.println("*    MENÚ PRINCIPAL    *");
            System.out.println("************************");
            System.out.println("1. Iniciar Misión");
            System.out.println("2. Guardar estado");
            System.out.println("3. Cargar estado");
            opcion = scanner.nextInt();
            System.out.println(opcion);
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
                default:
                    System.out.println("Opción incorrecta");
                    break;
            }
        } while (opcion != 1 && opcion != 2 && opcion != 3);
    }
    
    private static void iniciar() {
        System.out.println("Juego iniciado");
    }
    
    private static void guardarEstado() {
        System.out.println("Estado guardado");
    }
    
    private static void cargarEstado() {
        System.out.println("Estado cargado");
    }
}
