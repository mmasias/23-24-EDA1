public class Main {
    public static void main(String[] args) {
        SpreadSheet Spread = new SpreadSheet(10,15);
        while(true){
            Print.print(Spread);
            Print.printControls(Spread.pos);
            Control.controls(Spread);
        }

    }
}