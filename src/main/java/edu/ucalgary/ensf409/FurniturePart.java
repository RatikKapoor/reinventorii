package edu.ucalgary.ensf409;

import java.util.Arrays;
import java.util.List;

/**
 * FurniturePart: Abstract class for furniture items such as Chair, Desk, Filing
 * and Lamp. Contains an ENUM with respective furniture types.
 * 
 * @author Risat Haque, Robert Brown, Anand Patel, Ratik Kapoor
 * @since 1.1
 */
public abstract class FurniturePart {

    /**
     * Types enum includes furniture part types.
     */
    public enum Types {
        CHAIR(new String[] { "Task", "Mesh", "Kneeling", "Executive", "Ergonomic" }),
        DESK(new String[] { "Traditional", "Adjustable", "Standing" }),
        FILING(new String[] { "Small", "Medium", "Large" }), LAMP(new String[] { "Desk", "Swing Arm", "Study" });

        /**
         * @param input
         * @return
         * @throws IllegalFurnitureTypeException
         */
        public static Types fromString(String input) throws IllegalFurnitureTypeException {
            for (Types t : Types.values()) {
                if (t.toString().toLowerCase().contains(input.toLowerCase())) {
                    return t;
                }
            }
            throw new IllegalFurnitureTypeException();
        }

        private final List<String> types;

        /**
         * @param types
         */
        Types(String[] types) {
            this.types = Arrays.asList(types);
        }

        /**
         * @param type
         * @return true if type exists
         */
        public boolean hasType(String type) {
            return this.types.contains(type);
        }

        /**
         * @return List as a string of types
         */
        public List<String> getList() {
            return this.types;
        }

        /**
         * @return string of name
         */
        @Override
        public String toString() {
            return this.name();
        }
    }

    private String id;
    private String type;
    private int price;
    private String manuID;

    /**
     * @return id
     */
    public String getId() {
        return this.id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return a string for type
     */
    public String getType() {
        return this.type;
    }

    /**
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return price as int
     */
    public int getPrice() {
        return this.price;
    }

    /**
     * @param price
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * @return manuID as a string
     */
    public String getManuID() {
        return this.manuID;
    }

    /**
     * @param manuID
     */
    public void setManuID(String manuID) {
        this.manuID = manuID;
    }

    /**
     * Throws Custom Exception when furnitureType does not match existing enums
     * 
     * @param type
     */
    public FurniturePart(String type) {
        if (!checkType(type)) {
            throw new IllegalFurnitureTypeException();
        }
        this.type = type;
    }

    /**
     * Standard Constructor
     * 
     * @param id
     * @param type
     * @param price
     * @param manuID
     */
    public FurniturePart(String id, String type, int price, String manuID) {

        if (!checkType(type)) {
            throw new IllegalFurnitureTypeException();
        }

        this.id = id;
        this.type = type;
        this.price = price;
        this.manuID = manuID;
    }

    /**
     * Abstract protected method to determine whether Furniture Type matches Types
     * Enum. Only accessible by children, hence protected.
     * 
     * @param myType
     * @return boolean. True if type is valid, False if type is invalid.
     */
    abstract protected boolean checkType(String myType);

    /**
     * stringToBoolean converts "Y" into true, everything else into false
     * 
     * @param input
     * @return
     */
    protected boolean stringToBoolean(String input) {
        if (input.equals("Y")) {
            return true;
        }
        return false;
    }
}
