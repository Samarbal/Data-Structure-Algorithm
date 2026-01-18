package DS_Chapter5.QueueExercise;

import java.util.Scanner;

public class PriorityQueueInteger<T> {
    // a priority queue, which gives priority to items based on the highest priority
    // value (smallest or largest).


    // Node definition
    private class Node {
        int data;
        int priority;
        Node next;

        public Node(int data, int priority) {
            this.data = data;
            this.priority = priority;
            this.next = null;
        }
    }

    // Parameters (Attributes )
    private Node head;

    public PriorityQueueInteger() {
        this.head = null;
    }

    // Enqueue: smaller number = higher priority

    public void enqueue(int data, int pri) // O(n)
    {
        Node newNode = new Node(data, pri);

        // conditions : not empty or less priorty
        if (head == null || pri < head.priority) {
            newNode.next = head;
            head = newNode;
        }

        else {
            Node current = head;

            // condition
            while (current.next != null && current.next.priority <= pri) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;

        }
    }

    // Dequeue highest priority

    public int dequeue() {
        int data = -1;
        if (head == null) {
            System.out.println(" The Queue is empty !");
            return -1;
        } else {
            data = this.head.data;
            head = head.next;
            return data;
        }
    }

    // peek : highest priority element
    public int peek() {

        if (head == null) {
            System.out.println("The queue is empty ");
            return -1;
        } else {
            return head.data;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        PriorityQueueInteger pq = new PriorityQueueInteger();

        int choice;
        do {
            System.out.println("\n--- Priority Queue Menu ---");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter element to enqueue: ");
                    int element = input.nextInt();
                    System.out.print("Enter priority (smaller = higher): ");
                    int priority = input.nextInt();
                    pq.enqueue(element, priority);
                    System.out.println("Element added.");
                    break;

                case 2:
                    int removed = pq.dequeue();
                    if (removed != -1) {
                        System.out.println("Removed element: " + removed);
                    }
                    break;

                case 3:
                    int top = pq.peek();
                    if (top != -1) {
                        System.out.println("Highest priority element: " + top);
                    }
                    break;

                case 4:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);

        input.close();

    }

}
