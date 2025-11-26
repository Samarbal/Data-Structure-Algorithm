package DS_Chapter1;

public class ArrayOperation {
    public static void main(String[] args) {
        int array1 [] = {12, 25, 14, 58, 95, 25, 45, 5, 12, -12, -20, 58};
        System.out.println("The highest value in the array is: " + findHighest(array1));
        System.out.println("The lowest value in the array is: " + findLowest(array1));

    }
    
    // Find the hights value in an array method
    public static int findHighest(int[] arr) {
        int highest = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > highest) {
                highest = arr[i];
            }
        }
        return highest;
    }

    // Find the lowest value in an array method 
    public static int findLowest(int[] arr) {
        int lowest = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < lowest) {
                lowest = arr[i];
            }
        }
        return lowest;
    }

    // Summing the elements of an array method



    // Average of the elements in an array method


    // Sawping two elements in an array method


    // Reversing an array method

    // insertion sort method


    
}
