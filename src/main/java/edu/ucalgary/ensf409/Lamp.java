package edu.ucalgary.ensf409;

public class Lamp extends FurniturePart {
    private Boolean base;
    private Boolean bulb;

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

    public Lamp(String id, String type, String base, String bulb, int price, String manuid) {
        super(id, type, price, manuid);
        if (base.equals("Y")) {
            this.base = true;
        } else if (base.equals("N")) {
            this.base = false;
        }
        if (bulb.equals("Y")) {
            this.bulb = true;
        } else if (bulb.equals("N")) {
            this.bulb = false;
        }

    }

    public void printLamp() {
        System.out.println(this.getId() + " " + this.getType() + " " + this.bulb + " " + this.base);
    }
}
