/*
* This is the ATM class
* Main Class
* Ask the user for a valid input
* */

import java.util.Scanner;

public class ATM {

    private ATMComputation atmComputation = new ATMComputation(); // new instance of ATMComputation class

    /*
    * Main Method
    * */
    public static void main(String[] args) throws InterruptedException {
        ATM atm = new ATM(); // new instance of ATM class
        System.out.println("Welcome " + atm.getAtmComputation().getUser().getName());
        System.out.println("Your current balance is " + atm.getAtmComputation().getUser().getAccountBalance());
        atm.askInput(); // ask for valid input
    }

    /*
    * Method for asking user input
    * */
    private void askInput() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        if (atmComputation.getUser().getAccountBalance() < 20) {
            System.out.println("You don't have enough balance to withdraw!");
            System.out.println("Terminating...");
            Thread.sleep(1500);
            System.exit(0);
        }

        System.out.println("Enter amount to withdraw (Enter e to exit): ");
        int withdrawAmount = 0;

        String errorMessage = "Invalid amount! Please enter a valid value...";

        try { // ask user for valid integer input
            withdrawAmount = scanner.nextInt();
        }catch (Exception e) { // print the invalid message if user enters invalid input
            if (scanner.next().toLowerCase().equals("e")) {
                System.out.println("Terminating...");
                Thread.sleep(1500);
                System.exit(0);
            }
            System.out.println(errorMessage);
            askInput();
        }

        /*
        * This statement checks if the input is a valid input for the ATM
        * */
        if (withdrawAmount % 10 != 0 || (withdrawAmount < 40 && withdrawAmount != 20) || withdrawAmount > atmComputation.getUser().getAccountBalance()) {
            System.out.println(errorMessage);
            askInput();
        }

        /*
        * Call withdraw method
        * */
        atmComputation.withdraw(withdrawAmount);

        /*
        * Ask user for another transaction
        * */
        askUser();
    }

    /*
    * Method for asking user for another transaction
    * */
    private void askUser() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to process another transaction? (y/n)");
        String answer = scanner.next();
        String strYes = "y";
        String strNo = "n";
        if (answer.toLowerCase().equals(strYes)) {
            askInput();
        }else if (answer.toLowerCase().equals(strNo)) {
            System.exit(0);
        }else {
            askUser();
        }
    }

    /*
    * Getters and Setters
    * */

    public ATMComputation getAtmComputation() {
        return atmComputation;
    }
}
