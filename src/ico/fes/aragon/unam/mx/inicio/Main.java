package ico.fes.aragon.unam.mx.inicio;

import ico.fes.aragon.unam.mx.clases.JuegoDeLaVida;

public class Main {
    public static void main(String[] args) throws InterruptedException {


        JuegoDeLaVida juego = new JuegoDeLaVida(8,8);
        juego.inicializarRandom();
        juego.actualizacionRejilla();


        for (int i = 0; i < 10 ; i++) {
            System.out.println("Generacion " + (i+1));
            juego.imprimirRejilla();
            juego.actualizacionRejilla();
            Thread.sleep(1000); //pausas cada n milisegndos
        }

    }
}