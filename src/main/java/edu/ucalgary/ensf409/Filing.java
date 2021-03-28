package edu.ucalgary.ensf409;

/**
 * Implementation of class Filing extending from FurniturePart
 */
public class Filing extends FurniturePart {
    private boolean rails;
    private boolean cabinets;
    private boolean cabinet;

    /**
     * Constructor for Filing
     * 
     * @param id
     * @param type
     * @param rails
     * @param cabinets
     * @param cabinet
     * @param price
     * @param manuID
     */
    public Filing(String id, String type, String rails, String cabinets, String cabinet, int price, String manuID) {

        super(id, type, price, manuID);
        this.rails = stringToBoolean(rails);
        this.cabinets = stringToBoolean(cabinets);
        this.cabinet = stringToBoolean(cabinet);

    }

    public Boolean getRails() {
        return this.rails;
    }

    public void setRails(Boolean rails) {
        this.rails = rails;
    }

    public Boolean getCabinets() {
        return this.cabinets;
    }

    public void setCabinets(Boolean cabinets) {
        this.cabinets = cabinets;
    }

    public Boolean getCabinet() {
        return this.cabinet;
    }

    public void setCabinet(Boolean cabinet) {
        this.cabinet = cabinet;
    }

}
