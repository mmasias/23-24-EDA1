public class List {

  private Node first = null;
  private int size = 0;

  public int size() {
    return this.size;
  }

  public boolean isEmpty() {
    return this.size() > 0 ? false : true;
  }

  public void insert(String value) {
    Node lastNode = new Node(value);
    System.out.println(" > El último el llegar es " + lastNode.getValue());
    if (this.first == null) {
      this.first = lastNode;
    } else {
      Node iterator = this.first;
      while (iterator.getNext() != null) {
        iterator = iterator.getNext();
      }
      iterator.setNext(lastNode);
    }
    this.size++;
  }

  public void insertStart(String value) {
    Node newFirst = new Node(value);
    System.out.println(" > El primero en la lista es " + newFirst.getValue());
    if (this.first == null) {
      this.first = newFirst;
    } else {
      newFirst.setNext(this.first);
      this.first = newFirst;
    }
    this.size++;
  }

  public void insertByIndex(String value, int index) {
    if (index == 0) {
      this.insertStart(value);
    } else if (index == this.size()) {
      this.insert(value);
    } else {
      Node newIndexedNode = new Node(value);
      Node iterator = this.first;
      int count = 0;
      while (count < index - 1) {
        iterator = iterator.getNext();
        System.out.println(iterator.getValue());
        count++;
      }
      Node nextNode = iterator.getNext();
      iterator.setNext(newIndexedNode);
      newIndexedNode.setNext(nextNode);
      this.size++;
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
      if (previous != null) {
        System.out.println(" > Se fue " + iterator.getValue());
        previous.setNext(null);
      } else {
        this.first = null;
      }
      this.size--;
    }
  }

  public void deleteStart() {
    if (this.first != null) {
      System.out.println(" > Se fue " + this.first.getValue());
      Node nextNode = this.first.getNext();
      this.first = null;
      this.first = nextNode;
      this.size--;
    }
  }

  public void deleteByIndex(int index) {
    if (this.first != null) {
      if (index == 0) {
        deleteStart();
      } else if (index == this.size() - 1) {
        delete();
      } else {
        Node iterator = this.first;
        Node previous = null;
        int count = 0;
        while (count < index) {
          previous = iterator;
          iterator = iterator.getNext();
          count++;
        }
        System.out.println(" > Se fue " + iterator.getValue());
        Node nextNode = iterator.getNext();
        previous.setNext(null);
        previous.setNext(nextNode);
        this.size--;
      }
    }
  }

  public String[] listAll() {
    String[] list = new String[this.size()];
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