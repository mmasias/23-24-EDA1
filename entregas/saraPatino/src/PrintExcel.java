package src;

public class PrintExcel {
    private static final int ROWS = 15;
    private static final int COLUMNS = 10;
    public Funcionalidades funcionalidades = new Funcionalidades();

    public void printHeaders() {
        System.out.print("      ");
        for (int column = 0; column < COLUMNS; column++) {
            char columnLetter = (char) ('A' + column);
            System.out.printf("%-8s", columnLetter);
        }
        System.out.println();
    }

    public void printLine() {
        System.out.print("     +");
        for (int column = 0; column < COLUMNS; column++) {
            System.out.print("-------+");
        }
        System.out.println();
    }

    public void printing(String[][] excel, int[] position) {
        int currentRow = position[0];
        int currentColumn = position[1];

        clean();
        printOptions(position);
        printHeaders();
        printLine();

        for (int row = 0; row < ROWS; row++) {
            System.out.printf("%-5d|", row + 1);
            for (int column = 0; column < COLUMNS; column++) {
                String celda = excel[row][column];
                celda = celda.length() > 5 ? celda.substring(0, 5) : String.format("%-5s", celda);
                if (row == currentRow && column == currentColumn) {
                    celda = "[" + celda + "]";
                } else {
                    celda = " " + celda + " ";
                }

                System.out.print(celda + "|");
            }
            System.out.println();
        }
        printLine();
        funcionalidades.moving(2, 5);

    }

    public void printOptions(int[] position) {
        int currentRow = position[0];
        int currentColumn = position[1];

        System.out.println("DESPLAZAMIENTO: wasd | Edición: e | Salir: f");
        System.out.println("[" + (char) ('A' + currentColumn) + (currentRow + 1) + "] ");
    }

    

    public void clean() {
        System.out.print("\033[0;0H\033[0;0J");
        System.out.flush();
    }
}