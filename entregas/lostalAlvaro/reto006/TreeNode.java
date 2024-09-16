public class TreeNode<T> {
    private T data;
    private int contador = 1;
    private TreeNode<T> leftNode;
    private TreeNode<T> rightNode;

    public TreeNode(T data) {
        setData(data);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public TreeNode<T> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode<T> leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode<T> getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode<T> rightNode) {
        this.rightNode = rightNode;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

}