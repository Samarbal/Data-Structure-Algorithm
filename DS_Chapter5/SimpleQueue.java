package DS_Chapter5;
import java.util.Scanner;
// Chapter 5 Queue 

// part 1: Simple Queue  : FIRST IN FIRST OUT (FIFO)
public class SimpleQueue<T> {
    // perpar the node
    private class Node {
        T data;
                Node next;

        // constructor
        public Node(T data) {
            this.data = data;
            this.next = null;

        }
    }

    // Queue parameters
    Node front;
    Node rear;
    int size;

    // constructor
    public SimpleQueue() {
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

    // Enqueue function : adding elements (data) to the end of the queue
    public void Enqueue(T data) {
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

    // Dequeue function : deleting elements from front of the queue
    public T Dequeue() {

        // check if empty
        if (isEmpty()) {
            System.out.println("Queue is Empty  ");
            return null;
        } else {
            T data = front.data;
            front = front.next;
            if (front == null) {
                rear = null;
            }
            size--;
            return data;

        }
    }

    // peek function: return the first element of the queue
    public T peek() {
        // check if empty
        if (isEmpty()) {
            return null;
        }
        return front.data;
    }

    public static void main(String[] args) {

        SimpleQueue<Integer> queue = new SimpleQueue<>();
        Scanner input = new Scanner(System.in);

        int choice ;
        System.out.println("Simple Queue Operations ");
      
        do {System.out.println("-------------------------");
            System.out.println("1- Enqueue ");
            System.out.println("2- Dequeue ");
            System.out.println("3- Peek ");
            System.out.println("4- Size ");
            System.out.println("5- Exit ");
            System.out.print("Enter your choice : ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to Enqueue : ");
                    int value = input.nextInt();
                    queue.Enqueue(value);
                    System.out.println(value + " is added to the queue ");
                    break;
                case 2:
                    Integer removedValue = queue.Dequeue();
                    if (removedValue != null) {
                        System.out.println(removedValue + " is removed from the queue ");
                    }
                    break;
                case 3:
                     System.out.println("Front element: " + queue.peek());

                    break;
                case 4:
                    System.out.println("Queue size is : " + queue.size());
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        while(choice != 5);

        input.close();
    }

}
