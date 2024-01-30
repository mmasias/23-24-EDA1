package arbolReto6.src;

public class Lista<T> {
    private Nodo<T> primero;

    public Lista() {
        this.primero = null;
    }
    public Lista(Nodo<T> primero) {
        this.primero = primero;
    }

    public Nodo<T> getPrimero() {
        return primero;
    }
    Simulacion simulacion = new Simulacion();

    public int size() {
        int count = 0;
        Nodo<T> current = primero;
        while (current != null) {
            current = current.getSiguiente();
            count++;
        }
        return count;
    }


    public void agregar(Lista<Lista> node){
        if (primero == null) {
            primero = (Nodo<T>) node.getPrimero();
        } else {
            Nodo<T> current = primero;
            while (current.getSiguiente() != null) {
                current = current.getSiguiente();
            }
            current.setSiguiente((Nodo<T>) node.getPrimero());
        }
    }

    public void agregar(Nodo<T> node){
        if (primero == null) {
            primero = node;
        } else {
            Nodo<T> current = primero;
            while (current.getSiguiente() != null) {
                current = current.getSiguiente();
            }
            current.setSiguiente( node);
        }
    }
    public void agregarEn(Nodo<T> node, int index){
        int count = 0;
        if (count >= index) {
            node.setSiguiente(primero);
            primero = node;
        } else {
            Nodo<T> current = primero;
            while (current.getSiguiente() != null && count < index - 1) {
                current = current.getSiguiente();
                count++;
            }
            node.setSiguiente(current.getSiguiente());
            current.setSiguiente(node);
        }
    }

    public void eliminar(int index) {
        if (index + 1 > size() || index < 0) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            primero = primero.getSiguiente();
        } else {
            Nodo<T> current = primero;
            while (current != null && index > 1) {
                current = current.getSiguiente();
                index--;
            }
            current.setSiguiente(current.getSiguiente().getSiguiente());
        }
    }
    public boolean isEmpty() {
        return size() == 0;
    }

    public Nodo<T> get(int index) {
        if (index + 1 > size()) {
            throw new IndexOutOfBoundsException();
        }

        Nodo<T> current = primero;
        while (current != null && index > 0) {
            current = current.getSiguiente();
            index--;
        }
        return current;
    }
    public void imprimirLista(Lista<T> lista) {
        for (int i = 0; i < lista.size(); i++) {
            System.out.println("###" + lista.get(i).getDato());
        }
    }
    public void busqueda(String nombreUsuario, Lista<String> nombresUsuarios){
        for (int i = 0; i < nombresUsuarios.size(); i++) {
            if (nombresUsuarios.get(i).getDato().equals(nombreUsuario)) {
            }
        }
    }

}
