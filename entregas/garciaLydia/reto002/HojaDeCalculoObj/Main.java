package entregas.garciaLydia.reto002.HojaDeCalculoObj;

import entregas.garciaLydia.reto002.HojaDeCalculoObj.Comando;
import entregas.garciaLydia.reto002.HojaDeCalculoObj.HojaDeCalculo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HojaDeCalculo hoja = new HojaDeCalculo(15, 10);

        while (true) {
            HojaDeCalculo.imprimir();
            System.out.println("Estás en la fila " + (hoja.getFilaActual() + 1) + ", columna " + (char) ('A' + hoja.getColumnaActual()));
            System.out.print("Seleccione un comando: [W]Arriba; [A]Izquierda; [S]Abajo; [D]Derecha; [Q]Finalizar programa; [E]Editar: ");

            String comando = scanner.nextLine().toUpperCase();

            // Procesar el comando
            if (comando.length() == 1) {
                Comando accion = Comando.fromChar(comando.charAt(0));
                if (accion != null) {
                    accion.ejecutar(hoja, scanner);
                } else {
                    System.out.println("Comando no válido.");
                }
            } else {
                System.out.println("Comando no válido.");
            }
        }
    }
}