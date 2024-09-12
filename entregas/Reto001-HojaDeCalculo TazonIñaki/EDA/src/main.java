import java.util.Scanner;

public class main {
    public static final int NUM_ROWS = 15;
    public static final int NUM_COLS = 10;
    private String[][] cells = new String[NUM_ROWS][NUM_COLS];

    String black="\033[30m"; 
    String red="\033[31m";
    private int currentRow = 0;
    private int currentCol = 0;

    public main() {
        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_COLS; j++) {
                cells[i][j] = "x";
            }
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printCells();
            System.out.println("Te encuentras en la celda: [" + (currentRow + 1) + ", " + (currentCol + 1) + "]");
            System.out.print("Introduce un comando (w/a/s/d para mover, f para salir, e para ingresar valor): ");
            String command = scanner.next();
            switch (command.toLowerCase()) {
                case "w":
                    if (currentRow > 0) {
                        currentRow--;
                    }
                    break;
                case "a":
                    if (currentCol > 0) {
                        currentCol--;
                    }
                    break;
                case "s":
                    if (currentRow < NUM_ROWS - 1) {
                        currentRow++;
                    }
                    break;
                case "d":
                    if (currentCol < NUM_COLS - 1) {
                        currentCol++;
                    }
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
                    cells[currentRow][currentCol] = value;
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

    private void printCells() {
        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_COLS; j++) {
                String value = String.format("%-7s", cells[i][j]);
                if (i == currentRow && j == currentCol) {
                    System.out.print(red + value + "\t");
                } else {
                    System.out.print(black + value + "\t");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        new main().run();
    }
    public static boolean isNumeric(String str) {
        return str.matches("\\d+");  
    }
}