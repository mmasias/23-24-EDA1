import structure.ListNode;

public class Patient {
    public String pacientName = "";
    public String date = "";
    public Survey survey;

    public Patient(String name, String date) {
        this.pacientName = name;
        this.date = date;
        this.survey = new Survey(5);
        enterIntakeData();
    }

    public Patient(String name, String date, int duration) {
        this.pacientName = name;
        this.date = date;
        this.survey = new Survey(duration);
        enterIntakeData();
    }

    private void enterIntakeData() {
        for (int i = 0; i <= survey.daysNumber; i++) {
            System.out.println("Enter intake data for Day " + (i+1) + ":");
            
            Day currentDay = survey.daysList.getNode(i).data;
            ListNode<Meal> currentMeal = currentDay.meals.firstNode;

            while (currentMeal != null) {
                IntakeManager.enterIntakeData(currentMeal.data);
                currentMeal = currentMeal.nextNode;
            }
        }
    }

    public void printSurvey() {
        PrintManager printManager = new PrintManager();
        printManager.printSurvey(survey);
    }
}
