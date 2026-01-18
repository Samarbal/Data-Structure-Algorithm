package DS_Chapter5.QueueExercise;

import java.util.Scanner;

public class DequeInteger {

    // Perpar the node
    private class Node {
        int data;
        Node next;
        Node prev;

        // constructor
        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    // deque paremeters (Attributes )
    private Node front;
    private Node rear;
    private int size;

    // constructor
    public DequeInteger() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    // Deque : which is a queue that supports insertion and deletion from both sides
    // (front and rear )

    // isEmpty function
    public boolean isEmpty() {
        return this.size == 0;
    }

    // get size function
    public int size() {
        return this.size;
    }

    // Add at fist
    public void addFirst(int element) {
        Node newNode = new Node(element);

        if (isEmpty()) {
            front = rear = newNode;
        } else {
            newNode.next = front;
            front.prev = newNode;
            front = newNode;
        }
        size++;
    }

    // Add at rear
    public void addLast(int element) {
        Node newNode = new Node(element);

        if (isEmpty()) {
            front = rear = newNode;
        } else {
            newNode.prev = rear;
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    // Remove from first
    public int removeFirst() {
        int data = 0;
        if (isEmpty()) {
            System.out.println("Deque is empty !!");
            return -1;
        } else {
            data = front.data;
            front = front.next;

            if (front == null) { // only one element
                rear = null;
            } else {
                front.prev = null;
            }
        }
        size--;
        return data;
    }

    // remove from last
    public int removeLast() {
        int data = 0;
        if (isEmpty()) {
            System.out.println("Deque is empty !!");
            return -1;
        } else {
            data = rear.data;
            rear = rear.prev;

            if (rear == null) { // only one element
                front = null;
            } else {
                rear.next = null;
            }
        }
        size--;
        return data;
    }




    public static void main(String[] args) {
        DequeInteger deque = new DequeInteger();
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            System.out.println("----------------");
            System.out.println("Deque Operation ");
            System.out.println("1. Add front");
            System.out.println("2. Add rear");
            System.out.println("3. Remove front");
            System.out.println("4. Remove rear ");
            System.out.println("5. Exit ");
            System.out.println("Enter choice : ");
            choice = input.nextInt();

            switch (choice) {
                case 1:

                    System.out.print("Enter element: ");
                    deque.addFirst(input.nextInt());

                    break;
                case 2:

                    System.out.print("Enter element: ");
                    deque.addLast(input.nextInt());
                    break;

                case 3:
                    System.out.println("Removed from front: " + deque.removeFirst());
                    break;

                case 4:
                    System.out.println("Removed from rear : " + deque.removeLast());
                    break;

                case 5:
                    System.out.println("Exiting program...");

                    break;
                default:
                    System.out.println("Invalid choice!");

            }
        } while (choice != 5);
        input.close();

    }

}