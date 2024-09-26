import java.util.Scanner;

public class HojaDeCalculo{

    Scanner sc = new Scanner(System.in);

    static boolean salir = false;

    static String[][] texto = new String[15][10];

    static int y = 0;
    static int x = 0;
    static String textoTemp = "";
    int letra = 0;
    public static void main(String[] args) {
        int[][] hojaCalculo = new int[15][10];
        
        while(!salir){
            System.out.println("         A         B         C         D         E         F         G         H         I         J");
            System.out.println("\t+---------+---------+---------+---------+---------+---------+---------+---------+---------+---------+");
            imprimirHojaCalculo(hojaCalculo);
            System.out.println("\t+---------+---------+---------+---------+---------+---------+---------+---------+---------+---------+");
            System.out.println("Estás en la celda: [" + (char)(65+x) + (y + 1) + "]");
            System.out.println("WASD para moverte");
            System.out.println("E para editar");
            System.out.println("Q para salir");
            opciones();
        }
        System.out.println("Adiós! Gracias por usar la hoja de cálculo");
        
        
    }

    public static void opciones(){
        Scanner sc = new Scanner(System.in);
        String opcion = sc.nextLine();

        switch (opcion) {
            case "w":
                if(y > 0){
                    y--;
                }
                break;
            case "a":
                if(x > 0){
                    x--;
                }
                break;
            case "s":
                if(y < 14){
                    y++;
                }
                break;
            case "d":
                if(x < 9){
                    x++;
                }
                break;
            case "e":
                boolean grabar = false;
                while(!grabar){
                    System.out.println("Introduce el valor de la celda: ");
                    textoTemp = sc.nextLine();
                    if (textoTemp.length() > 7){
                        System.out.println("El texto es demasiado largo");
                    }
                    else{
                        grabar = true;
                        grabar();
                    }
                }
                
                break;
            case "q":
                System.out.println("Adiós");
                salir = true;
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
    }

    public static void imprimirHojaCalculo(int[][] hojaCalculo){

        
        for(int i = 0; i < hojaCalculo.length; i++){
            for(int j = 0; j < hojaCalculo[i].length; j++){
                if(j == 0 && i < 9){
                    System.out.print(i + 1 + "       |");
                }
                else if(j == 0 && i >= 9){
                    System.out.print(i + 1 + "      |");
                }

                if(texto[i][j] != null && i==y && j==x){
                    System.out.print("[" + texto[i][j] + " ".repeat(7 - texto[i][j].length()) + "]|");
                }
                else if(texto[i][j] != null){
                    System.out.print(" " + texto[i][j] + " ".repeat(7 - texto[i][j].length()) + " |");
                }
                else if(i==y && j==x){
                    System.out.print("[       ]|");
                }
                else{
                    System.out.print("         |");
                }
            }
            System.out.println();
        }
    }
    public static void grabar(){
        texto[y][x] = textoTemp;
        textoTemp = "";
    }
}
