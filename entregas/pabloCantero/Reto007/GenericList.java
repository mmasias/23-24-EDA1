public class GenericList<T extends Comparable<T>> {
    private GenericNode<T> first = null;

    public int size() {
        if (this.first == null) {
            return 0;
        }
        int count = 1;
        GenericNode<T> iterator = first;
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
        GenericNode<T> newNode = new GenericNode<T>(value);
        if (this.first == null)
            this.first = newNode;
        else {
            newNode.setNext(this.first);
            this.first = newNode;
        }
    }

    public void insertEnd(T value) {
        GenericNode<T> newNode = new GenericNode<T>(value);
        if (this.first == null)
            this.first = newNode;
        else {
            GenericNode<T> iterator = this.first;
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

    public GenericNode<T> getFirst() {
        return this.first;
    }

    public GenericNode<T> getLast() {
        GenericNode<T> iterator = this.first;
        while (iterator.getNext() != null) {
            iterator = iterator.getNext();
        }
        return iterator;
    }

    public Object[] listAll() {
        Object[] list = (T[]) new Object[this.size()];
        GenericNode<T> iterator = this.first;

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

    public void insertarEnOrden(T value) {
        GenericNode<T> newNode = new GenericNode<T>(value);

        if (this.first == null || value.compareTo(this.first.getValue()) < 0) {
            newNode.setNext(this.first);
            this.first = newNode;
        } else {
            GenericNode<T> current = this.first;
            GenericNode<T> previous = null;

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
        GenericNode<T> actual = first;
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

}