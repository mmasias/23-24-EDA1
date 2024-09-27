import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int rows = 15;
        final int columns = 10;
        String [][] matrix = new String[rows][columns];

        printMenu();
        createSpreadSheet(matrix);
        options(matrix);

    }

    static void createSpreadSheet(String [][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j]= " ";
            }
        }
    }
    public static void printSpreadSheet(String[][] matrix, int cellLength) {
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

        for (int i = 0; i < matrix.length; i++) {

            String rowNumber = String.format("%2d", i + 1);

            System.out.print(rowNumber + " |");
            for (int j = 0; j < 10; j++) {
                String value = "";
                if (j < matrix[i].length) {
                    value = matrix[i][j];
                }

                value = String.format("%-" + cellLength + "s", value);

                System.out.print(" " + value + " |");
            }
            System.out.println();
        }
        System.out.print("   ");
        for (int i = 0; i < 10; i++) {
            System.out.print("+---------");
        }
        System.out.println("+");
    }
    public static void options(String[][] matrix) {
        Scanner scanner = new Scanner(System.in);
        int actualRow = 0;
        int actualColumn = 0;
        int cellLength = 7;

        while (true) {
            printSpreadSheet(matrix, cellLength);

            System.out.println("Actual Position: Row [" + (actualRow + 1) + "], Column [" + (char) ('A' + actualColumn) + "]");

            System.out.print("Option: ");
            String option = scanner.nextLine().toUpperCase();

            switch (option) {
                case "W":
                    if (actualRow > 0) {
                        actualRow--;
                    }
                    break;
                case "A":
                    if (actualColumn > 0) {
                        actualColumn--;
                    }
                    break;
                case "S":
                    if (actualRow < 9) {
                        actualRow++;
                    }
                    break;
                case "D":
                    if (actualColumn < 9) {
                        actualColumn++;
                    }
                    break;
                case "E":
                    System.out.print("Text: ");
                    String text = scanner.nextLine();

                    if (text.length() > cellLength) {
                        text = text.substring(0, cellLength);
                    }

                        matrix[actualRow][actualColumn] = text;
                    break;
                case "Q":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }
    static void printMenu() {
        System.out.println("Options:");
        System.out.println("W - Up");
        System.out.println("A - Left");
        System.out.println("S - Down");
        System.out.println("D - Right");
        System.out.println("E - Add text");
        System.out.println("Q - Exit");
    }
}
