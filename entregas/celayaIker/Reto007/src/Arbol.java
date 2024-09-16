import java.util.List;
import java.util.Scanner;
public class Arbol {

    Nodo raiz=new Nodo("EncuestaNutricional",null);


    EncuestaNutricional EncuestaNutricional = new EncuestaNutricional();
    Arbol arbol = new Arbol("EncuestaNutricional");

    String dato;
    Comida Comida = new Comida();
    Nodo Nodo = new Nodo(dato, null);

    int dias;



    public Arbol(String dato) {
        this.dato = dato;
        this.raiz = new Nodo(dato, null);
    }
    public Arbol() {
        this.dato = dato;
    }

    public void añaderama(String dato, Nodo padre){
        Nodo hijo = new Nodo(dato, padre);

    }
    public void ramaNodo(List<String> lista, Nodo Nodo){
        Nodo = new Nodo(lista, null);
    }
    public void creaRaiz(String dato){
        Nodo raiz = new Nodo(dato, null);
    }
    public int setDias(int dia) {
        this.dias = dia;
        return dia;
    }
    public int getDia() {
        return dias;
    }




}