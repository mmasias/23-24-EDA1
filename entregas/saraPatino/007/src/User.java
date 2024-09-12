package src;
import java.util.Scanner;

public class User {
    public User () {}

    public static String name(Scanner scanner){
        System.out.println("Ingresa tu nombre");
        String name = scanner.nextLine();
        return name;
    }
}
