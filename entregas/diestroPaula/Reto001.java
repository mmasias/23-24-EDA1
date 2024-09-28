import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int filas = 15;
        int columnas = 10;
        String[][] matriz = new String[filas][columnas];
        inicializarMatriz(matriz);
        comandos(matriz);
    }
    public static void inicializarMatriz(String[][] matriz){
        for (String[] strings : matriz) {
            Arrays.fill(strings, " ");
        }
    }
    public static void imprimirMatriz(String[][] matriz, int maxCeldaLength) {
        System.out.print("   ");
        for (char c = 'A'; c <= 'J'; c++) {
            System.out.print("| " + c + "       ");
        }
        System.out.println("|");

        System.out.print("   ");
        for (int i = 0; i < 10; i++) {
            System.out.print("+---------");
        }
        System.out.println("+");

        for (int i = 0; i < matriz.length; i++) {

            String numFila = String.format("%2d", i + 1);

            System.out.print(numFila + " |");
            for (int j = 0; j < 10; j++) {
                String interior = "";
                if (j < matriz[i].length) {
                    interior = matriz[i][j];
                }

                interior = String.format("%-" + maxCeldaLength + "s", interior);

                System.out.print(" " + interior + " |");
            }
            System.out.println();
        }
    }

    public static void comandos(String[][] matriz) {
        Scanner scanner = new Scanner(System.in);
        int filaActual = 0;
        int columnaActual = 0;
        int maxCeldaLength = 7;

        while (true) {
            imprimirMatriz(matriz, maxCeldaLength);

            System.out.println("Utilice las teclas W, A, S y D para moverse.");

            System.out.println("Celda actual --> [" + (char) ('A' + columnaActual) +  (filaActual + 1) + "]");

            System.out.println("Presione 'E' para ingresar texto en la celda actual.");
            System.out.println("Presione 'Q' para salir.");
            String comando = scanner.nextLine().toUpperCase();

            switch (comando) {
                case "W":
                    if (filaActual > 0) {
                        filaActual--;
                    }
                    break;
                case "A":
                    if (columnaActual > 0) {
                        columnaActual--;
                    }
                    break;
                case "S":
                    if (filaActual < 9) {
                        filaActual++;
                    }
                    break;
                case "D":
                    if (columnaActual < 9) {
                        columnaActual++;
                    }
                    break;
                case "E":
                    System.out.print("Texto que desea añadir: ");
                    String texto = scanner.nextLine();

                    if (texto.length() > maxCeldaLength) {
                        texto = texto.substring(0, maxCeldaLength);
                    }

                    matriz[filaActual][columnaActual] = texto;
                    break;
                case "Q":
                    scanner.close();
                    System.exit(0);
                    break;
            }
        }
    }

}
