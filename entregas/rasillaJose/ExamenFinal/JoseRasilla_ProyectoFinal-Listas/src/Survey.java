import structure.JavaList;

public class Survey {
    
    public JavaList<Day> daysList;
    public int daysNumber;

    public Survey(int duration){
        daysNumber = duration;
        daysList = new JavaList<>();
        for (int i = 1; i <= duration; i++) {
            Day newDay = new Day("Day " + (i));
            daysList.addNode(newDay);
        }
    }
}
