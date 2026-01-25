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



    // Constructor for initial queue addition (only generates ID)
    public Customer() {
        this.id = waitingId++;
        this.name = "";
        this.nationalId = 0;
        this.address = "";
        this.issue = "";
        this.solved = false;
        this.servedBy = "";
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

    public void setName (String name ){
        this.name = name ; 
    }
     public void setNationalId (int  id  ){
        this.nationalId = id ; 
    }
     public void setAddress (String address ){
        this.address= address ; 
    }

     public void setIssue (String issue ){
        this.issue= issue ;}
        
    public void setSolved(boolean solved) {
        this.solved = solved;
    }


    public void setServedBy(String servedBy) {
        this.servedBy = servedBy;
    }

@Override
public String toString() {
    return "Customer ID: " + String.format("%03d", id) +
           ", Name: " + name +
           ", National ID: " + nationalId +
           ", Address: " + address +
           ", Issue: " + issue +
           ", Solved: " + (solved ? "Yes" : "No") +
           ", Served By: " + servedBy;
}

}
