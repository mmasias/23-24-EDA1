import java.util.Scanner;

public class Control {
    public static void controls(SpreadSheet Spread){

        Scanner input = new Scanner(System.in);
        char userInput = input.nextLine().charAt(0);
        switch (userInput) {

            case 's', 'S':
                Spread.pos[0] = Spread.pos[0] + 1;
                break;
            case 'w', 'W':
                Spread.pos[0] = Spread.pos[0] - 1;
                break;
            case 'a', 'A':
                Spread.pos[1] = Spread.pos[1] - 1;
                break;
            case 'd', 'D':
                Spread.pos[1] = Spread.pos[1] + 1;
                break;

            case 'E', 'e':
                overWrite(Spread);
                break;

            case 'q', 'Q':
                System.exit(0);
                break;
        }

    }

    public static void overWrite(SpreadSheet Spread) {
        System.out.println("Ingrese texto");
        System.out.println("Celda actual -> [" + (char) ('A' + Spread.pos[1]) + (Spread.pos[0] + 1) + "]");
        System.out.println("valor actual -> [" + Spread.spreadSheet[Spread.pos[1]][Spread.pos[0]] + "]");
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();

        if(userInput.length() > 7) {
            Spread.spreadSheet[Spread.pos[0]][Spread.pos[1]] = userInput.substring(0, 7);
        } else {
            Spread.spreadSheet[Spread.pos[0]][Spread.pos[1]] = userInput;
        }
    }
}
