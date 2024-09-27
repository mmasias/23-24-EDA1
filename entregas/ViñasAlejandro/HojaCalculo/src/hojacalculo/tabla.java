package hojacalculo;

import java.util.Scanner;

public class tabla {    
    //ATRIBUTOS DE LA CLASE

    private int numfilas=15; //Valor por defecto en constructor vacío
    private int numcolumnas=10; //Valor por defecto en constructor vacío
    private posicion posXY = null; //Es un objeto que se obtiene al instanciar la clase posicion
    private String celdas[][]=null;
    //static final--Les asignamos un valor una vez y en todos los objetos que se creen en base a esta clase tendrán siempre el mismo valor
    private static final String letras[]={"A","B","C","D","E","F","G", "H", "I","J","L","M","N","Ñ","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    private static final String validos="asdw";
    
    //CONSTRUCTORES DE LA CLASE

    //Constructor para valores por defecto
    public tabla(){
        this.inicializa();
        this.repinta();
    }
   
    /*getters y setters*/
    public int getNumfilas()
    {
        return this.numfilas;
    }
    public void setNumfilas(int numero)
    {
        this.numfilas=numero;
        this.repinta();
    }
    public int getNumcolumnas()
    {
        return this.numcolumnas;
    }
    public void setNumcolumnas(int numero)
    {
        this.numcolumnas=(numero>letras.length)?10:numero; //Si intentamos poner más columnas de las disponibles se pone el por defecto
        this.repinta();
    }
    //METODOS DE LA CLASE

    //Método de la clase tabla que inicializa la posición y las celdas
    private void inicializa()
    {
        posXY=new posicion();
        celdas = new String[this.numfilas][this.numcolumnas];
         //Inicialización de celdas
         for (int i=0; i<this.numfilas; i++)         
            for (int j=0; j<this.numcolumnas;j++)
                celdas[i][j]="     ";         
    }
    //Método de la clase tabla que se encargará de dibujar la tabla
    private void dibujo_tabla(){        
        String espacios ="       ";        
        //Dibujamos tabla        
        //Cabecera
        System.out.print("       ");        
        for(int i=0;i<this.numcolumnas;i++)
            System.out.print(letras[i]+ espacios);        
        System.out.print("\n      ");        
        for(int i=0;i<this.numcolumnas;i++)
            System.out.print("+-------");
        System.out.println("+");        
        //Filas
        for(int i=0;i<this.numfilas;i++){
            if(i<9)
                System.out.print((i+1)+"     ");
            else
                System.out.print((i+1)+"    ");            
            for(int j=0;j<this.numcolumnas;j++)
                if(this.posXY.getfila()==i && this.posXY.getcolumna()==j)
                    System.out.print("|["+celdas[i][j]+"]");
                else
                    System.out.print("| "+celdas[i][j]+" ");
            System.out.println("|");
        }
        System.out.print("      ");
        for(int i=0;i<this.numcolumnas;i++)
            System.out.print("+-------");
        System.out.println("+");            
    }
    //Método de la clase tabla que se encarga de pintar el menú
    private void menu(){
        System.out.println("Celda actual -> ["+letras[this.posXY.getcolumna()]+(this.posXY.getfila()+1)+"]");
        System.out.println("Utilice las teclas W, A, S y D para moverse.");
        System.out.println("Presione 'E' para ingresar texto en la celda actual");
        System.out.println("Presione 'Q' para salir");
        System.out.print("     Introduce un comando ..... ");
    }
    //Método de la clase tabla que gestiona qué operación realizar, mover o introducir texto
    public void opera(char caracter,  Scanner lector)
    {
        switch (Character.toUpperCase(caracter)){           
            case 'E':
                this.introducir_texto(lector);
            default:
                if(esComandoValido(caracter)) 
                    this.mover(caracter);
        }  
    } 
    private boolean esComandoValido(char caracter)
    {
        return validos.contains(String.valueOf(caracter)) ;  
    }  
    private void mover(char comando){        
        switch(comando){            
            //Movimiento arriba
            case 'w':
                if(this.posXY.getfila()!=0)
                {
                    this.posXY.muevefila('-');//fila--;  
                    this.repinta();
                }                    
                else
                    System.out.println("\nYa estás en la primera fila. Movimiento imposible\n.");                                  
                break;            
            //Movimiento abajo
            case 's':
                if(this.posXY.getfila()!=this.numfilas-1)
                {                    
                    this.posXY.muevefila('+');
                    this.repinta();
                }                    
                else
                    System.out.println("\nYa estás en la última fila. Movimiento imposible\n.");

                break;                
            //Movimiento izquierda
            case 'a':
                if(this.posXY.getcolumna()!=0)
                {
                    this.posXY.muevecol('-');
                    this.repinta();
                }   
                else
                    System.out.println("\nYa estás en la primera columna. Movimiento imposible\n");
                break;
            //Movimiento derecha
            case 'd':
                if(this.posXY.getcolumna()!=this.numcolumnas-1)  
                {                                 
                    this.posXY.muevecol('+');                                    
                    this.repinta();
                }
                else
                    System.out.println("\nYa estás en la última columna. Movimiento imposible\n");                                  break;
            default:
                System.out.println("\nComando no permitido.\n");
        }      
    }
    private void repinta()
    {
        this.dibujo_tabla();
        this.menu();
    }
    private void introducir_texto(Scanner lector){             

        lector.nextLine();
        System.out.print("Texto a ingresar ...   ");
        String texto = lector.nextLine();        
        //Si el texto es mayor que 5 caracteres (tamaño celda 7 = 5 + [ ])
        //le corto. Si es menor lo relleno de espacios.
        if(texto.length()>5)
            texto=texto.substring(0,5);
        else
            texto=texto+ " ".repeat(5-texto.length());
        //for(int i=texto.length();i<5;i++)
        //   texto+=" ";
        //Cargo el valor introducido en la matriz en la posición fijada
        celdas[this.posXY.getfila()][this.posXY.getcolumna()]=texto;       
        this.dibujo_tabla(); 
        this.menu();       
    }
  
}
