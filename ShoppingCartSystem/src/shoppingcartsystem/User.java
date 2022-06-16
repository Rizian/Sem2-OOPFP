package shoppingcartsystem;

public class User {
    // Attributes
    private String fname;   // Firstname
    private String lname;   // Lastname
                            // Names are separated to make formatting easier
                            // in places where only either one is needed to
                            // be shown.
    private long ID;    // ID for storing / avoiding name collisions
    private double balance;     // User's balance
    
    // Constructor
    User(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
    }
    
    // Methods
    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public long getID() {
        return ID;
    }

    public double getBalance() {
        return balance;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public void addBalance(double toAdd) {      // adds the specified amount to balance
        this.balance += toAdd;
    }
    
    public void subtractBalance(double toSubt) {    // subtracts the specified amount from balance
        if (toSubt > this.balance) {    
            return;             // does nothing if the amount to be subtracted
        }                       // is greater than the amount in the balance
        this.balance -= toSubt;
    }
    
}
