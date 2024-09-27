public class Main {
    public static void main(String[] args) {
        HojaDeCalculo001 spreadsheet = new HojaDeCalculo001();
        boolean running = true;
        while (running) {
            spreadsheet.display();
            running = spreadsheet.processCommand();
        }
        spreadsheet.closeScanner();
    }
}
