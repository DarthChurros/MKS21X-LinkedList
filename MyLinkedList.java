

public class MyLinkedList {
  private int size;
  private Node start, end;

  public MyLinkedList(int first) {
    start = new Node(first);
    size = 0;
    end = start;
  }

  public int size() {
    return size;
  }

  public boolean add(int value) {
    end.setNext(new Node(end));
    end = end.next();
    end.set(value);
    size++;
    return true;
  }

  public String toString() {
    String ans = "[";
    Node current = start;
    while (current.hasNext()) {
      //System.out.println("node " + current.value() +" is followed by "+current.next().value());
      ans += current.value() + ", ";
      current = current.next();
    }
    return ans + current.value() + "]";
  }

  public static void main(String[] args) {
    MyLinkedList test = new MyLinkedList(1);

    System.out.println("test = " + test);

    test.add(2);
    test.add(-5);
    test.add(4);

    System.out.println("Adding 2, -5, 4...");
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
