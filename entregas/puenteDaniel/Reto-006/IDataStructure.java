public interface IDataStructure<T> {
    int size();
    TreeNode<T> getFirst();
    boolean isEmpty();
    Object[] listData();
}