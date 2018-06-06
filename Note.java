/*
* This class is the Note class
* This class designs the attribute of a certain Note
* */

public class Note {

    private int value; // The value of the note
    private int quantity; // The quantity of the note

    public Note(int value, int quantity) { // constructor
        this.value = value;
        this.quantity = quantity;
    }

    /*
    * Getters and Setters
    * */

    public int getValue() {
        return value;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
