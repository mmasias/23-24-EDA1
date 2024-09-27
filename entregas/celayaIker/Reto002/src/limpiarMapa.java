package Reto002.src;

public class limpiarMapa extends limpiar{
    static void limpiarPantalla() {

        System.out.print("\033[H\033[2J");
    }
}