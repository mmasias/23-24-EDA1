
import java.util.Scanner;

public class hoja {
    private String[][] hojaCalculo;
    private int filaActual;
    private int columnaActual;

    public hoja(int filas, int columnas) {
        hojaCalculo = new String[filas][columnas];
        inicializar();
        filaActual = 0;
        columnaActual = 0;
    }

    public void ejecutarBucle() {
        Scanner scanner = new Scanner(System.in);
        String comando = "";

        while (!comando.equals("F")) {
            PrintManager.imprimirHoja(hojaCalculo);
            PrintManager.imprimirCeldaActual(filaActual, columnaActual);

            System.out.print("CMDs: [W] Arriba, [S] Abajo, [A] Izquierda, [D] Derecha, [E] Escribir, [F] Salir - Ingrese comando:");
            comando = scanner.nextLine().trim().toUpperCase();

            switch (comando) {
                case "W":
                    moverArriba();
                    break;
                case "A":
                    moverIzquierda();
                    break;
                case "S":
                    moverAbajo();
                    break;
                case "D":
                    moverDerecha();
                    break;
                case "F":
                    System.out.println("Programa finalizado");
                    return;
                default:
                    if (comando.length() <= 7) {
                        hojaCalculo[filaActual][columnaActual] = comando;
                    } else {
                        hojaCalculo[filaActual][columnaActual] = comando.substring(0, 7);
                    }
                    break;
            }
        }
    }

    private void moverArriba() {
        if (filaActual > 0) {
            filaActual--;
        } else {
            System.out.println("No puedes moverte más arriba");
        }
    }

    private void moverIzquierda() {
        if (columnaActual > 0) {
            columnaActual--;
        } else {
            System.out.println("No puedes moverte más a la izquierda");
        }
    }

    private void moverAbajo() {
        if (filaActual < hojaCalculo.length - 1) {
            filaActual++;
        } else {
            System.out.println("No puedes moverte más abajo");
        }
    }

    private void moverDerecha() {
        if (columnaActual < hojaCalculo[0].length - 1) {
            columnaActual++;
        } else {
            System.out.println("No puedes moverte más a la derecha");
        }
    }

    private void inicializar() {
        for (int i = 0; i < hojaCalculo.length; i++) {
            for (int j = 0; j < hojaCalculo[i].length; j++) {
                hojaCalculo[i][j] = "";
            }
        }
    }

    public void editar(Scanner scanner) {
        System.out.print("Ingrese el nuevo valor para la celda: ");
        String nuevoValor = scanner.nextLine().trim();
        hojaCalculo[filaActual][columnaActual] = nuevoValor;
        System.out.println("El valor de la celda ha sido actualizado.");
    }
}
