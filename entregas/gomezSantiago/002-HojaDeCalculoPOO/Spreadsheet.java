import java.util.Scanner;

class Spreadsheet {
    private static final int COLUMNS = 10;
    private static final int ROWS = 15;

    private String[][] cells;
    private String[][] columnLabels;
    private String[][] rowLabels;
    private int currentRow;
    private int currentColumn;
    private String message;
    private Scanner scanner;

    public Spreadsheet() {
        cells = new String[ROWS][COLUMNS];
        columnLabels = generateColumnLabels();
        rowLabels = generateRowLabels();
        currentRow = 0;
        currentColumn = 0;
        message = "Bienvenido a tu hoja de cálculo";
        scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            showSpreadsheet();
            System.out.print("Ingrese comando: ");
            String command = scanner.nextLine().trim().toUpperCase();

            switch (command) {
                case "E":
                    System.out.println("Ingrese el texto: ");
                    String textToAssign = scanner.nextLine();
                    cells[currentRow][currentColumn] = textToAssign;
                    break;
                case "W":
                    if (currentRow > 0) {
                        currentRow--;
                    }
                    break;
                case "A":
                    if (currentColumn > 0) {
                        currentColumn--;
                    }
                    break;
                case "S":
                    if (currentRow < ROWS - 1) {
                        currentRow++;
                    }
                    break;
                case "D":
                    if (currentColumn < COLUMNS - 1) {
                        currentColumn++;
                    }
                    break;
                case "Q":
                    System.out.println("+---------------------+");
                    System.out.println("| Programa finalizado |");
                    System.out.println("+---------------------+");
                    return;
                default:
                    System.out.println("Entrada inválida, intenta otra vez");
                    break;
            }
        }
    }

    private void showSpreadsheet() {
        System.out.println("+----------------------------------------------------------------------------------+");
        System.out.println("|                      " + message + "                            |");
        System.out.println("+----------------------------------------------------------------------------------+");
        System.out.print("|" + "  ");

        for (int column = 0; column < COLUMNS; column++) {
            System.out.print("|   " + columnLabels[0][column] + ("   "));
        }
        System.out.print("|");
        System.out.println();
        System.out.println("+--+-------+-------+-------+-------+-------+-------+-------+-------+-------+-------+");

        for (int row = 0; row < ROWS; row++) {
            System.out.print("|" + rowLabels[row][0]);
            for (int column = 0; column < COLUMNS; column++) {
                String content = cells[row][column];
                if (content == null) {
                    content = "";
                }
                content = String.format("%7s", content);

                String finalContent = content.substring(0, Math.min(7, content.length()));

                if (row == currentRow && column == currentColumn) {
                    System.out.print("|[     ]");
                } else {
                    System.out.print("|" + finalContent);
                }
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("+--+-------+-------+-------+-------+-------+-------+-------+-------+-------+-------+");
        System.out.println();
        System.out.println("+------------------------------------------------------------------------+");
        System.out.println("| Celda actual -> [ " + columnLabels[0][currentColumn] + rowLabels[currentRow][0]
                + " ]                                                |");
        System.out.println("| Utilice las teclas W, A, S y D para moverse.                           |");
        System.out.println("| Presione 'E' para ingresar texto en la celda actual.                   |");
        System.out.println("| Presione 'Q' para salir.                                               |");
        System.out.println("+------------------------------------------------------------------------+");
    }

    private String[][] generateColumnLabels() {
        String[][] columnLabels = new String[1][COLUMNS];
        for (int column = 0; column < COLUMNS; column++) {
            columnLabels[0][column] = Character.toString((char) ('A' + column));
        }
        return columnLabels;
    }

    private String[][] generateRowLabels() {
        String[][] rowLabels = new String[ROWS][1];
        for (int row = 0; row < ROWS; row++) {
            rowLabels[row][0] = String.format("%2d", row + 1);
        }
        return rowLabels;
    }
}