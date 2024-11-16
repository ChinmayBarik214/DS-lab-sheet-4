public class DoublyLinkedList {

  // Represent a node of the doubly linked list
  class Node {
    int data;
    Node previous;
    Node next;

    public Node(int data) {
      this.data = data;
    }
  }

  // Represent the head and tail of the doubly linked list
  Node head, tail = null;

  // insert() will add a node to the list
  public void insert(int data) {
    // Create a new node
    Node newNode = new Node(data);

    // If list is empty
    if (head == null) {
      // Both head and tail will point to newNode
      head = tail = newNode;
      // head's previous will point to null
      head.previous = null;
      // tail's next will point to null, as it is the last node of the list
      tail.next = null;
    } else {
      // newNode will be added after tail such that tail's next will point to newNode
      tail.next = newNode;
      // newNode's previous will point to tail
      newNode.previous = tail;
      // newNode will become new tail
      tail = newNode;
      // As it is last node, tail's next will point to null
      tail.next = null;
    }
  }

  // delete() will delete a node with the given value from the list
  public void delete(int data) {
    // If list is empty
    if (head == null) {
      System.out.println("List is empty");
      return;
    }

    // Start from the first node
    Node current = head;

    // Traverse the list to find the node to delete
    while (current != null && current.data != data) {
      current = current.next;
    }

    // If node was not found
    if (current == null) {
      System.out.println("Node with value " + data + " not found");
      return;
    }

    // If node to be deleted is the head node
    if (current == head) {
      head = current.next;
      if (head != null) {
        head.previous = null;
      } else {
        // If the list had only one node, update tail also
        tail = null;
      }
      return;
    }

    // If node to be deleted is the tail node
    if (current == tail) {
      tail = current.previous;
      tail.next = null;
      return;
    }

    // If node to be deleted is in the middle
    current.previous.next = current.next;
    current.next.previous = current.previous;
  }

  // traverse() will print out the nodes of the list
  public void traverse() {
    // Node current will point to head
    Node current = head;
    if (head == null) {
      System.out.println("List is empty");
      return;
    }
    while (current != null) {
      // Prints each node by incrementing the pointer.
      System.out.print(current.data + " ");
      current = current.next;
    }
  }

  public static void main(String[] args) {
    DoublyLinkedList dList = new DoublyLinkedList();
    // Add nodes to the list
    dList.insert(1);
    dList.insert(2);

    // Delete node with value 2
    dList.delete(2);

    // traverse
    dList.traverse();
  }
}