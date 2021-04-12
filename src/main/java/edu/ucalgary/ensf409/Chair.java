package edu.ucalgary.ensf409;

import java.util.ArrayList;

/**
 * Implementation of class Chair extending from FurniturePart
 * 
 * @since 1.3
 */
public class Chair extends FurniturePart {
    private boolean legs;
    private boolean cushion;
    private boolean arms;
    private boolean seat;

    /**
     * query constructor for chair (only requires type)
     * 
     * @param type string type of chair
     */
    public Chair(String type) {
        super(type);
    }

    /**
     * full constructor for chair (includes all paramaters)
     * 
     * @param id      string id of chair
     * @param type    string type of chair
     * @param legs    string legs of chair (will be converted to boolean)
     * @param cushion string cushion of chair (will be converted to boolean)
     * @param arms    string arms of chair (will be converted to boolean)
     * @param seat    string seat of chair (will be converted to boolean)
     * @param price   int price of chair
     * @param manuid  string manufacturer id of chair
     */
    public Chair(String id, String type, String legs, String cushion, String arms, String seat, int price,
            String manuid) {
        super(id, type, price, manuid);

        this.legs = stringToBoolean(legs);
        this.cushion = stringToBoolean(cushion);
        this.arms = stringToBoolean(arms);
        this.seat = stringToBoolean(seat);

    }

    /**
     * chair constructor from database
     * 
     * @param data  arraylist of strings from DB -> data[0] - id of item, data[1] -
     *              type of chair, data[2] - id of manufacturer, data[3] - legs?
     *              (y/n), data[4] - arms? (y/n), data[5] - seat? (y/n), data[6] -
     *              cushion? (y/n)
     * @param price integer price of chair
     */
    public Chair(ArrayList<String> data, int price) {
        super(data.get(0), data.get(1), price, data.get(2));
        this.legs = stringToBoolean(data.get(3));
        this.arms = stringToBoolean(data.get(4));
        this.seat = stringToBoolean(data.get(5));
        this.cushion = stringToBoolean(data.get(6));

        if (data.size() > 7) {
            throw new IllegalArgumentException("ArrayList is too large");
        }
    }

    /**
     * getter for legs
     * 
     * @return true if legs are usable, false otherwise
     */
    public Boolean getLegs() {
        return this.legs;
    }

    /**
     * setter for legs
     * 
     * @param legs true if legs useable, false otherwise
     */
    public void setLegs(Boolean legs) {
        this.legs = legs;
    }

    /**
     * getter for cushion
     * 
     * @return true if cushion are usable, false otherwise
     */
    public Boolean getCushion() {
        return this.cushion;
    }

    /**
     * setter for cushion
     * 
     * @param cushion true if cushion useable, false if not
     */
    public void setCushion(Boolean cushion) {
        this.cushion = cushion;
    }

    /**
     * getter for arms
     * 
     * @return true if arms are usable, false otherwise
     */
    public Boolean getArms() {
        return this.arms;
    }

    /**
     * setter for arms
     * 
     * @param arms true if arms are useable, false if not
     */
    public void setArms(Boolean arms) {
        this.arms = arms;
    }

    /**
     * getter for seat
     * 
     * @return true if seat is useable, false otherwise
     */
    public Boolean getSeat() {
        return this.seat;
    }

    /**
     * setter for seat
     * 
     * @param seat true if seat is useable, false if not
     */
    public void setSeat(Boolean seat) {
        this.seat = seat;
    }

    protected boolean checkType(String myType) {
        Types aType = Types.CHAIR;
        for (String t : aType.getList()) {
            if (t.toString().equals(myType)) {
                return true;
            }
        }
        return false;
    }

}

/**
 * an enumeration for the types of chairs
 *
 * @author Robert Brown
 */
enum ChairType {
    Kneeling, Task, Mesh, Ergonomic, Executive;

    @Override
    public String toString() {
        return this.name().replace("_", " ");
    }
}

/**
 * an enumeration for the parts of the chair
 *
 * @author Robert Brown
 */
enum ChairParts {
    Legs, Cushion, Arms, Seat;

    @Override
    public String toString() {
        return this.name().toString();
    }
}