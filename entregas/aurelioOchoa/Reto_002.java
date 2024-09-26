import java.util.Scanner;

class SpreadsheetApp {
    public static void main(String[] args) {
        Spreadsheet spreadsheet = new Spreadsheet();
        spreadsheet.run();
    }
}

class Spreadsheet {
    private static final int NUM_ROWS = 15;
    private static final int NUM_COLUMNS = 10;
    private static final char[] COMMAND_LIST = {'e', 's', 'w', 'a', 'd', 'q'};
    
    private String[][] cells;
    private int[] cursorPosition;

    public Spreadsheet() {
        this.cells = new String[NUM_ROWS][NUM_COLUMNS];
        this.cursorPosition = new int[]{0, 0};
    }

    public void run() {
        boolean endAppLoop = false;
        Scanner input = new Scanner(System.in);
        final int[] limits = {0, cells.length - 1, 0, cells[0].length - 1};

        do {
            printSpreadsheet();
            endAppLoop = askUserInput(input, limits);
        } while (!endAppLoop);

        input.close();
    }

    private void printHeader() {
        System.out.println("+" + "-".repeat(82) + "+");
        System.out.print("|$$|");
        for (char letter = 'A'; letter < 'A' + NUM_COLUMNS; letter++) {
            System.out.print("   " + letter + "   |");
        }
        System.out.println("\n|--+" + "-------+".repeat(10));
    }

    private void printRowNumber(int row) {
        int sheetRow = row + 1;
        String wall = (String.valueOf(sheetRow).length() < 2) ? "| " : "|";
        if (row == 9) {
            System.out.print("|" + sheetRow + "|");
        } else {
            System.out.print(wall + sheetRow + "|");
        }
    }

    private String formatCell(String cellData) {
        if (cellData == null) {
            return "     ";
        } else if (cellData.length() < 5) {
            return " ".repeat(5 - cellData.length()) + cellData;
        } else {
            return cellData.substring(0, 5);
        }
    }

    private void printSpreadsheet() {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        printHeader();

        for (int row = 0; row < cells.length; row++) {
            printRowNumber(row);

            for (int column = 0; column < cells[row].length; column++) {
                String data = cells[row][column];

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

    private void printFooter() {
        int realCursorPositionX = cursorPosition[0] + 1;
        int realCursorPositionY = cursorPosition[1] + 1;

        System.out.println("|--+" + "-------+".repeat(10));
        System.out.print("|x:" + realCursorPositionX + "|Y:" + realCursorPositionY + "|");
        System.out.println(" -> Data in the cell: " + cells[cursorPosition[0]][cursorPosition[1]]);
        System.out.println("|" + "-".repeat(82) + "|");
        System.out.println("|             [W]    ");
        System.out.println("|Commands: [A][S][D] move  [Q]Quit    [E]Enter data");
        System.out.print("|Enter a command: ");
    }

    private boolean isValidCommand(char command) {
        for (char validCommand : COMMAND_LIST) {
            if (command == validCommand) {
                return true;
            }
        }
        return false;
    }

    private boolean askUserInput(Scanner input, int[] limits) {
        boolean endAppLoop = false;
        String userInput = input.nextLine();
        char command;

        command = userInput.length() > 0 ? userInput.charAt(0) : ' ';
        if (!isValidCommand(command)) {
            System.out.println("|Incorrect command!");
            System.out.print("|Enter a command: ");
            userInput = input.nextLine();
        } else {
            switch (command) {
                case 'e':
                    System.out.print("Enter data: ");
                    String data = input.nextLine();
                    cells[cursorPosition[0]][cursorPosition[1]] = data;
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
                    System.out.println("|Incorrect command!");
                    break;
            }
        }
        return endAppLoop;
    }

    public static void main(String[] args) {
        Spreadsheet spreadsheet = new Spreadsheet();
        spreadsheet.run();
    }
}

class Cell {
    private String data;

    public Cell() {
        this.data = "";
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}