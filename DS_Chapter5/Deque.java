package DS_Chapter5;

// part 3 Deque : which is a queue that supports insertion and deletion from both sides (front and rear )
public class Deque<T> {
    // Perpar the node
    private class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        // constructor
        public Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    // deque paremeters (Attributes )
    Node<T> front;
    Node<T> rear;
    int size;

    // constructor
    public Deque() {
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

    // Add at fist
    public void addFirst(T item) {
        Node<T> newNode = new Node<>(item);

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
    public void addLast(T item) {
        Node<T> newNode = new Node<>(item);

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
    public T removeFirst() {
        T data = null;
        if (isEmpty()) {
            System.out.println("Deque is empty !!");
            return null;
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
    public T removeLast() {
        T data = null;
        if (isEmpty()) {
            System.out.println("Deque is empty !!");
            return null;
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

    // peek first
    public T peekFirst() {
        if (isEmpty()) {
            System.out.println("Deque is empty !");
            return null;
        } else {
            return front.data;
        }
    }

    // peek last
    public T peekLast() {
        if (isEmpty()) {
            System.out.println("Deque is empty !");
            return null;
        } else {
            return rear.data;
        }
    }

    public static void main(String[] args) {
        Deque<String> position = new Deque<>();
        position.addFirst("Manager");
        position.addLast("Assistant");
        position.addLast("Employer");
        position.addFirst("Deputy");

        System.out.println("Size : " + position.size());

        System.out.println(position.peekFirst());
        System.out.println(position.peekLast());

        System.out.println("Remove First  :: " + position.removeFirst());

        System.out.println("Remove Last :: " + position.removeLast());
        System.out.println("The first peek  is :: " + position.peekFirst());

        System.out.println();

        System.out.println("Size : " + position.size());

    }

}
