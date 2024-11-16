// Class representing a Min-Heap based Priority Queue implementation
public class PriorityQueue {
  public static void main(String[] args) {
    // Create a PriorityQueues object with a capacity of 10
    PriorityQueue pq = new PriorityQueue(10);

    // Insert elements into the priority queue
    pq.insert(3);
    pq.insert(1);
    pq.insert(2);

    // Remove and print the minimum element
    System.out.println(pq.remove()); // Expected output: 1 (smallest element)
  }

  private int[] heap; // Array to store heap elements
  private int size; // Current size of the heap
  private int capacity; // Maximum capacity of the heap

  // Constructor to initialize the priority queue with a given capacity
  public PriorityQueue(int capacity) {
    this.capacity = capacity;
    this.size = 0;
    this.heap = new int[capacity + 1]; // Index 0 is unused for ease of calculation
  }

  // Helper methods to get the indices of the parent and children of a given node
  private int parent(int i) {
    return i / 2;
  }

  private int leftChild(int i) {
    return 2 * i;
  }

  private int rightChild(int i) {
    return 2 * i + 1;
  }

  // Method to insert a new element into the priority queue
  public void insert(int data) {
    if (size >= capacity) {
      throw new IllegalStateException("Heap is full");
    }
    size++;
    heap[size] = data; // Insert the new element at the end
    int current = size;

    // Move up the element to maintain the min-heap property
    while (current > 1 && heap[current] < heap[parent(current)]) {
      swap(current, parent(current));
      current = parent(current);
    }
  }

  // Method to remove and return the minimum element from the priority queue
  public int remove() {
    if (size == 0) {
      throw new IllegalStateException("Heap is empty");
    }
    int min = heap[1]; // The root of the heap is the minimum element
    heap[1] = heap[size]; // Replace the root with the last element
    size--; // Decrease the size of the heap
    heapify(1); // Heapify the root to restore the min-heap property
    return min; // Return the removed minimum element
  }

  // Helper method to maintain the min-heap property
  private void heapify(int i) {
    int smallest = i;
    int left = leftChild(i);
    int right = rightChild(i);

    // Find the smallest among the current node, left child, and right child
    if (left <= size && heap[left] < heap[smallest]) {
      smallest = left;
    }
    if (right <= size && heap[right] < heap[smallest]) {
      smallest = right;
    }
    // Swap and continue heapifying if the current node is not the smallest
    if (smallest != i) {
      swap(i, smallest);
      heapify(smallest);
    }
  }

  // Helper method to swap two elements in the heap
  private void swap(int i, int j) {
    int temp = heap[i];
    heap[i] = heap[j];
    heap[j] = temp;
  }

  // Method to check if the priority queue is empty
  public boolean isEmpty() {
    return size == 0;
  }

  // Method to peek at the minimum element without removing it
  public int peekMin() {
    if (size == 0) {
      throw new IllegalStateException("Heap is empty");
    }
    return heap[1];
  }
}