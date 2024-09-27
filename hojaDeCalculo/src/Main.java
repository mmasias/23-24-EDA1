import java.util.Scanner;

public class Main {
    static final int FILA = 0;
    static final int COLUMNA = 1;
    static final int ARRIBA = 1;
    static final int ABAJO = 2;
    static final int IZQUIERDA = 3;
    static final int DERECHA = 4;
    static final int INGRESO=5;
    static final int FIN=6;
    static final int[][] MOVIMIENTOS = {
            {0, 0},
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };
    public static void main(String[] args) {





            int[][] hoja = {
                    {0, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15},
                    {1, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15},
                    {2, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15},
                    {3, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15},
                    {4, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15},
                    {5, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15},
                    {6, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15},
                    {7, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15},
                    {8, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15},
                    {9, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15},
                    {10, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15},
                    {11, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15},
                    {12, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15},
                    {13, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15},
                    {14, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15},
            };
            String [] finalDeHoja={"    +-------+-------+-------+-------+-------+-------+-------+-------+-------+-------+"};
            String[] []cabezera={
                    {"     A       B       C       D       E       F       G       H       I       J"},
                    {"    +-------+-------+-------+-------+-------+-------+-------+-------+-------+-------+"},
            };
            int [] usuario={1,1};
            System.out.println(cabezera[0][0]);
        System.out.println(cabezera[1][0]);
            imprimeHoja(hoja,usuario);
        for (int i = 0; i < usuario.length; i++) {
            definePosicion(usuario,hoja);
        }
            System.out.println(finalDeHoja);
        }
    public static void imprimeElementosHoja(int unTile) {

        String[] terreno = {"1    |", "2    |", "3    |", "4    |", "5    |", "6    |", "7    |", "8    |", "9    |", "10   |", "11   |", "12   |", "13   |", "14   |", "15   |", "       |"};
        System.out.print(terreno[unTile]);
    }
    public static void imprimeUsuario() {

        System.out.print("[     ]|");
    }
    public static void imprimeHoja(int[][] hoja, int[] usuario) {

        for (int fila = 0; fila < hoja.length; fila++) {
            for (int columna = 0; columna < hoja[fila].length; columna++) {
                if (fila == usuario[FILA] && columna == usuario[COLUMNA]) {
                    imprimeUsuario();
                }else {
                    imprimeElementosHoja(hoja[fila][columna]);
                }
                imprimeElementosHoja(hoja.length);
            }
            System.out.println();

        }
        System.out.println();

    }

    public static char preguntaChar() {

        Scanner entrada = new Scanner(System.in);
        return entrada.next().charAt(0);
    }




    static void mueve(int[] usuario, int movimiento, int[][] hoja) {

        int nuevaFila = usuario[FILA] + MOVIMIENTOS[movimiento][FILA];
        int nuevaColumna = usuario[COLUMNA] + MOVIMIENTOS[movimiento][COLUMNA];



        usuario[FILA] = nuevaFila;
        usuario[COLUMNA] = nuevaColumna;



    }
    private static void definePosicion(int[] usuario, int[][] hoja) {

        switch (capturaMovimiento()) {
            case ARRIBA:
                mueve(usuario, ARRIBA, hoja);
                break;
            case ABAJO:
                mueve(usuario, ABAJO, hoja);
                break;
            case IZQUIERDA:
                mueve(usuario, IZQUIERDA, hoja);
                break;
            case DERECHA:
                mueve(usuario, DERECHA, hoja);
                break;
        }
    }

    private static int capturaMovimiento() {

        switch (preguntaChar()) {
            case 's', 'S':
                return ABAJO;
            case 'w', 'W':
                return ARRIBA;
            case 'a', 'A':
                return IZQUIERDA;
            case 'd', 'D':
                return DERECHA;
            case 'e','E':

        }
        return 0;
    }





    }


