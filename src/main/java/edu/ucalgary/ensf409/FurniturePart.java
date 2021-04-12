package edu.ucalgary.ensf409;

import java.util.Arrays;
import java.util.List;

/**
 * @since 1.1
 */
public abstract class FurniturePart {
    public enum Types {
        CHAIR(new String[] { "Task", "Mesh", "Kneeling", "Executive", "Ergonomic" }),
        DESK(new String[] { "Traditional", "Adjustable", "Standing" }),
        FILING(new String[] { "Small", "Medium", "Large" }), LAMP(new String[] { "Desk", "Swing Arm", "Study" });

        public static Types fromString(String input) {
            for (Types t : Types.values()) {
                if (t.toString().toLowerCase().contains(input.toLowerCase())) {
                    return t;
                }
            }
            return null;
        }

        private final List<String> types;

        Types(String[] types) {
            this.types = Arrays.asList(types);
        }

        public boolean hasType(String type) {
            return this.types.contains(type);
        }

        public List<String> getList() {
            return this.types;
        }

        @Override
        public String toString() {
            return this.name();
        }
    }

    private String id;
    private String type;
    private int price;
    private String manuID;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getManuID() {
        return this.manuID;
    }

    public void setManuID(String manuID) {
        this.manuID = manuID;
    }

    public FurniturePart(String type) {
        if (!checkType(type)) {
            throw new IllegalFurnitureTypeException();
        }
        this.type = type;
    }

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
