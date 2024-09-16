package entregas.sergioMayen.ListaReto4;

public class List {
    private Node first = null;
    private Node last = null;
    private int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insert(String value) {
        Node newNode = new Node(value);
        if (first == null) {
            first = newNode;
            last = newNode; // Cuando la lista está vacía, el nuevo nodo es el primero y el último.
        } else {
            last.setNext(newNode);
            last = newNode; // El nuevo nodo se convierte en el último.
        }
        size++;
    }

    public void insertAtBeginning(String value) {
        Node newNode = new Node(value);
        newNode.setNext(first);
        first = newNode; // El nuevo nodo se convierte en el primero.
        size++;
    }

    public void delete() {
        if (first != null) {
            if (size == 1) {
                first = null;
                last = null; // Cuando se elimina el último elemento, se actualiza "last".
            } else {
                Node iterator = first;
                Node previous = null;
                while (iterator.getNext() != null) {
                    previous = iterator;
                    iterator = iterator.getNext();
                }
                previous.setNext(null);
                last = previous; // Actualizamos "last" al nodo anterior.
            }
            size--;
        }
    }

    public String[] listAll() {
        String[] list = new String[size];
        Node iterator = first;
        int count = 0;
        while (iterator != null) {
            list[count] = iterator.getValue();
            count++;
            iterator = iterator.getNext();
        }
        return list;
    }
}