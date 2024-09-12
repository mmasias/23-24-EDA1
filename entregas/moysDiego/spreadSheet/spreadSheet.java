import java.util.Scanner;

public class spreadSheet {
    public static void main(String[] args) {
        final int COLUMNS_NUMBER = 10;
        final int ROWS_NUMBER = 15;
        final int MAX_LENGTH = 6;

        String[][] spreadSheet = new String[ROWS_NUMBER][COLUMNS_NUMBER];
        int actualRow = 0;
        int actualColumn = 0;
        boolean editMode = false;

        Scanner input = new Scanner(System.in);
        char userInput;
        boolean finish = false;

        printTemplate();
        showSpreadSheet(spreadSheet, actualRow, actualColumn, editMode);
        do {
            System.out.println("cmdS: [W]Arriba, [S]Abajo, [A]Izquierda, [D]Derecha, [F]Salir, [E]Ingresar Texto");
            System.out.println("Ingrese Comando: ");
            userInput = input.nextLine().charAt(0);

            if (!editMode) {
                switch (userInput) {
                    case 'w', 'W':
                        if (actualRow > 0) {
                            actualRow--;
                        }
                        break;
                    case 's', 'S':
                        if (actualRow < ROWS_NUMBER - 1) {
                            actualRow++;
                        }
                        break;
                    case 'a', 'A':
                        if (actualColumn > 0) {
                            actualColumn--;
                        }
                        break;
                    case 'd', 'D':
                        if (actualColumn < COLUMNS_NUMBER - 1) {
                            actualColumn++;
                        }
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
                        spreadSheet[actualRow][actualColumn] = content;
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
            showSpreadSheet(spreadSheet, actualRow, actualColumn, editMode);

        } while (!finish);
    }

    private static void printTemplate() {
        System.out.println("--- HOJA DE CALCULOS ---");
        System.out.println("| 1  |    A    |    B    |    C    |    D    |    E    |    F    |    G    |    H    |    I    |    J    |");
    }

    private static void showSpreadSheet(String[][] spreadSheet, int actualRow, int actualColumn, boolean editMode) {
        final int ROWS_NUMBER = spreadSheet.length;
        final int COLUMNS_NUMBER = spreadSheet[0].length;
        final String SEPARATOR = "+------------------------------------------------------------------------------------------------------------+";
        System.out.println(SEPARATOR);

        for (int row = 0; row < ROWS_NUMBER; row++) {
            if (row <= 8) {
                System.out.print("|  " + (row + 1) + " |");
            }else {
                System.out.print("| " + (row + 1) + " |");
            }
            for (int column = 0; column < COLUMNS_NUMBER; column++) {
                String content = spreadSheet[row][column];
                if (content == null) {
                    content = "";
                }
                if (row == actualRow && column == actualColumn) {
                    System.out.print("[" + FormatContent(content) + "] |");
                } else {
                    System.out.print("  " + FormatContent(content) + " |");
                }
            }
            System.out.println();
        }

        System.out.println(SEPARATOR);
    }

    private static String FormatContent(String content) {
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