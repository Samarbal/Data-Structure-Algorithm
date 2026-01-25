package Customer_Management_System_Project;

public class Stack {
    // node class
    private class Node {
        Customer data;
        Node next;

        public Node(Customer data) {
            this.data = data;
            this.next = null;
        }
    }

    // attributes
    private Node top;
    private int size;

    // constructor
    public Stack() {
        this.top = null;
        this.size = 0;
    }
    // isEmpty function
    public boolean isEmpty() {
        return this.size == 0;  }
    // get size function
    public int size() {
        return this.size;
    }
    
    // push function
    public void push(Customer data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        size++;
    }
    // pop function
    public Customer pop() {
        if (isEmpty()) {
            return null; // or throw exception
        }
        Customer poppedData = top.data;
        top = top.next;
        size--;
        return poppedData;
    }  
    // peek function
    public Customer peek() {
        if (isEmpty()) {
            return null; // or throw exception
        }
        return top.data;
    }
    
    // display function
    public void display() {
        Node current = top;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
    




}