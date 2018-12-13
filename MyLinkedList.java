

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
    Integer old;
  }

  public boolean contains(Integer value) {
    Node current = start;
    while (current.hasNext()) {
      if (current.value() == value) {
        return true;
      }
    }
    return end.value() == value;
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
