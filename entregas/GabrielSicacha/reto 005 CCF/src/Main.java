public class Main {
    public static void main(String[] args) {


        Carrefour ccf = new Carrefour(9,true, 6, 4, 0.4);
        Clock clock = new Clock(ccf.getOpeningHour(), 0, ccf.getAnteMeridian());
        ccf.openDay(clock);
        Queue queue = new Queue();
        do{
            System.out.println(clock.clock());
            ccf.checkArrivals(queue);
            ccf.advance(queue);
            ccf.status(queue);
            clock.setMin(clock.getMin()+1);
        }while(!((clock.getHour()==ccf.openingHour)&&(clock.isAnteMeridian()!=ccf.anteMeridian)));
    }

}