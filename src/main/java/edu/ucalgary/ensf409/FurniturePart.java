package edu.ucalgary.ensf409;

public abstract class FurniturePart {
    private String id;
    private String type;
    private int price;
    private String ManuID;

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

    public FurniturePart(String id, String type, int price, String ManuID) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.ManuID = ManuID;
    }
}
