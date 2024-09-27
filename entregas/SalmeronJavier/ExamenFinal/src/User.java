import java.time.LocalDate;

public class User {
    private String name;
    private LocalDate date;
    private DaysList days;

    User(String name) {
        this.name = name;
        this.date = LocalDate.now();
        this.days = new DaysList();
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public DayNode getDay(String dayName) {
        return days.getDay(dayName);
    }

    public static User registerUser() {

        User user = new User(UserIO.getInput("Enter your name: "));

        System.out.println("New User created:");
        System.out.println("  Name: " + user.getName());
        System.out.println("  Creation Date: " + user.getDate());

        return user;
    }

    public void printAll() {
        for (DayNode dayNode : days.days) {
            boolean showDay = false;

            for (MealNode mealNode : dayNode.meals.meals) {
                if (mealNode != null && !mealNode.getFood().getItems().isEmpty()) {
                    showDay = true;
                    break;
                }
            }

            if (showDay) {
                System.out.println("\u25BC Day: " + dayNode.day);

                for (MealNode mealNode : dayNode.meals.meals) {
                    if (mealNode != null && !mealNode.getFood().getItems().isEmpty()) {
                        System.out.println("   \u25B6 Meal: " + mealNode.meal);

                        List<String> foodItems = mealNode.getFood().getItems();
                        System.out.println("      \u25CF Food Items:");
                        for (String item : foodItems) {
                            System.out.println("        - " + item);
                        }
                    }
                }
            }
        }
    }

    public void registerFood() {
        while (true) {
            System.out.print("Select day: ");
            boolean first = true;
            for (DayNode dayNode : days.days) {
                if (!first) System.out.print(", ");
                System.out.print(dayNode.day);
                first = false;
            }

            DayNode day = getDay(UserIO.getInput(":\n> "));

            if (day == null) {
                System.out.println("Day not found.");
                continue;
            }

            System.out.print("Select meal: ");
            first = true;
            for (MealNode mealNode : day.meals.meals) {
                if (!first) System.out.print(", ");
                System.out.print(mealNode.meal);
                first = false;
            }

            MealNode meal = day.getMeal(UserIO.getInput((":\n> ")));

            if (meal == null) {
                System.out.println("Meal not found.");
                continue;
            }

            System.out.println("Enter food to register. Type 'END' once finished.");
            while (true) {
                String item = UserIO.getInput("  > ");

                if ("END".equalsIgnoreCase(item)) {
                    System.out.println("- - - - - - -");
                    break;
                }

                meal.getFood().addItem(item);
            }
            
            String answer = UserIO.getInput("Add more food? (Yes/No): ");
            if (!"Yes".equalsIgnoreCase(answer) /*|| !"y".equalsIgnoreCase(answer)*/) {
                break;
            } 

        }

    }

}
