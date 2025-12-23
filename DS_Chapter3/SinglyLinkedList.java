

public class SinglyLinkedList<T> {

    // declare Node class
    private class Node<T> {
        T data;
        Node<T> next;

        // constructor
        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // general variables
    Node <T>head;
    int size;

    // constructor
    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    // is empty method
    public boolean isEmpty() {
        return head == null;
    }

    // size method
    public int size() {
        return this.size;
    }

    // clear all nodes
    public void clear() {
        size = 0;
        this.head = null;
    }

    // Adding node
    public void Add(T data) {
        Node <T>newNode = new Node(data);
        // if empty list
        if (isEmpty()) {
            head = newNode;
            size++;
        }

        // if one node there
        else if (head.next == null) {
            head.next = newNode;
            size++;
        }

        // if more than one node there
        else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            size++;
        }
    }

    // in adding node method time is O(n) and space is O(1)

    // delete nodes method


  public void deleteFromBeginning() {
    if (isEmpty()) {
        System.out.println("List is empty!");
        return;
    }

    head = head.next;
    size--;
} 

public void deleteENd(){
    Node <T> current = head;
    if (isEmpty()){
        System.out.println("List is empty!");
        return;
    }
   while (current.next.next != null){
        current = current.next;

    }
    current.next = null;
    size--; 
}


    // display method
    public void display() {
        if (isEmpty()) {
            System.out.println("Empty List !");
        } else {
            Node<T> current = head;
            while (current != null) {
                System.out.print(current.data + " -> ");
                current = current.next;
            }

        }
    }

    public static void main(String[] args) {
        SinglyLinkedList< Integer> list = new SinglyLinkedList<>();

        list.Add(10);
        list.Add(20);
        list.Add(30);


        System.out.println("Size of the list: " + list.size());
        list.display();

        list.deleteFromBeginning();
        System.out.println("\nSize of the list after deletion: " + list.size());

        list.Add(5);
        list.Add(10);
        list.deleteENd();


        list.display();



    }
}
