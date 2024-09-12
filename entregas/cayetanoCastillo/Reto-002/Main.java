package miJava;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int filas = 15;
        int columnas = 10;

        GestorHojaCalculo gestorHoja = new GestorHojaCalculo(filas, columnas);
        Scanner scanner = new Scanner(System.in);

        int posX = 0;
        int posY = 0;

        System.out.println("Utilice las teclas a,w,s,d para moverse.");
        System.out.println("Utilice la tecla e para ingresar un valor.");
        System.out.println("Utilice la tecla q para finalizar el programa.");

        while (true) {
            gestorHoja.mostrarHojaCalculo(posX, posY);
            char movimiento = scanner.next().charAt(0);

            switch (movimiento) {
                case 'a':
                    if (posY > 0)
                        posY--;
                    break;
                case 'w':
                    if (posX > 0)
                        posX--;
                    break;
                case 'd':
                    if (posY < columnas - 1)
                        posY++;
                    break;
                case 's':
                    if (posX < filas - 1)
                        posX++;
                    break;
                case 'e':
                    System.out.print("Ingrese un valor (numérico o carácter, máximo 7 caracteres): ");
                    scanner.nextLine(); // Consumir el salto de línea
                    String valor = scanner.nextLine();
                    gestorHoja.ingresarValor(posX, posY, valor);
                    break;
                case 'q':
                    System.out.println("Programa finalizado.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Entrada no válida. Usa a, w, d, s para moverte.");
                    break;
            }
        }
    }
}
