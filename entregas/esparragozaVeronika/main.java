package esparragozaVeronika;
import esparragozaVeronika.core.*;
import esparragozaVeronika.view.*;

import java.util.Scanner;

public class main {
    static Scanner scanner = new Scanner(System.in);
    public static boolean isOperative;
    public static void main(String[] args) {
        initializeProgram();
    }
    public static void initializeProgram() {
        isOperative = true;
        String[][] table = new String[15][10];
        int[] initialPosition = {0, 1};
        User currentUser = new User();
        Cell cells = new Cell(table, currentUser);
        currentUser.setUserPosition(initialPosition);
        new Spreadsheet(table);
        Movement userMovement = new Movement(currentUser, cells);

        while (isOperative) {
            new ExcelStructure(table, cells, currentUser);
            System.out.println("Introduce una tecla ('w', 's', 'a', 'd', ':q' para salir, ':e' para editar): ");
            String userInput = scanner.nextLine();
            userMovement.inputUserMovement(userInput, table);
        }
        System.out.println("Programa finalizado");
    }
}