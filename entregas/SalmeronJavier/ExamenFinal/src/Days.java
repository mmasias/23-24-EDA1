class DayNode {
    String day;
    MealsList meals;

    public DayNode(String day) {
        this.day = day;
        this.meals = new MealsList();
    }

    public MealNode getMeal(String mealName) {
        return meals.getMeal(mealName);
    }
}

class DaysList {
    List<DayNode> days;

    DaysList() {
        days = new List<>();
        initializeDaysList();
    }

    private void initializeDaysList() {
        days.insert(new DayNode("Monday"), -1);
        days.insert(new DayNode("Tuesday"), -1);
        days.insert(new DayNode("Wednesday"), -1);
        days.insert(new DayNode("Thursday"), -1);
        days.insert(new DayNode("Friday"), -1);
    }

    public DayNode getDay(String dayName) {
        for (DayNode day : days) {
            if (day.day.equalsIgnoreCase(dayName)) {
                return day;
            }
        }
        return null;
    }
}
