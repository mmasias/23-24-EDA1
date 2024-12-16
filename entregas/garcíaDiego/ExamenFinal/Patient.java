import java.time.LocalDate;

public class Patient implements TreeData{
    private LocalDate dischargeDate;
    private String name;
    public Patient(LocalDate dischargeDate, String name) {
        this.dischargeDate = dischargeDate;
        this.name = name;
    }
    public LocalDate getDischargeDate() {
        return dischargeDate;
    }
    public void setDischargeDate(LocalDate dischargeDate) {
        this.dischargeDate = dischargeDate;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Patient(String name, LocalDate dischargeDate) {
        this.name = name;
        this.dischargeDate = dischargeDate;
    }

    @Override
    public String getInformation() {
        return "discharge date: "+dischargeDate+ "Name "+name;
    }
    
}
