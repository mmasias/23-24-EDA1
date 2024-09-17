import java.text.SimpleDateFormat;
import java.util.Date;

public class Survey {

    String name;
    CustomDate actualDay;
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");



    public Survey() {
        int day;
        int month;
        int year;
        Date date = new Date();
        formatter = new SimpleDateFormat("dd");
        day= Integer.parseInt(formatter.format(date));
        formatter = new SimpleDateFormat("MM");
        month= Integer.parseInt(formatter.format(date));
        formatter = new SimpleDateFormat("yyyy");
        year= Integer.parseInt(formatter.format(date));
        actualDay= new CustomDate(day,month,year);
        name = String.valueOf(day)+"/"+String.valueOf(month)+"/"+String.valueOf(year);
    }


    public String getName() {
        return name;
    }

    public CustomDate getActualDay() {
        return actualDay;
    }

    public void setActualDay(CustomDate actualDay) {
        this.actualDay = actualDay;
    }

   void showData(){

       System.out.print("Fecha Encuesta: ");
       actualDay.showData();
   }

}
