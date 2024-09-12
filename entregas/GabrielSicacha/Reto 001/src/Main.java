//imports
import java.util.Arrays;
import java.util.Scanner;
public class Main {


    public static void main(String[] args) {
        //inicializamos un par de variables importantes
        int[] pos = {0, 0};
        int rows = 15;
        int columns = 10;

        //creamos nuestra matriz
        String[][] spreadSheet = new String[rows][columns];

        //inicializamos nuestra matriz
        initialize(spreadSheet);

        //código se ejecutará indefinidamente
        while(true) {
            print(spreadSheet,rows,columns,pos);
            control(spreadSheet, pos);
        }
    }


    //inicializamos nuestra matriz, dándole un valor vacío a cada casilla
    public static void initialize(String[][] spreadSheet){
        for (String[] strings : spreadSheet) {
            Arrays.fill(strings, " ");
        }
    }


    //imprimimos la hoja de cálculo
    public static void print(String[][] spreadSheet, int rows, int columns, int[] pos){


        //creamos las letras de cada columna, desde a hasta el character equivalente al número total de columnas
        for (int c = 0; c < columns; c++){
            if(c==0){
                System.out.print("     ");
            }
            System.out.print((char) ('A' + c) + "       ");
        }
        System.out.println();

        //empezamos a dibujar la hoja de cálculo
        for (int i = 0; i < rows; i++){

            //borde superior
            if (i==0){
                borde(columns);
            }

            for (int j = 0; j < columns; j++){
                if (j==0){
                    //enumeramos cada fila
                    System.out.print(formatString(String.valueOf(i+1), 5)+"|");
                }

                //formateamos e imprimimos el valor de cada celda
                if ((i==pos[0])&&(j==pos[1]) ){
                    System.out.print("["+formatString(spreadSheet[pos[1]][pos[0]], 7)+"]|");
                } else {
                    System.out.print(" "+formatString(spreadSheet[i][j], 7)+" |");
                }
            }

            System.out.println();

            //borde inferior
            if (i==rows-1){
                borde(columns);
            }
        }


    }



    //método para mostrar las instrucciones y recibirlas
    public static void control(String[][] spreadSheet, int[] pos){
        System.out.println("Celda actual -> [" +(char) ('A' + pos[1])+(pos[0]+1)+"]");
        System.out.println("Utilice las teclas W, A, S y D para moverse.");
        System.out.println("Presione 'E' para ingresar texto en la celda actual.");
        System.out.println("Presione 'Q' para salir.");

        Scanner input = new Scanner(System.in);
        char userInput = input.nextLine().charAt(0);
        switch (userInput) {

            //mover la casilla seleccionada
            case 's', 'S':
                pos[0] = pos[0] + 1;
                break;
            case 'w', 'W':
                pos[0] = pos[0] - 1;
                break;
            case 'a', 'A':
                pos[1] = pos[1] - 1;
                break;
            case 'd', 'D':
                pos[1] = pos[1] + 1;
                break;

            //ingresar texto a una casilla
            case 'E', 'e':
                overWrite(spreadSheet, pos);
                break;
            //terminar programa
            case 'q', 'Q':
                System.exit(0);
                break;
        }

    }

    //método para formatear Strings y casillas a un largo especifico
    public static String formatString(String string, int length) {
        return String.format("%-"+length+ "s", string);
    }

    //método para imprimir borde superior e inferior
    public static void borde(int columns){
        for (int b = 0; b < columns; b++) {
            if (b == 0) {
                System.out.print("     +");
            }
            System.out.print("---------+");
            if (b + 1 == columns) {
                System.out.println();
            }
        }
    }


    //método para ingresar y sobreescribir el valor de las casillas
    public static void overWrite(String[][] spreadSheet, int[] pos){
        System.out.println("Ingrese texto");
        System.out.println("Celda actual -> [" +(char) ('A' + pos[1])+(pos[0]+1)+"]");
        System.out.println("valor actual -> [" + spreadSheet[pos[1]][pos[0]]+"]");
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();

        //asegurarnos que el valor no tendrá un valor superior al tamaño de la casilla
        if(userInput.length() > 7) {
            spreadSheet[pos[1]][pos[0]] = userInput.substring(0, 7);
        } else {
            spreadSheet[pos[1]][pos[0]] = userInput;
        }
    }
}