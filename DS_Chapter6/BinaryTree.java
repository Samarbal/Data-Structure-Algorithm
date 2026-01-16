package DS_Chapter6;

import java.util.LinkedList;
import java.util.Queue;
/* Tree is Hierarchy representation of data
        1. Root node : top node of the tree 
        2. Parent node : node which have child nodes
        3. Child node : node which have parent node
        4. Leaf node : node which do not have any child nodes
        5. Sibling nodes : nodes which have same parent node
        6. Depth of node : number of edges from root to that node
        7. Height of node : number of edges from that node to the deepest leaf node
        8. Height of tree : number of edges from root to the deepest leaf node
        9. Level of node : number of edges from root to that node + 1
        10. Degree of node : number of children of that node

 */
public class BinaryTree<T> {

    /*  

    Binary Tree: every parent has max 2 children
             example :
                       10
                   /      \
                20        30
               /  \      /  \   
             40   50   60   70        
    */

    // prepare the node
    class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;

        // constructor
        public Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // root of the binary tree
    Node<T> root;

    // constructor of binary tree
    public BinaryTree() {
        this.root = null;
    }

    // insert method --> level order insertion
    public void insert(T data){

        Node<T> newNode = new Node(data);

        // if tree is empty
        if(root == null){
            root = newNode;
            return;
        }

        // if tree is not empty
        // create a queue to hold nodes and insert level by level 
        Queue <Node<T>> queue = new LinkedList<>();
        // adding the root 
        queue.add(root);

        // current variable 
        Node <T> current;

        while(! queue.isEmpty()){
            // get the first element of the queue
            current = queue.poll();
            // check left child if is empty , we insert in 
            if(current.left == null){
                current.left = newNode;
                return;
            } else {
                  // not empty so it added to the queue to check on later 
                queue.add(current.left);
            }

            // check right child if is empty , we insert in 
            if(current.right == null){
                current.right = newNode;
                return;
            } else {
                // not empty so it added to the queue to check on later 
                queue.add(current.right);
            }
        }
    }

    // display in  traversal
    // Pre-order traversal: root -> left -> right
public void preOrder(){
        preOrderRec(root);
        System.out.println(" ");
    }

    public void preOrderRec(Node<T> node){
        if(node == null){  // stop condition 
            return;
        }
        System.out.print(node.data + " ");
        preOrderRec(node.left);
        preOrderRec(node.right);
    }

    // In-order traversal: left -> root -> right

public void inOrder(){
        inOrderRec(root);
        System.out.println(" ");
    }

    public void inOrderRec(Node<T> node){
        if(node == null){
            return;
        }
        inOrderRec(node.left);
        System.out.print(node.data + " ");
        
        inOrderRec(node.right);
    }


    // Post-order traversal: left -> right -> root

public void postOrder(){
        postOrderRec(root);
        System.out.println(" ");
    }

    public void postOrderRec(Node<T> node){
        if(node == null){
            return;
        }
        postOrderRec(node.left);
        postOrderRec(node.right);
        System.out.print(node.data + " ");
    }

// delete node method in binary tree
/* 1. search for the element 
2. find the deep set 
3.replace the values 
4. delete the deep set node value  */

public void delete(T data){
    // if tree is empty
        if(root == null){
            return;
        }
        // if tree has one node 
        if(root.left == null && root.right == null){
            if(root.data.equals(data)){
                root = null;
            }
            return;
        }

        // create a queue to hold nodes , and search using level order 
        Queue <Node<T>> queue = new LinkedList<>();
        queue.add(root);

        Node<T> current = null;  // current node 
        Node<T> delNode = null; // the deleted node 

        // search for the wanted node 
        while(! queue.isEmpty()){
            current = queue.poll();
            

            // if the wanted node is found , store it in delNode variable 
            if(current.data.equals(data)){
                delNode = current;
            }
              // add left and right child to the queue
            if(current.left != null){
                queue.add(current.left);
            }

            if(current.right != null){
                queue.add(current.right);
            }
        }
        // the deleted node is found , now replace its value with deepest node value
        if(delNode != null){
            delNode.data = current.data;
            // delete the deepest node
            deleteDeepest(current);
            }
    }
// delete deepest node method
    public void deleteDeepest(Node<T> delNode){

// create a queue to hold nodes , and search using level order
        Queue <Node<T>> queue = new LinkedList<>();
        // adding the root
        queue.add(root);
// current variable
        Node<T> current = null;
// traverse the tree to find the deepest node
        while(! queue.isEmpty()){
            // get the first element of the queue
            current = queue.poll();
// check if the current node is the deepest node
            if(current == delNode){
                current = null;
                return;
            }
// check right child 
            if(current.right != null){
                if(current.right == delNode){
                    current.right = null;
                    return;
                } else {
                    queue.add(current.right);
                }
            }
// check left child
            if(current.left != null){
                if(current.left == delNode){
                    current.left = null;
                    return;
                } else {
                    queue.add(current.left);
                }
            }
        }
    }
public static void main(String[] args) {
    BinaryTree<Integer> bt = new BinaryTree<>();

    // insert nodes
    bt.insert(10);
    bt.insert(20);
    bt.insert(30);
    bt.insert(40);
    bt.insert(50);
    bt.insert(60);
    bt.insert(70);

    // display traversals
    System.out.println("Pre-order Traversal:");
    bt.preOrder();

    System.out.println("In-order Traversal:");
    bt.inOrder();

    System.out.println("Post-order Traversal:");
    bt.postOrder();

    // delete a node
    System.out.println("Deleting node 30");
    bt.delete(30);

    System.out.println("In-order Traversal after deletion:");
    bt.inOrder();
}

}
