package print;

import java.util.ArrayList;
import java.util.List;

public class PrintInstructions {
    private List<String> instructions;
    public PrintInstructions() {
        this.instructions = new ArrayList<>();
    }
    public void addInstruction(String instruction) {
        instructions.add(instruction);
    }
    public void printMenu() {
        for (String instruction : instructions) {
            System.out.println(instruction);
        }
    }
}
