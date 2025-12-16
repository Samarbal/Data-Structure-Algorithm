 

public class BagImplementaion {
    public static void main(String[] args){
        
        Bag <String> bag = new Bag<>(5);
        System.out.println("Is the bag full? " + bag.isFull());
        System.out.println("Is the bag empty? " + bag.isEmpty()); 

        bag.Add("Apple");
        bag.Add("Banana");  
        bag.Add("Orange");
        bag.Add("Grapes");

        System.out.println("Is the bag full? " + bag.isFull());
        System.out.println("Is the bag empty? " + bag.isEmpty());

        System.out.println("Current size of the bag: " + bag.currentSize());
        bag.Display();

        System.out.println("Does the bag contain 'Banana'? " + bag.Contain("Banana"));
        System.out.println("Does the bag contain 'Mango'? " + bag.Contain("Mango"));
 
        System.out.println("---------");
        bag.Remove("Banana");
        System.out.println("After removing 'Banana':"); 
        bag.Display();

        bag.RemoveAt(0);
        System.out.println("After removing item at index 0:");
        bag.Display();

        
    }
}