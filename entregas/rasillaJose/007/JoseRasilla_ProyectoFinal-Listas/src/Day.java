import structure.JavaList;

public class Day{
    public String name = "";
    public JavaList<Meal> meals;

    public Day(String dayName) {
        this.name = dayName;
        this.meals = new JavaList<>();
        addMeals();
    }

    private void addMeals() {
        meals.addNode(new Meal("Breakfast"));
        meals.addNode(new Meal("Appetizer"));
        meals.addNode(new Meal("Lunch"));
        meals.addNode(new Meal("Snack"));
        meals.addNode(new Meal("Dinner"));
    }

}
