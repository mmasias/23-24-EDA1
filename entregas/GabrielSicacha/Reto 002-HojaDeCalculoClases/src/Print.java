public class Print {

    public static void print(SpreadSheet Spread){


        for (int c = 0; c < Spread.columns; c++){
            if(c==0){
                System.out.print("     ");
            }
            System.out.print((char) ('A' + c) + "         ");
        }
        System.out.println();

        for (int i = 0; i < Spread.rows; i++){

            if (i==0){
                borde(Spread.columns);
            }

            for (int j = 0; j < Spread.columns; j++){
                if (j==0){
                    System.out.print(formatString(String.valueOf(i+1), 5)+"|");
                }


                if ((i==Spread.pos[0])&&(j==Spread.pos[1]) ){
                    System.out.print("["+formatString(Spread.spreadSheet[i][j], 7)+"]|");
                } else {
                    System.out.print(" "+formatString(Spread.spreadSheet[i][j], 7)+" |");
                }
            }

            System.out.println();

            if (i==Spread.rows-1){
                borde(Spread.columns);
            }
        }


    }

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

    public static String formatString(String string, int length) {

        return String.format("%-"+length+ "s", string);
    }

    public static void printControls(int[] pos){
        System.out.println("Celda actual -> [" +(char) ('A' + pos[1])+(pos[0]+1)+"]");
        System.out.println("Utilice las teclas W, A, S y D para moverse.");
        System.out.println("Presione 'E' para ingresar texto en la celda actual.");
        System.out.println("Presione 'Q' para salir.");
    }
}
