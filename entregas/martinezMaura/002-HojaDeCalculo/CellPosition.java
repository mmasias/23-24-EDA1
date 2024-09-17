package main; 

public class CellPosition {
    private int row;
    private int column;

    public CellPosition(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public void moveUp() {
        if (row > 0) {
            row--;
        }
    }

    public void moveDown(int maxRows) {
        if (row < maxRows - 1) {
            row++;
        }
    }

    public void moveLeft() {
        if (column > 0) {
            column--;
        }
    }

    public void moveRight(int maxColumns) {
        if (column < maxColumns - 1) {
            column++;
        }
    }
}