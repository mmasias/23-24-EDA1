
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        final int numRows = 15;
        final int numColumns = 10;
        final int cellWidth = 6;

        SpreadSheet spreadsheet = new SpreadSheet(numRows, numColumns);
        CellPosition currentPosition = new CellPosition(0, 0);
        Scanner input = new Scanner(System.in);
        char userInput;
        boolean quit = false;

        Printer.printHeader();
        Printer.printSpreadsheet(spreadsheet, currentPosition);
        
        while (!quit) {
            System.out.println("Comandos: [W] Arriba, [S] Abajo, [A] Izquierda, [D] Derecha, [Q] Salir, [E] Ingresar Texto");
            System.out.println("Ingrese Comando: ");
            userInput = input.nextLine().toUpperCase().charAt(0);

            switch (userInput) {
                case 'W':
                    currentPosition.moveUp();
                    break;
                case 'S':
                    currentPosition.moveDown(spreadsheet.getNumRows());
                    break;
                case 'A':
                    currentPosition.moveLeft();
                    break;
                case 'D':
                    currentPosition.moveRight(spreadsheet.getNumColumns());
                    break;
                case 'Q':
                    System.out.println("Adios");
                    quit = true;
                    break;
                case 'E':
                    System.out.println("Ingrese Texto:");
                    String content = input.nextLine();
                    content = content.length() > cellWidth ? content.substring(0, cellWidth) : content;
                    spreadsheet.setCell(currentPosition.getRow(), currentPosition.getColumn(), content);
                    break;
                default:
                    System.out.println("Comando no válido.");
                    break;
            }
            Printer.printSpreadSheet(spreadsheet, currentPosition);
        }
    }
}
