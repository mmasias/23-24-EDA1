package main;


public class Printer {
    public static void printHeader() {
        System.out.println("+--------------------------------------------------------------------------------------------------------+");
        System.out.println("| 0  |    A    |    B    |    C    |    D    |    E    |    F    |    G    |    H    |    I    |    J    |");
    }

    public static void printSpreadsheet(SpreadSheet spreadsheet, CellPosition currentPosition) {
        int numRows = spreadsheet.getNumRows();
        int numColumns = spreadsheet.getNumColumns();

       
        printHeader();

        
        for (int row = 0; row < numRows; row++) {
            if (row <= 8) {
                System.out.print("|  " + (row + 1) + " |");
            } else {
                System.out.print("| " + (row + 1) + " |");
            }

            for (int column = 0; column < numColumns; column++) {
                String content = spreadsheet.getCell(row, column);

                if (row == currentPosition.getRow() && column == currentPosition.getColumn()) {
                    System.out.print(" [" + formatContent(content) + "] |");
                } else {
                    System.out.print("  " + formatContent(content) + " |");
                }
            }

            System.out.println();
        }

       
        System.out.println("+--------------------------------------------------------------------------------------------------------+");
    }

    private static String formatContent(String content) {
        final int cellWidth = 6;
        if (content.length() > cellWidth) {
            return content.substring(0, cellWidth);
        } else {
            StringBuilder sb = new StringBuilder(content);
            while (sb.length() < cellWidth) {
                sb.insert(0, " ");
            }
            return sb.toString();
        }
    }

    public static void printSpreadSheet(SpreadSheet spreadsheet, CellPosition currentPosition) {
    }
}

