package ExamenFinal.utils.generica;

public class GenericList<T> {

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

    public void clear() {
        this.first = null;
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

    public void printAll() {
        GenericNode<T> iterator = this.first;

        while (iterator != null) {
            System.out.println(iterator.getValue());
            iterator = iterator.getNext();
        }
    }

    

    public void delete(T value) {
        if (this.first != null) {
            if (this.first.getValue().equals(value)) {
                this.first = this.first.getNext();
            } else {
                GenericNode<T> iterator = this.first;
                while (iterator.getNext() != null) {
                    if (iterator.getNext().getValue().equals(value)) {
                        iterator.setNext(iterator.getNext().getNext());
                        break;
                    }
                    iterator = iterator.getNext();
                }
            }
        }
    }

    public T get(int valor) {
        GenericNode<T> iterator = this.first;
        int count = 0;
        while (iterator != null) {
            if (count == valor) {
                return iterator.getValue();
            }
            count++;
            iterator = iterator.getNext();
        }
        return null;
    }
}