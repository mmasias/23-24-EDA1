package Reto004;

import Reto003.Node;

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

    public void insertEnd(String value) {
        Node newNode = new Node(value);
        if (this.first == null)
            this.first = newNode;
        else {
            Node iterator = this.first;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(newNode);
        }
        System.out.println("> Llegó al final " + value);
    }

    public void insertFront(String value) {
        Node n = new Node(value);
        if (this.first == null)
            this.first = n;
        else {
            n.setNext(this.first);
            this.first = n;
        }
        System.out.println("> Llegó al inicio " + value);
    }



    public String deleteEnd() {
        if (this.first != null) {
            if (this.first.getNext() == null) {
                this.first = null;
            } else {
                Node iterator = this.first;
                while (iterator.getNext().getNext() != null) {
                    iterator = iterator.getNext();
                }
                iterator.setNext(null);
            }
            System.out.println("< Se fue el último");

        }

        return null;
    }

    public String deleteFront() {
        if (this.first != null) {
            this.first = this.first.getNext();
        }
        System.out.println("< Se fue el primero");
        return null;
    }

    public void insertTo(String value, int index) {
        Node newNode = new Node(value);
        if (this.first == null)
            this.first = newNode;
        else {
            Node iterator = this.first;
            int count = 0;
            while (iterator.getNext() != null && count < index - 1) {
                iterator = iterator.getNext();
                count++;
            }
            newNode.setNext(iterator.getNext());
            iterator.setNext(newNode);
        }
        System.out.println("> Llegó a la posición " + index + " " + value);
    }

    public String deleteTo(int index) {
        if (this.first != null) {
            if (index == 0) {
                this.first = this.first.getNext();
            } else {
                Node iterator = this.first;
                int count = 0;
                while (iterator.getNext() != null && count < index - 1) {
                    iterator = iterator.getNext();
                    count++;
                }
                if (iterator.getNext() != null) {
                    iterator.setNext(iterator.getNext().getNext());
                }
            }
        }
        System.out.println("< Se fue el de la posición " + index);
        return null;
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
