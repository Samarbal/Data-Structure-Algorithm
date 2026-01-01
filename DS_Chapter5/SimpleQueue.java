package DS_Chapter5;
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

        System.out.println("Front element is : " + queue.peek());
        queue.Enqueue(10);
        queue.Enqueue(20);
        queue.Enqueue(30);

        System.out.println("queue size " + queue.size);

        System.out.println("Remove " + queue.Dequeue());
        System.out.println("Remove " + queue.Dequeue());

        System.out.println("Front element is : " + queue.peek());

    }

}
