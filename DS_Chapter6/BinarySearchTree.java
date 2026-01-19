package DS_Chapter6; 
public class BinarySearchTree  <T extends Comparable<T>>{
   // every node has to be comparable
   
   // prepare the node
    class Node<T extends Comparable<T>> {
         T data;
         Node<T> left;
         Node<T> right;
    
         // constructor
         public Node(T data){
              this.data = data;
              this.left = null;
              this.right = null;
         }
    }

    // root of the binary tree
    private Node<T> root;

    // constructor of binary tree
    public BinarySearchTree() {
        this.root = null;
    }

    // insert method , it depends on recursive function
    public void insert(T data) {
        root = insertRec(root, data);
    }

    // recursive insert function
    private Node<T> insertRec(Node<T> root, T data) {
        // tree is empty
        if (root == null) {
            root = new Node<>(data);
            return root;
        }
        // traverse to the right place and insert the node
        if (data.compareTo(root.data) < 0) {
            root.left = insertRec(root.left, data);
         // data is greater than root's data   
        } else if (data.compareTo(root.data) > 0) {
            root.right = insertRec(root.right, data);
        }
        // return the unchanged node pointer
        return root;
    }

    // delete method: * leaf node, node with one child, node with two children
    // it depends on recursive function
    public void delete (T data) {
        root = deleteRec(root, data);}
    
        private Node<T> deleteRec(Node<T> node, T data) {
            // tree is empty
            if (node == null) {
                return node;
            }
            // traverse to the right place and delete the node
            // data is smaller than node's data
            if (data.compareTo(node.data) < 0) {
                node.left = deleteRec(node.left, data);
            }  // data is greater than node's data 
            else if (data.compareTo(node.data) > 0) {
                node.right = deleteRec(node.right, data);
            }   // data is same as node's data, then this is the node to be deleted 
            else {
                // node with only one child or no child
                if (node.left == null)
                    return node.right;
                // node with only one child
                else if (node.right == null)
                    return node.left;

                // node with two children: get the inorder successor (smallest in the right subtree)
                node.data = minValue(node.right);

                // delete the inorder successor
                node.right = deleteRec(node.right, node.data);
            }
            return node;
        }

        private T minValue(Node<T> root) {
            T minv = root.data;
            while (root.left != null) {
                minv = root.left.data;
                root = root.left;
            }
            return minv;
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


    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        System.out.println("In-order traversal:");
        
        bst.inOrder();

        
        System.out.println("Post-order traversal:");
        bst.postOrder();


        System.out.println("Pre-order traversal:");
        bst.preOrder();

        System.out.println("Delete 20:");
        bst.delete(20);
        System.out.println("In-order traversal after deleting 20:");
        bst.inOrder();

        System.out.println("Delete 30:");
        bst.delete(30);
        System.out.println("In-order traversal after deleting 30:");
        bst.inOrder();

        System.out.println("Delete 50:");
        bst.delete(50);
        System.out.println("In-order traversal after deleting 50:");
        bst.inOrder();
    }


    

}
