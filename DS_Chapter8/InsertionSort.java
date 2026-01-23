package DS_Chapter8;

public class InsertionSort {
    // insertion sort algorithm
    // time complexity: O(n^2) in worst and average case, O(n) in best case

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        // start form second element
        for (int i = 1; i < n; i++) {
            // the current element to be inserted in the sorted part
            int key = arr[i];
            // move elements of arr[0..i-1], that are greater than key,
            // to one position ahead of their current position
            int j = i - 1;
            // shift elements to the right to make space for key
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            // place key at after the element just smaller than it
            arr[j + 1] = key;
        }

    }

    public static void displayArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 5, 8, 1, 9, 12, 6 };
        System.out.println("Original Array ----");
        displayArray(arr);
        System.out.println("Sorted Array ------");
        insertionSort(arr);
        displayArray(arr);
    }

}
