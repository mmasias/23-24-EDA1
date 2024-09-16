class BinaryTree<T> {
    private Node<T> root;

    public BinaryTree() {
        root = null;
    }

    public void add(int key, T value) {
        root = addRecursive(root, key, value);
    }

    private Node<T> addRecursive(Node<T> current, int key, T value) {
        if (current == null) {
            return new Node<>(key, value);
        }

        if (key < current.key) {
            current.left = addRecursive(current.left, key, value);
        } else if (key > current.key) {
            current.right = addRecursive(current.right, key, value);
        } else {
            return current;
        }

        return current;
    }

    public T find(int key) {
        return findRecursive(root, key);
    }

    private T findRecursive(Node<T> current, int key) {
        if (current == null) {
            return null;
        } 
        if (key == current.key) {
            return current.value;
        } 
        return key < current.key ? findRecursive(current.left, key) : findRecursive(current.right, key);
    }
}