import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private String[][] matriz;
    private int filaActual;
    private int columnaActual;
    private final int filas = 15;
    private final int columnas = 10;
    private final int maxCeldaLength = 7;

    public Main() {
        matriz = new String[filas][columnas];
        inicializarMatriz();
        filaActual = 0;
        columnaActual = 0;
    }

    public void inicializarMatriz() {
        for (String[] strings : matriz) {
            Arrays.fill(strings, " ");
        }
    }

    public void imprimirMatriz() {
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

    public void moverCelda(String direccion) {
        switch (direccion) {
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
        }
    }

    public void ingresarTexto(String texto) {
        if (texto.length() > maxCeldaLength) {
            texto = texto.substring(0, maxCeldaLength);
        }
        matriz[filaActual][columnaActual] = texto;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main spreadsheet = new Main();

        while (true) {
            spreadsheet.imprimirMatriz();
            System.out.println("Utilice las teclas W, A, S y D para moverse.");
            System.out.println("Celda actual --> [" + (char) ('A' + spreadsheet.columnaActual) + (spreadsheet.filaActual + 1) + "]");
            System.out.println("Presione 'E' para ingresar texto en la celda actual.");
            System.out.println("Presione 'Q' para salir.");
            String comando = scanner.nextLine().toUpperCase();

            switch (comando) {
                case "W":
                case "A":
                case "S":
                case "D":
                    spreadsheet.moverCelda(comando);
                    break;
                case "E":
                    System.out.print("Texto que desea añadir: ");
                    String texto = scanner.nextLine();
                    spreadsheet.ingresarTexto(texto);
                    break;
                case "Q":
                    scanner.close();
                    System.exit(0);
                    break;
            }
        }
    }
}
