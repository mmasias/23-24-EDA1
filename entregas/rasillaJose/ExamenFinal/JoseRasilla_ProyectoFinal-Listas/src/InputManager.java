import java.util.Scanner;

public class InputManager {

    public static String promptString(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        String userInput = scanner.nextLine();
        return userInput;
    }

    public static int promptInt(String prompt) {
        Scanner scanner = new Scanner(System.in);
        int userInput;
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a valid integer: ");
            scanner.next();
        }
        userInput = scanner.nextInt();
        return userInput;
    }

    public static void closeScanner() {
        scanner.close();
    }

}
