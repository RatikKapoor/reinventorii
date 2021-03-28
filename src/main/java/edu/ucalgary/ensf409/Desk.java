package edu.ucalgary.ensf409;

/**
 * Implementation of class Desk extending from FurniturePart
 */
public class Desk extends FurniturePart {
    private boolean legs;
    private boolean top;
    private boolean drawer;
    private static String[] deskParts = { "legs", "top", "drawer" };

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

        super(id, type, price, manuID, deskParts);
        this.legs = stringToBoolean(legs);
        this.top = stringToBoolean(top);
        this.drawer = stringToBoolean(drawer);

    }

    public Boolean getLegs() {
        return this.legs;
    }

    public void setLegs(Boolean legs) {
        this.legs = legs;
    }

    public Boolean getTop() {
        return this.top;
    }

    public void setTop(Boolean top) {
        this.top = top;
    }

    public Boolean getDrawer() {
        return this.drawer;
    }

    public void setDrawer(Boolean drawer) {
        this.drawer = drawer;
    }

}
