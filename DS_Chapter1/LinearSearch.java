// package DS_Chapter1;

public class LinearSearch {
    public static void main(String[] args) {
        int array[] = {12, 25, 14, 58, 95, 25, 45, 5, 12, -12, -20, 58};
        int target = 0;
        int result = linearSearch(array, target);
        if (result == -1) {
            System.out.println("Element not found in the array.");
        } else {
            System.out.println("Element found at index: " + result);
        }
    }

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Return the index if the target is found
            }
        }
        return -1; // Return -1 if the target is not found
    }
    
}
