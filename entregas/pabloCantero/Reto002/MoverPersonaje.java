package Reto002;

import java.util.Scanner;

public class MoverPersonaje{
    public static void comprobarLimites(int[] posicionCursor, int limiteInferior, int limiteSuperior, int limiteIzquierdo,
            int limiteDerecho) {
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
    }
    static boolean moverUsuario(Scanner entrada, boolean terminar, String[][] unaMatriz, int[] posicionCursor) {
        char inputUsuario;
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
            case 'f', 'F':
                terminar = true;
        }
        return terminar;
    }
    private static void modificar(String[][] unaMatriz, int[] posicionCursor) {
    }
}






