import java.util.Scanner;

public class HojaDeCalculo {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        char textoUsuario;
        boolean fin = false;

        String[][] matriz = {
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

        int[] cursor = {0, 0};

        int limiteInferior = 0;
        int limiteSuperior = matriz.length - 1;
        int limiteIzquierdo = 0;
        int limiteDerecho = matriz[0].length - 1;

        do {
            System.out.println("+------------------------------------------------------------------------+");
            System.out.println("| |   A  |   B  |   C  |   D  |   E  |   F  |   G  |   H  |   I  |   J  |");
            System.out.println("+------------------------------------------------------------------------+");
            imprimeTerreno(matriz, cursor);
            System.out.println("Opciones: [W] Arriba | [S] Abajo | [A] Izquierda | [D] Derecha | [E] Editar | [F] Salir");
            System.out.print("Ingrese una opcion: ");

            textoUsuario = entrada.nextLine().charAt(0);
            switch (textoUsuario) {
                case 's', 'S':
                    cursor[0] = cursor[0] + 1;
                    break;
                case 'w', 'W':
                    cursor[0] = cursor[0] - 1;
                    break;
                case 'a', 'A':
                    cursor[1] = cursor[1] - 1;
                    break;
                case 'd', 'D':
                    cursor[1] = cursor[1] + 1;
                    break;
                case 'E', 'e':
                    modificar(matriz, cursor);
                    break;
                case 'f', 'F':
                    fin = true;
                    break;
            }

            if (cursor[0] < limiteInferior) {
                cursor[0] = limiteSuperior;
            }
            if (cursor[0] > limiteSuperior) {
                cursor[0] = limiteInferior;
            }
            if (cursor[1] < limiteIzquierdo) {
                cursor[1] = limiteDerecho;
            }
            if (cursor[1] > limiteDerecho) {
                cursor[1] = limiteIzquierdo;
            }


        } while (!fin);
    }

    static void imprimeTerreno(String[][] matriz, int[] cursor) {
        final int ANCHO_CELDA = 6;
        String celda = "";
        limpiarPantalla();

        for (int i = 0; i < matriz.length; i++) {
            if (i < 9) {
                System.out.print(" " + (i + 1));
            } else {
                System.out.print((i + 1));
            }

            for (int j = 0; j < matriz[i].length; j++) {
                boolean borde = false;
                if (cursor[0] == i && cursor[1] == j) {
                    borde = true;
                }
                celda = limpia(matriz[i][j], ANCHO_CELDA, borde);
                System.out.print("|" + celda);
            }
            System.out.println("|");

        }
        System.out.println("x: " + cursor[0] + " | y:" + cursor[1]);


    }

    static String limpia(String texto, int largo, boolean borde) {
        if (texto.length() < largo) {
            texto = " ".repeat(largo - texto.length()) + texto;
        } else {
            texto = texto.substring(texto.length() - largo);
        }
        if (borde) {
            texto = "[" + limpia(texto, 4, !borde) + "]";
        }
        return texto;
    }

    static void imprimePacman() {
        String[] pacman = {" - "};
        System.out.print(pacman);
    }

    static void limpiarPantalla() {

        System.out.print("");
    }

    static void modificar(String[][] hoja, int[] posicion) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un valor");
        String valor = sc.nextLine();
        String resultado = "";
        if (valor.length() > 6) {
            for (int i = 0; i < 6; i++) {
                resultado = resultado + valor.charAt(i);
            }

        } else {
            resultado = valor;
        }
        hoja[posicion[0]][posicion[1]] = resultado;

    }
    
}
