package Reto003;

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

    public String insert(String value) {
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
        System.out.println("> Llegó " + value);
        return value;
    }

    public String delete(String value) {
        if (this.first != null) {
            if (this.first.getValue().equals(value)) {
                this.first = this.first.getNext();
            }else {
                Node iterator = this.first;
                while (iterator.getNext() !=null && !iterator.getNext().getValue().equals(value)) {
                    iterator = iterator.getNext();
                }
                if (iterator.getNext() != null) {
                    iterator.setNext(iterator.getNext().getNext());
                }
            }
        }
        System.out.println("< Se fue " + value);
        return value;
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
