package main; 


public class SpreadSheet {
    private String[][] cells;
    private int numRows;
    private int numColumns;

    public SpreadSheet(int numRows, int numColumns) {
        this.numRows = numRows;
        this.numColumns = numColumns;
        cells = new String[numRows][numColumns];
    }

    public int getNumRows() {
        return numRows;
    }

    public int getNumColumns() {
        return numColumns;
    }

    public String getCell(int row, int column) {
        return cells[row][column];
    }

    public void setCell(int row, int column, String content) {
        cells[row][column] = content;
    }
}




