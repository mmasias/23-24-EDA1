import java.util.Scanner;

public class UserIO {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getInput(String msg){
        System.out.print(msg);
        String userInput = scanner.nextLine();
        return userInput;
    }
    
}
