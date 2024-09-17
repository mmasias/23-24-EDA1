public class Main {
    public static void main(String[] args) {
        HojaCalculo hoja = new HojaCalculo(15, 10);
        InterfazHojaCalculo interfaz = new InterfazHojaCalculo(hoja);
        interfaz.ejecutar();
    }
}
