import java.util.Scanner;

public class App {

    private static final String[] MOVEMENT_ACTIONS = { "w", "a", "s", "d", "e", "q" };

    private static String[][] spreadsheet = new String[15][10];
    private static int currentRow = 0;
    private static int currentColumn = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        initializeSpreadsheet();
        while (isRunning) {
            displaySpreadsheet();

            System.out.println("Current cell -> " + "[" + convertColumnToLetter(currentColumn) + currentRow + "]");
            System.out.println("Use the W, A, S & D keys to move around the spreadsheet.");
            System.out.println("Press 'E' to enter a text in the current cell.");
            System.out.println("Press 'Q' to exit.");

            String userInput = scanner.nextLine();

            switch (userInput) {
                case "w":
                    moveUp();
                    break;
                case "a":
                    moveLeft();
                    break;
                case "s":
                    moveDown();
                    break;
                case "d":
                    moveRight();
                    break;
                case "e":
                    enterText(scanner);
                    break;
                case "q":
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }
    }

    private static void initializeSpreadsheet() {
        for (int i = 0; i < spreadsheet.length; i++) {
            for (int j = 0; j < spreadsheet[0].length; j++) {
                spreadsheet[i][j] = "      ";
            }
        }
    }

    private static void displaySpreadsheet() {
        System.out.print("  ");
        for (int col = 0; col < spreadsheet[0].length; col++) {
            System.out.printf("%7s ", convertColumnToLetter(col));
        }
        System.out.println("");
        System.out.println("   +-------+-------+-------+-------+-------+-------+-------+-------+-------+-------+");

        for (int i = 0; i < spreadsheet.length; i++) {
            System.out.printf("%2d ", (i + 1));
            for (int j = 0; j < spreadsheet[i].length; j++) {
                if (i == currentRow && j == currentColumn) {
                    System.out.print("|[_____]");
                } else {
                    System.out.printf("|%7s", spreadsheet[i][j]);
                }
            }
            System.out.println("|");
        }

        System.out.println("   +-------+-------+-------+-------+-------+-------+-------+-------+-------+-------+");
    }

    private static void moveUp() {
        if (currentRow > 0) {
            currentRow--;
        }
    }

    private static void moveDown() {
        if (currentRow < spreadsheet.length - 1) {
            currentRow++;
        }
    }

    private static void moveLeft() {
        if (currentColumn > 1) {
            currentColumn--;
        }
    }

    private static void moveRight() {
        if (currentColumn < spreadsheet[0].length - 1) {
            currentColumn++;
        }
    }

    private static void enterText(Scanner scanner) {
        System.out.println("Enter the text for the cell: ");
        String text = scanner.nextLine();

        if (text.length() > 7) {
            spreadsheet[currentRow][currentColumn] = text.substring(0, 7);
        } else if (text.length() < 7) {
            int spaces = 7 - text.length();
            text = " ".repeat(spaces) + text;
            spreadsheet[currentRow][currentColumn] = text;
        } else {
            spreadsheet[currentRow][currentColumn] = text;
        }
    }

    private static String convertColumnToLetter(int column) {
        char letter = (char) ('A' + column);
        return String.valueOf(letter);
    }
}