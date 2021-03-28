package edu.ucalgary.ensf409;

import java.util.ArrayList;

/**
 * Implementation of class Filing extending from FurniturePart
 */
public class Filing extends FurniturePart {
    private boolean rails;
    private boolean drawers;
    private boolean cabinet;

    /**
     * Constructor for Filing
     * 
     * @param id
     * @param type
     * @param rails
     * @param cabinets
     * @param cabinet
     * @param price
     * @param manuID
     */
    public Filing(String id, String type, String rails, String drawers, String cabinet, int price, String manuID) {
        super(id, type, price, manuID);
        this.rails = stringToBoolean(rails);
        this.drawers = stringToBoolean(drawers);
        this.cabinet = stringToBoolean(cabinet);
    }

    public Filing(ArrayList<String> data, int price) {
        super(data.get(0), data.get(1), price, data.get(2));
        this.rails = stringToBoolean(data.get(3));
        this.drawers = stringToBoolean(data.get(4));
        this.cabinet = stringToBoolean(data.get(5));
    }

    public boolean getRails() {
        return this.rails;
    }

    public void setRails(Boolean rails) {
        this.rails = rails;
    }

    public boolean getDrawers() {
        return this.drawers;
    }

    public void setDrawers(Boolean drawers) {
        this.drawers = drawers;
    }

    public boolean getCabinet() {
        return this.cabinet;
    }

    public void setCabinet(Boolean cabinet) {
        this.cabinet = cabinet;
    }

}

/**
 * an enumeration for filing types
 * 
 * @author Robert Brown
 */
enum FilingType {
    Small, Medium, Large;

    @Override
    public String toString() {
        return this.name().replace("_", " ");
    }
}
