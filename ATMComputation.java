/*
* This is the ATMComputation class
* This class contains methods necessary for the ATM logic
* */

public class ATMComputation {

    // private User user = new User(20000, "John Caesar Patac"); // new instance of user class
    private User user = new User();

    /*
    * Create an array of notes
    * Each note has quantity = 100
    * */
    private Note[] notes = {new Note(1000, 100), new Note(500, 100),
            new Note(200, 100), new Note(100, 100),
            new Note(50, 100), new Note(20, 100)};


    /*
    * Main Logic for ATM
    * */
    public void withdraw(int amount) {

        /*
        * Statement checks for ATM balance
        * */
        if (validWithdraw(amount)) {
            System.out.println("The amount exceeds the ATM balance!");
            return;
        }

        int totalNotes = 0;
        int copy = amount;
        int total = 0;
        int currVal;
        int count;

        System.out.println("\nDENOMINATIONS:\n");

        for (int i = 0; i < notes.length; i++) { // traverse the Array of notes
            if (amount == 0) { // break loop if amount is already zero
                break;
            }
            if (notes[i].getQuantity() > 0) { // check if the current note has more than 1 quantity
                currVal = notes[i].getValue();
                count = amount / currVal; // number of denominations for the current note

                /*
                * This statement checks if I can still divide the amount if current denomination quantity is subtracted to it
                * For example if amount = 60, checks if I can use 1 x 50 to divide the amount
                * This is not possible because if we use 1 x 50, we can't cater the remaining amount which is 10
                * Since we can't do that, we have to use another note to divide 60 and that's 3 x 20
                * */
                if (amount - (count * currVal) != 20 && amount - (count * currVal) < 40 && amount - (count * currVal) > 0) {
                    count--;
                }

                /*
                * Print denomination if count is more than zero
                * */
                if (count > 0) {
                    if (count <= notes[i].getQuantity()) { // checks if the current quantity of the note can sustain the needed denomination
                        amount -= (count * currVal); // decrement the amount based on the quantity of note needed
                        total += (count * currVal);
                        printResult(currVal, count);
                        totalNotes += count;
                        notes[i].setQuantity(notes[i].getQuantity() - count); // decrement the quantity of notes

                    }else { // if quantity of notes can't sustain the needed note
                        amount -= (notes[i].getQuantity() * currVal); // decrement amount based on all the remaining quantity of note
                        total += (notes[i].getQuantity() * currVal);
                        printResult(currVal, notes[i].getQuantity());
                        totalNotes += notes[i].getQuantity();
                        notes[i].setQuantity(0); // use all the quantity of that note
                    }
                }
            }
        }

        /*
        * Print the total amount, total number of notes used and the new balance of the user
        * */
        System.out.println("--------------------------------");
        System.out.println("TOTAL\t\t\t = " + total);
        System.out.println("--------------------------------");
        System.out.println("Number of Notes\t\t = " + totalNotes);
        user.setAccountBalance(user.getAccountBalance() - copy);
        System.out.println("\nNew Balance: " + user.getAccountBalance());
        System.out.println("--------------------------------\n");
    }

    private boolean validWithdraw(int withdrawAmount) {
        int atmTotalValue = 0;
        for (int i = 0; i < notes.length; i++) {
            atmTotalValue += (notes[i].getValue() * notes[i].getQuantity());
        }
        return (withdrawAmount > atmTotalValue);
    }

    private void printResult(int value, int quantity) {
        System.out.println(value + "\tx\t" + quantity + "\t = " + value * quantity);
        
        /* Better UI for IntelliJ
        if (Integer.toString(value).length() > 3) {
            System.out.println(value + "\tx\t" + quantity + "\t = " + value * quantity);
        }else {
            System.out.println(value + "\t\tx\t" + quantity + "\t = " + value * quantity);
        }
        */
    }

    public User getUser() {
        return user;
    }
}
