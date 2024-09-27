import java.lang.reflect.Array;

public class GenericList<T> {

    private GenericNode<T> first = null;

    public int size() {
        if (this.first == null) {
            return 0;
        }
        int count = 0;
        GenericNode<T> iterator = first;
        while (iterator != null) {
            count++;
            iterator = iterator.getNext();
        }
        return count;
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public void insertFront(T value) {
        GenericNode<T> newNode = new GenericNode<>(value);
        newNode.setNext(this.first);
        this.first = newNode;
    }

    public void insertEnd(T value) {
        GenericNode<T> newNode = new GenericNode<>(value);
        if (this.first == null) {
            this.first = newNode;
        } else {
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

    public T[] listAll(Class<T> type) {
        @SuppressWarnings("unchecked")
        T[] list = (T[]) Array.newInstance(type, this.size());
        GenericNode<T> iterator = this.first;

        int count = 0;
        while (iterator != null) {
            list[count] = iterator.getValue();
            count++;
            iterator = iterator.getNext();
        }
        return list;
    }
}
