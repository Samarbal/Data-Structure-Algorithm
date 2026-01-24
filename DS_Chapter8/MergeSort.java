package DS_Chapter8;
// merge sort implementation in Java
// based on divide and conquer approach to sort an array 
// it divides the array into two halves, recursively sorts them, and then merges the sorted halves
// time complexity O(n log n)
public class MergeSort {
     
    public static void mergeSort(int[] arr) {
        int n = arr.length;
        int mid = n/2 ;

        if (n > 1){
            int []left = new int[mid];
            int []right = new int[n - mid];
            System.arraycopy(arr, 0, left, 0, mid);
            System.arraycopy(arr, mid, right, 0, n - mid);

            mergeSort(left);
            mergeSort(right);
            merge(left, right, arr);
        }
    }

    public static void merge(int[] left, int[] right, int[] arr) {
        int i = 0, // left array index
         j = 0,  // right array index
         k = 0; // merged array index
        // merge until one of the arrays is exhausted
         while (i < left.length && j < right.length) {
            // compare elements from left and right arrays and copy the smaller one to merged array
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } 
            // if element in right array is smaller
            else {
                arr[k++] = right[j++];
            }
        }
        // if there are remaining elements in left array
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        // if there are remaining elements in right array
        while (j < right.length) {
            arr[k++] = right[j++];
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
        mergeSort(arr);
        displayArray(arr);
    }

}
