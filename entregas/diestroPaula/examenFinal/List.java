import java.util.Iterator;
import java.util.NoSuchElementException;

public class List<T> implements Iterable<T> {
    private Node<T> cabeza;
    private int size;

    public List() {
        this.cabeza = null;
        this.size = 0;
    }

    public void agregar(T data) {
        Node<T> nuevoNodo = new Node<>(data);
        nuevoNodo.setSiguiente(cabeza);
        cabeza = nuevoNodo;
        size++;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Indice fuera de rango");
        }

        Node<T> current = cabeza;
        for (int i = 0; i < index; i++) {
            current = current.getSiguiente();
        }
        return current.getData();
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Indice fuera de rango");
        }

        if (index == 0) {
            cabeza = cabeza.getSiguiente();
        } else {
            Node<T> current = cabeza;
            for (int i = 0; i < index - 1; i++) {
                current = current.getSiguiente();
            }
            current.setSiguiente(current.getSiguiente().getSiguiente());
        }
        size--;
    }

    public void clear() {
        cabeza = null;
        size = 0;
    }

    public boolean contains(T data) {
        Node<T> current = cabeza;
        while (current != null) {
            if (current.getData().equals(data)) {
                return true;
            }
            current = current.getSiguiente();
        }
        return false;
    }

    public Node<T> getCabeza() {
        return cabeza;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> current = cabeza;
        while (current != null) {
            sb.append(current.getData().toString());
            if (current.getSiguiente() != null) {
                sb.append(" -> ");
            }
            current = current.getSiguiente();
        }
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = cabeza;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                } else {
                    T data = current.getData();
                    current = current.getSiguiente();
                    return data;
                }
                
            }
        };
    }

}