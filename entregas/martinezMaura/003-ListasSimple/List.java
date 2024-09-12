package lisbasica;

public class List {

    private Node first = null;
    private int size = 0; 

    public int size() {
       return size;
    }

    public boolean isEmpty() {
       return size == 0;
    }

    public void insert(String value) {
        
        Node nodoQueEntra = new Node(value);
        if (this.first == null){
            this.first = nodoQueEntra;
            System.out.println("Entró" + value);
        } else {
            Node iterator = this.first;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(nodoQueEntra);
            System.out.println("Entró " + value);
        }
        size++;
    }

    public void delete() {
        if (this.first != null) {
            if (size == 1) {
                String deletedVaulue = first.getValue();
                first = null;
                System.out.println("Salió " + deletedVaulue);
            } else {
                Node iterator = this.first;
                while (iterator.getNext().getNext() != null) {
                    iterator = iterator.getNext();
                }
                String deletedValue = iterator.getNext() .getValue();
                iterator.setNext(null);
                System.out.println("Salió " +deletedValue);
            }
            size--; 
        }
    }

    public String[] listAll() {
        String[] list = new String[size];
        Node iterator = this.first;
        int count = 0;
        while (iterator != null) {
            list[count] = iterator.getValue();
            count++;
            iterator = iterator.getNext();
        }
        return list;
    }

   
}
