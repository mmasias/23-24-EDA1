
package hojacalculo;

import java.util.Scanner;

/**
 *
 * @author alejandro
 */
public class HojaCalculo {

    final static String letras[]={"A", "B","C","D","E", "F","G", "H", "I","J"};
    static String celdas[][] = new String[15][10];
    static int fila = 0;
    static int columna = 0;
    
    public static void main(String[] args) {
        
        char comando;
        Scanner teclado = new Scanner(System.in);
        
        //Inicialización de celdas
        for (int i=0; i<15; i++){
            for (int j=0; j<10;j++)
                celdas[i][j]="     ";
        }
        
        do{
            System.out.println();
            dibujo_tabla ();
            menu();
            comando = teclado.next().charAt(0);
            
            //Convierto en minúsculas
            comando = Character.toLowerCase(comando);
            
            //Llamo a la función que introduce el texto en la tabla
            if(comando =='e'){
                introducir_texto(teclado);
            }
            else    
                //Si no es salida, tiene que ser un comando de acción.
                if(comando!='q')
                    movimiento(comando);
            
        }while(comando!='q');
        
        System.out.println("\n\n********** Fin del programa **********");
        
    }
    
    public static void movimiento(char comando){
        
        switch(comando){
            
            //Movimiento arriba
            case 'w':
                if(fila==0)
                    System.out.println("\nYa estás en la primera fila. Movimiento imposible\n.");
                else
                    fila--;
                
                break;
            
            //Movimiento abajo
            case 's':
                if(fila==14)
                    System.out.println("\nYa estás en la última fila. Movimiento imposible\n.");
                else
                    fila++;
                break;
                
            //Movimiento izquierda
            case 'a':
                if(columna==0)
                    System.out.println("\nYa estás en la primera columna. Movimiento imposible\n");
                else
                    columna--;
                
                break;
            //Movimiento derecha
            case 'd':
                if(columna==9)
                    System.out.println("\nYa estás en la última columna. Movimiento imposible\n");
                else
                    columna++;
                break;
            default:
                System.out.println("\nComando no permitido.\n");
        }
       
    }
    
    public static void introducir_texto(Scanner teclado){
        teclado.nextLine();
        System.out.print("Texto a ingresar ...   ");
        String texto = teclado.nextLine();
        
        //Si el texto es mayor que 5 caracteres (tamaño celda 7 = 5 + [ ])
        //le corto. Si es menor lo relleno de espacios.
        if(texto.length()>5)
            texto=texto.substring(0,5);
        for(int i=texto.length();i<5;i++)
            texto+=" ";
        //Cargo el valor introducido en la matriz en la posición fijada
        celdas[fila][columna]=texto;
        
    }
    
    public static void menu(){
        System.out.println("Celda actual -> ["+letras[columna]+(fila+1)+"]");
        System.out.println("Utilice las teclas W, A, S y D para moverse.");
        System.out.println("Presione 'E' para ingresar texto en la celda actual");
        System.out.println("Presione 'Q' para salir");
        System.out.print("     Introduce un comando ..... ");
    }
    
    
    
    
    
    public static void dibujo_tabla(){
        
        String espacios ="       ";
        
        //Dibujamos tabla
        
        //Cabecera
        System.out.print("       ");
        
        for(int i=0;i<10;i++)
            System.out.print(letras[i]+ espacios);
        
        System.out.print("\n      ");
        
        for(int i=0;i<10;i++)
            System.out.print("+-------");
        System.out.println("+");
        
        //Filas
        for(int i=0;i<15;i++){
            if(i<9)
                System.out.print((i+1)+"     ");
            else
                System.out.print((i+1)+"    ");
            
            for(int j=0;j<10;j++)
                if(fila==i && columna==j)
                    System.out.print("|["+celdas[i][j]+"]");
                else
                    System.out.print("| "+celdas[i][j]+" ");
            System.out.println("|");
        }
        System.out.print("      ");
        for(int i=0;i<10;i++)
            System.out.print("+-------");
        System.out.println("+");
            
    }
    
}
