package DS_Chapter8;
//  quick sort algorithm
//quick sort algorithm : it depends on divide and conquer , pick an element  as pivot and sort the array based on it 

public class QuickSort {
    public static void quickSort (int arr[] , int low, int high){
    
        if (low< high){
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition (int arr[], int low , int high ){
        int pivot = arr[high]; // pivot
        int i = (low -1); // index of smaller element

        for (int j = low; j < high; j++) {
            // if current element is smaller than or equal to pivot
            if (arr[j] <= pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swapping arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        // pivot element
        return i + 1;
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
        quickSort(arr, 0, arr.length - 1);
        displayArray(arr);
    }
}
