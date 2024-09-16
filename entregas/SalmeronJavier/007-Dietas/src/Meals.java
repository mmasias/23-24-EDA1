class MealNode {
    String meal;
    MealNode[] children;
    Food food;

    public MealNode(String meal) {
        this.meal = meal;
        this.children = new MealNode[5];
        this.food = new Food();
    }

    public Food food() {
        return food;
    }

}

class MealsTree {
    MealNode root;

    MealsTree(String rootMeal) {
        root = new MealNode(rootMeal);
        initializeMealsTree(this.root);
    }

    private void initializeMealsTree(MealNode root) {
        root.children[0] = new MealNode("Breakfast");
        root.children[1] = new MealNode("Morning Snack");
        root.children[2] = new MealNode("Lunch");
        root.children[3] = new MealNode("Late Snack");
        root.children[4] = new MealNode("Dinner");
    }

    public MealNode getMeal(String mealName) {
        for (MealNode child : root.children) {
            if (child.meal.equalsIgnoreCase(mealName)) {
                return child;
            }
        }
        return null;
    }

}
