

public class MyLinkedList {
  private int size;
  private Node start, end;

  public MyLinkedList() {
    size = 0;
  }

  public int size() {
    return size;
  }

  public boolean add(int value) {
    if (size == 0) {
      start = new Node(value);
      end = start;
      size++;
      return true;
    }
    end.setNext(new Node(end));
    end = end.next();
    end.set(value);
    size++;
    return true;
  }

  public Integer get(int index) {
    return getNode(index).value();
  }

  public Integer set(int index, Integer value) {
    Node current = getNode(index);
    Integer old = current.value();
    current.set(value);
    return old;
  }

  public boolean contains(Integer value) {
    return indexOf(value) >= 0;
  }

  public int indexOf(Integer value) {
    Node current = start;
    for (int i = 0; i < size; i++) {
      if (current.value() == value) {
        return i;
      }
      current = current.next();
    }
    return -1;
  }

  public void add(int index, Integer value) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException();
    }
    Node current;
    Node newNode = new Node(value);
    if (index == size) {
      add(value);
      end = newNode;
      if (index == 0) {
        start = newNode;
        end = start;
      }
    } else {
      current = getNode(index-1);
      current.next().setPrev(newNode);
      newNode.setNext(current.next());
      if (index != 0) {
        current.setNext(newNode);
        newNode.setPrev(current);
      }

    }
    size++;
  }

  public String toString() {
    String ans = "[";
    try {
      Node current = start;
      while (current.hasNext()) {
        //System.out.println("node " + current.value() +" is followed by "+current.next().value());
        ans += current.value() + ", ";
        current = current.next();
      }
      return ans + current.value() + "]";
    } catch (NullPointerException e) {
      return "[]";
    }
  }

  private Node getNode(int index) {
    Node current = start;
    while (index > 0) {
      current = current.next();
      index--;
    }
    return current;
  }

  public static void main(String[] args) {
    MyLinkedList test = new MyLinkedList();

    System.out.println("test = " + test);

    test.add(2);
    test.add(-5);
    test.add(4);

    System.out.println("Adding 2, -5, 4...");
    System.out.println("test = " + test);
    System.out.println("The second element is " + test.get(1));

    test.add(2, 3);
    System.out.println("Adding 3 in the third slot...");
    System.out.println("test = " + test);
  }

  private class Node {
    private int data;
    private Node next, prev;

    public Node(Node last) {
      prev = last;
    }

    public Node(int val) {
      data = val;
    }

    public Node next() {
      return next;
    }

    public void setNext(Node newNext) {
      next = newNext;
    }

    public void setPrev(Node newPrev) {
      prev = newPrev;
    }

    public boolean hasNext() {
      return next != null;
    }

    public int value() {
      return data;
    }

    public void set(int value) {
      data = value;
    }
  }
}
