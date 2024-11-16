public class SinglyLinkedList {
  // Represent a node of the singly linked list
  class Node {
    int data;
    Node next;

    public Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  // Represent the head and tail of the singly linked list
  public Node head = null;
  public Node tail = null;

  // insert() will add a new node to the list
  public void insert(int data) {
    // Create a new node
    Node newNode = new Node(data);

    // Checks if the list is empty
    if (head == null) {
      // If list is empty, both head and tail will point to new node
      head = newNode;
      tail = newNode;
    } else {
      // newNode will be added after tail such that tail's next will point to newNode
      tail.next = newNode;
      // newNode will become new tail of the list
      tail = newNode;
    }
  }

  // delete() will delete a node with the given value from the list
  public void delete(int data) {
    // Store head node
    Node current = head;
    Node prev = null;

    // If head node itself holds the data to be deleted
    if (current != null && current.data == data) {
      head = current.next; // Change head

      // If this was the only node in the list, update tail
      if (head == null) {
        tail = null;
      }
      return;
    }

    // Search for the node to be deleted, keep track of previous node
    while (current != null && current.data != data) {
      prev = current;
      current = current.next;
    }

    // If data wasn't present in linked list
    if (current == null) {
      return;
    }

    // If this is the last node, update tail
    if (current.next == null) {
      tail = prev;
    }

    // Unlink the node from linked list
    prev.next = current.next;
  }

  // traverse() will display all the nodes present in the list
  public void traverse() {
    // Node current will point to head
    Node current = head;

    if (head == null) {
      System.out.println("List is empty");
      return;
    }
    while (current != null) {
      // Prints each node by incrementing pointer
      System.out.print(current.data + " ");
      current = current.next;
    }
    System.out.println();
  }

  public static void main(String[] args) {
    SinglyLinkedList sList = new SinglyLinkedList();

    // Add nodes to the list
    sList.insert(1);
    sList.insert(2);
    // Delete node with value 2
    sList.delete(1);
    // traverse
    sList.traverse();
  }
}