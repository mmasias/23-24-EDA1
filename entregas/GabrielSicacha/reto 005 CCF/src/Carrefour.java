public class Carrefour {

    int openingHour;
    boolean anteMeridian;
    int totalRegisters;
    int initialRegisters;
    Register[] registers;
    double averageClientsPerMin;

    String cut = "--------------------------";
    public Carrefour(int openingHour,boolean anteMeridian,  int totalRegisters, int initialRegisters, double averageClientsPerMin) {
        this.openingHour = openingHour;
        this.anteMeridian = anteMeridian;
        this.totalRegisters = totalRegisters;
        this.initialRegisters = Math.min(initialRegisters, totalRegisters);
        this.averageClientsPerMin = averageClientsPerMin;
    }


    public int getOpeningHour() {
        return openingHour;
    }

    public boolean getAnteMeridian() {
        return anteMeridian;
    }

    public int getTotalRegisters() {
        return totalRegisters;
    }

    public void openDay(Clock clock){
        registers = new Register[totalRegisters];
        System.out.println(cut);
        System.out.println("Inicio del dia. " + clock.clock());
        System.out.println(cut);
            for(int i=1;i<totalRegisters+1;i++){
                if (i <= initialRegisters+1){
                    registers[i-1] = new Register((i),true,false);
                    System.out.println(" > caja " + i + " ha abierto");
                } else {
                    registers[i-1] = new Register((i),false,false);
                }
            }
        System.out.println(cut);
    }




    public void advance(Queue queue){
        for(int i=1; i<totalRegisters;i++){
            if(registers[i].isOpen()){
                if(!registers[i].isFull()&&!queue.isEmpty()){
                    System.out.println(" > Un cliente se dirige a la caja " + i);
                    registers[i].setItemsOnRegister(queue.attend());
                } else if(registers[i].isFull()){
                    registers[i].registerItems();
                }
            }
        }
    }

    public void checkArrivals(Queue queue){
        System.out.println(cut);
        if(Math.random()>averageClientsPerMin){
            queue.arrives();
        } else {
            System.out.println(" > No ha llegado nadie");
        }
    }

    public void status(Queue queue){
        System.out.println(" > gente en cola: " +queue.size());
        for(int i=1; i<totalRegisters;i++){
            if(registers[i].isOpen()){
                System.out.println(" > la caja numero " + i + " tiene "+ registers[i].getItemsOnRegister() + " items");
            }
        }
        System.out.println(cut);
    }


}
