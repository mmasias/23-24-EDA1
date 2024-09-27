import java.util.Scanner;

public class MainProgram {
    public static void main(String[] args) {
        final int MAX_LENGTH = 6;
        Scanner input = new Scanner(System.in);
        char userInput;
        boolean finish = false;
        boolean editMode = false;

        SpreadSheet spreadSheet = new SpreadSheet();

        printTemplate();
        showSpreadSheet(spreadSheet, editMode);

        do {
            System.out.println("cmdS: [W]Arriba, [S]Abajo, [A]Izquierda, [D]Derecha, [F]Salir, [E]Ingresar Texto");
            System.out.println("Ingrese Comando: ");
            userInput = input.nextLine().charAt(0);

            if (!editMode) {
                switch (userInput) {
                    case 'w', 'W':
                        spreadSheet.moveUp();
                        break;
                    case 's', 'S':
                        spreadSheet.moveDown();
                        break;
                    case 'a', 'A':
                        spreadSheet.moveLeft();
                        break;
                    case 'd', 'D':
                        spreadSheet.moveRight();
                        break;
                    case 'f', 'F':
                        System.out.println("Ha finalizado el programa");
                        finish = true;
                        break;
                    case 'e', 'E':
                        System.out.println("Texto o numero");
                        String content = input.nextLine();
                        if (content.length() > MAX_LENGTH) {
                            content = content.substring(0, MAX_LENGTH);
                        }
                        spreadSheet.getCell(spreadSheet.getActualRow(), spreadSheet.getActualColumn()).setContent(content);
                        break;
                    case '[':
                        editMode = true;
                        break;
                }
            } else {
                if (userInput == ']') {
                    editMode = false;
                }
            }

            printTemplate();
            showSpreadSheet(spreadSheet, editMode);

        } while (!finish);
    }

    private static void printTemplate() {
        System.out.println("--- HOJA DE CALCULOS ---");
        System.out.println("| 1  |    A    |    B    |    C    |    D    |    E    |    F    |    G    |    H    |    I    |    J    |");
    }

    private static void showSpreadSheet(SpreadSheet spreadSheet, boolean editMode) {
        final int ROWS_NUMBER = spreadSheet.getRowsNumber();
        final int COLUMNS_NUMBER = spreadSheet.getColumnsNumber();
        final String DIVISION = "+------------------------------------------------------------------------------------------------------------+";

        System.out.println(DIVISION);

        for (int row = 0; row < ROWS_NUMBER; row++) {
            if (row <= 8) {
                System.out.print("|  " + (row + 1) + " |");
            } else {
                System.out.print("| " + (row + 1) + " |");
            }
            for (int col = 0; col < COLUMNS_NUMBER; col++) {
                Cell cell = spreadSheet.getCell(row, col);
                String content = cell.getContent();
                if (content == null) {
                    content = "";
                }
                if (row == spreadSheet.getActualRow() && col == spreadSheet.getActualColumn()) {
                    System.out.print("[" + formatContent(content) + "] |");
                } else {
                    System.out.print("  " + formatContent(content) + " |");
                }
            }
            System.out.println();
        }

        System.out.println(DIVISION);
    }

    private static String formatContent(String content) {
        final int MAX_LENGTH = 6;
        if (content.length() > MAX_LENGTH) {
            return content.substring(0, MAX_LENGTH);
        } else {
            StringBuilder sb = new StringBuilder(content);
            while (sb.length() < MAX_LENGTH) {
                sb.insert(0, " ");
            }
            return sb.toString();
        }
    }
}