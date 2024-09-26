public class Intake implements Comparable<Intake>, TreeData{
    private Schedule schedule;
    private GenericList<Food> food;

    public Intake(Schedule schedule) {
        this.schedule = schedule;
        this.food = new GenericList<Food>();
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public GenericList<Food> getFood() {
        return food;
    }

    public void insertFood(Food food){
        this.food.insertInOrder(food);
    }

    @Override
    public int compareTo(Intake o){
        if(this.schedule.getCode()<o.schedule.getCode()){
            return 1;
        }else if (this.schedule.getCode()>o.schedule.getCode()){
            return -1;
        }else{
            return 0;
        }
    }

    public String getInformation(){
        String text =schedule.getDescription();
        for (int i = 0; i < food.size(); i++) {
            text+=food.getObject(i).toString();
        }
        return text;
    }
    public void empty (){
        this.food.empty();
    }
}
