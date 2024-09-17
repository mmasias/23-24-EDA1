package Reto002;

import java.util.Scanner;

class Controlador {
    private int filas;
    private int columnas;
    private int posicionActualX;
    private int posicionActualY;
    private String[][] matriz;
    private String[][] valores;
    private Input input;
    private ImprimirMatriz imprimirMatriz;

    public Controlador(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.posicionActualX = 0;
        this.posicionActualY = 0;
        this.matriz = new String[filas][columnas];
        this.valores = new String[filas][columnas];
        this.input = new Input();
        this.imprimirMatriz = new ImprimirMatriz();


        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = "       ";
                valores[i][j] = "       ";
            }
        }
    }

    public void ejecutar() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            imprimirMatriz.mostrarMatriz(matriz);

            System.out.println("Posición actual: " + (posicionActualX + 1) + "," + (posicionActualY + 1));
            System.out.println("Bienvenido al sistema de control, ingrese la opción que desea realizar.");
            System.out.println("W para moverse arriba, S para moverse abajo, A para moverse a la izquierda, D para moverse a la derecha,");
            System.out.println("E para ingresar un valor y Q para salir");

            String opcion = input.obtenerOpcion(scanner);

            switch (opcion) {
                case "W":
                    moverArriba();
                    break;
                case "S":
                    moverAbajo();
                    break;
                case "A":
                    moverIzquierda();
                    break;
                case "D":
                    moverDerecha();
                    break;
                case "E":
                    ingresarValor(scanner);
                    break;
                case "Q":
                    System.out.println("Gracias por usar el sistema de control");
                    System.exit(0);
                default:
                    System.out.println("Comando no válido.");
            }
        }
    }

    private void moverArriba() {
        if (posicionActualX > 0) {
            matriz[posicionActualX][posicionActualY] = valores[posicionActualX][posicionActualY];
            posicionActualX--;
            matriz[posicionActualX][posicionActualY] = "[     ]";
        }
    }

    private void moverAbajo() {
        if (posicionActualX < filas - 1) {
            matriz[posicionActualX][posicionActualY] = valores[posicionActualX][posicionActualY];
            posicionActualX++;
            matriz[posicionActualX][posicionActualY] = "[     ]";
        }
    }

    private void moverIzquierda() {
        if (posicionActualY > 0) {
            matriz[posicionActualX][posicionActualY] = valores[posicionActualX][posicionActualY];
            posicionActualY--;
            matriz[posicionActualX][posicionActualY] = "[     ]";
        }
    }

    private void moverDerecha() {
        if (posicionActualY < columnas - 1) {
            matriz[posicionActualX][posicionActualY] = valores[posicionActualX][posicionActualY];
            posicionActualY++;
            matriz[posicionActualX][posicionActualY] = "[     ]";
        }
    }

    private void ingresarValor(Scanner scanner) {
        System.out.println("Ingrese el valor que desea ingresar:");
        String valor = input.obtenerValor(scanner);
        if (valor.length() > 7) {
            valor = valor.substring(0, 7);
            System.out.println("El valor ingresado es mayor a 7 caracteres.");
        }
        valores[posicionActualX][posicionActualY] = String.format("%7s", valor);
        matriz[posicionActualX][posicionActualY] = valores[posicionActualX][posicionActualY];
    }
}
