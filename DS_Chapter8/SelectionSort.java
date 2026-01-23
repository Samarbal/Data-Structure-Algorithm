package DS_Chapter8;

public class SelectionArray {
    // selection sort algorithm
    // time complexity: O(n^2) in worst, average, and best case

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        // traverse through all array elements
        // find the minimum element in unsorted array
        for (int i = 0; i < n - 1; i++) {

            int minIndex = i;
            // check the element to be minimum
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // swap the found minimum element with the first element
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
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
        selectionSort(arr);
        displayArray(arr);
    }
}
