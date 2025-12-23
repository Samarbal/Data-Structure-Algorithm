public class DoubleLinkedList<T> {

    class Node<T> {
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

    // general variables
    Node<T> head;
    int size;

    // constructor
    public DoubleLinkedList() {
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

    // insert at the beginning
    public void insertAtBeginning(T data) {

        Node<T> newNode = new Node<>(data);

        // if the list is empty
        if (isEmpty()) {
           head =  newNode;
        }
        // if not empty and has elements
        else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;

        }
        size++;
    }

    // insert at end

    public void insertAtEnd(T data) {
        Node<T> newNode = new Node<>(data);

        // if the list is empty
        if (isEmpty()) {
           head =  newNode ;
        }
        // if not empty and has elements
        else {
            // loop till reach temp.next = null , then we add the new element
            Node<T> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
           
        }  size++; 

    }

    // Delete From beginning Method
    public void deleteFromBeginning() {
        if (!isEmpty()) {
            if (head.next != null) {
                // العنصر التاني خلي الي قبله يساوي فاؤغ
                head.next.prev = null;
                head = head.next;
                size--;
            }
        }

        // is empty
        else {
            System.out.println("Empty list !");
        }

    }

    // delete from end method
    public void deleteFromEnd() {
        // if empty
        if (isEmpty()) {
            System.out.println("Empty List !! ");
        }

        // if has one element
        else if (head.next == null) {
            head = null;
            size--;
        }
        // if has many elements
        else {
            Node<T> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            // العنصر السابق ال temp الي بعده ؤح يكون فارغ
            temp.prev.next = null;
            size--;
        }
    }

    // search method
    public boolean search(T data) {
        Node<T> temp = head;
        while (temp != null) {
            if (temp.data.equals(data)) {
                return true;
            }
            temp = temp.next;

        }
        return false;
    }

    // reverse elements method 
    
    public void reverse() {
    Node<T> current = head;
    Node<T> temp = null;

    while (current != null) {
        // swap next and prev
        temp = current.prev;
        current.prev = current.next;
        current.next = temp;

        // move to next node (which is prev now)
        current = current.prev;
    }

    // fix head
    if (temp != null) {
        head = temp.prev;
    }
}



    //display in reverse 
    public void dispalyReverse () {
    if (isEmpty()) {
        System.out.println("Empty list ");
        return;
    }

    Node<T> temp = head;

    // نروح لآخر عنصر
    while (temp.next != null) {
        temp = temp.next;
    }

    // نطبع من الأخير للأول
    while (temp != null) {
        System.out.println("Data " + temp.data);
        temp = temp.prev;
    }

    System.out.println("\nNull");
}

    // display  forward method 

    public void display(){
         if (isEmpty())
        {System.out.println("Empty list ");
            return;
        }

         // else 
            else{
                Node <T> temp =  head ; 
                while (temp != null ){
                    System.out.println("Data " + temp.data  );
                    temp =  temp.next ; 
                }
                  System.out.println(" \n Null ");
            }
    }

    public static void main(String[] args) {
        DoubleLinkedList<Integer> dll = new DoubleLinkedList<>();

        dll.insertAtEnd(10);
        dll.insertAtEnd(20);
        dll.insertAtEnd(30);
        dll.insertAtBeginning(5);
        dll.display();
       // System.out.println("After reversing ");
        //dll.reverse();
        dll.display();
        System.out.println("Display in reverse ");
        dll.dispalyReverse();}


}
