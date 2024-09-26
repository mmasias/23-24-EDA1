import java.util.Scanner;

public class SpreadSheet {

    private String reset = "\u001B[0m";
    private String green = "\033[32m";
    private String yellow= "\033[33m";
    private String cyan= "\033[36m";
    private String red= "\033[31m";
    private String purple="\033[35m";
    private String white = "\033[37m";

    private final int rows;

    private final int columns;

    private final Cell[][] table;

    private int currentRow = 0;

    private int currentColumn = 0;

    private final String[] alphabet = {
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "V", "W", "X", "Y", "Z"
    };

    public SpreadSheet(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.table = new Cell[rows][columns];
        initializeTable();
    }

    private void initializeTable() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                table[i][j] = new Cell();
            }
        }
    }


    public void printSheet() {
        printHeaderBorders();
        printColumns();
        printHorizontalBorders();
        for (int i = 0; i < table.length; i++) {
            System.out.print((i + 1) + "\t");
            for (int j = 0; j < table[i].length; j++) {
                if (j == 0 || j < table[i].length - 1) {
                    String cellContent = table[i][j].formatCell();
                    if (i == currentRow && j == currentColumn) {
                        System.out.print("|\u001B[47m" + cellContent + " \u001B[0m");
                    } else {
                        System.out.print("| " + cellContent);
                    }
                }
                if (j == (table[i].length - 1)) {
                    String cellContent = table[i][j].formatCell();
                    if (i == currentRow && j == currentColumn) {
                        System.out.print("|\u001B[47m" + cellContent + "\u001B[0m|");
                    } else {
                        System.out.print("| " + cellContent + "|");
                    }
                }
            }
            System.out.println();
        }
        printHorizontalBorders();
        System.out.println(this.cyan + "Celda actual → [" + alphabet[currentColumn] + (currentRow + 1) + "]" + this.reset);
        String currentCellContent = table[currentRow][currentColumn].getContent();
        System.out.println(this.purple + "Contenido actual: " + (currentCellContent != null ? currentCellContent : "") + this.reset);
    }



    public void moveCurrentRow(int delta) {
        int newRow = currentRow + delta;
        if (newRow >= 0 && newRow < rows) {
            currentRow = newRow;
        }
    }

    public void moveCurrentColumn(int delta) {
        int newColumn = currentColumn + delta;
        if (newColumn >= 0 && newColumn < columns) {
            currentColumn = newColumn;
        }
    }

    public void setCellValue(String value) {
        table[currentRow][currentColumn].setContent(value);
    }

    private void printHorizontalBorders() {
        System.out.print("\t");
        for (int i = 0; i < table[0].length; i++) {
            if (i == 0 || i < table[0].length - 1) {
                System.out.print("+--------");
            }
            if (i == (table[0].length - 1)) {
                System.out.print("+-------+");
            }
        }
        System.out.println();
    }

    private void printHeaderBorders(){
        System.out.print("\t");
        for (int h = 0; h < table[0].length; h++) {
            if (h == 0 || h < table[0].length - 1) {
                System.out.print("+--------");
            }
            if (h == (table[0].length - 1)) {
                System.out.print("+-------+");
            }
        }
        System.out.println();
    }

    private void printColumns(){
        System.out.print("\t    ");

        for(int i = 0; i < table[0].length; i++){
            System.out.print(alphabet[i] + "        ");
        }

        System.out.println();
    }



    /*private final String[][] table;
    private int currentRow = 0;
    private int currentColumn = 0;



    public SpreadSheet(int rows, int columns){
        this.table = new String[rows][columns];
    }








    private String formatCell(String cellValue) {
        if (cellValue == null) {
            return "       ";
        } else if (cellValue.length() >= 7) {
            return cellValue.substring(0, 7);
        } else {
            int spacesToAdd = 7 - cellValue.length();
            StringBuilder formatted = new StringBuilder(cellValue);
            for (int i = 0; i < spacesToAdd; i++) {
                formatted.append(" ");
            }
            return formatted.toString();
        }
    }


    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printSheet();
            System.out.println(this.yellow+"Utilice las teclas W, A, S y D para moverse."+this.reset);
            System.out.println(this.green+"Utiliza la tecla 'E' para ingresar texto."+this.reset);
            System.out.println(this.red+"Utiliza la tecla 'Q' para salir de la aplicacion."+this.reset);
            System.out.print(this.white+"Ingrese un comando: "+this.reset);
            String command = scanner.next();
            handleCommand(command, scanner);
        }
    }


    private void handleCommand(String command, Scanner scanner) {
        switch (command) {
            case "w":
                if (currentRow > 0) {
                    currentRow--;
                }
                break;
            case "s":
                if (currentRow < table.length - 1) {
                    currentRow++;
                }
                break;
            case "a":
                if (currentColumn > 0) {
                    currentColumn--;
                }
                break;
            case "d":
                if (currentColumn < table[0].length - 1) {
                    currentColumn++;
                }
                break;
            case "e":
                System.out.print("Ingrese el valor: ");
                String value = scanner.next();
                table[currentRow][currentColumn] = value;
                break;
            case "q":
                System.out.println("--------------------------------");
                System.out.println("Has salido de la hoja....!!!!");
                System.out.println("Calificacion = 10/10 :)");
                System.exit(0);
                break;
            default:
                System.out.println("Comando no válido.");
        }
    }*/
}
