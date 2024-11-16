public class CircularLinkedList {
  static class Node {
      int data;
      Node next;

      Node(int data) {
          this.data = data;
          this.next = null;
      }
  }

  private Node tail;

  public void insert(int data) {
      Node newNode = new Node(data);
      if (tail == null) {
          tail = newNode;
          tail.next = newNode;
          return;
      }
      newNode.next = tail.next;
      tail.next = newNode;
      tail = newNode;
  }

  public void delete(int data) {
      if (tail == null) {
          System.out.println("List is empty!");
          return;
      }
      Node current = tail.next;
      Node prev = tail;

      do {
          if (current.data == data) {
              if (current == tail) {
                  if (tail.next == tail) {
                      tail = null;
                  } else {
                      tail = prev;
                      tail.next = current.next;
                  }
              } else {
                  prev.next = current.next;
              }
              return;
          }
          prev = current;
          current = current.next;
      } while (current != tail.next);

      System.out.println("Value not found!");
  }

  public void traverse() {
      if (tail == null) {
          System.out.println("List is empty!");
          return;
      }
      Node current = tail.next;
      do {
          System.out.print(current.data + " -> ");
          current = current.next;
      } while (current != tail.next);
  }

  public static void main(String[] args) {
      CircularLinkedList list = new CircularLinkedList();
      list.insert(1);
      list.insert(2);
      list.traverse();
      System.out.print(1);
  }
}