public interface IDataEstructure<T> {
    int size();

    TreeNode<T> getFirst();

    boolean isEmpty();

    Object[] listData();

}