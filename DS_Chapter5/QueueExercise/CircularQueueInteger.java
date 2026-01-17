package DS_Chapter5.QueueExercise;

import java.util.Scanner;

public class CircularQueueInteger {

    int queue[];
    int front, rear, capacity, size;

    // constructor
    public CircularQueueInteger(int capacity) {
        this.queue = new int[capacity];
        this.front = 0;
        this.rear = -1; // unknown yet
        this.size = 0;
        this.capacity = capacity;
    }

    // get size function
    public int size() {
        return this.size;
    }

    // check is full
    public boolean isFull() {
        return size == capacity;
    }

    // check is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Enqueue Function : adding element to the rear
    public void enqueue(int item) {
        // check is full
        if (isFull()) {
            // throw new IllegalStateException("The circular queue is full sorry !");
            System.out.println("is full you can not add ");
        } else {
            rear = (rear + 1) % capacity; // to keep in the loop
            queue[rear] = item;
            size++;

        }
    }

    // Dequeue element from the front
    public int dequeue() {
        int item = -1;
        // check if is empty
        if (isEmpty()) {
            System.out.println("Sorry the circular queue is empty ");
            return -1;
        } else {
            item = queue[front];
            front = (front + 1) % capacity;
            size--;
            return item;
        }
    }

    // Peek function : return the first element in the queue
    public int peek() {
        if (isEmpty()) {
            return -1;
        } else {
            return queue[front];
        }
    }

    // Implementation

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Circular Queue Operations ");
        System.out.print("Enter circular queue capacity: ");
        int cap = input.nextInt();

        CircularQueueInteger circularQueue = new CircularQueueInteger(cap);

        int choice;

        do {
            System.out.println("-------------------------");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Check if Full");
            System.out.println("5. Check if Empty");
            System.out.println("6. Size");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();

            switch (choice) {
                case 1:
                    if (circularQueue.isFull()) {
                        System.out.println("Queue is full, cannot add element.");
                    } else {
                        System.out.print("Enter element to enqueue: ");
                        int value = input.nextInt();
                        circularQueue.enqueue(value);
                        System.out.println(value + " added successfully.");
                    }
                    break;

                case 2:
                    System.out.println("Dequeue element: " + circularQueue.dequeue());
                    break;
                case 3:
                    System.out.println("Front element is: " + circularQueue.peek());
                    break;
                case 4:
                    System.out.println("Is Full: " + circularQueue.isFull());
                    break;
                case 5:
                    System.out.println("Is Empty: " + circularQueue.isEmpty());
                    break;
                case 6:
                    System.out.println("Size: " + circularQueue.size());
                    break;

                case 7:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");

            }

        } while (choice != 7);
        input.close();
    }

}
