package edu.ucalgary.ensf409;

/**
 * IllegalFurnitureTypeException: Custom Exception for better testing and future
 * implementation.
 * 
 * @author Risat Haque, Anand Patel, Robert Brown, Ratik Kapoor
 * @since 1.1
 */
public class IllegalFurnitureTypeException extends IllegalArgumentException {
    private static final long serialVersionUID = 1L;

    public IllegalFurnitureTypeException() {
        super("Check Valid Furniture Type for Furniture");
    }
}
