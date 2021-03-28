package edu.ucalgary.ensf409;

import java.util.ArrayList;

/**
 * Implementation of class Chair extending from FurniturePart
 */
public class Chair extends FurniturePart {
    private boolean legs;
    private boolean cushion;
    private boolean arms;
    private boolean seat;

    /**
     * Constructor for Chair Class extending from FurniturePart
     * 
     * @param id
     * @param type
     * @param legs
     * @param cushion
     * @param arms
     * @param seat
     * @param price
     * @param manuid
     */
    public Chair(String id, String type, String legs, String cushion, String arms, String seat, int price,
            String manuid) {

        super(id, type, price, manuid);
        this.legs = stringToBoolean(legs);
        this.cushion = stringToBoolean(cushion);
        this.arms = stringToBoolean(arms);
        this.seat = stringToBoolean(seat);

    }

    public Chair(ArrayList<String> data, int price) {
        super(data.get(0), data.get(1), price, data.get(2));
        this.legs = stringToBoolean(data.get(3));
        this.arms = stringToBoolean(data.get(4));
        this.seat = stringToBoolean(data.get(5));
        this.cushion = stringToBoolean(data.get(6));
    }

    public Boolean getLegs() {
        return this.legs;
    }

    public void setLegs(Boolean legs) {
        this.legs = legs;
    }

    public Boolean getCushion() {
        return this.cushion;
    }

    public void setCushion(Boolean cushion) {
        this.cushion = cushion;
    }

    public Boolean getArms() {
        return this.arms;
    }

    public void setArms(Boolean arms) {
        this.arms = arms;
    }

    public Boolean getSeat() {
        return this.seat;
    }

    public void setSeat(Boolean seat) {
        this.seat = seat;
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
