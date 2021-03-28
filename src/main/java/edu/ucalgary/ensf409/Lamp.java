package edu.ucalgary.ensf409;

import java.util.ArrayList;

public class Lamp extends FurniturePart {
    private Boolean base;
    private Boolean bulb;
    private static String[] lampParts = { "base", "bulb " };

    public Boolean getBase() {
        return this.base;
    }

    public void setBase(Boolean base) {
        this.base = base;
    }

    public Boolean getBulb() {
        return this.bulb;
    }

    public void setBulb(Boolean bulb) {
        this.bulb = bulb;
    }

    public Lamp(String type) {
        super(type);
    }

    public Lamp(ArrayList<String> data, int price) {
        super(data.get(0), data.get(1), price, data.get(4), lampParts);
        if (data.get(2).equals("Y")) {
            this.base = true;
        } else if (data.get(2).equals("N")) {
            this.base = false;
        }
        if (data.get(3).equals("Y")) {
            this.bulb = true;
        } else if (data.get(3).equals("N")) {
            this.bulb = false;
        }
    }

    public Lamp(String id, String type, String base, String bulb, int price, String manuid) {
        super(id, type, price, manuid);
        // if (base.equals("Y")) {
        // this.base = true;
        // } else if (base.equals("N")) {
        // this.base = false;
        // }
        // if (bulb.equals("Y")) {
        // this.bulb = true;
        // } else if (bulb.equals("N")) {
        // this.bulb = false;
        // }

        this.base = stringToBoolean(base);
        this.bulb = stringToBoolean(bulb);

    }

    public void printLamp() {
        System.out.println(this.getId() + " " + this.getType() + " " + this.bulb + " " + this.base);
    }
}
