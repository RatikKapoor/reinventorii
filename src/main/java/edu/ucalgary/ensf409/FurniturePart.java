package edu.ucalgary.ensf409;

import java.util.Arrays;
import java.util.List;

public abstract class FurniturePart {
    public enum Types {
        Chair(new String[] { "Legs", "Arms", "Seat", "Cushion" }), Desk(new String[] { "Legs", "Top", "Drawer" }),
        Filing(new String[] { "Rails", "Drawers", "Cabinet" }), Lamp(new String[] { "Base", "Bulb" });

        private final List<String> properties;

        Types(String[] properties) {
            this.properties = Arrays.asList(properties);
        }

        public boolean hasProperty(String property) {
            return this.properties.contains(property);
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
