package Treasure_Chest_Project;

import java.util.Random;
import java.util.Scanner;

class Treasure {
    // to store the name and quantity
    String name;
    int count;

    // constructor
    public Treasure(String name, int count) {
        this.name = name;
        this.count = count; // how many treasures of this type
    }
}
// ---------------------------------------------------------------

public class TreasureChest {
 
    Treasure[] chest;
    int size;
    int capacity = 25; // maximum capacity of the chest

    // constructor
    public TreasureChest() {
        this.chest = new Treasure[capacity];
        this.size = 0;
    }

    // add treasure
    public void addTreasure(String name) {
        // case normalization: to make all the treasure names in small letters
        // to make all the treasure names in small letters
        name = name.trim().toLowerCase();

        // check if the chest is full
        if (size == capacity) {
            System.out.println("Treasure chest is full !");
            return;
        }

        // check if the treasure already exists
        for (int i = 0; i < size; i++) {
            if (chest[i].name.equals(name)) {
                chest[i].count++;
                System.out.println(name + " has been added to the treasure chest !");
                return;
            }
        }
        // add treasure if it does not exist before

        chest[size] = new Treasure(name, 1);
        size++;
        System.out.println(name + " has been added to the treasure chest !");

    }

    // remove treasure
    public void removeTreasure(String name) {
        // to make all the treasure names in small letters
        name = name.trim().toLowerCase();

        // check if the chest is empty
        if (size == 0) {
            System.out.println("Treasure chest is empty !");
            return;
        }
        // search for the treasure
        // declaring boolean to check is found inside the loop
        boolean isFound = false;
        for (int i = 0; i < size; i++) {
            if (chest[i].name.equalsIgnoreCase(name)) {
                isFound = true;
                // decrease the count if more than 1
                if (chest[i].count > 1) {
                    chest[i].count--;
                    System.out.println(name + " has been removed from the treasure chest !");
                    return;
                }
                // remove the treasure if only 1 exists
                else {
                    // shift the treasures to fill the gap
                    for (int j = i; j < size - 1; j++) {
                        chest[j] = chest[j + 1];
                    }
                    size--;
                    System.out.println(name + " has been removed from the treasure chest !");

                }
                return;
            }
        }
        if (!isFound) {
            System.out.println("" + name + " is not found in the treasure chest !");
        }
    }

    // count and display treasures
    public void displayChest() {
        // check if empty
        if (size == 0) {
            System.out.println("Treasure chest is empty !");
            return;
        }

        // display the names and counts for each treasure
        System.out.println("Treasure chest contents: \n ");
        for (int i = 0; i < size; i++) {

            System.out.println("- " + chest[i].name + ": " + chest[i].count);
        }

        System.out.println("--------------------------------");
    }

    // get the total count of the treasures
    public int totalCount() {
        int total = 0;
        for (int i = 0; i < size; i++) {
            total += chest[i].count;
        }
        return total;
    }

    // search if the treasure exists

    public void searchTreasure(String name) {
        // to make all the treasure names in small letters
        name = name.trim().toLowerCase();

        // check if empty
        if (size == 0) {
            System.out.println("Treasure chest is empty !");
            return;
        }
        // search for the treasure
        boolean isFound = false;
        for (int i = 0; i < size; i++) {
            if (chest[i].name.equalsIgnoreCase(name)) {
                isFound = true;
                System.out.println(name + " found in the treasure chest with count: " + chest[i].count);
                return;
            }
        }
        if (!isFound) {
            System.out.println(name + " not found in the treasure chest !");
        }
    }

    // most frequent treasure

    public void mostFreqTreasure() {
        // check if empty
        if (size == 0) {
            System.out.println("Treasure chest is empty !");
            return;
        }

        int maxCount = chest[0].count;
        String mostFrequent = chest[0].name;

        for (int i = 1; i < size; i++) {
            if (chest[i].count > maxCount) {
                maxCount = chest[i].count;
                mostFrequent = chest[i].name;
            }
        }

        System.out.println("Most frequent treasure: " + mostFrequent + " with count: " + maxCount);
    }

    // random distribution
    public void randomDistribution() {

        Random rand = new Random();
        // pool of treasures
        String[] pool = { "Gold Coin", "Diamond", "Map", "Shield", "Sword", "Crown" };

        int n = rand.nextInt(5) + 1; // random number between 1 and 5
        for (int i = 0; i < n; i++) {
            String treasure = pool[rand.nextInt(pool.length)];
            addTreasure(treasure);
        }
    }

    // Implementation details

    public static void main(String[] args)

    {

        Scanner input = new Scanner(System.in);
        // create a treasure chest
        TreasureChest chest = new TreasureChest();

        int choice;
        System.out.println("=== Welcome to the Treasure Chest Management System ! ===");
        System.out.println("----------------------------------------");

        System.out.println(
                "We don't want you to start empty handed, so we have added some random treasures to your chest !");
        System.out.println("----------------------------------------");
        // to let the user start with some random treasures
        chest.randomDistribution();
        System.out.println("----------------------------------------");

        do {
            // display the operation menu
            System.out.println("Choose an operation : ");
            System.out.println("1. Add a new Treasure ");
            System.out.println("2. Remove a Treasure ");
            System.out.println("3. Display all Treasures ");
            System.out.println("4. Search for a Treasure ");
            System.out.println("5. Count total treasures");
            System.out.println("6. Most Frequent Treasure ");
            System.out.println("7. Exit ");

            System.out.println("Enter your choice (1-7): ");
            choice = input.nextInt();
            input.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    // add a treasure
                    System.out.println("Enter the name of the treasure to add: ");
                    String name = input.nextLine();
                    chest.addTreasure(name);
                    System.out.println("----------------------------------------");
                    break;

                case 2:
                    // remove a treasure
                    System.out.println("Enter the name of the treasure to remove: ");
                    String removeName = input.nextLine();
                    chest.removeTreasure(removeName);
                    System.out.println("----------------------------------------");
                    break;

                case 3:
                    // dispaly all treasures
                    chest.displayChest();
                    System.out.println("----------------------------------------");
                    break;

                case 4:
                    // search for a treasure
                    System.out.println("Enter the name of the treasure to search for: ");
                    String searchName = input.nextLine();
                    chest.searchTreasure(searchName);
                    System.out.println("----------------------------------------");
                    break;

                case 5:
                    // count total treasures
                    System.out.println("Total treasures in chest: " + chest.totalCount());
                    System.out.println("----------------------------------------");
                    break;

                case 6:
                    // most frequent treasure
                    chest.mostFreqTreasure();
                    System.out.println("----------------------------------------");
                    break;

                case 7:
                    System.out.println("Exiting the Treasure Chest Management System. Goodbye!");
                    System.out.println("----------------------------------------");

                default:
                    break;
            }

        } while (choice != 7);
    }

}
