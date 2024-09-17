package Reto002;

public class ImprimirMatriz {

        public void mostrarMatriz(String[][] matriz) {
            System.out.println("    A       B       C       D       E       F       G       H       I       J");
            System.out.println("+-------+-------+-------+-------+-------+-------+-------+-------+-------+-------+");
            for (int i = 0; i < matriz.length; i++) {
                System.out.print("|");
                for (int j = 0; j < matriz[i].length; j++) {
                    System.out.print(matriz[i][j]);
                    System.out.print("|");
                }
                System.out.println();
            }
            System.out.println("+-------+-------+-------+-------+-------+-------+-------+-------+-------+-------+");
        }
    }

