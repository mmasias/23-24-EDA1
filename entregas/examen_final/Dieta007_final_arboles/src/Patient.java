public class Patient {

    String name;
    CustomDate dischargeDate;

    int day = (int) (Math.random()*30+1);
    int month = (int) (Math.random()*12+1);
    int year = 2023;

    public Patient(String name) {
        this.name = name;
        dischargeDate = new CustomDate(day,month,year);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CustomDate getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(CustomDate dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    void showData(){
        System.out.println("Nombre paciente: "+name);
        System.out.print("Fecha alta: ");
        dischargeDate.showData();

    }
}
