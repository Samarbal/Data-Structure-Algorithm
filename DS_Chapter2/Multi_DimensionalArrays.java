// package DS_Chapter2;

import java.util.Scanner;

public class Multi_DimensionalArrays {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // students data

        String student[][] = new String[2][3];
        int size = 0;
        boolean userSelect = true;

        while (userSelect) {
            System.out.println("-----Students Scores ------");
            System.out.println("1. Add");
            System.out.println("2. Display");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Exit");
            System.out.print("Enter you choice : ");

            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    // Add student data
                    if (size < student.length) {
                        System.out.println("Add Student Data");

                        System.out.print("Enter Student Number : ");
                        String stdNumber = input.next();

                        System.out.print("Enter Student Name : ");
                        String stdName = input.next();

                        System.out.print("Enter Student Mark : ");
                        String stdMark = input.next();

                        student[size][0] = stdNumber;
                        student[size][1] = stdName;

                        student[size][2] = stdMark;

                        size++;

                        System.out.println("... Student Added Successfully !  ");
                    } else {
                        System.out.println("you exceded the limit ");
                    }
                    break;

                case 2:
                    // Display student data
                    System.out.println("......Display Student Data.......");
                    for (int i = 0; i < size; i++) {
                        System.out.println("Student Number : " + student[i][0]);
                        System.out.println("Student Name   : " + student[i][1]);
                        System.out.println("Student Mark   : " + student[i][2]);
                        System.out.println("---------------------------");
                    }

                    break;

                case 3:
                    // update student data
                    System.out.println(".... Update Student Data......");
                    System.out.println("Enter Student Number to Update : ");
                    String updatedValue = input.next();
                    boolean found = false;

                    int updateIndex = -1;

                    for (int i = 0; i < size; i++) {
                        if (student[i][0].equals(updatedValue)) {
                            updateIndex = i;
                            System.out.print("Enter New Student Name : ");
                            String newName = input.next();

                            System.out.print("Enter New Student Mark : ");
                            String newMark = input.next();

                            student[i][1] = newName;
                            student[i][2] = newMark;

                            System.out.println("... Student Data Updated Successfully !  ");
                            found = true;
                            break;
                        }

                    }
                    if (!found) {
                        System.out.println("Student Number not found !");
                    }

                    break;

                case 4:
                    // Delete student data
                    System.out.println("..... Delete Student Data.......");

                    System.out.print("Enter Student Number to Delete : ");
                    String deleteValue = input.next();
                    boolean isFound = false;
                    int deleteIndex = -1;

                    // shift the elements
                    // 1. find the index of the element
                    for (int i = 0; i < size - 1; i++) {
                        if (student[i][0].equals(deleteValue)) {
                            deleteIndex = i;
                            isFound = true;
                        }
                    }

                    if (isFound) {

                        // // 2. Shift the elements:

                        for (int j = deleteIndex; j < size - 1; j++) {
                            student[j][0] = student[j + 1][0];
                            student[j][1] = student[j + 1][1];
                            student[j][2] = student[j + 1][2];
                        }

                        // decrease the size
                        size--;

                        System.out.println("... Student Data Deleted Successfully !  ");

                    }

                    else {
                        System.out.println("Student Number not found !");
                    }

                    break;

                case 5:
                    userSelect = false;
                    System.out.println("Exiting the program. Goodbye!");

                    break;
                default:
                    break;
            }

        }

    }

}
