import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int posX = 0;
        int posY = 0;
        int filas = 15;
        int columnas = 10;

        String[][] hojaCalculo = new String[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                hojaCalculo[i][j] = "       ";
            }
        }


        System.out.println("    A       B       C       D       E       F       G       H       I       J");
        System.out.println("+-------+-------+-------+-------+-------+-------+-------+-------+-------+-------+");
        for (int i = 0; i < filas; i++) {
            System.out.print("|");
            for (int j = 0; j < columnas; j++) {
                if (i == posX && j == posY) {
                    System.out.print("[     ]");
                } else {
                    System.out.print(hojaCalculo[i][j]);
                }
                if (j < columnas - 1) {
                    System.out.print("|");
                }
            }
            System.out.println("|");
        }
        System.out.println("+-------+-------+-------+-------+-------+-------+-------+-------+-------+-------+");
        System.out.println("Estás en la celda: " + (posX + 1) + "/" + (posY + 1));
        System.out.println("Pulse W,A,S,D para desplazarse.");
        System.out.println("Pulse E para editar la celda seleccionada.");
        System.out.println("Pulse Q para salir.");

        Scanner scanner = new Scanner(System.in);

        while (true) {

            char movimiento = scanner.next().charAt(0);

            switch (movimiento) {
                case 'a', 'A':
                    if (posY > 0)
                        posY--;
                    break;
                case 'w', 'W':
                    if (posX > 0)
                        posX--;
                    break;
                case 'd', 'D':
                    if (posY < columnas - 1)
                        posY++;
                    break;
                case 's', 'S':
                    if (posX < filas - 1)
                        posX++;
                    break;
                case 'e', 'E':
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Ingrese un valor:");
                    String valor = sc.nextLine();
                    valor = valor.length() > 7 ? valor.substring(0, 7) : valor;
                    hojaCalculo[posX][posY] = String.format("%7s", valor);
                    break;
                case 'q', 'Q':
                    System.out.println("Programa finalizado.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Entrada no válida.");
                    break;
            }


            System.out.println("    A       B       C       D       E       F       G       H       I       J");
            System.out.println("+-------+-------+-------+-------+-------+-------+-------+-------+-------+-------+");
            for (int i = 0; i < filas; i++) {
                System.out.print("|");
                for (int j = 0; j < columnas; j++) {
                    if (i == posX && j == posY) {
                        System.out.print("[     ]");
                    } else {
                        System.out.print(hojaCalculo[i][j]);
                    }
                    if (j < columnas - 1) {
                        System.out.print("|");
                    }
                }
                System.out.println("|");
            }
            System.out.println("+-------+-------+-------+-------+-------+-------+-------+-------+-------+-------+");
            System.out.println("Estás en la celda: " + (posX + 1) + "/" + (posY + 1));
            System.out.println("Pulse W,A,S,D para desplazarse.");
            System.out.println("Pulse E para editar la celda seleccionada.");
            System.out.println("Pulse Q para salir.");
        }
    }
}