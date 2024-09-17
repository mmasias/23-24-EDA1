public class List {

    private Node first = null;

    public int size() {
        if (this.first == null) {
            return 0;
        } else {
            int count = 1;
            Node iterator = first;
            while (iterator.getNext() != null) {
                count++;
                iterator = iterator.getNext();
            }
            return count;
        }
    }

    public boolean isEmpty() {
        return this.size() > 0 ? false : true;
    }

    public void insertStart(String value) {
        Node nodoQueEntra = new Node(value);
        if (this.first == null)
            this.first = nodoQueEntra;
        else {
            nodoQueEntra.setNext(this.first);
            this.first = nodoQueEntra;
        }
        System.out.println(" > Llegó " +value);
    }

    public void insertEnd(String value) {
        Node nodoQueEntra = new Node(value);
        if (this.first == null)
            this.first = nodoQueEntra;
        else {
            Node iterator = this.first;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(nodoQueEntra);
        }
        System.out.println(" > Llegó " +value);
    }

    public void deleteStart() {
        if (this.first != null) {
            Node iterator = this.first;
            this.first = iterator.getNext();
            System.out.println(" Se fue " +iterator.getValue());
        }
    }

    public void deleteEnd() {
        Node iterator = this.first;
        Node previous = null;
        while (iterator.getNext() != null && iterator != null) {
            previous = iterator;
            iterator = iterator.getNext();
        }
        if (previous != null) {
            previous.setNext(null);
            System.out.println(" Se fue " +iterator.getValue());
        } else if (iterator != null){
            System.out.println(" Se fue " +iterator.getValue());
            this.first = null;
        }     
    }

    public void inserIndex(String value,int index) {
        if (index <0 || index > this.size()) {
            System.out.println("No se puede insertar en esa posición");
            return;
        }
        if (index == 0) {
            insertStart(value);
        }else if (index == this.size()) {
            insertEnd(value);
        }else {
            Node newNode = new Node(value);
            Node iterator = this.first;
            for (int i = 0; i < index - 1; i++) {
                iterator = iterator.getNext();
            }
            newNode.setNext(iterator.getNext());
            iterator.setNext(newNode);
            System.out.println(" > Llegó " +value);
        }
    }

    public void deleteIndex(int index) {
        if (index <0 || index > this.size()) {
            System.out.println("No se puede eliminar en esa posición");
            return;
        }
        if (index == 0) {
            deleteStart();
        }else if (index == this.size()) {
            deleteEnd();
        }else {
            Node iterator = this.first;
            for (int i = 0; i < index - 1; i++) {
                iterator = iterator.getNext();
            }
            System.out.println(" Se fue " +iterator.getNext().getValue());
            iterator.setNext(iterator.getNext().getNext());
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