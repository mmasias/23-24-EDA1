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
        return this.size() == 0;
    }
    

    public void insert(int position, String value) {
        Node newNode = new Node(value);
        
        if (position <= 0) {
            System.out.println("La posición debe ser un número positivo o mayor que cero.");
            return;
        }
        
        if (position == 1 || this.first == null) {
            // Insertar en el inicio o si la lista está vacía
            newNode.setNext(this.first);
            this.first = newNode;
        } else {
            Node iterator = this.first;
            Node previous = null;
            int currentPosition = 1;
            
            while (iterator.getNext() != null && currentPosition < position) {
                previous = iterator;
                iterator = iterator.getNext();
                currentPosition++;
            }
            
            if (currentPosition == position) {
                // Insertar en la posición especificada
                previous.setNext(newNode);
                newNode.setNext(iterator);
            } else if (currentPosition == position - 1) {
                // Insertar al final de la lista
                iterator.setNext(newNode);
            } else {
                System.out.println("La posición especificada no existe en la lista.");
            }
        }
    }
    

    public void delete(int position) {
        if (this.first == null) {
            System.out.println("La lista está vacía.");
            return;
        }
        
        if (position == 1) {
            // Eliminar desde el inicio
            this.first = this.first.getNext();
        } else {
            Node iterator = this.first;
            Node previous = null;
            int currentPosition = 1;
            
            while (iterator.getNext() != null && currentPosition < position) {
                previous = iterator;
                iterator = iterator.getNext();
                currentPosition++;
            }
            
            if (currentPosition == position) {
                // Eliminar el nodo en la posición especificada
                previous.setNext(iterator.getNext());
            } else {
                System.out.println("La posición especificada no existe en la lista.");
            }
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