
class List<T> {
    private Node<T> first = null;

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (first == null) {
            first = newNode;
        } else {
            Node<T> iterator = first;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(newNode);
        }
    }

    public T get(int index) {
        int currentIndex = 0;
        Node<T> current = first;
        while (currentIndex < index && current != null) {
            currentIndex++;
            current = current.getNext();
        }
        if (current != null) {
            return current.getValue();
        }
        return null;
    }

    public int size() {
        int count = 0;
        Node<T> current = first;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }
}