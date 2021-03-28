package edu.ucalgary.ensf409;

import java.util.ArrayList;

/**
 * Implementation of class Desk extending from FurniturePart
 */
public class Desk extends FurniturePart {
    private boolean legs;
    private boolean top;
    private boolean drawer;

    /**
     * Constructor for Chair
     * 
     * @param id
     * @param type
     * @param legs
     * @param top
     * @param drawer
     * @param price
     * @param manuID
     */
    public Desk(String id, String type, String legs, String top, String drawer, int price, String manuID) {
        super(id, type, price, manuID);
        this.legs = stringToBoolean(legs);
        this.top = stringToBoolean(top);
        this.drawer = stringToBoolean(drawer);
    }

    public Desk(ArrayList<String> data, int price) {
        super(data.get(0), data.get(1), price, data.get(2));
        this.legs = stringToBoolean(data.get(3));
        this.top = stringToBoolean(data.get(4));
        this.drawer = stringToBoolean(data.get(5));
    }

    public boolean getLegs() {
        return this.legs;
    }

    public void setLegs(Boolean legs) {
        this.legs = legs;
    }

    public boolean getTop() {
        return this.top;
    }

    public void setTop(Boolean top) {
        this.top = top;
    }

    public boolean getDrawer() {
        return this.drawer;
    }

    public void setDrawer(Boolean drawer) {
        this.drawer = drawer;
    }

}

/**
 * an enumeration for desk types
 * 
 * @author Robert Brown
 */
enum DeskType {
    Standing, Adjustable, Traditional;

    @Override
    public String toString() {
        return this.name().replace("_", " ");
    }
}
