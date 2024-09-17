public class limpiarTablero extends limpiar{
    static void limpiarPantalla() {

        System.out.print("\033[H\033[2J");
    }
}
