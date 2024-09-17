import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HojaDeCalculo hoja = new HojaDeCalculo();

        while (true) {
            hoja.mostrarHoja();
            System.out.println("Estás en la celda: [" + (char) (65 + hoja.getX()) + (hoja.getY() + 1) + "]");
            System.out.println("WASD para moverte");
            System.out.println("E para editar");
            System.out.println("Q para salir");

            String opcion = sc.nextLine().toLowerCase();  // Convertir a minúsculas para manejar mayúsculas y minúsculas

            if (opcion.equals("q")) {
                System.out.println("Adiós");
                break;
            } else if (opcion.equals("e")) {
                hoja.editar(sc);
            } else if (opcion.equals("w") || opcion.equals("a") || opcion.equals("s") || opcion.equals("d")) {
                hoja.mover(opcion);
            } else {
                System.out.println("Opción no válida");
            }
        }

        sc.close();
    }
}