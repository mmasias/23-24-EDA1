import java.time.LocalDate;

public class Survey implements TreeData {
    private LocalDate date;
    public Survey(LocalDate date){
        this.date= date;
    }
    public LocalDate getDate() {
        return this.date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    @Override
    public String getInformation() {
        return "survey's date: "+date.toString();
    }
    
}
