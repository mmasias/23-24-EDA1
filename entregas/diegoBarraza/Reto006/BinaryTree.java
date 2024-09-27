public class BinaryTree<T extends Comparable<T>> implements IDataStructure<T> {
    private NodoTree<T> root;

    public NodoTree<T> getRoot() {
        return root;
    }

    public void insert(T data) {
        if (root == null) {
            root = new NodoTree<>(data);
        } else {
            insert(data, root);
        }
    }

    private void insert(T data, NodoTree<T> node) {
        if (node != null) {
            final int comparison = data.compareTo(node.getData());
            if (comparison < 0) {
                if (node.getLeftNode() == null) {
                    node.setLeftNode(new NodoTree<>(data));
                } else {
                    insert(data, node.getLeftNode());
                }
            } else if (comparison > 0) {
                if (node.getRightNode() == null) {
                    node.setRightNode(new NodoTree<>(data));
                } else {
                    insert(data, node.getRightNode());
                }
            }
        }
    }

    @Override
    public int size() {
        return countNodes(root);
    }

    @Override
    public NodoTree<T> getFirst() {
        throw new UnsupportedOperationException("Unimplemented method 'getFirst'");
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public Object[] listData() {
        final Object[] arr = new Object[size()];
        fillInOrder(arr, root, 0);
        return arr;
    }

    private int fillInOrder(Object[] arr, NodoTree<T> node, int firstIndex) {
        if (node != null) {
            int leftCount = fillInOrder(arr, node.getLeftNode(), firstIndex);
            arr[firstIndex + leftCount] = node.getData();
            int rightCount = fillInOrder(arr, node.getRightNode(), firstIndex + leftCount + 1);
            return leftCount + 1 + rightCount;
        } else {
            return 0;
        }
    }

    public NodoTree<T> search(T data) {
        return searchNode(root, data);
    }

    private NodoTree<T> searchNode(NodoTree<T> node, T data) {
        if (node == null) {
            return null;
        } else {
            if (node.getData() == data)
                return node;
            final NodoTree<T> inLeft = searchNode(node.getLeftNode(), data);
            if (inLeft != null)
                return inLeft;
            return searchNode(node.getRightNode(), data);
        }
    }

    public void remove(T data) {
        final NodoTree<T> node = search(data);
        if (node != null) {
            final boolean hasLeft = node.getLeftNode() != null;
            final boolean hasRight = node.getRightNode() != null;
            final NodoTree<T> parent = findParent(node);
            if (hasLeft && hasRight) {
                removeTwoChildNode(node, parent);
            } else {
                removeEmptyOrSingleChildNode(node, parent);
            }
        }
    }

    private NodoTree<T> findParent(NodoTree<T> search) {
        return findParent(root, search);
    }

    private NodoTree<T> findParent(NodoTree<T> node, NodoTree<T> search) {
        if (node != null) {
            if (node.getLeftNode() == search)
                return node;
            if (node.getRightNode() == search)
                return node;
            final NodoTree<T> inLeft = findParent(node.getLeftNode(), search);
            if (inLeft != null)
                return inLeft;
            return findParent(node.getRightNode(), search);
        } else {
            return null;
        }
    }

    private void removeTwoChildNode(NodoTree<T> node, NodoTree<T> parent) {
        final NodoTree<T> leftmostValue = findLeftmostChild(node.getRightNode());
        removeEmptyOrSingleChildNode(leftmostValue, findParent(leftmostValue));
        node.setData(leftmostValue.getData());
    }

    private NodoTree<T> findLeftmostChild(NodoTree<T> node) {
        if (node.getLeftNode() != null) {
            return findLeftmostChild(node.getLeftNode());
        } else {
            return node;
        }
    }

    private void removeEmptyOrSingleChildNode(NodoTree<T> node, NodoTree<T> parent) {
        final NodoTree<T> child = (node.getLeftNode() != null)
                ? node.getLeftNode()
                : node.getRightNode();
        if (parent != null) {
            if (node == parent.getLeftNode()) {
                parent.setLeftNode(child);
            } else {
                parent.setRightNode(child);
            }
        } else {
            root = child;
        }
    }

    private int countNodes(NodoTree<T> node) {
        if (node != null) {
            return 1 + countNodes(node.getLeftNode()) + countNodes(node.getRightNode());
        } else {
            return 0;
        }
    }

    public void preOrden() {
        preOrdenRec(root);
    }

    private void preOrdenRec(NodoTree<T> raiz) {
        if (raiz != null) {
            System.out.println(raiz.getData().toString());
            preOrdenRec(raiz.getLeftNode());
            preOrdenRec(raiz.getRightNode());
        }
    }

    public void inOrden() {
        inOrdenRec(root);
    }

    private void inOrdenRec(NodoTree<T> raiz) {
        if (raiz != null) {
            inOrdenRec(raiz.getRightNode());
            System.out.println(raiz.getData().toString());
            inOrdenRec(raiz.getLeftNode());
        }
    }

    public void postOrden() {
        postOrdenRec(root);
    }

    private void postOrdenRec(NodoTree<T> raiz) {
        if (raiz != null) {
            postOrdenRec(raiz.getLeftNode());
            postOrdenRec(raiz.getRightNode());
            System.out.println(raiz.getData().toString());
        }
    }
}
