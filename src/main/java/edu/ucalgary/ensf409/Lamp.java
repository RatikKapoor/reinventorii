package edu.ucalgary.ensf409;

import java.util.ArrayList;

public class Lamp extends FurniturePart {
    private boolean base;
    private boolean bulb;

    public boolean getBase() {
        return this.base;
    }

    public void setBase(Boolean base) {
        this.base = base;
    }

    public boolean getBulb() {
        return this.bulb;
    }

    public void setBulb(Boolean bulb) {
        this.bulb = bulb;
    }

    public Lamp(String type) {
        super(type);
    }

    public Lamp(ArrayList<String> data, int price) {
        super(data.get(0), data.get(1), price, data.get(2));

        this.base = stringToBoolean(data.get(3));
        this.bulb = stringToBoolean(data.get(4));
    }

    public Lamp(String id, String type, String base, String bulb, int price, String manuid) {
        super(id, type, price, manuid);

        this.base = stringToBoolean(base);
        this.bulb = stringToBoolean(bulb);
    }

    public void printLamp() {
        System.out.println(this.getId() + " " + this.getType() + " " + this.bulb + " " + this.base);
    }
}

/**
 * an enumeration for lamp types
 * 
 * @author Robert Brown, Ratik Kapoor
 */
enum LampType {
    Desk, Study, Swing_Arm;

    @Override
    public String toString() {
        return this.name().replace("_", " ");
    }
}
