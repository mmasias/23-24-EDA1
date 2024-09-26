import structure.JavaList;

public class Survey {
    
    public JavaList<Day> daysList;
    public int daysNumber;

    public Survey(int duration){
        daysNumber = duration;
        daysList = new JavaList<>();
        for (int i = 0; i <= duration; i++) {
            Day newDay = new Day("Day " + (i+1));
            daysList.addNode(newDay);
        }
    }
}
