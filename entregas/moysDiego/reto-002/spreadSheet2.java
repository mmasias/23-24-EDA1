public class SpreadSheet2 {
    private final int COLUMNS_NUMBER = 10;
    private final int ROWS_NUMBER = 15;
    private Cell[][] cells;
    private int actualRow;
    private int actualColumn;

    public SpreadSheet() {
        cells = new Cell[ROWS_NUMBER][COLUMNS_NUMBER];
        for (int row = 0; row < ROWS_NUMBER; row++) {
            for (int col = 0; col < COLUMNS_NUMBER; col++) {
                cells[row][col] = new Cell();
            }
        }
        actualRow = 0;
        actualColumn = 0;
    }

    public Cell getCell(int row, int col) {
        return cells[row][col];
    }

    public int getActualRow() {
        return actualRow;
    }

    public int getActualColumn() {
        return actualColumn;
    }

    public void moveUp() {
        if (actualRow > 0) {
            actualRow--;
        }
    }

    public void moveDown() {
        if (actualRow < ROWS_NUMBER - 1) {
            actualRow++;
        }
    }

    public void moveLeft() {
        if (actualColumn > 0) {
            actualColumn--;
        }
    }

    public void moveRight() {
        if (actualColumn < COLUMNS_NUMBER - 1) {
            actualColumn++;
        }
    }

    public int getRowsNumber() {
        return ROWS_NUMBER;
    }

    public int getColumnsNumber() {
        return COLUMNS_NUMBER;
    }
}