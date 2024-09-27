import structure.ListNode;

public class PrintManager {
    public void printSurvey(Survey survey){
        printDays(survey.daysList.firstNode);
    }

    private void printDays(ListNode<Day> currentDayNode) {
        while (currentDayNode != null) {
            Day currentDay = currentDayNode.data;
            System.out.println("Day: " + currentDay.name);

            printMeals(currentDay.meals.firstNode);

            currentDayNode = currentDayNode.nextNode;
        }
    }

    private void printMeals(ListNode<Meal> currentMealNode) {
        while (currentMealNode != null) {
            Meal currentMeal = currentMealNode.data;
            System.out.println("\tMeal: " + currentMeal.mealName);

            printIntakes(currentMeal.intakes.firstNode);

            currentMealNode = currentMealNode.nextNode;
        }
    }

    private void printIntakes(ListNode<Intake> currentIntakeNode) {
        while (currentIntakeNode != null) {
            Intake currentIntake = currentIntakeNode.data;
            System.out.println("\t\tIntake: " + currentIntake.intakeDescription);

            currentIntakeNode = currentIntakeNode.nextNode;
        }
    }
}
