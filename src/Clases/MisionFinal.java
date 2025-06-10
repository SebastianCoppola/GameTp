package Clases;

import java.util.Random;
import java.util.Scanner;

public class MisionFinal extends Mision {

    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    Snake snake = new Snake(new Posicion(0, 0));
    MetalGear rex = new MetalGear(new Posicion(0, 0));

    @Override
    public void iniciar() {
        int ultimoDanioRecibido = 0;
        boolean opcionValida;

        System.out.println("\n¡Comienza la batalla final entre Snake y Metal Gear REX!");

        while (snake.estaVivo() && rex.estaVivo()) {
            do {
                // Turno de Snake
                System.out.println("\nHP Snake: " + snake.getHp() + " | HP Metal Gear REX: " + rex.getHp());
                System.out.println("\nEs tu turno, ¿qué acción querés realizar?");
                System.out.println("1. Disparar misil (daño aleatorio entre 10 y 30)");
                System.out.println("2. Esquivar ataque (reduce daño recibido entre 50% y 100%)");
                System.out.print("Tu elección: ");

                int opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        int danioMisil = random.nextInt(21) + 10;
                        rex.recibirDanio(danioMisil);
                        System.out.println("💥 Snake dispara un misil causando " + danioMisil + " de daño a Metal Gear REX!");
                        opcionValida = true;
                        break;
                    case 2:
                        if (ultimoDanioRecibido > 0) {
                            int porcentaje = random.nextInt(51) + 50;
                            int vidaRecuperada = ultimoDanioRecibido * porcentaje / 100;
                            int nuevaHp = Math.min(snake.getHp() + vidaRecuperada, 100);
                            System.out.println("🛡️ Snake esquiva el " + porcentaje + "% del ataque recibido anteriormente (" + vidaRecuperada + "HP de vida recuperada).");
                            snake.setHp(nuevaHp);
                            opcionValida = true;
                            break;
                        } else {
                            System.out.println("⚠️ Snake aún no ha sido atacado. No puede esquivar un ataque que no se ejecuto.");
                            opcionValida = false;
                            break;
                        }
                    default:
                        System.out.println("❌ Opción inválida, intenta nuevamente.");
                        opcionValida = false;
                        break;
                }
            } while (!opcionValida);

            System.out.println("\nHP Snake: " + snake.getHp() + " | HP Metal Gear REX: " + rex.getHp());
            if (!rex.estaVivo()) {
                break;
            }

            // Turno de MetalGear
            System.out.println("\n👾 Turno de Metal Gear REX...");

            int ataqueEnemigo = random.nextInt(2);
            int danio = random.nextInt(26) + 15;

            if (ataqueEnemigo == 0) {
                System.out.println("💣 Metal Gear REX lanza misiles y produce un daño de " + danio);
            } else {
                System.out.println("🔫 Metal Gear REX dispara con láser y produce un daño de " + danio);
            }

            snake.recibirDanio(danio);
            ultimoDanioRecibido = danio;
        }

        System.out.println("\n🏁 FIN DE LA BATALLA");
        if (snake.estaVivo()) {
            System.out.println("🎉 ¡Snake ganó!\n");
            Menu menuIntermedio = new Menu(3);
            menuIntermedio.mostrarMenu();
        } else {
            System.out.println("💀 Metal Gear REX derrotó a Snake...");
            Menu menuIntermedio = new Menu(2);
            menuIntermedio.mostrarMenu();
        }
    }
}
