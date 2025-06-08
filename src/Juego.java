import Clases.Menu;
import Clases.Mision;
import Clases.MisionFinal;
import Clases.MisionIntermedia;
import java.util.Scanner;

public class Juego {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Menu menuPrincipal = new Menu(0);
        menuPrincipal.mostrarMenu();
    }
}
