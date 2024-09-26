import java.util.Scanner;

public class reto_001 {
    static char[] commandList = {'e', 's', 'w', 'a', 'd', 'q'};
    static int[] cursorPosition = {0, 0};
    private static final int NUM_ROWS = 15;
    private static final int NUM_COLUMNS = 10;
    static String[][] spreadsheet = new String[NUM_ROWS][NUM_COLUMNS];

    public static void main(String[] args) {

        boolean endAppLoop = false;
        Scanner input = new Scanner(System.in);
        final int[] limits = {0, spreadsheet.length - 1, 0, spreadsheet[0].length - 1};

        do {
            printSpreadsheet(spreadsheet, cursorPosition);
            endAppLoop = askUserInput(spreadsheet, cursorPosition, input, limits);
        } while (!endAppLoop);

        input.close();
    }

    static void printHeader() {
        System.out.println("+" + "-".repeat(82) + "+");
        System.out.print("|$$|");
        for (char letter = 'A'; letter < 'A' + NUM_COLUMNS; letter++) {
            System.out.print("   " + letter + "   |");
        }
        System.out.println("\n|--+" + "-------+".repeat(10));
    }

    static void printRowNumber(int row) {
        int sheetRow = row + 1;
        String wall = (String.valueOf(sheetRow).length() < 2) ? "| " : "|";
        if (row == 9) {
            System.out.print("|" + sheetRow + "|");
        } else {
            System.out.print(wall + sheetRow + "|");
        }
    }

    static String formatCell(String cellData) {
        if (cellData == null) {
            return "     ";
        } else if (cellData.length() < 5) {
            return " ".repeat(5 - cellData.length()) + cellData;
        } else {
            return cellData.substring(0, 5);
        }
    }

    static void printSpreadsheet(String[][] spreadsheet, int[] cursorPosition) {

        System.out.print("\033[H\033[2J");
        System.out.flush();

        printHeader();

        for (int row = 0; row < spreadsheet.length; row++) {
            printRowNumber(row);

            for (int column = 0; column < spreadsheet[row].length; column++) {
                String data = spreadsheet[row][column];

                if (row == cursorPosition[0] && column == cursorPosition[1]) {
                    System.out.print("[" + formatCell(data) + "]|");
                } else {
                    System.out.print(" " + formatCell(data) + " |");
                }
            }
            System.out.println();
        }
        printFooter();
    }

    static void printFooter() {

        int realCursorPositionX = cursorPosition[0] + 1;
        int realCursorPositionY = cursorPosition[1] + 1;

        System.out.println("|--+" + "-------+".repeat(10));
        System.out.print("|x:" + realCursorPositionX + "|Y:" + realCursorPositionY + "|");
        System.out.println(" -> Dato en la celda: " + spreadsheet[cursorPosition[0]][cursorPosition[1]] );
        System.out.println( "|" + "-".repeat(82) + "|");
        System.out.println("|             [W]    ");
        System.out.println("|Comandos: [A][S][D] movimiento  [Q]Salir    [E]Introducir dato");
        System.out.print("|Ingrese un comando: ");
    }

    static boolean isValidCommand(char command) {
        for (char validCommand : commandList) {
            if (command == validCommand) {
                return true;
            }
        }
        return false;
    }

    static boolean askUserInput(String[][] spreadsheet, int[] cursorPosition, Scanner input, int[] limits) {
        boolean endAppLoop = false;
        String userInput = input.nextLine();
        char command;

        command = userInput.length() > 0 ? userInput.charAt(0) : ' ';
        if (!isValidCommand(command)) {
            System.out.println("|Comando incorrecto!");
            System.out.print("|Ingrese un comando: ");
            userInput = input.nextLine();
        } else {
            switch (command) {
                case 'e':
                    System.out.print("Introduce el dato: ");
                    String data = input.nextLine();
                    spreadsheet[cursorPosition[0]][cursorPosition[1]] = data;
                    break;
                case 's':
                    cursorPosition[0] = Math.min(cursorPosition[0] + 1, limits[1]);
                    break;
                case 'w':
                    cursorPosition[0] = Math.max(cursorPosition[0] - 1, limits[0]);
                    break;
                case 'a':
                    cursorPosition[1] = Math.max(cursorPosition[1] - 1, limits[2]);
                    break;
                case 'd':
                    cursorPosition[1] = Math.min(cursorPosition[1] + 1, limits[3]);
                    break;
                case 'q':
                    endAppLoop = true;
                    break;
                default:
                    System.out.println("|Comando incorrecto!");
                    break;
            }
        }
        return endAppLoop;
    }

}