package edu.ucalgary.ensf409;

import java.util.ArrayList;

/**
 * Implementation of class Filing extending from FurniturePart
 * 
 * @since 1.3
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
    public Filing(String type) {
        super(type);
    }

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

    protected boolean checkType(String myType) {
        Types aType = Types.Filing;
        for (String t : aType.getList()) {
            if (t.toString().equals(myType)) {
                return true;
            }
        }
        return false;
    }

}

// /**
// * an enumeration for filing types
// *
// * @author Robert Brown
// */
// enum FilingType {
// Small, Medium, Large;

// @Override
// public String toString() {
// return this.name().replace("_", " ");
// }
// }

// /**
// * an enumeration for the parts of the Filing
// *
// * @author Robert Brown
// */
// enum FilingParts {
// Rails, Drawers, Cabinet;

// @Override
// public String toString() {
// return this.name().toString();
// }
// }
