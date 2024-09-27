class Node<T> {
    int key;
    T value;
    Node<T> left;
    Node<T> right;

    public Node(int key, T value) {
        this.key = key;
        this.value = value;
        left = null;
        right = null;
    }
}