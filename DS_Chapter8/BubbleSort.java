package DS_Chapter8;
// chapter 8: sorting algorithms 

public class BubbleSort {
    // bubble sort algorithm
    // time complexity: O(n^2) in worst and average case, O(n) in best case

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        // traverse through all array elements
        for (int i = 0; i < n - 1; i++) {
            // last i elements are already sorted
            for (int j = 0; j < n - i - 1; j++) {
                // swap if the element found is greater than the next element
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
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
        bubbleSort(arr);
        displayArray(arr);
    }

}
