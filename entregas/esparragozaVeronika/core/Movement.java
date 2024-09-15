package esparragozaVeronika.core;

import esparragozaVeronika.main;

import java.util.Scanner;

public class Movement {
    private User user;
    private Cell cell;
    static Scanner scanner = new Scanner(System.in);
    public Movement(User user, Cell cell) {
        this.user = user;
        this.cell = cell;
    }
    public void inputUserMovement(String userInput, String[][] table) {
        switch (userInput) {
            case "w":
                if (user.getUserPosition()[1] > 1) {
                    user.getUserPosition()[1]--;
                }
                break;
            case "s":
                if (user.getUserPosition()[1] < table.length - 1) {
                    user.getUserPosition()[1]++;
                }
                break;
            case "a":
                if (user.getUserPosition()[0] > 0) {
                    user.getUserPosition()[0]--;
                }
                break;
            case "d":
                if (user.getUserPosition()[0] < table[0].length - 1) {
                    user.getUserPosition()[0]++;
                }
                break;
            case ":q":
                main.isOperative = false;
                break;
            case ":e":
                System.out.println("Que deseas escribir: ");
                String dataEnter = scanner.nextLine();
                cell.putTextInCell(table, dataEnter);

                break;
            default:
                System.out.println("Tecla no permitida");
                break;
        }
    }
}
