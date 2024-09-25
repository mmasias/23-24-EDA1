package src;

import java.util.Scanner;

public class Excel {

    private static final int ROWS = 15;
    private static final int COLUMNS = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Funcionalidades funcionalidades = new Funcionalidades();
        PrintExcel print = new PrintExcel();

        String[][] excel = new String[ROWS][COLUMNS];
        funcionalidades.startingExcel(excel);

        int[] position = { 0, 0 };
        boolean operating = true;

        while (operating) {
            print.printing(excel, position);
            char command = scanner.next().toUpperCase().charAt(0);
            operating = funcionalidades.processCommand(command, excel, position);
        }

        print.clean();
        scanner.close();
       
        
    }
}
