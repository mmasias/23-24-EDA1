import java.util.Scanner;

public class SpreadSheet {
    public static void main(String[] args) {


        Scanner entrada = new Scanner(System.in);
        char inputUsuario;
        boolean terminar = false;


        String[][]  = {
                {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "}


        };

        int[] posicionCursor = {0, 0};

        int limiteInferior = 0;
        int limiteSuperior = unaMatriz.length - 1;
        int limiteIzquierdo = 0;
        int limiteDerecho = unaMatriz[0].length - 1;

        do {
           
            imprimeTerreno(unaMatriz, posicionCursor);
            System.out.println("Utilice las teclas WASD para moverse por el terreno");
            System.out.println("Utilice la tecla E para editar la celda actual");
            System.out.println("Utilice la tecla Q para salir del programa");
            System.out.print("Ingrese un comando: ");

            inputUsuario = entrada.nextLine().charAt(0);
            switch (inputUsuario) {
                case 's', 'S':
                    posicionCursor[0] = posicionCursor[0] + 1;
                    break;
                case 'w', 'W':
                    posicionCursor[0] = posicionCursor[0] - 1;
                    break;
                case 'a', 'A':
                    posicionCursor[1] = posicionCursor[1] - 1;
                    break;
                case 'd', 'D':
                    posicionCursor[1] = posicionCursor[1] + 1;
                    break;
                case 'E', 'e':
                    modificar(unaMatriz, posicionCursor);

                    break;
                case 'q', 'Q':
                    terminar = true;
            }

            if (posicionCursor[0] < limiteInferior) {
                posicionCursor[0] = limiteSuperior;
            }
            if (posicionCursor[0] > limiteSuperior) {
                posicionCursor[0] = limiteInferior;
            }
            if (posicionCursor[1] < limiteIzquierdo) {
                posicionCursor[1] = limiteDerecho;
            }
            if (posicionCursor[1] > limiteDerecho) {
                posicionCursor[1] = limiteIzquierdo;
            }


        } while (!terminar);
    }

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

    static String limpia(String texto, int largo, boolean borde) {
        if (texto.length() < largo) {
            texto = " ".repeat(largo - texto.length()) + texto;
        } else {
            texto = texto.substring(texto.length() - largo);
        }
        if (borde) {
            texto = "[" + limpia(texto, 5, !borde) + "]";
        }
        return texto;
    }

    static void limpiarPantalla() {

        System.out.print("\033[H\033[2J");
    }

    static void modificar(String[][] hoja, int[] posicion) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un valor");
        String valor = sc.nextLine();
        String resultado = "";
        if (valor.length() > 7) {
            for (int i = 0; i < 7; i++) {
                resultado = resultado + valor.charAt(i);
            }

        } else {
            resultado = valor;
        }
        hoja[posicion[0]][posicion[1]] = resultado;
    }


}




