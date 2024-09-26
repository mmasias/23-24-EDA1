class List {
    Node head;
    Node tail;

    void insert(String data) {
        Node newNode = new Node(data, "> Llegó " + data); // Registra la entrada
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    void delete() {
        if (tail != null) {
            String data = tail.data;
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            } else {
                head = null;
            }
            System.out.println("Se fue " + data); // Registra la salida
        }
    }

    int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    boolean isEmpty() {
        return head == null;
    }

    String[] listAll() {
        String[] result = new String[size()];
        Node current = head;
        int i = 0;
        while (current != null) {
            result[i] = current.data;
            i++;
            current = current.next;
        }
        return result;
    }
}

