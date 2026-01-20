package Customer_Management_System_Project;

public class User {

    // User attributes
    private String username;
    private String password;
    private boolean isAdmin;
    private boolean isActive;

    // Constructor
    public User(String username, String password, boolean isAdmin, boolean isActive) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
        this.isActive = isActive;
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

    @Override
    public String toString() {
        return "Username: " + username + ", Is Admin: " + isAdmin + ", Is Active: " + isActive;
    }

}
