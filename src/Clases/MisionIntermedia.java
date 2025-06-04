package Clases;

import java.util.Scanner;

public class MisionIntermedia extends Mision {

    public MisionIntermedia(Integer numero) {
        this.numero = numero;
        this.nombre = "Misión " + numero;
        this.descripcion = "Mueve a Snake por el mapa.";
    }

    @Override
    public void iniciar(){
        if(this.numero == 1) {
            iniciarMision1();
        } else {
            iniciarMision2();
        }
    }

    private void iniciarMision1(){
        Mapa mapa = new Mapa(7, 7);
        Snake snake = new Snake(new Posicion(3, 3));
        Scanner scanner = new Scanner(System.in);
        while (true) {
            mapa.mostrar(snake);
            System.out.print("Mover (w/a/s/d, x para salir): ");
            char input = scanner.next().charAt(0);
            if (input == 'x') break;
            mapa.moverSnake(snake, input);
        }
        scanner.close();
    }

    private void iniciarMision2(){

    }
}
