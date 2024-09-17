public class Main {
    public static void main(String[] args) {
        int filas = 15;
        int columnas = 10;

        hoja hoja = new hoja(filas, columnas);
        hoja.ejecutarBucle();

        System.out.println("Programa finalizado.");
    }
}
