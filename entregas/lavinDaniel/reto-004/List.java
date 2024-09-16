class List {
    Node head;
    Node tail;
    void insertAtStart(String data) {
        Node newNode = new Node(data, "> Llegó " + data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Agregar elemento al final
    void insertAtEnd(String data) {
        Node newNode = new Node(data, "> Llegó " + data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Agregar elemento en la posición i-ésima (basada en índice 0)
    void insertAtIndex(int index, String data) {
        if (index < 0) {
            throw new IllegalArgumentException("Índice fuera de rango");
        }
        if (index == 0) {
            insertAtStart(data);
        } else {
            Node newNode = new Node(data, "> Llegó " + data);
            Node current = head;
            int i = 0;
            while (i < index - 1 && current != null) {
                current = current.next;
                i++;
            }
            if (current == null) {
                throw new IllegalArgumentException("Índice fuera de rango");
            }
            newNode.next = current.next;
            newNode.prev = current;
            current.next = newNode;
            if (newNode.next != null) {
                newNode.next.prev = newNode;
            }
        }
    }

    // Eliminar elemento desde el inicio
    void deleteAtStart() {
        if (head != null) {
            String data = head.data;
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
            System.out.println("Se fue " + data);
        }
    }


    void deleteAtEnd() {
        if (tail != null) {
            String data = tail.data;
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            } else {
                head = null;
            }
            System.out.println("Se fue " + data);
        }
    }


    void deleteAtIndex(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Índice fuera de rango");
        }
        if (index == 0) {
            deleteAtStart();
        } else {
            Node current = head;
            int i = 0;
            while (i < index && current != null) {
                current = current.next;
                i++;
            }
            if (current == null) {
                throw new IllegalArgumentException("Índice fuera de rango");
            }
            Node prevNode = current.prev;
            Node nextNode = current.next;
            if (prevNode != null) {
                prevNode.next = nextNode;
            } else {
                head = nextNode;
            }
            if (nextNode != null) {
                nextNode.prev = prevNode;
            } else {
                tail = prevNode;
            }
            System.out.println("Se fue " + current.data);
        }
    }
}

