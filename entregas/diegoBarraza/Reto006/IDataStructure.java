public interface IDataStructure<T> {

        int size();
        NodoTree<T> getFirst();
        boolean isEmpty();
        Object[] listData();
    }

