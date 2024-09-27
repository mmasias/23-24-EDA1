import java.util.Comparator;
import java.util.function.Consumer;

public class DatosArbol<T> {
    private Arbol<T> arbol;

    public DatosArbol(Comparator<T> comparador) {
        this.arbol = new Arbol<>(comparador);
    }

    public void insertar(T elemento) {
        arbol.insertar(elemento);
    }

    public T buscar(T elemento) {
        return arbol.buscar(elemento);
    }

    public void recorrerInOrden(Consumer<T> accion) {
        arbol.recorrerInOrden(accion);
    }

}
