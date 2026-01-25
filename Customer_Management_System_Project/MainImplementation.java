package Customer_Management_System_Project;

import java.util.Scanner;

public class MainImplementation {

    // static data structures to hold users and customers
    static ArrayBag<User> usersBag = new ArrayBag<>(20);
    static QueueCustomers waitingQueue = new QueueCustomers();
    static ArrayBag<Customer> allServedCustomers = new ArrayBag<>(100);
    static Customer lastServedCustomer = null;

    static Scanner scanner = new Scanner(System.in);

    // default admin user
    static {
        usersBag.add(new User("boss", "boss123", true, true));
        usersBag.add(new User("Ahmed", "123", false, true));
        usersBag.add(new User("Sara", "123", false, true));

    }

    // main method
    public static void main(String[] args) {
        while (true) {

            System.out.println("Welcome to the Customer Management System at Paltel Palestine");
            System.out.println("Please log in to continue.");
            System.out.println("1- Press Enter to get waiting ID");
            System.out.println("2- Login as employee/admin");
            System.out.println("0- Exit");

            String input = scanner.nextLine(); // Changed to nextLine to handle "Enter" key

            if (input.equals("1") || input.isEmpty()) {
                addCustomerToQueue();
            } else if (input.equals("2")) {
                User user = userLogin();
                if (user != null) {
                    if (user.isAdmin()) {
                        adminMenu(user);
                    } else {
                        employeeMenu(user);
                    }
                }
            } else if (input.equals("0")) {
                System.out.println("Exiting the system. Goodbye!");
                break;

            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }

    }

    // add customer to queue method
    private static void addCustomerToQueue() {
        Customer newCustomer = new Customer(); // Creates customer with auto-generated ID
        waitingQueue.Enqueue(newCustomer);
        System.out.println("Your waiting ID is " + String.format("%03d", newCustomer.getId()));
        System.out.println("Please wait to be served by an employee.");
        System.out.println();
    }

    // user login method
    private static User userLogin() {
        System.out.println("Enter username : ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        for (int i = 0; i < usersBag.size(); i++) {
            User u = usersBag.getItem(i);
            if (u.getUsername().equals(username)
                    && u.getPassword().equals(password)
                    && u.isActive()) {
                return u;
            }
        }
        System.out.println("Invalid login or inactive user.");
        return null;

    }

    // employee menu method
    private static void employeeMenu(User user) {
        while (true) {
            System.out.println("\nWelcome " + user.getUsername());
            System.out.println("1- Serve next customer");
            System.out.println("2- Check last served customer");
            System.out.println("3- View all served customers");
            System.out.println("4- View a served customer issue by ID or name ");
            System.out.println("0- Logout");

            int choice = Integer.parseInt(scanner.nextLine());

            if (choice == 1) {
                // serve the next customer
                serveCustomer(user);
            } else if (choice == 2) {
                // last served customer
                Customer last = user.getServedCustomer().peek();
                System.out.println(last != null ? last : "No customers served yet.");
            }

            else if (choice == 3) {
                // view all served customers
                user.getServedCustomer().display();

            } else if (choice == 4) {
                // view customer issues by name or id
                System.out.print("Enter customer ID or Name to search: ");
                String searchInput = scanner.nextLine();
                boolean found = false;
                Stack servedStack = user.getServedCustomer();
                Stack tempStack = new Stack();

                while (!servedStack.isEmpty()) {
                    Customer cust = servedStack.pop();
                    // Try to parse as ID first, if fails, treat as name
                    boolean matches = false;
                    try {
                        int searchId = Integer.parseInt(searchInput);
                        matches = (cust.getId() == searchId);
                    } catch (NumberFormatException e) {
                        // Not a number, so search by name (case-insensitive)
                        matches = cust.getName().toLowerCase().contains(searchInput.toLowerCase());
                    }

                    if (matches) {
                        System.out.println("Customer found:");
                        System.out.println("Name: " + cust.getName());
                        System.out.println("ID: " + String.format("%03d", cust.getId()));
                        System.out.println("National ID: " + cust.getNationalId());
                        System.out.println("Address: " + cust.getAddress());
                        System.out.println("Issue: " + cust.getIssue());
                        System.out.println("Solved: " + (cust.isSolved() ? "Yes" : "No"));
                        found = true;
                    }
                    tempStack.push(cust);
                }

                // Restore the original stack
                while (!tempStack.isEmpty()) {
                    servedStack.push(tempStack.pop());
                }

                if (!found) {
                    System.out.println("Customer with ID/Name '" + searchInput + "' not found.");
                }
            }

            else if (choice == 0) {
                break;
            }
        }

    }

    private static void serveCustomer(User user) {
        Customer customer = waitingQueue.Dequeue();

        if (customer == null) {
            System.out.println("No customers in queue.");
            return;
        }

        System.out.print("Enter customer name: ");
        customer.setName(scanner.nextLine());

        System.out.print("Enter national ID: ");
        customer.setNationalId(Integer.parseInt(scanner.nextLine()));

        System.out.print("Enter address: ");
        customer.setAddress(scanner.nextLine());

        System.out.print("Enter issue description: ");
        customer.setIssue(scanner.nextLine());

        System.out.print("Is issue solved? (1: yes, 0: no): ");
        customer.setSolved(scanner.nextLine().equals("1"));

        customer.setServedBy(user.getUsername());
        user.getServedCustomer().push(customer);
        allServedCustomers.add(customer);
        lastServedCustomer = customer;

        System.out.println("Customer served successfully.");

    }

    // admin menu method
    private static void adminMenu(User user) {

        while (true) {
            System.out.println("\nWelcome Admin " + user.getUsername());
            System.out.println("1- View customers queue");
            System.out.println("2- Check last served customer and by whom he was served");
            System.out.println("3- View all customers issues");
            System.out.println("4- Manage employees");
            System.out.println("5- View Customer Service Tree");
            System.out.println("0- Logout");

            int choice = Integer.parseInt(scanner.nextLine());

            if (choice == 1) {
                // view customer queue
                waitingQueue.displayQueue();
            } else if (choice == 2) {
                // check last served customer and by who
                if (lastServedCustomer != null) {
                    System.out.println("Last served customer: " + lastServedCustomer.getName() +
                            " (ID: " + String.format("%03d", lastServedCustomer.getId()) +
                            "), served by: " + lastServedCustomer.getServedBy());
                } else {
                    System.out.println("No customers have been served yet.");
                }
            } else if (choice == 3) {
                // display all customers
                System.out.println("All served customers:");
                for (int i = 0; i < allServedCustomers.size(); i++) {
                    Customer c = allServedCustomers.getItem(i);
                    System.out.println(c.getName() + " (ID: " + String.format("%03d", c.getId()) +
                            ") - Issue: " + c.getIssue() + " - Solved: " + (c.isSolved() ? "Yes" : "No") +
                            " - Served by: " + c.getServedBy());
                }
                if (allServedCustomers.size() == 0) {
                    System.out.println("No customers have been served yet.");
                }
            } else if (choice == 4) {
                // manage employees
                System.out.println("Employee Management:");
                System.out.println("Available employees:");

                // Create a list of employees
                ArrayBag<User> employees = new ArrayBag<>(20);
                for (int i = 0; i < usersBag.size(); i++) {
                    User u = usersBag.getItem(i);
                    if (!u.isAdmin()) {
                        employees.add(u);
                        System.out.println(
                                (employees.size()) + "- " + u.getUsername() + " (Active: " + u.isActive() + ")");
                    }
                }

                if (employees.size() == 0) {
                    System.out.println("No employees found.");
                    return;
                }

                System.out.print("Select employee number: ");
                int empChoice = Integer.parseInt(scanner.nextLine());
                if (empChoice < 1 || empChoice > employees.size()) {
                    System.out.println("Invalid choice.");
                    return;
                }

                User selectedEmployee = employees.getItem(empChoice - 1);
                System.out.println("Selected: " + selectedEmployee.getUsername());
                System.out.println("What do you want to do with this employee?");
                System.out.println("1- Enable/Disable user");
                System.out.println("2- Change name");
                System.out.print("Choice: ");

                int action = Integer.parseInt(scanner.nextLine());

                if (action == 1) {
                    selectedEmployee.setActive(!selectedEmployee.isActive());
                    System.out.println("Employee " + selectedEmployee.getUsername() + " is now " +
                            (selectedEmployee.isActive() ? "enabled" : "disabled"));
                } else if (action == 2) {
                    System.out.print("Enter new username: ");
                    String newUsername = scanner.nextLine();

                    System.out
                            .println("Username changed from " + selectedEmployee.getUsername() + " to " + newUsername);
                } else {
                    System.out.println("Invalid action.");
                }

            } else if (choice == 5) {
                // View Customer Service Summary
                System.out.println("Customer Service Summary:");
                System.out.println("==========================");

                // print Manager
                for (int i = 0; i < usersBag.size(); i++) {
                    User u = usersBag.getItem(i);
                    if (u.isAdmin()) {
                        System.out.println("Manager: " + u.getUsername());
                        break; // assuming only one admin
                    }
                }

                // Print Employees and their service info
                for (int i = 0; i < usersBag.size(); i++) {
                    User u = usersBag.getItem(i);

                    // Only employees
                    if (!u.isAdmin()) {
                        System.out.println("------------------------------");
                        System.out.println("Employee: " + u.getUsername());
                        System.out.println("Active: " + (u.isActive() ? "Yes" : "No"));

                        Stack servedStack = u.getServedCustomer();

                        if (servedStack.isEmpty()) {
                            System.out.println("No customers served yet.");
                        } else {
                            Customer last = servedStack.peek(); // LIFO behavior
                            System.out.println("Total customers served: " + servedStack.size());
                            System.out.println("Last served customer:");
                            System.out.println(" - Name: " + last.getName());
                            System.out.println(" - ID: " + String.format("%03d", last.getId()));
                            System.out.println(" - Issue: " + last.getIssue());
                            System.out.println(" - Status: " + (last.isSolved() ? "Solved" : "Not Solved"));
                        }
                    }
                }

            }

            else if (choice == 0) {
                break;
            }
        }

    }

}
