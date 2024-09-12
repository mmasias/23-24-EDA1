package veronikaEsparragoza;

import java.util.Scanner;

public class main {
    static Scanner scanner = new Scanner(System.in);
    static String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};

    public static void main(String[] args) {

        int[] userInitialPosition = {0, 1};
        boolean exitProgram = false;
        String[][] table = new String[15][10];
        initialDataInTable(table);

        while (!exitProgram) {
            printTableHeader();
            printTableBody(table, userInitialPosition);
            printInformation();
            String inputUser = scanner.nextLine();
            exitProgram = programsEnds(inputUser);
            userInputAndMovement(inputUser, userInitialPosition, table);
        }
    }

    private static void initialDataInTable(String[][] table){
        for (int column = 0; column < table.length; column++) {
            for (int row = 0; row < table[0].length; row++){
                table[column][row] = " ".repeat(7);
            }
        }
    }
    private static void printTableHeader(){
        System.out.print("__");
        for (int letter = 0; letter < alphabet.length; letter++){
            System.out.print("|__ " + alphabet[letter] + " __|");
        }
    }
    private static void printNumberOfRows(int column){
        System.out.println("");
        if(column < 10){
            System.out.print("0" + column);
        } else {
            System.out.print(column);
        };
    }
    private static void printTableBody(String[][] table, int[] userPosition){
        for (int column = 1; column < table.length; column++) {
            printNumberOfRows(column);
            for (int row = 0; row < table[0].length; row++) {
                if (userPosition[0] == row && userPosition[1] == column) {
                    System.out.print("\u001B[31m[" + table[column][row] +"]\u001B[0m");
                } else{
                    System.out.print("|" + table[column][row] + "|");
                }
            }
        }
        System.out.println("");
    }
    private static void putTextInCell(int[] userPosition, String[][] table){
        String textInputInCell = counterLetter(scanner.nextLine());
        table[userPosition[1]][userPosition[0]] = textInputInCell;
    }
    private static void userInputAndMovement(String inputUser, int[] userPosition, String[][] table) {
        switch (inputUser) {
            case "w":
                if (userPosition[1] > 1) {
                    userPosition[1]--;
                }
                break;
            case "s":
                if (userPosition[1] < table.length - 1) {
                    userPosition[1]++;
                }
                break;
            case "a":
                if (userPosition[0] > 0) {
                    userPosition[0]--;
                }
                break;
            case "d":
                if (userPosition[0] < table[0].length - 1) {
                    userPosition[0]++;
                }
                break;
            case ":q":
                System.out.println("Programa finalizado");
                break;
            case ":e":
                System.out.println("Que deseas escribir: ");
                putTextInCell(userPosition, table);
                break;
            default:
                System.out.println("Falta una tecla");
                printTableBody(table, userPosition);
                break;
        }
    }
    private static String counterLetter(String textInputinCell){
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
    private static boolean programsEnds(String inputUser){
        if (inputUser.equals(":q")){
            return true;
        } else {
            return false;
        }
    }
    private static void printInformation(){
        System.out.println("Para moverte usa las teclas w, a, s, d");
        System.out.println("Para escribir en una celda usa ':e'");
        System.out.println("Para salir usa ':q'");
        System.out.print("Que deseas hacer: ");
    }
}
