class MealNode {
    String meal;
    Food food;

    public MealNode(String meal) {
        this.meal = meal;
        this.food = new Food();
    }

    public Food getFood() {
        return food;
    }
}

class MealsList {
    List<MealNode> meals;

    MealsList() {
        meals = new List<>();
        initializeMealsList();
    }

    private void initializeMealsList() {
        meals.insert(new MealNode("Breakfast"), -1);
        meals.insert(new MealNode("Morning Snack"), -1);
        meals.insert(new MealNode("Lunch"), -1);
        meals.insert(new MealNode("Late Snack"), -1);
        meals.insert(new MealNode("Dinner"), -1);
    }

    public MealNode getMeal(String mealName) {
        for (MealNode meal : meals) {
            if (meal.meal.equalsIgnoreCase(mealName)) {
                return meal;
            }
        }
        return null;
    }
}