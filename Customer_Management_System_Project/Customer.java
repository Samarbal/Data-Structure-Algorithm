package Customer_Management_System_Project;

public class Customer {

    // Customer attributes

    private static int waitingId = 1; // Static variable to generate unique waiting IDs

    private int id;
    private String name;
    private int nationalId;
    private String address;
    private String issue;
    private boolean solved;
    private String servedBy;

    // Constructor
    public Customer(String name, int nationalId, String address, String issue) {
        this.id = waitingId++;
        this.name = name;
        this.nationalId = nationalId;
        this.address = address;
        this.issue = issue;
        this.solved = false; // Initially not solved
        this.servedBy = ""; // No one has served the customer yet
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getNationalId() {
        return nationalId;
    }

    public String getAddress() {
        return address;
    }

    public String getIssue() {
        return issue;
    }

    public boolean isSolved() {
        return solved;
    }

    public String getServedBy() {
        return servedBy;
    }

    public void setSolved(boolean solved) {
        this.solved = solved;
    }

    public void setServedBy(String servedBy) {
        this.servedBy = servedBy;
    }

    @Override
    public String toString() {
        return "Customer ID: \"%03d\" " + id + ", Name: " + name + ", National ID: " + nationalId +
                ", Address: " + address + ", Issue: " + issue + ", Solved: " + solved +
                ", Served By: " + servedBy;
    }

}
