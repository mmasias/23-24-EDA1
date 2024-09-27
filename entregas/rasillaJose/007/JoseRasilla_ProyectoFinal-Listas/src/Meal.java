import structure.JavaList;

public class Meal {
    public String mealName = "";
    public JavaList<Intake> intakes;

    public Meal(String mealName) {
        this.mealName = mealName;
        this.intakes = new JavaList<>();
    }

    public void addIntake(Intake intake) {
        intakes.addNode(intake);
    }
}
