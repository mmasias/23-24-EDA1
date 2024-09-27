import java.util.List;
public class Nodo {

    String dato = "";
    Nodo padre;
    List<String> lista;

    public Nodo(String dato, Nodo padre) {
        this.dato = dato;
        this.padre = padre;
    }
    public Nodo(String dato) {
        this.dato = dato;
        this.padre = null;
    }

    public Nodo(List<String> dato, Nodo padre) {
        this.lista = dato;
        this.padre = padre;
    }


    public void crearaiz(String dato){
        this.dato = dato;
        this.padre = null;
    }

    public void crearhijo(String dato, Nodo padre){
        Nodo hijo = new Nodo(dato, padre);
    }



}