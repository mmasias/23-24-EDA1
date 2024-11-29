public class PrintManager {
    public static void imprimirHoja(String[][] hojaCalculo) {
        int numFilas = hojaCalculo.length;
        int numColumnas = hojaCalculo[0].length;

        System.out.print("\t\t");
        for (int i = 0; i < numColumnas; i++) {
            char letra = (char) ('A' + i);
            System.out.print(letra + "\t\t\t");
        }
        System.out.println();

        System.out.print("\t\t");
        for (int i = 0; i < numColumnas; i++) {
            System.out.print("--------\t");
        }
        System.out.println();

        for (int i = 0; i < numFilas; i++) {
            System.out.print(i + 1 + "\t|\t");
            for (int j = 0; j < numColumnas; j++) {
                String celda = hojaCalculo[i][j];
                System.out.printf("%-7s|\t", celda);
            }
            System.out.println();
            System.out.print("\t|\t");
            for (int j = 0; j < numColumnas; j++) {
                System.out.print("--------\t");
            }
            System.out.println();
        }
        System.out.println();
    }



    public static void imprimirCeldaActual(int fila, int columna) {
        char letra = (char) ('A' + columna);
        int numero = fila + 1;
        System.out.println("Celda actual: " + letra + numero);
        System.out.println();
    }
}
