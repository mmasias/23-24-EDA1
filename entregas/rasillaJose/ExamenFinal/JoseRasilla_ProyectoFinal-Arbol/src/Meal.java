import structure.JavaList;
import structure.TreeNode;

public class Meal extends TreeNode {
    public String mealName = "";
    public JavaList<Intake> intakes;

    public Meal(String mealName) {
        super(false, "Meal");
        this.mealName = mealName;
        this.intakes = new JavaList<>();
    }

    public void addIntake(Intake intake) {
        intakes.addNode(intake);
    }
}
