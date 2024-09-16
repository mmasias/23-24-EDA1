public class List {

    private Node first = null;

    public int size() {
        if (this.first == null) {
            return 0;
        }
        int count = 1;
        Node iterator = first;
        while (iterator.getNext() != null) {
            count++;
            iterator = iterator.getNext();
        }
        return count;
    }

    public boolean isEmpty() {
        return this.size() > 0 ? false : true;
    }

    public void insertEnd(String value) {
        Node newNode = new Node(value);
        if (this.first == null)
        this.first = newNode;
        else {
            Node iterator = this.first;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(newNode);
        }
    }
    
    public void insertFront(String value) {
        Node n = new Node(value);
        if (this.first == null)
            this.first = n;
        else {
            n.setNext(this.first);
            this.first = n;
        }
    }

    public void delete() {
        if (this.first != null) {
            Node iterator = this.first;
            Node previous = null;
            while (iterator.getNext() != null) {
                previous = iterator;
                iterator = iterator.getNext();
            }
            previous.setNext(null);
        }
    }
    public void deleteFirst(){
        if (size()>0) {
            this.first = first.getNext();

        }
    }
    public void insertFirst(String value){
        Node nuevo = new Node(value);
        nuevo.setNext(first);
        first = nuevo;
    }
    public void insertFirst(Node nuevo){

        nuevo.setNext(first);
        first = nuevo;
    }

    public String[] listAll() {
        String[] list = new String[this.size()];
        Node iterator = this.first;
        if (iterator == null)
            return list;
        int count = 0;
        while (iterator != null) {
            list[count] = iterator.getValue();
            count++;
            iterator = iterator.getNext();
        }
        return list;
    }
    public Node deleteValue(String value) {
        Node iterator = first;
        Node anterior = first;
        while (iterator != null) {
            if (iterator.getValue() == value) {
                anterior.setNext(iterator.getNext());
                return iterator;
            } else {
                anterior = iterator;

            }
            iterator = iterator.getNext();
        }
        return null;
    }
        public void insertpos (Node n, int pos){
        if (pos == 0){
            insertFirst(n);
        }else if (pos > this.size()) {
            insertEnd(n.getValue());
        }else{
            int i = 1;
            Node iterator = first;
            while (iterator != null){
                if (i == pos){
                    n.setNext(iterator.getNext());
                    iterator.setNext(n);
                }
                iterator=iterator.getNext();
                i++;
            }
        }
    }

}
