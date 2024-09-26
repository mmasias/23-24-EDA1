import java.util.Scanner;

public class SpreadSheetApp {
    private final SpreadSheet spreadsheet;
    private final Scanner scanner;

    public SpreadSheetApp(int rows, int columns) {
        this.spreadsheet = new SpreadSheet(rows, columns);
        this.scanner = new Scanner(System.in);
    }

    public void start() {


        while (true) {
            spreadsheet.printSheet();
            System.out.println("Utilice las teclas W, A, S y D para moverse.");
            System.out.println("Utiliza la tecla 'E' para ingresar texto.");
            System.out.println("Utiliza la tecla 'Q' para salir de la aplicación.");
            System.out.print("Ingrese un comando: ");
            String command = scanner.next();
            handleCommand(command);
        }
    }

    private void handleCommand(String command) {
        switch (command.toLowerCase()) {
            case "w":
                spreadsheet.moveCurrentRow(-1);
                break;
            case "s":
                spreadsheet.moveCurrentRow(1);
                break;
            case "a":
                spreadsheet.moveCurrentColumn(-1);
                break;
            case "d":
                spreadsheet.moveCurrentColumn(1);
                break;
            case "e":
                System.out.print("Ingrese el valor: ");
                scanner.nextLine();
                String value = scanner.nextLine();
                spreadsheet.setCellValue(value);
                break;
            case "q":
                System.out.println("--------------------------------");
                System.out.println("Has salido de la hoja....!!!!");
                System.out.println("Calificación = 10/10 :)");
                System.exit(0);
                break;
            default:
                System.out.println("Comando no válido.");
        }
    }
}
