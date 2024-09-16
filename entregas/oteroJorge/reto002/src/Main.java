import core.Options;
import print.PrintInstructions;


public class Main {
    public static void main(String[] args) {

        PrintInstructions printInstructions = new PrintInstructions();

        printInstructions.addInstruction("W: Move Up");
        printInstructions.addInstruction("A: Move Left");
        printInstructions.addInstruction("S: Move Down");
        printInstructions.addInstruction("D: Move Right");
        printInstructions.addInstruction("E: Edit Cell");
        printInstructions.addInstruction("Q: Exit");

        printInstructions.printMenu();

        Options options = new Options(15,10);
        options.createSpreadSheet();
        options.options();
    }
}
