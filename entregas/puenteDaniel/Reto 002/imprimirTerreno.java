public class imprimirTerreno extends limpiarTerreno{

    static void imprimeTerreno(String[][] unaMatriz, int[] posicionCursor) {
        final int ANCHO_DE_CELDA = 7;
        String celda = "";
        limpiarPantalla();
        String[] letras = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};

        System.out.println("      A       B       C       D       E       F       G       H       I       J  ");
        System.out.println("  +-------+-------+-------+-------+-------+-------+-------+-------+-------+-------+");

        for (int i = 0; i < unaMatriz.length; i++) {
            if (i < 9) {
                System.out.print(" " + (i + 1));
            } else {
                System.out.print((i + 1));
            }

            for (int j = 0; j < unaMatriz[i].length; j++) {
                boolean borde = false;
                if (posicionCursor[0] == i && posicionCursor[1] == j) {
                    borde = true;
                }
                celda = limpia(unaMatriz[i][j], ANCHO_DE_CELDA, borde);
                System.out.print("|" + celda);
            }
            System.out.println("|");

        }
        System.out.println("  +-------+-------+-------+-------+-------+-------+-------+-------+-------+-------+");
        System.out.println("Celda actual: "+ letras[posicionCursor[1]] + posicionCursor[0] );

    }
}