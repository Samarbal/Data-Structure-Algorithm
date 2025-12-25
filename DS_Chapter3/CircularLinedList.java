public class CircularLinedList<T> {

    // prepare the node class
    class Node<T> {
        T data;
        Node<T> next;

        // constructor
        public Node(T data) {
            this.data = data;
            this.next = null;
        }

    }

    // general variables

    Node<T> head;
    int size;

    // constructor
    public CircularLinedList() {
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

    // insert at the beginning method
    public void insertAtBeginning(T data) {
        Node<T> newNode = new Node<>(data);

        // if the list is empty
        if (isEmpty()) {
            head = newNode;
            // its a circular linked list
            newNode.next = head;
        }
        // if not empty and has elements
        else {
            Node<T> temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
            head = newNode;
        }
        size++;
    }
    // insert at end method

    public void insertAtEnd(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode;
            newNode.next = head;
        } else {

            // create temporary node
            Node<T> temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
            // it's a circe and this is the deffernece between adding from the end and from
            // Beggining
            // head = newNode ;

        }
        size++;

    }

    // delete from beginning

    public void deleteFromBeginning() {
        if (!isEmpty()) {
            // if one element

            if (head.next == head) {
                head = null;
            }

            // if more than one element
            else {
                Node<T> temp = head;
                while (temp.next != head) {
                    temp = temp.next; // till the last element
                }
                head = head.next;
                temp.next = head; // here the head points to the second element
            }

            size--;
        } else {
            System.out.println("Empty list ");
        }

    }

    // delete ffrom end

    public void deleteFromEnd() {
        if (!isEmpty()) {
            // if one element
            if (head.next == head) {
                head = null;
            }

            // if more than one element
            else {
                Node<T> temp = head;
                while (temp.next != head) {
                    temp = temp.next; // reaches the last element
                }

                Node<T> prev = head;
                while (prev.next != temp) {
                    prev = prev.next; // reaches before the last element
                }
                prev.next = head;

            }
            size--;
        }

        else {
            System.out.println("Empty list ");
        }
    }

    // display
    public void display() {
        if (isEmpty()) {
            System.out.println("Empty List");
        } else {
            Node<T> temp = head;
            do {
                System.out.println("Data : " + temp.data);
                temp = temp.next;
            } while (temp != head);

            System.out.println("Done diaplay ");

        }
    }

    public static void main(String[] args) {
        CircularLinedList<String> Name = new CircularLinedList<>();

        int si = Name.size;
        Name.insertAtBeginning("Ali ");
        Name.insertAtBeginning("Samr ");
        Name.insertAtEnd("Diam ");
        Name.insertAtEnd("rame ");
        Name.display();
        System.out.println("size is now  :  " + Name.size);

        System.out.println("trt to delete");
        Name.deleteFromBeginning();
        Name.deleteFromEnd();
        Name.display();

        System.out.println("size is now:  " + Name.size);
    }

}
