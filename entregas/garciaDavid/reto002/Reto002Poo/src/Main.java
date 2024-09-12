import HojaDeCalculo.Movimiento;
import HojaDeCalculo.Tabla;

public class Main {
    public static void main(String[] args) {
        Tabla tabla = new Tabla(15, 10);
        Movimiento movimiento = new Movimiento();
        String direccion;
        do {
            movimiento.imprimirOpciones();
            tabla.imprimirHoja();
            System.out.println("Posición actual: " + tabla.getPosicionActual());
            System.out.print("Ingrese una opción: ");
            direccion = movimiento.leerDireccion();

            if (direccion.equalsIgnoreCase("E")) {
                System.out.print("Ingrese el texto: ");
                String texto = movimiento.leerDireccion();
                movimiento.moverse(tabla, direccion, texto);
            } else {
                movimiento.moverse(tabla, direccion, "");
            }
        } while (!direccion.equalsIgnoreCase("Q"));

    }
}