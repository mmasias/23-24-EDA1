import java.util.*;

public class main {
    private static final int NUM_ROWS = 15;
    private static final int NUM_COLS = 10;
    private String[][] celdas;
    private int currentRow = 0;
    private int currentCol = 0;

    public main() {
        celdas = new String[NUM_ROWS][NUM_COLS];
        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_COLS; j++) {
                celdas[i][j] = "x";
            }
        }
    }

    public void moverArriba() {
        if (currentRow > 0) {
            currentRow--;
        }
    }

    public void moverAbajo() {
        if (currentRow < NUM_ROWS - 1) {
            currentRow++;
        }
    }

    public void moverIzquierda() {
        if (currentCol > 0) {
            currentCol--;
        }
    }

    public void moverDerecha() {
        if (currentCol < NUM_COLS - 1) {
            currentCol++;
        }
    }

    public void ingresarValor(String valor) {
        celdas[currentRow][currentCol] = valor;
    }

    public void imprimirCuadricula() {
        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_COLS; j++) {
                String valor = String.format("%-7s", celdas[i][j]);
                if (i == currentRow && j == currentCol) {
                    System.out.print("\033[31m" + valor + "\t");
                } else {
                    System.out.print("\033[30m" + valor + "\t");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        main cuadricula = new main();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            cuadricula.imprimirCuadricula();
            System.out.println("Te encuentras en la celda: [" + (cuadricula.currentRow + 1) + ", " + (cuadricula.currentCol + 1) + "]");
            System.out.print("Introduce un comando (w/a/s/d para mover, f para salir, e para ingresar valor): ");
            String command = scanner.next();
            switch (command.toLowerCase()) {
                case "w":
                    cuadricula.moverArriba();
                    break;
                case "a":
                    cuadricula.moverIzquierda();
                    break;
                case "s":
                    cuadricula.moverAbajo();
                    break;
                case "d":
                    cuadricula.moverDerecha();
                    break;
                case "e":
                    System.out.print("Ingrese comando: ");
                    String value = scanner.next();
                    if (!isNumeric(value)) {
                        System.out.println("Por favor, introduzca solo números.");
                        break;
                    }
                    
                    if (value.length() > 7) {
                        value = value.substring(0, 7);
                    }
                    cuadricula.ingresarValor(value);
                    break;
                case "f":
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Comando desconocido.");
                    break;
            }
        }
    }

    public static boolean isNumeric(String str) {
        return str.matches("\\d+");  
    }
}
