class DayNode {
    String day;
    DayNode[] children;
    MealsTree meals;

    public DayNode(String day) {
        this.day = day;
        this.children = new DayNode[5];
        this.meals = new MealsTree(day);
    }

    public MealNode getMeal(String mealName) {
        return meals.getMeal(mealName);
    }

}

class DaysTree {
    DayNode root;

    DaysTree(String rootDay) {
        root = new DayNode(rootDay);
        initializeDaysTree(this.root);
    }

    private void initializeDaysTree(DayNode root) {
        root.children[0] = new DayNode("Monday");
        root.children[1] = new DayNode("Tuesday");
        root.children[2] = new DayNode("Wednesday");
        root.children[3] = new DayNode("Thursday");
        root.children[4] = new DayNode("Friday");
    }

    public DayNode getDay(String dayName) {
        for (DayNode child : root.children) {
            if (child.day.equalsIgnoreCase(dayName)) {
                return child;
            }
        }
        return null;
    }

}