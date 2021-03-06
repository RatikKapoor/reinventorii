package edu.ucalgary.ensf409;

import java.util.ArrayList;

/**
 * Implementation of class Desk extending from FurniturePart
 * 
 * @author Robert Brown, Anand Patel, Ratik Kapoor, Risat Haque
 * @since 1.1
 *
 */
public class Desk extends FurniturePart {
    private boolean legs;
    private boolean top;
    private boolean drawer;

    /**
     * a constructor for desk with only type, used when creating a query of the the
     * object
     * 
     * @param type string type of desk
     */
    public Desk(String type) {
        super(type);
    }

    /**
     * full constructor for desk (includes all paramaters)
     * 
     * @param id     string id of desk
     * @param type   string type of desk
     * @param legs   string legs of desk (will be converted to boolean)
     * @param top    string top of desk (will be converted to boolean)
     * @param drawer string drawer of desk (will be converted to boolean)
     * @param price  int pice of desk
     * @param manuId string manufacturer id of desk
     */
    public Desk(String id, String type, String legs, String top, String drawer, int price, String manuId) {
        super(id, type, price, manuId);
        this.legs = stringToBoolean(legs);
        this.top = stringToBoolean(top);
        this.drawer = stringToBoolean(drawer);
    }

    /**
     * desk constructor from database
     * 
     * @param data  arraylist of strings from DB -> data[0] - id of item, data[1] -
     *              type of desk, data[2] - id of manufacturer, data[3] - legs?
     *              (y/n), data[4] - top? (y/n), data[5] - drawer? (y/n)
     * @param price integer price of desk
     */
    public Desk(ArrayList<String> data, int price) {
        super(data.get(0), data.get(1), price, data.get(2));
        this.legs = stringToBoolean(data.get(3));
        this.top = stringToBoolean(data.get(4));
        this.drawer = stringToBoolean(data.get(5));

        if (data.size() > 6) {
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
     * getter for top
     * 
     * @return true if top is useable, false otherwise
     */
    public boolean getTop() {
        return this.top;
    }

    /**
     * setter for top
     * 
     * @param top true if top is useable, false if not
     */
    public void setTop(Boolean top) {
        this.top = top;
    }

    /**
     * getter for drawer
     * 
     * @return true if drawer is useable, false otherwise
     */
    public boolean getDrawer() {
        return this.drawer;
    }

    /**
     * setter for drawer
     *
     * @param drawer true if drawer is useable, false if not
     */
    public void setDrawer(Boolean drawer) {
        this.drawer = drawer;
    }

    protected boolean checkType(String myType) {
        Types aType = Types.DESK;
        for (String t : aType.getList()) {
            if (t.toString().equals(myType)) {
                return true;
            }
        }
        return false;
    }

}

/**
 * an enumeration for the parts of the desk
 *
 * @author Robert Brown
 */
enum DeskParts {
    LEGS, TOP, DRAWER;

    @Override
    public String toString() {
        String first = this.name().substring(0, 1).toUpperCase();
        String second = this.name().substring(1).toLowerCase();
        return first + second;
    }
}
