package Reto006.src;

public class NodoTree<T> {
    private T data;
    private NodoTree<T> leftNode;
    private NodoTree<T> rightNode;

    public NodoTree(T data) {
        setData(data);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public NodoTree<T> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(NodoTree<T> leftNode) {
        this.leftNode = leftNode;
    }

    public NodoTree<T> getRightNode() {
        return rightNode;
    }

    public void setRightNode(NodoTree<T> rightNode) {
        this.rightNode = rightNode;
    }
}