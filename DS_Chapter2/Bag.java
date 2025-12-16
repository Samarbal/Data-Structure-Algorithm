public class Bag<T> {

    // generic data type

    // declaring the variables
    private T items[];
    private int capacity; // total capacity of the bag
    private int size; // the current size of the bag

    // constructor
    public Bag(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.items = (T[]) new Object[capacity];

    }

    // is full method
    public boolean isFull() {
        return size == capacity;
    }

    // is empty method
    public boolean isEmpty() {
        return size == 0;
    }

    // check size method
    public int currentSize() {
        return this.size;
    }

    // Display elements method
    public void Display() {
        for (int i = 0; i < size; i++) {
            System.out.println("Item : " + items[i]);
        }
    }

    // Add items Methods
    public void Add(T item) {
        // check is full or not
        if (isFull()) {
            System.out.println("Sorry, the bag is full !!");
            return; 
        }

        
        this.items[size] = item;
        size++;
        System.out.println(item + " has been added successfully !");
    }



    // Contain items method
    public boolean Contain(T item) {
        boolean isFound = false;
        // check if the bag is not empty to search
        if (!isEmpty()) {
            for (int i = 0; i < size; i++) {
                if (items[i] == item) {
                    isFound = true;
                    break;
                }

            }

        }
        return isFound;
    }

    // remove items from the bag
    public void Remove(T item) {
        // check if empty
        if (!isEmpty()) {
            int index = indexOf(item);
            if (index != -1) {
                for (int i = index; i < size - 1; i++) {
                    items[i] = items[i + 1];
                }
                size--;
                System.out.println(item + " has been removed successfully !");
            } else {
                System.out.println(item + " is not found !! ");
                return;
            }

        } else {
            System.out.println("The bag is empty !");
        }
    }

    // get the index
    private int indexOf(T item) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (items[i].equals(item)) {
                index = i;
            }
        }

        return index;
    }

    // remove item at specific index
    public void RemoveAt(int index) {
        T item = get(index);
        if (item != null) {
            Remove(item);
        } else {
            System.out.println("Sorry, Invalid index !");
        }
    }

    private T get(int index) {
        if (!isEmpty() && index >=0 && index < size) {
            for (int i = 0; i < size; i++) {
                if (items[i] == items[index]) {
                    return items[i];
                }
            }
        }
        return null;
    }

}
