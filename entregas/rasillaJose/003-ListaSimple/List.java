public class List {

    private Node first = null;

    public int size(){
        int count = 0;
        if (this.first == null) {
            return 0;
        }
        Node iterator = this.first;
        while(iterator.getisLast()){
            iterator = iterator.getNext();
            count++;
        }
        return count;
    }

    public boolean isEmpty() {
        return this.size() > 0 ? false : true;
    }

    public void insert(String value) {
        Node nodoQueEntra = new Node(value);
        System.out.println("*entró " + nodoQueEntra.getValue() + " *");
        if (this.first == null)
            this.first = nodoQueEntra;
        else {
            Node iterator = this.first;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(nodoQueEntra);
        }
    }

    public void delete() {
        if (this.first != null) {
            Node iterator = this.first;
            System.out.println("*salió " + iterator.getValue() + " *");
            Node previous = null;
            while (iterator.getNext() != null) {
                previous = iterator;
                iterator = iterator.getNext();
            }
            previous.setNext(null);
        }
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
}
