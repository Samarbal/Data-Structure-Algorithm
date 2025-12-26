package DS_Chapter4;

public class Stack<T> {
    // first in last out ==> FILO

    // prepare the node
    class Node<T> {
        T data;
        Node<T> next;

        // constructor
        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // stack atttibutes
    private int size;
    private Node<T> top;

    // constructor
    public Stack() {
        this.top = null;
        this.size = 0;

    }

    // is empty method
    public boolean isEmpty() {
        return top == null;
    }

    // the size method
    public int size() {
        return this.size;
    }

    // Stack Methhod

    // push
    public void push(T data) {
        Node<T> newNode = new Node(data);

        newNode.next = top; // [3] , push (7)--> [3][7] , newNode.next = 3 (prev top), top = new node [7]
        top = newNode;

        size++;
    }

    // pop

    public T pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty ");
            return null;
        }
        T data = top.data;
        top = top.next;
        size--;
        String stat = "Data is ";
        return data;

    }

    // peak
    public T peek() {
        // return the top data without deleting

        if (isEmpty()) {
            System.out.println("Stack is empty ");
            return null;
        }

        return top.data;
    }

    // display

        public  boolean isBalanced (String exp){
            Stack<Character> stack =  new Stack<>();

            for (char ch :  exp.toCharArray() ) {
                if(ch == '(')
                    {  // open tag 
                    stack.push(ch);}

             if(ch == ')'){   // closed tag
                   if(stack.isEmpty()) {return false;}
                
                   else{stack.pop();    }
                }


            }
            return stack.isEmpty();


        
        }


    // stack implementation

    public static void main(String[] args) {

    
        Stack <String> operation = new Stack<>();

        String exp1 = "()";
        System.out.println("Opreation one  : "+  operation.isBalanced(exp1));
       

         String exp2  = "(10 + (5)";

         System.out.println("Opreation 2 : "+  operation.isBalanced(exp2));
        



    }
       
}
