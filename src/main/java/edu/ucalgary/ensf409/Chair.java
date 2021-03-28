package edu.ucalgary.ensf409;

/**
 * Implementation of class Chair extending from FurniturePart
 */
public class Chair extends FurniturePart {
    private boolean legs;
    private boolean cushion;
    private boolean arms;
    private boolean seat;
    private static String[] chairParts = { "legs", "cushion", "arms", "seat" };

    /**
     * Constructor for Chair Class
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

        super(id, type, price, manuid, chairParts);
        this.legs = stringToBoolean(legs);
        this.cushion = stringToBoolean(cushion);
        this.arms = stringToBoolean(arms);
        this.seat = stringToBoolean(seat);

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
