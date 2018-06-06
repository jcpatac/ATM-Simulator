/*
* This class is the User class
* This class designs the attributes of a user
* */

public class User {

    private int accountBalance; // Account Balance of a user
    private String name; // The Name of the user

    // public User(int accountBalance, String name) { // Constructor
    //     this.accountBalance = accountBalance;
    //     this.name = name;
    // }

    /*
    * Getters and Setters
    * */

    public int getAccountBalance() {
        return accountBalance;
    }

    public String getName() {
        return name;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void setName(String name) {
        this.name = name;
    }
}
