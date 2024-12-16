public class TreeNode<T extends TreeData> implements Comparable<TreeNode<T>> {
    private T value;
    private GenericList<TreeNode<T>> nodeChildren;

    public TreeNode() {
    }

    public TreeNode(T value, GenericList<TreeNode<T>> nodeChildren) {
        this.value = value;
        this.nodeChildren = new GenericList<TreeNode<T>>();
    }

    @Override
    public int compareTo(TreeNode<T> o) {
        return 0;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public GenericList<TreeNode<T>> getNodeChildren() {
        return nodeChildren;
    }

    public void setNodeChildren(GenericList<TreeNode<T>> nodeChildren) {
        this.nodeChildren = nodeChildren;
    }

    public void insertChildren(TreeNode<T> nodeChild) {
        nodeChildren.insertInOrder(nodeChild);
    }

    public TreeNode(T value) {
        this.value = value;
        this.nodeChildren = new GenericList<TreeNode<T>>();
    }

}
