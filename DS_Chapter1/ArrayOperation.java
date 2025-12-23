//package DS_Chapter1;

public class ArrayOperation {
    public static void main(String[] args) {
        int array1 [] = {12, 25, 14, 58, 95, 25, 45, 5, 12, -12, -20, 58};
        
        System.out.println("The highest value in the array is: " + findHighest(array1));
        System.out.println("---------------------------------");
        System.out.println("The lowest value in the array is: " + findLowest(array1));
        System.out.println("---------------------------------");
        System.out.println("The sum of the elements in the array is: " + sumArray(array1));
        System.out.println("---------------------------------");
        System.out.println("The average of the elements in the array is: " + averageArray(array1));
        System.out.println("---------------------------------");
     reverseArray(array1);
            
        System.out.println("---------------------------------");
        insertionSort(array1);
        
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
    public static int sumArray(int [] arr ){
        int sum = 0 ;
        for (int i = 0; i< arr.length ; i++ ){
            sum += arr[i];
        }
        return sum ;
    }



    // Average of the elements in an array method

    public static float averageArray ( int [] arr ){
        float sum = 0; 
        int len = arr.length; 

        for (int i = 0 ; i < arr.length ; i++ ){
            sum += arr[i];
        }
        float avg = sum / len ; 
        return avg ; 

    }


    // Reversing an array method

    public static void reverseArray ( int [] arr){
        int left =0; 
        int right = arr.length -1 ; 
        
        while ( left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp ;
            
            left ++;
            right --; 
        }
System.out.println("The reversed array is: "  );
        for ( int i =0 ; i < arr.length ; i++ ){
            System.out.print(arr[i] + " ");
        }

    }

    // insertion sort method . O(n)
    public static void insertionSort ( int [] arr ){
        for ( int i =1 ; i < arr.length ; i++ ){
            int key = arr[i];
            int j = i -1 ; 

            while ( j >= 0 && arr[j] > key ){
                arr[j + 1 ] = arr[j];
                j --; 
            }
            arr[j + 1 ] = key ;
        }
        System.out.println("The sorted array using insertion sort is: "  );
        for ( int i =0 ; i < arr.length ; i++ ){
            System.out.print(arr[i] + " ");
        }

    }




}
