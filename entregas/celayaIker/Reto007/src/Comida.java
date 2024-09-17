import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Comida {
    String alimentos;
    List<String> lista = new ArrayList<String>();
    Arbol arbol = new Arbol();
    EncuestaNutricional EncuestaNutricional = new EncuestaNutricional();

    public Comida(String alimentos) {
        this.alimentos = alimentos;
        this.lista = new ArrayList<String>();
    }
    public Comida() {
        this.alimentos = alimentos;
    }

    public void añadirAlimento(String alimento){
        lista.add(alimento);
    }
    public void mostrarAlimentos(){
        System.out.println("Alimentos del Comida: ");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
    }
    public String getLista() {
        return lista.toString();
    }

    public void creaComida(){
        lista = new ArrayList<String>();
        System.out.println("Ingrese un alimento del Comida del dia "+arbol.getDia()+" (-1 para terminar / -2 para listar alimentos ingresados)");
        Scanner sc = new Scanner(System.in);
        alimentos = sc.nextLine();
        while (alimentos != "-1"){
            alimentos = sc.nextLine();
            if (alimentos == "-2"){
                mostrarAlimentos();
                creaComida();
            }
            else {
                añadirAlimento(alimentos);
                creaComida();
            }
        }

    }
    public void creamedia(){
        lista = new ArrayList<String>();
        System.out.println("Ingrese un alimento de la media mañana del día "+arbol.getDia()+" (-1 para terminar / -2 para listar alimentos ingresados)");
        Scanner sc = new Scanner(System.in);
        alimentos = sc.nextLine();
        while (alimentos != "-1"){
            alimentos = sc.nextLine();
            if (alimentos == "-2"){
                mostrarAlimentos();
                creamedia();
            }
            else {
                añadirAlimento(alimentos);
                creamedia();
            }
        }
        EncuestaNutricional.rellenadias();


    }
    public void creaalmu(){
        lista = new ArrayList<String>();
        System.out.println("Ingrese un alimento del almuerzo del día "+arbol.getDia()+" (-1 para terminar / -2 para listar alimentos ingresados)");
        Scanner sc = new Scanner(System.in);
        alimentos = sc.nextLine();
        while (alimentos != "-1"){
            alimentos = sc.nextLine();
            if (alimentos == "-2"){
                mostrarAlimentos();
                creaalmu();
            }
            else {
                añadirAlimento(alimentos);
                creaalmu();
            }
        }
        EncuestaNutricional.rellenadias();


    }

    public void creamerienda(){
        lista = new ArrayList<String>();
        System.out.println("Ingrese un alimento de la merienda del día "+arbol.getDia()+" (-1 para terminar / -2 para listar alimentos ingresados)");
        Scanner sc = new Scanner(System.in);
        alimentos = sc.nextLine();
        while (alimentos != "-1"){
            alimentos = sc.nextLine();
            if (alimentos == "-2"){
                mostrarAlimentos();
                creamerienda();
            }
            else {
                añadirAlimento(alimentos);
                creamerienda();
            }
        }
        EncuestaNutricional.rellenadias();


    }

    public void creacena(){
        lista = new ArrayList<String>();
        System.out.println("Ingrese un alimento de la cena del día "+arbol.getDia()+" (-1 para terminar / -2 para listar alimentos ingresados)");
        Scanner sc = new Scanner(System.in);
        alimentos = sc.nextLine();
        while (alimentos != "-1"){
            alimentos = sc.nextLine();
            if (alimentos == "-2"){
                mostrarAlimentos();
                creacena();
            }
            else {
                añadirAlimento(alimentos);
                creacena();
            }
        }
        EncuestaNutricional.rellenadias();


    }


}