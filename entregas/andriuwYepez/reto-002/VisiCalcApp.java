import java.util.Scanner;

public class VisiCalcApp {
    public static void main(String[] args) {
        HojaCalculo hoja = new HojaCalculo();
        Scanner entrada = new Scanner(System.in);
        char inputUsuario;
        boolean terminar = false;

        do {
            System.out.println("cmdS: [W]Arriba, [S]Abajo, [A]Izquierda, [D]Derecha, [F]Salir, [E]Ingresar Texto");
            System.out.println("Ingrese Comando: ");
            inputUsuario = entrada.nextLine().charAt(0);

            switch (inputUsuario) {
                case 'w', 'W':
                    hoja.moverArriba();
                    break;
                case 's', 'S':
                    hoja.moverAbajo();
                    break;
                case 'a', 'A':
                    hoja.moverIzquierda();
                    break;
                case 'd', 'D':
                    hoja.moverDerecha();
                    break;
                case 'f', 'F':
                    System.out.println("Ha finalizado el programa");
                    terminar = true;
                    break;
                case 'e', 'E':
                    System.out.println("Texto o numero");
                    String contenido = entrada.nextLine();
                    hoja.ingresarTexto(contenido);
                    break;
            }

            System.out.println("--- HOJA DE CALCULOS ---");
            hoja.mostrarHojaDeCalculo();
            System.out.println("| |X: " + (hoja.getFilaActual() + 1) + "|" + " Y: " + hoja.getColumnaActual() + "|");
            System.out.println("+----------------------------------------------------------------------------------------------+");
        } while (!terminar);
    }
}
