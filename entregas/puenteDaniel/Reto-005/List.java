public class List {
    private Node first;
    
    public int size(){
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

    public void add(String value) {
        Node newNode = new Node(value);
        if (this.first == null) {
            this.first = newNode;
        } else {
           newNode.setNext(this.first);
              this.first = newNode;
        }
        System.out.println("Llegó " + value);
    }

    public void remove(){
        if (this.first != null) {
            System.out.println("Se fue " + this.first.getValue());
            this.first = this.first.getNext();
        }
    }

    public boolean isEmpty(){
        return this.size() > 0 ? false : true;
    }

    public String [] listAll(){
        String [] larray = new String[this.size()];
        Node iterator = this.first;
        int i = 0;
        while (iterator != null) {
            larray[i] = iterator.getValue();
            iterator = iterator.getNext();
            i++;
        }
        return larray;
    }
}
