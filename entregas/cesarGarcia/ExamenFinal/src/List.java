public class List<T extends Comparable<T>> {

    private ListNode<T> first = null;

    public int size() {
        if (this.first == null) {
            return 0;
        }
        int count = 1;
        ListNode<T> iterator = first;
        while (iterator.getNext() != null) {
            count++;
            iterator = iterator.getNext();
        }
        return count;
    }

    public boolean isEmpty() {
        return this.size() > 0 ? false : true;
    }

    public void insertFront(T value) {
        ListNode<T> newNode = new ListNode<T>(value);
        if (this.first == null)
            this.first = newNode;
        else {
            newNode.setNext(this.first);
            this.first = newNode;
        }
    }

    public void insertEnd(T value) {
        ListNode<T> newNode = new ListNode<T>(value);
        if (this.first == null)
            this.first = newNode;
        else {
            ListNode<T> iterator = this.first;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(newNode);
        }
    }

    public void deleteFront() {
        if (this.first != null) {
            this.first = this.first.getNext();
        }
    }

    public ListNode<T> getFirst() {
        return this.first;
    }

    public ListNode<T> getLast() {
        ListNode<T> iterator = this.first;
        while (iterator.getNext() != null) {
            iterator = iterator.getNext();
        }
        return iterator;
    }

    public Object[] listarTodo() {
        Object[] list = new Object[this.size()];
        ListNode<T> iterator = this.first;

        if (iterator == null)
            return list;

        int count = 0;
        while (iterator != null) {
            list[count] = iterator.getValue();
            count++;
            iterator = iterator.getNext();
        }
        return list;
    }

    public void insertarOrdenado(T value) {
        ListNode<T> newNode = new ListNode<T>(value);

        if (this.first == null || value.compareTo(this.first.getValue()) < 0) {
            newNode.setNext(this.first);
            this.first = newNode;
        } else {
            ListNode<T> current = this.first;
            ListNode<T> previous = null;
            while (current != null && value.compareTo(current.getValue()) >= 0) {
                previous = current;
                current = current.getNext();
            }
            newNode.setNext(current);
            if (previous != null) {
                previous.setNext(newNode);

            }
        }
    }

    public T getObjeto(int posicion) {
        int contador = 0;
        if (first == null) {
            throw new IndexOutOfBoundsException();
        }
        ListNode<T> actual = first;
        do {

            if (posicion == contador) {
                return actual.getValue();
            }
            contador++;
            actual = actual.getNext();

        } while (actual != null);
        throw new IndexOutOfBoundsException();
    }

    public void vaciar() {
        this.first = null;
    }

    public T getValorPorPosicion(int posicion) {
        if (this.first == null)
            throw new IndexOutOfBoundsException();
        ListNode<T> actual = this.first;
        int contador = 0;
        do {
            if (contador == posicion) {
                return actual.getValue();
            }
            contador++;
            actual = actual.getNext();
        } while (actual != null);
        throw new IndexOutOfBoundsException();
    }

    public int indexOf(T value) {
        ListNode<T> iterator = this.first;
        int index = 0;
        while (iterator != null) {
            if (iterator.getValue().equals(value)) {
                return index;
            }
            if (iterator.getValue() instanceof String) {
                if (((String) iterator.getValue()).equalsIgnoreCase((String) value)) {
                    return index;
                }
            }
            iterator = iterator.getNext();
            index++;
        }
        return -1;
    }
}