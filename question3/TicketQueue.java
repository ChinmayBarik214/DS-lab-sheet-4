import java.util.LinkedList;
import java.util.Queue;

class TicketQueue {

  private Queue<String> queue;

  // Constructor to initialize the queue
  public TicketQueue() {
    queue = new LinkedList<>();
  }

  // Method to add a ticket to the queue
  public void enqueue(String ticket) {
    queue.add(ticket);
  }

  // Method to process a ticket (dequeue)
  public String dequeue() {
    if (queue.isEmpty()) {
      System.out.println("No tickets to process.");
      return null;
    }
    String processedTicket = queue.remove();
    return processedTicket;
  }

  // Main method for testing
  public static void main(String[] args) {
    TicketQueue ticketQueue = new TicketQueue();

    // Performing operations as per the example
    ticketQueue.enqueue("ticket1");
    ticketQueue.enqueue("ticket2");
    String ticket = ticketQueue.dequeue(); // Process one ticket

    // Expected Outputs
    System.out.println(ticket); // Expected: ticket1
  }
}