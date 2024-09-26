public class IntakeManager {

    public static void enterIntakeData(Meal meal) {
        int numIntakes = InputManager.promptInt("Enter the number of intakes for " + meal.mealName + ": ");

        for (int i = 1; i <= numIntakes; i++) {
            String intakeDescription = InputManager.promptString("Enter intake " + i + " for " + meal.mealName + ": ");
            meal.addIntake(new Intake(intakeDescription));
        }
    }
}

