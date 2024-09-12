package Arboles.model;
import java.util.Scanner;

class SurveyNode {
    String data;
    SurveyNode[] children;

    public SurveyNode(String data, int numChildren) {
        this.data = data;
        this.children = new SurveyNode[numChildren];
    }

    public void addChild(int index, SurveyNode child) {
        if (index >= 0 && index < children.length) {
            children[index] = child;
        } else {
            System.out.println("Invalid index for adding child.");
        }
    }

    public SurveyNode getChild(int index) {
        if (index >= 0 && index < children.length) {
            return children[index];
        } else {
            return null;
        }
    }

    public void printSurvey() {
        printSurvey(this, 0);
    }

    private void printSurvey(SurveyNode node, int depth) {
        if (node == null) {
            return;
        }

        for (int i = 0; i < depth; i++) {
            System.out.print("    ");
        }

        System.out.println(node.data);

        for (SurveyNode child : node.children) {
            printSurvey(child, depth + 1);
        }
    }
}

public class NutritionSurveySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creating the root node for the survey hierarchy
        SurveyNode root = new SurveyNode("Paciente", 1);

        // Example survey data
        SurveyNode survey = new SurveyNode("Encuesta", 5);
        SurveyNode day1 = new SurveyNode("Dia 1", 5);
        SurveyNode breakfast = new SurveyNode("Desayuno", 0);

        // Adding food items to breakfast
        addFoodItems(breakfast, scanner);

        day1.addChild(0, breakfast);
        survey.addChild(0, day1);

        // Adding survey to the root
        root.addChild(0, survey);

        // Printing the survey hierarchy
        root.printSurvey();
    }

    private static void addFoodItems(SurveyNode node, Scanner scanner) {
        int foodCount = 0;
        while (true) {
            System.out.println("Ingrese un alimento para " + node.data + " (-1 para terminar / -2 para listar alimentos ingresados)");
            String foodItem = scanner.nextLine();

            if ("-1".equals(foodItem)) {
                break;
            } else if ("-2".equals(foodItem)) {
                System.out.println("Alimentos ingresados en " + node.data + ": " + foodCount);
            } else {
                SurveyNode foodNode = new SurveyNode(foodItem, 0);
                node.addChild(foodCount, foodNode);
                foodCount++;
            }
        }
    }
}
