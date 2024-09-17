import java.util.Scanner;

public class HojaDeCalculo001 {
    private final int ROWS = 15;
    private final int COLS = 10;
    private String[][] cells = new String[ROWS][COLS];
    private int currentRow = 0;
    private int currentCol = 0;
    private Scanner scanner = new Scanner(System.in);

    public HojaDeCalculo001() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                cells[i][j] = "";
            }
        }
    }

    public void display() {
        System.out.print("\t");
        for (int i = 0; i < COLS; i++) {
            System.out.print((char) ('A' + i) + "\t\t");
        }
        System.out.println("\n\t" + "-".repeat(COLS * 10 - 1));

        for (int i = 0; i < ROWS; i++) {
            System.out.print((i + 1) + " |\t");
            for (int j = 0; j < COLS; j++) {
                System.out.print(cells[i][j] + "\t\t");
            }
            System.out.println("\n\t" + "-".repeat(COLS * 10 - 1));
        }

        System.out.println("Current cell --> (" + (char) ('A' + currentCol) + (currentRow + 1)+")");
        System.out.println("Press 'e' to add text to the current cell.");
        System.out.println("Press 'q' to exit.");
    }

    public boolean processCommand() {
        System.out.print("Enter command (w/a/s/d/e/q): ");
        char command = scanner.nextLine().charAt(0);

        switch (command) {
            case 'w':
                if (currentRow > 0) currentRow--;
                break;
            case 's':
                if (currentRow < ROWS - 1) currentRow++;
                break;
            case 'a':
                if (currentCol > 0) currentCol--;
                break;
            case 'd':
                if (currentCol < COLS - 1) currentCol++;
                break;
            case 'e':
                System.out.print("Enter value for cell " + (char) ('A' + currentCol) + (currentRow + 1) + ": ");
                String input = scanner.nextLine();
                cells[currentRow][currentCol] = input.substring(0, Math.min(input.length(), 7));
                break;
            case 'q':
                System.out.println("Exiting...");
                return false;
            default:
                System.out.println("Invalid command!");
                break;
        }
        return true;
    }

    public void closeScanner() {
        scanner.close();
    }


}
