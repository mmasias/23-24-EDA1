package hojacalculo;

import java.util.Scanner;

/**
 *
 * @author alejandro
 */
public class HojaCalculo {
    
    public static void main(String[] args) {
        
        char comando;
        Scanner teclado = new Scanner(System.in);        
        tabla mihoja=new tabla();              
        do{
            System.out.println();            
            comando = teclado.next().charAt(0);            
            //Convierto en mmayúsculas
            comando = Character.toLowerCase(comando);
            if (comando=='q')           
                System.out.println("\n\n********** Fin del programa **********");           
            else if (comando=='a' || comando=='s' || comando=='d' || comando=='w' || comando=='e')
                mihoja.opera(comando, teclado);
            else   
                System.out.println("\n\n********** Comando no válido. Pruebe de nuevo **********");  
        }while(comando!='q');
        teclado.close();
        mihoja=null;
        System.exit(1);
    }    
}
