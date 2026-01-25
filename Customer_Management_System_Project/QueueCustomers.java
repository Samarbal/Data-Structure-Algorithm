package Customer_Management_System_Project;

public class QueueCustomers {

    // first in first out--> first customer sign in will be served first

    // prepare the node
    // Each node stores a Customer and a reference to the next node
    class Node {
        Customer data;
        Node next;

        public Node(Customer data) {
            this.data = data;
            this.next = null;
        }
    }

    // attributes of the queue
    Node front;
    Node rear;
    int size;

    // constructor
    public QueueCustomers() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    // isEmpty function
    public boolean isEmpty() {
        return this.size == 0;
    }

    // get size function
    public int size() {
        return this.size;
    }

    // Enqueue function : adding customers to the end queue
    public void Enqueue(Customer data) {
        Node newNode = new Node(data);
        // if the queue is empty
        if (isEmpty()) {
            front = newNode;
        } else {
            rear.next = newNode;
        }
        rear = newNode;

        size++;
    }

    // Dequeue function : deleting customers from front of the queue after being served
    public Customer Dequeue() {

        // check if empty
        if (isEmpty()) {
            System.out.println("Queue is Empty  ");
            return null;
        } else {
            Customer data = front.data;
            front = front.next;

            // If queue becomes empty after dequeue
            if (front == null) {
                rear = null;
            }
            size--;
            return data;

        }
    }

    // return the first element of the queue
    public Customer peek() {
        // check if empty
        if (isEmpty()) {
            return null;
        }
        return front.data;
    }

    // display the queue
    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
        } else {
            System.out.println("Customers in the Queue:");
            Node current = front;
            while (current != null) {
                System.out.println(current.data);
                current = current.next;
            }
            System.out.println("Total Customers in Queue: " + size);
        }
    }
}
