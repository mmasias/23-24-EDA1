public class BinaryTree<T extends Comparable<T>> implements IDataEstructure<T> {
    private TreeNode<T> root;

    public BinaryTree() {
        this.root = null;
    }

    public TreeNode<T> getRoot() {
        return root;
    }

    public void insert(T data) {
        if (root == null) {
            root = new TreeNode<>(data);
        } else {
            insert(data, root);
        }
    }

    public void insert(T data, TreeNode<T> node) {
        if (node != null) {
            final int comparison = data.compareTo(node.getData());
            if (comparison < 0) {
                if (node.getLeftNode() == null) {
                    node.setLeftNode(new TreeNode<>(data));
                } else {
                    insert(data, node.getLeftNode());
                }
            } else if (comparison > 0) {
                if (node.getRightNode() == null) {
                    node.setRightNode(new TreeNode<>(data));
                } else {
                    insert(data, node.getRightNode());
                }
            } else {
                node.setContador(node.getContador() + 1);
            }
        }
    }

    public TreeNode<T> search(T data) {
        return searchNode(root, data);
    }

    private TreeNode<T> searchNode(TreeNode<T> node, T data) {
        if (node == null) {
            return null;
        } else {
            if (node.getData() == data)
                return node;
            final TreeNode<T> inLeft = searchNode(node.getLeftNode(), data);
            if (inLeft != null) {
                return inLeft;
            }
            return searchNode(node.getRightNode(), data);

        }
    }

    public void remove(T data) {
        final TreeNode<T> node = search(data);
        if (root != null) {
            final boolean hasLeft = root.getLeftNode() != null;
            final boolean hasRight = root.getRightNode() != null;
            final TreeNode<T> parent = findParent(node);
            if (hasLeft && hasRight) {
                removeTwochildNode(node, parent);
            } else {
                removeEmptyOrSingleChildNode(node, parent);
            }
        }
    }

    private TreeNode<T> findParent(TreeNode<T> search) {
        return findParent(root, search);
    }

    private TreeNode<T> findParent(TreeNode<T> node, TreeNode<T> search) {
        if (node != null) {
            if (node.getLeftNode() == search) {
                return node;
            }
            if (node.getRightNode() == search) {
                return node;
            }
            final TreeNode<T> inLeft = findParent(node.getLeftNode(), search);
            if (inLeft != null) {
                return inLeft;
            }
            return findParent(node.getRightNode(), search);

        } else {
            return null;
        }
    }

    private void removeTwochildNode(TreeNode<T> node, TreeNode<T> parent) {
        final TreeNode<T> leftmostValue = findLeftmostValue(node.getRightNode());
        removeEmptyOrSingleChildNode(leftmostValue, findParent(leftmostValue));
        node.setData(leftmostValue.getData());
    }

    private TreeNode<T> findLeftmostValue(TreeNode<T> node) {
        if (node.getLeftNode() != null) {
            return findLeftmostValue(node.getLeftNode());
        } else {
            return node;
        }
    }

    private void removeEmptyOrSingleChildNode(TreeNode<T> node, TreeNode<T> parent) {
        final TreeNode<T> child = (node.getLeftNode() != null)
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

    private int countNodes(TreeNode<T> node) {
        if (node != null) {
            return 1 + countNodes(node.getLeftNode()) + countNodes(node.getRightNode());
        } else {
            return 0;
        }
    }

    @Override
    public int size() {
        return countNodes(root);
    }

    @Override
    public TreeNode<T> getFirst() {
        throw new UnsupportedOperationException("Unimplemented method 'getFirst");
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

    private int fillInOrder(Object[] arr, TreeNode<T> node, int firstIndex) {
        if (node != null) {
            int leftCount = fillInOrder(arr, node.getLeftNode(), firstIndex);
            arr[firstIndex + leftCount] = node.getData();
            int rightCount = fillInOrder(arr, node.getRightNode(), firstIndex + leftCount + 1);
            return leftCount + 1 + rightCount;
        } else {
            return 0;
        }
    }

    public void preorden() {
        preordenRec(root);
    }

    private void preordenRec(TreeNode<T> raiz) {
        if (raiz != null) {
            System.out.println(raiz.getData().toString() + " ");
            preordenRec(raiz.getLeftNode());
            preordenRec(raiz.getRightNode());
        }
    }

    public void inorden() {
        inordenRec(root);
    }

    private void inordenRec(TreeNode<T> raiz) {
        if (raiz != null) {
            inordenRec(raiz.getLeftNode());
            String contador = raiz.getContador() > 0 ? "x" + raiz.getContador() : " ";
            System.out.println(raiz.getData().toString() + " " + contador);
            inordenRec(raiz.getRightNode());
        }
    }

    public void postorden() {
        postordenRec(root);
    }

    private void postordenRec(TreeNode<T> raiz) {
        if (raiz != null) {
            postordenRec(raiz.getLeftNode());
            postordenRec(raiz.getRightNode());
            System.out.println(raiz.getData().toString() + " ");
        }
    }
}