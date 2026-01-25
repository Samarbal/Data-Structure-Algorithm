package Customer_Management_System_Project;

public class User {

    // User attributes
    private String username;
    private String password;
    private boolean isAdmin;
    private boolean isActive;
    private Stack serverdCustomers;

    // Constructor
    public User(String username, String password, boolean isAdmin, boolean isActive) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
        this.isActive = isActive;
        this.serverdCustomers = new Stack();

    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Stack getServedCustomer() {
        return serverdCustomers;
    }

}
