package Clases;

import java.util.Random;
import java.util.Scanner;

public class MisionFinal extends Mision {

    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    Snake snake = new Snake(new Posicion(0, 0));
    MetalGear metalGear = new MetalGear(new Posicion(0, 0));

    @Override
    public void iniciar() {
        System.out.println("\n¡Comienza la batalla final entre Snake y MetalGear!");

        while (snake.estaVivo() && metalGear.estaVivo()) {
            // Turno de Snake
            System.out.println("\nHP Snake: " + snake.getHp() + " | HP MetalGear: " + metalGear.getHp());
            System.out.println("\nEs tu turno, ¿qué acción querés realizar?");
            System.out.println("1. Disparar (20 de daño)");
            System.out.println("2. Esquivar próximo ataque");
            System.out.print("Tu elección: ");

            int opcion = scanner.nextInt();
            boolean esquivar = false;

            switch (opcion) {
                case 1:
                    System.out.println("💥 Snake dispara a MetalGear");
                    metalGear.recibirDanio(20);
                    break;
                case 2:
                    System.out.println("🕹️ Snake esquivará el próximo ataque de MetalGear");
                    esquivar = true;
                    break;
                default:
                    System.out.println("❌ Opción inválida. Pierdes el turno.");
                    break;
            }

            System.out.println("\nHP Snake: " + snake.getHp() + " | HP MetalGear: " + metalGear.getHp());
            if (!metalGear.estaVivo()) {
                break;
            }

            // Turno de MetalGear
            System.out.println("\n👾 Turno de MetalGear...");

            int ataqueEnemigo = random.nextInt(2); // 0: misiles, 1: láser
            int danio = (ataqueEnemigo == 0) ? 25 : 15;

            if (ataqueEnemigo == 0) {
                System.out.println("💣 MetalGear lanza misiles!");
            } else {
                System.out.println("🔫 MetalGear dispara con láser!");
            }

            if (esquivar) {
                System.out.println("🕹️ Snake esquivó el ataque de MetalGear");
            } else {
                snake.recibirDanio(danio);
            }
        }

        System.out.println("\n🏁 FIN DE LA BATALLA");
        if (snake.estaVivo()) {
            System.out.println("🎉 ¡Snake ganó!");
        } else {
            System.out.println("💀 MetalGear derrotó a Snake...");
            reiniciarBatallaFinal();
        }
    }

    private void reiniciarHp() {
        snake.setHp(100);
        metalGear.setHp(100);
    }

    private void reiniciarBatallaFinal() {
        System.out.println("\nSnake será llevado al hospital. 🏥");

        System.out.println("\n¿Deseas reiniciar la batalla?");
        System.out.println("1. Si");
        System.out.println("2. No");
        System.out.print("Tu elección: ");

        int opcion = scanner.nextInt();
        do {
            switch (opcion) {
                case 1:
                    System.out.println("Se reinicia la batalla.");
                    reiniciarHp();
                    iniciar();
                    break;
                case 2:
                    System.out.println("\n🏁 Fin del juego. Volviendo al menú principal...\n");
                    return;
                default:
                    System.out.println("❌ Opción inválida, intente nuevamente");
                    break;
            }
        } while (opcion != 1 && opcion != 2);
    }
}
