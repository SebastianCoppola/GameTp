
import Clases.Menu;

public class Juego {

    public static void main(String[] args) {
        System.out.println(" Bienvenido/a!");
        System.out.println(" Eres Snake, un agente de élite entrenado para");
        System.out.println(" infiltrarte en bases enemigas y cumplir misiones");
        System.out.println(" secretas de alto riesgo.");
        System.out.println(" Snake ha sido capturado por *Metal Gear REX*");
        System.out.println(" durante una misión de infiltración fallida.");
        System.out.println(" Ahora está atrapado en las profundidades de la");
        System.out.println(" base enemiga. Su única opción es escapar desde adentro");
        System.out.println(" superando misiones cada vez más difíciles para llegar a Metal Gear REX");
        System.out.println(" Las misiones que deberás enfrentar son:");
        System.out.println(" ▸ Misión Inicial: recoger la llave y llegar a la salida evitando al guardia.");
        System.out.println(" ¡Si quedás a una celda de distancia del guardia, estás atrapado/a y deberás reiniciar la partida!");
        System.out.println(" ▸ Misión Intermedia: consiguer el C4 y escapar sin ser atrapado por los guardias.");
        System.out.println(" ¡Si quedás a una celda de distancia del guardia, estás atrapado/a y deberás reiniciar la partida!");
        System.out.println(" ▸ Misión Final: enfrentate en un combate uno a uno contra *Metal Gear REX*.");
        System.out.println(" ¡Buena suerte!");
        System.out.println("");

        Menu menuPrincipal = new Menu(0);
        menuPrincipal.mostrarMenu();
    }
}
