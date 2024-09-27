import java.util.Scanner;

public class SpreadSheetManager {
    static SpreadSheet spreadsheet = new SpreadSheet();

    public enum Direction {
        up, down, right, left
    };

    public static int xPosition = 0;
    public static int yPosition = 0;

    public static void main(String[] args) {
        setUp();
        userInput();
    }

    public static void setUp() {
        PrintManager.printConstructionMessage();
        spreadsheet.buildSpreadSheet();
        PrintManager.printSpreadSheet(xPosition, yPosition, spreadsheet);
    }

    public static void userInput() {
        Scanner s = new Scanner(System.in);
        PrintManager.printInstructions();
        String instruction = s.nextLine();
        switch (instruction) {
            case "e":
                PrintManager.printModifyInstructions();
                String newContent = s.nextLine();
                modify(newContent);
                break;
            case "w":
                move(Direction.up);
                break;
            case "a":
                move(Direction.left);
                break;
            case "s":
                move(Direction.down);
                break;
            case "d":
                move(Direction.right);
                break;
            case "x":
                PrintManager.printCloseMessage();
                break;
            default:
                PrintManager.printWrongInput();
                userInput();
                break;
        }
        s.close();
    }

    public static void move(Direction direction) {
        switch (direction) {
            case up:
                if (xPosition > 0) {
                    xPosition--;
                }
                break;
            case down:
                if (xPosition < 14) {
                    xPosition++;
                }
                break;
            case left:
                if (yPosition > 0) {
                    yPosition--;
                }
                break;
            case right:
                if (yPosition < 9) {
                    yPosition++;
                }
                break;
            default:
                break;
        }
        PrintManager.printSpreadSheet(xPosition, yPosition, spreadsheet);
        userInput();
    }

    public static void modify(String newContent) {
        spreadsheet.setCell(xPosition, yPosition, newContent);
        PrintManager.printSpreadSheet(xPosition, yPosition, spreadsheet);
        userInput();
    }

}