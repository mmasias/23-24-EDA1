package listasbasicas;

public class List {
    private Node first = null;

    public int size() {
        int count = 0;
        Node temp = first;
        while (temp != null) {
            count++;
            temp = temp.getNext();
        }
        return count;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insert(String value) {
        Node newNode = new Node(value);
        if (first == null) {
            first = newNode;
        } else {
            Node temp = first;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(newNode);
        }
        System.out.println(" > Entró " + value);
    }

    public void delete() {
        if (first != null) {
            if (first.getNext() == null) {
                System.out.println(" > Salió " + first.getValue());
                first = null;
            } else {
                Node temp = first;
                while (temp.getNext().getNext() != null) {
                    temp = temp.getNext();
                }
                System.out.println(" > Salió " + temp.getNext().getValue());
                temp.setNext(null);
            }
        }
    }

    public String[] listAll() {
        String[] list = new String[size()];
        Node temp = first;
        int index = 0;
        while (temp != null) {
            list[index++] = temp.getValue();
            temp = temp.getNext();
        }
        return list;
    }

    public void insertFirst(String value) {
        Node newNode = new Node(value);
        newNode.setNext(first);
        first = newNode;
        System.out.println(" > Entró " + value);
    }

    public void deleteFirst() {
        if (first != null) {
            System.out.println(" > Salió " + first.getValue());
            first = first.getNext();
        }
    }

    public void insertAt(int index, String value) {
        if (index == 0) {
            insertFirst(value);
        } else {
            Node current = first;
            for (int i = 0; current != null && i < index - 1; i++) {
                current = current.getNext();
            }
            if (current != null) {
                Node newNode = new Node(value);
                newNode.setNext(current.getNext());
                current.setNext(newNode);
                System.out.println(" > Entró " + value + " en la posición " + index);
            }
        }
    }

    public void insertLast(String value) {
        Node newNode = new Node(value);
        if (first == null) {
            first = newNode;
        } else {
            Node temp = first;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(newNode);
        }
        System.out.println(" > Entró " + value);
    }

    public void deleteLast() {
        if (first != null) {
            if (first.getNext() == null) {
                System.out.println(" > Salió " + first.getValue());
                first = null;
            } else {
                Node temp = first;
                while (temp.getNext().getNext() != null) {
                    temp = temp.getNext();
                }
                System.out.println(" > Salió " + temp.getNext().getValue());
                temp.setNext(null);
            }
        }
    }
}
