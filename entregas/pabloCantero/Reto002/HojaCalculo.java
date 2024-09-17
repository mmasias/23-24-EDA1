package Reto002;

import java.sql.SQLOutput;
import java.util.Scanner;

public class HojaCalculo{
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        char inputUsuario;
        boolean terminar = false;


        String[][] unaMatriz = CrearMatriz.crearMatriz();

        int[] posicionCursor = {0, 0};

        int limiteInferior = 0;
        int limiteSuperior = unaMatriz.length - 1;
        int limiteIzquierdo = 0;
        int limiteDerecho = unaMatriz[0].length - 1;
        int skin = 0;

        do {
            
            imprimeTerreno(unaMatriz, posicionCursor);
            imprimirInicio();

            terminar = MoverPersonaje.moverUsuario(entrada, terminar, unaMatriz, posicionCursor);

            MoverPersonaje.comprobarLimites(posicionCursor, limiteInferior, limiteSuperior, limiteIzquierdo, limiteDerecho);


        } while (!terminar);
    }

    

    

    

    private static void imprimirInicio() {
        System.out.println("CMDs: [w] Arriba | [s] Abajo | [a] Izquierda | [d] Derecha | [e] Ingresar comando | [F] Terminar");
        System.out.print("Ingrese un comando: ");
    }

    static void imprimeTerreno(String[][] unaMatriz, int[] posicionCursor) {
        final int ANCHO_DE_CELDA = 7;
        String celda = "";
        limpiarPantalla();
        System.out.println("+---------------------------------------------------------------------------------+");
        System.out.println("| |   A   |   B   |   C   |   D   |   E   |   F   |   G   |   H   |   I   |   J   |");
        System.out.println("+---------------------------------------------------------------------------------+");

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
        System.out.println("x: " + posicionCursor[0] + " | y:" + posicionCursor[1]);


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

    static void imprimePersonaje(int skin) {
        String[] personaje = {" - "};
        System.out.print(personaje[skin]);
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



