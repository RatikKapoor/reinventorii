package edu.ucalgary.ensf409;

/**
 * Custom class for a custom error
 * 
 * @author Risat Haque, Ratik Kapoor, Robert Brown, Anand Patel
 * @since 1.0
 */
public class IllegalFurnitureTypeException extends IllegalArgumentException {
    private static final long serialVersionUID = 1L;

    public IllegalFurnitureTypeException() {
        super("Check Valid Furniture Type for Furniture");
    }
}
