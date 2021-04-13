package edu.ucalgary.ensf409;

import java.util.ArrayList;

/**
 * Implementation of class Lamp extending from Furniture Part
 * 
 * @author Robert Brown, Ratik Kapoor, Risat Haque, Anand Patel
 * @since 1.2
 */
public class Lamp extends FurniturePart {
    private boolean base;
    private boolean bulb;

    /**
     * query constructor for lamp (only requires type)
     * 
     * @param type string type of lamp
     */
    public Lamp(String type) {
        super(type);
    }

    /**
     * full constructor for lamp (includes all paramaters)
     * 
     * @param id     string id of lamp
     * @param type   string type of lamp
     * @param base   string base of lamp (will be converted to boolean)
     * @param bulb   stirng bulb of lamp (will be converted to boolean)
     * @param price  int price of lamp
     * @param manuid string manufacturer id of lamp
     */
    public Lamp(String id, String type, String base, String bulb, int price, String manuid) {
        super(id, type, price, manuid);

        this.base = stringToBoolean(base);
        this.bulb = stringToBoolean(bulb);
    }

    /**
     * lamp constructor from database
     * 
     * @param data  arraylist of strings from DB -> data[0] - id of item, data[1] -
     *              type of lamp, data[2] - id of manufacturer, data[3] - base?
     *              (y/n), bulb? (y/n)
     * @param price integer price of lamp
     */
    public Lamp(ArrayList<String> data, int price) {
        super(data.get(0), data.get(1), price, data.get(2));

        this.base = stringToBoolean(data.get(3));
        this.bulb = stringToBoolean(data.get(4));

        if (data.size() > 5) {
            throw new IllegalArgumentException("ArrayList is too Large");
        }
    }

    /**
     * getter for base
     * 
     * @return true if base is useable, false otherwise
     */
    public boolean getBase() {
        return this.base;
    }

    /**
     * setter for base
     * 
     * @param base true if base is useable, false if not
     */
    public void setBase(Boolean base) {
        this.base = base;
    }

    /**
     * getter for bulb
     * 
     * @return true if bulb is useable, false othewise
     */
    public boolean getBulb() {
        return this.bulb;
    }

    /**
     * setter for bulb
     * 
     * @param bulb true if bulb is useable, false if not
     */
    public void setBulb(Boolean bulb) {
        this.bulb = bulb;
    }

    /**
     * a helper functiont o print the data of a bulb to console
     * 
     * used in debugging
     */
    public void printLamp() {
        System.out.println(this.getId() + " " + this.getType() + " " + this.bulb + " " + this.base);
    }

    protected boolean checkType(String myType) {
        Types aType = Types.LAMP;
        for (String t : aType.getList()) {
            if (t.toString().equals(myType)) {
                return true;
            }
        }
        return false;
    }
}

/**
 * an enumeration for the parts of the lamp
 *
 * @author Robert Brown
 */
enum LampParts {
    BASE, BULB;

    @Override
    public String toString() {
        String first = this.name().substring(0, 1).toUpperCase();
        String second = this.name().substring(1).toLowerCase();
        return first + second;
    }
}