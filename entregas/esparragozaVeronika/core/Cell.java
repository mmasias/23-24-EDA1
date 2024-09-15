package esparragozaVeronika.core;

public class Cell {
    private String[][] cells;
    private User user;
    public Cell(String[][] cells) {
        this.cells = cells;
    }
    public Cell(String[][] cells, User user) {
        this.cells = cells;
        this.user = user;
    }
    public String getCell(int column, int row){
        return cells[column][row];
    }
    public void setCellValue(int column, int row, String value) {
        this.cells[column][row] = value;
    }

    public void putTextInCell(String[][] table, String dataEnter){
        String textInputInCell = counterLetter(dataEnter);
        table[user.getUserPosition()[1]][user.getUserPosition()[0]] = textInputInCell;
    }
    public String counterLetter(String textInputinCell) {
        if (textInputinCell == null) {
            return " ".repeat(8);
        } else if (textInputinCell.length() >= 7) {
            return textInputinCell.substring(0, 7);
        } else {
            int spacesToAdd = 7 - textInputinCell.length();
            StringBuilder formatted = new StringBuilder(textInputinCell);
            for (int i = 0; i < spacesToAdd; i++) {
                formatted.append(" ");
            }
            return formatted.toString();
        }
    }
}
