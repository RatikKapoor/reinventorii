package edu.ucalgary.ensf409;

public class IllegalFurnitureTypeException extends IllegalArgumentException {
    private static final long serialVersionUID = 1L;

    public IllegalFurnitureTypeException() {
        super("Check Valid Furniture Type for Furniture");
    }
}
