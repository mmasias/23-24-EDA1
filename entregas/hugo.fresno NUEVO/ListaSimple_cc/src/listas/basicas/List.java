package listas.basicas;

public class List {

    private Node first = null;
    int tamaño=0;

    /*public int size() {
        Node nodeIni = first;
        int count =0;
        if (nodeIni != null) {
            count++;
            while(nodeIni.getNext()!=null){
                count++;
                nodeIni= nodeIni.getNext();
            }
        }
            return count;

    }*/
        //TODO METODO OPTIMIZADO
    public int size(){
        return tamaño;
    }

    public boolean isEmpty() {
        return this.size() > 0 ? false : true;
    }

    public void insertEnd(String value) {
        Node newNode = new Node(value);
        System.out.println("  > Llegó "+value);
        if (this.first == null){
            this.first = newNode;
            tamaño++;
        }
        else {
            Node iterator = this.first;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            tamaño++;
            iterator.setNext(newNode);

        }
    }

    public void insertFront(String value) {
        Node n = new Node(value);
        if (this.first == null) {
            this.first = n;
            tamaño++;

        }else {
            n.setNext(this.first);
            this.first = n;
            tamaño++;

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
            System.out.println("Se fue "+iterator.getValue());
            previous.setNext(null);
            tamaño--;
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

