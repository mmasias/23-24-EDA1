public class Day implements TreeData {
    private int date;
    private GenericList<Intake> inTakes;
    public Day(int date) {
        this.date = date;
        this.inTakes = new GenericList<Intake>();
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public GenericList<Intake> getInTakes() {
        return inTakes;
    }
    public void setInTakes(GenericList<Intake> intakes) {
        this.inTakes = intakes;
    }

    @Override
    public String getInformation() {
        return "Day : "+this.date;
    }
    
}
