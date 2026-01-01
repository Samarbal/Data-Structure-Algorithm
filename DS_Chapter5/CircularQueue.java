package DS_Chapter5;

// part 2 circular queue 
// A queue that uses array with a fixed size, when the parameters reaches the end of the array it return to the front again
public class CircularQueue<T> {
    // parameters
    T queue[];
    int front, rear, capacity, size;

    // constructor
    public CircularQueue(int capacity) {
        this.queue = (T[]) new Object[capacity];
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
    public void enqueue(T item) {
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
    public T dequeue() {
        T item = null;
        // check if is empty
        if (isEmpty()) {
            System.out.println("Sorry the circular queue is empty ");
            return null;
        } else {
            item = queue[front];
            front = (front + 1) % capacity;
            size--;
            return item;
        }
    }

    // Peek function : return the first element in the queue
    public T peek() {
        if (isEmpty()) {
            return null;
        } else {
            return queue[front];
        }
    }

    // Implementation

    public static void main(String[] args) {
        CircularQueue<Integer> circularQueue = new CircularQueue<>(5);

        // enqueue elements
        circularQueue.enqueue(10);
        circularQueue.enqueue(20);
        circularQueue.enqueue(30);
        System.out.println("Front element is: " + circularQueue.peek()); // should print 10

        System.out.println("Size : " + circularQueue.size);
        System.out.println("isFull : " + circularQueue.isFull());
        System.out.println("Dequeue element: " + circularQueue.dequeue());
        System.out.println("Front element is: " + circularQueue.peek());
        System.out.println("---------------");
        circularQueue.enqueue(50);
        circularQueue.enqueue(60);
        circularQueue.enqueue(70);
        circularQueue.enqueue(80);
        circularQueue.enqueue(90);
        circularQueue.enqueue(100);

        System.out.println("Size : " + circularQueue.size);
        System.out.println("isFull : " + circularQueue.isFull());
        System.out.println("Dequeue element: " + circularQueue.dequeue());
        System.out.println("Front element is: " + circularQueue.peek());

        System.out.println("---------------");
        int currentSize = circularQueue.size();
        for (int i = 0; i < currentSize; i++) {
            System.out.println("Dequeue element: " + circularQueue.dequeue());
        }
        System.out.println("---------------");

    }

}
