package core;

import java.util.Scanner;

public class Options {
    private int rows;
    private int columns;
    private String[][] spreadSheet;

    public Options(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.spreadSheet = new String[rows][columns];
    }
    public void createSpreadSheet() {
        for (int i = 0; i < this.spreadSheet.length; i++) {
            for (int j = 0; j < this.spreadSheet[i].length; j++) {
                this.spreadSheet[i][j]= " ";
            }
        }
    }
    public void printSpreadSheet(int cellLength) {
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

        for (int i = 0; i < this.spreadSheet.length; i++) {

            String rowNumber = String.format("%2d", i + 1);

            System.out.print(rowNumber + " |");
            for (int j = 0; j < 10; j++) {
                String value = "";
                if (j < this.spreadSheet[i].length) {
                    value = this.spreadSheet[i][j];
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
    public void options() {
        Scanner scanner = new Scanner(System.in);
        int actualRow = 0;
        int actualColumn = 0;
        int cellLength = 7;

        while (true) {
            printSpreadSheet( cellLength);

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

                    this.spreadSheet[actualRow][actualColumn] = text;
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
}
