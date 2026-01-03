package DS_Chapter5;
// Part 4: a priority queue, which gives priority to items based on the highest priority value (smallest or largest).

// here the small number is high priority 

public class PriorityQueue<T> {
    // Declare the node
    private class Node<T> {
        T data;
        int priority;
        Node<T> next;

        // constructor
        public Node(T data, int pri) {
            this.data = data;
            this.priority = pri;
            this.next = null;

        }

    }

    // Parameters (Attributes )
    private Node<T> head;

    public PriorityQueue() {
        this.head = null;
    }

    // Add function

    public void add(T item, int pri)  // O(n)
     {
        Node<T> newNode = new Node<T>(item, pri);

        // conditions : not empty or less priorty
        if (head == null || pri < head.priority) {
            newNode.next = head;
            head = newNode;
        }

        else {
            Node<T> current = head;

            // condition
            while (current.next != null && current.next.priority <= pri) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;

        }
    }

    // poll  : remove the most priory 

public T poll(){
    T data = null ;
    if (head == null ){System.out.println(" The Queue is empty !");  return null ; }
    else {
       data = this.head.data ;
       head = head.next;
       return data; 
    }
}

// peek 
public T peek (){

    if (head == null ){System.out.println("The queue is empty "); return null ;}
    else {return head.data ; }
}

public static void main(String[] args) {
    PriorityQueue<String> colors = new PriorityQueue<>();

        colors.add("Red", 3);
    colors.add("Blue", 1);
    colors.add("Green", 2);

    System.out.println(colors.peek()); // Blue
    System.out.println(colors.poll()); // Blue
    System.out.println(colors.poll()); // Green
    System.out.println(colors.poll()); // Red
}



}
