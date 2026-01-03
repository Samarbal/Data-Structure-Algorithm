package BalancedParetheses_Assignment;
// this is Assignment 2
/**
 * Balanced Parentheses
 * Checking Balanced Parentheses using Stack Data Structure
 * 
 * The idea of the project as follow: 
 * The stack  works with FILO principle(First in last out )
 * when there's an opening  parentheses , it added to the stack (pushed )
 * when there's a closing parentheses:
 *  1. if the stack is empty , there's no balanced--> return false 
 * 2. if there's an opening one, it popped and compare it with the closing one: 
 *    a. if it's equal (matched)-->  we remove the opening 
 *    b. if not equal (not matched) --> return false
 * 3.  At the end, if the stack is empty -> expression is balanced

 * 
  **/ 
 
public class BalancedParentheses <T>{

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

    // stack attributes 
    private Node<T> top;

    // constructor
    public BalancedParentheses() {
        this.top = null;

    }
    // Stack Method

    // push
    public void push(T data) {
        Node<T> newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

  // pop

    public T pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty ");
            return null;
        }
        T data = top.data;
        top = top.next;
        return data;
    } 

     // is empty method
    public boolean isEmpty() {
        return top == null;
    }



// check  balanced class 
public static class BracketChecker {

    public boolean checkBalanced(String expression){
        // create the stack 
        BalancedParentheses<Character> equ = new BalancedParentheses<>();

          // Traverse the expression character by character
        for(int i = 0 ; i < expression.length(); i++){
            char ch = expression.charAt(i);

            // if opening parentheses -->  push it to the stack 
            if(ch == '(' || ch == '{' || ch == '['){
                equ.push(ch);
            }
            // if closing parentheses 
            else if (ch == ')' || ch == '}' || ch == ']'){
                // if stack is empty -->  not balanced 
                if(equ.isEmpty()){
                    return false;
                }
                char topChar = equ.pop();

                // check for matching pairs
                if((ch == ')' && topChar != '(') ||
                   (ch == '}' && topChar != '{') ||
                   (ch == ']' && topChar != '[')){
                    return false;
                }
            }
        }
        // if stack is empty at the end , it's balanced 
        return equ.isEmpty();
    }
    
}


public class Main {
    public static void main(String[] args) {

        BracketChecker checker = new BracketChecker();

        String expression1 = "(1+200)*[10]/{53-2{";
        String expression2 = "{(a+b]*[c/d)}";
        String exp3 = "(2+4*{5*2})";

        System.out.println("Expression: " + expression1 + " is balanced: " + checker.checkBalanced(expression1));

        System.out.println("Expression: " + expression2 + " is balanced: " + checker.checkBalanced(expression2));
                System.out.println("Expression: " + exp3 + " is balanced: " + checker.checkBalanced(exp3));

    } }

}