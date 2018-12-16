

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
      if (index == 0) {
        start = newNode;
        end = start;
      } else {
      add(value);
      size--;
      }
    } else {
      current = getNode(index);
      if (index == 0) {
        start = newNode;
      } else {
        current.prev().setNext(newNode);
        newNode.setPrev(current.prev());
      }
      current.setPrev(newNode);
      newNode.setNext(current);
    }
    size++;
  }

  public Integer remove(int index) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException();
    }
    Node old;
    if (index == 0) {
      old = start;
      start = old.next();
      start.setPrev(null);
    } else if (index == size - 1) {
        old = end;
        end = old.prev();
        end.setNext(null);
    } else {
      old = getNode(index);
      old.next().setPrev(old.prev());
      old.prev().setNext(old.next());
    }
    size--;
    return old.value();
  }

  public String toString() {
    String ans = "[";
    try {
      Node current = start;
      while (current.hasNext()) {
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
    test.add(4,12);
    System.out.println("Adding 12 in the last slot...");
    System.out.println("test = " + test);
    test.add(0,0);
    System.out.println("Adding 0 in the first slot...");
    System.out.println("test = " + test);
    System.out.println("Removing the first element, "+test.remove(0)+"...\ntest = " + test);
    System.out.println("Removing the last element, "+test.remove(test.size()-1)+"...\ntest = " + test);
    System.out.println("Removing the third element, "+test.remove(2)+"...\ntest = " + test);
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

    public Node prev() {
      return prev;
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
