package esparragozaVeronika.core;
public class Spreadsheet {
    private Cell cell;
    public Spreadsheet(String[][] table) {
        this.cell = new Cell(table);
        for (int column = 0; column < table.length; column++) {
            for (int row = 0; row < table[0].length; row++) {
                cell.setCellValue(column, row, " ".repeat(7));
            }
        }
    }
}
