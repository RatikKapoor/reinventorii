package edu.ucalgary.ensf409;

import java.util.Arrays;
import java.util.List;

public abstract class FurniturePart {
    public enum Types {
        Chair(new String[] { "Task", "Mesh", "Kneeling", "Executive", "Ergonomic" }),
        Desk(new String[] { "Traditional", "Adjustable", "Standing" }),
        Filing(new String[] { "Small", "Medium", "Large" }), Lamp(new String[] { "Desk", "Swing Arm", "Study" });

        private final List<String> types;

        Types(String[] types) {
            this.types = Arrays.asList(types);
        }

        public boolean hasType(String type) {
            return this.types.contains(type);
        }

        @Override
        public String toString() {
            return this.name();
        }
    }

    private String id;
    private String type;
    private int price;
    private String ManuID;

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
        return this.ManuID;
    }

    public void setManuID(String ManuID) {
        this.ManuID = ManuID;
    }

    public FurniturePart(String type) {
        this.type = type;
    }

    public FurniturePart(String id, String type, int price, String ManuID) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.ManuID = ManuID;
    }

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
