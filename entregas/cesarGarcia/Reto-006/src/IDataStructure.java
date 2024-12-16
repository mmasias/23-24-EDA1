import javax.swing.tree.TreeNode;

public interface IDataStructure<T> {
    int size();
    TreeNode getFirst();
    boolean isEmpty();
    Object[] listData();
}