package Customer_Management_System_Project;


public class ArrayBag<T> {

    private T[] bag;        // Array to store elements
    private int size;       // Current number of elements
    private int capacity;   // Maximum capacity of the bag

    
    //  Constructor
     
    @SuppressWarnings("unchecked")
    public ArrayBag(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.bag = (T[]) new Object[capacity];
    }

   // Add an item to the bag
    public boolean add(T item) {
        if (isFull()) {
            return false;
        }
        bag[size++] = item;
        return true;
    }

    // Remove an item from the bag
    public boolean remove(T item) {
        int index = indexOf(item);
        if (index == -1) {
            return false;
        }
        removeAtIndex(index);
        return true;
    }

    // Remove item at specific index
    private void removeAtIndex(int index) {
        bag[index] = bag[size - 1]; // Replace with last element
        bag[size - 1] = null;
        size--;
    }

    // Find index of an item
    public int indexOf(T item) {
        for (int i = 0; i < size; i++) {
            if (bag[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    // Get item at specific index
    public T getItem(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return bag[index];
    }
 // Check if the bag is empty
    public boolean isEmpty() {
        return size == 0;
    }

  // Check if the bag is full
    public boolean isFull() {
        return size == capacity;
    }

    // Get current size of the bag
    public int size() {
        return size;
    }

}
