package esparragozaVeronika.view;
import esparragozaVeronika.core.*;

public class ExcelStructure {
    static String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N"};
    private Cell cells;
    private User user;
    public ExcelStructure(String[][] table, Cell cells, User user) {
        this.cells = cells;
        this.user = user;
        printTableHeader(table);
        printTableBody(table);
    }
    public void printTableHeader(String[][] table){
        System.out.print("__");
        for (int letter = 0; letter < table[0].length; letter++){
            System.out.print("|__ " + alphabet[letter] + " __|");
        }
    }
    public void printTableBody(String[][] table){
        for (int column = 1; column < table.length; column++) {
            printNumberOfRows(column);
            for (int row = 0; row < table[0].length; row++) {
                if (user.getUserPosition()[0] == row && user.getUserPosition()[1] == column) {
                    System.out.print("\u001B[31m[" + cells.getCell(column, row ) +"]\u001B[0m");
                } else{
                    System.out.print("|" + cells.getCell(column, row ) + "|");
                }
            }
        }
        System.out.println("");
    }
    private void printNumberOfRows(int column){
        System.out.println("");
        if(column < 10){
            System.out.print("0" + column);
        } else {
            System.out.print(column);
        };
    }

}
