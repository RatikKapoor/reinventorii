package edu.ucalgary.ensf409;

import java.util.ArrayList;

/**
 * Implementation of class Filing extending from FurniturePart
 * 
 * @author Robert Brown, Anand Patel, Ratik Kapoor, Risat Haque
 * @since 1.1
 */
public class Filing extends FurniturePart {
    private boolean rails;
    private boolean drawers;
    private boolean cabinet;

    /**
     * Constructor for Filing
     * 
     * @param type
     */
    public Filing(String type) {
        super(type);
    }

    /**
     * Constructor for Filing with all accepted arguments needed for Filing and
     * Furniture Part.
     * 
     * @param id
     * @param type
     * @param rails
     * @param drawers
     * @param cabinet
     * @param price
     * @param manuId
     */
    public Filing(String id, String type, String rails, String drawers, String cabinet, int price, String manuId) {
        super(id, type, price, manuId);
        this.rails = stringToBoolean(rails);
        this.drawers = stringToBoolean(drawers);
        this.cabinet = stringToBoolean(cabinet);
    }

    /**
     * Query Constructor for Filing
     * 
     * @param data
     * @param price
     */
    public Filing(ArrayList<String> data, int price) {
        super(data.get(0), data.get(1), price, data.get(2));
        this.rails = stringToBoolean(data.get(3));
        this.drawers = stringToBoolean(data.get(4));
        this.cabinet = stringToBoolean(data.get(5));

        if (data.size() > 6) {
            throw new IllegalArgumentException("ArrayList is too Large");
        }
    }

    /**
     * @return rails. Y is true, N is false
     */
    public boolean getRails() {
        return this.rails;
    }

    /**
     * Setter Method
     * 
     * @param rails
     */
    public void setRails(Boolean rails) {
        this.rails = rails;
    }

    /**
     * @return drawers. Y is true, N is false
     */
    public boolean getDrawers() {
        return this.drawers;
    }

    /**
     * Setter Method
     * 
     * @param drawers
     */
    public void setDrawers(Boolean drawers) {
        this.drawers = drawers;
    }

    /**
     * @return cabinet. Y is true, N is false
     */
    public boolean getCabinet() {
        return this.cabinet;
    }

    /**
     * Setter Method
     * 
     * @param cabinet
     */
    public void setCabinet(Boolean cabinet) {
        this.cabinet = cabinet;
    }

    /**
     * Checks the type and matches with FurniturePart embedded Enum.
     * 
     * @param myType
     * @return type of Furniture. True if it exists with Enum in FurniturePart.
     *         False otherwise
     */
    protected boolean checkType(String myType) {
        Types aType = Types.FILING;
        for (String t : aType.getList()) {
            if (t.toString().equals(myType)) {
                return true;
            }
        }
        return false;
    }

}

/**
 * an enumeration for the parts of the Filing
 *
 * @author Robert Brown
 */
enum FilingParts {
    RAILS, DRAWERS, CABINET;

    @Override
    public String toString() {
        String first = this.name().substring(0, 1).toUpperCase();
        String second = this.name().substring(1).toLowerCase();
        return first + second;
    }
}
