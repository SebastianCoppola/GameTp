package Clases;

import java.util.Random;

public class MetalGear extends Personaje implements Enemigo {
    Random random = new Random();
    private int ultimoDanioDeAtaque = 0;
    
    public MetalGear(Posicion posicion) {
        super(posicion);
    }

    @Override
    public void patrullar(Mapa mapa) {
       // No puede patrullar
    }

    @Override
    public boolean atrapado(Posicion snake) {
        //No puede atrapar 
        return false;
    }

    @Override
    public void atacar(Snake snake) {
        int ataqueEnemigo = random.nextInt(2);
            int danio = random.nextInt(26) + 15;

            if (ataqueEnemigo == 0) {
                System.out.println("💣 Metal Gear REX lanza misiles y produce un daño de " + danio);
            } else {
                System.out.println("🔫 Metal Gear REX dispara con láser y produce un daño de " + danio);
            }

            snake.recibirDanio(danio);
            ultimoDanioDeAtaque = danio;
    }
    
    public int getUltimoDanioDeAtaque() {
        return ultimoDanioDeAtaque;
    }

}
