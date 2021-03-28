package edu.ucalgary.ensf409;

public abstract class FurniturePart {
    private String id;
    private String type;
    private int price;
    private String ManuID;
    public String[] params;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getManuID() {
        return this.ManuID;
    }

    public void setManuID(String ManuID) {
        this.ManuID = ManuID;
    }

    public FurniturePart(String type) {
        this.type = type;
    }

    public FurniturePart(String id, String type, int price, String ManuID, String[] params) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.ManuID = ManuID;
        this.params = params;
    }

    /**
     * stringToBoolean converts "Y" into true, everything else into false
     * 
     * @param input
     * @return
     */
    protected boolean stringToBoolean(String input) {
        if (input.equals("Y")) {
            return true;
        }
        return false;
    }
}
