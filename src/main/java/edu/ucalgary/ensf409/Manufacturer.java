package edu.ucalgary.ensf409;

import java.util.ArrayList;

/**
 * A class for a manufacturer
 * 
 * @author Robert Brown, Risat Haque, Anand Patel, Ratik Kapoor
 * @since 1.1
 */
public class Manufacturer {
    private String manuId;
    private String name;
    private String phone;
    private String province;
    private ArrayList<FurniturePart.Types> types;

    public ArrayList<FurniturePart.Types> getTypes() {
        return this.types;
    }

    public void setTypes(ArrayList<FurniturePart.Types> types) {
        this.types = types;
    }

    public String getManuId() {
        return this.manuId;
    }

    public void setManuId(String manuId) {
        this.manuId = manuId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProvince() {
        return this.province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * a constructor for manufacturer with ArrayList Types
     * 
     * @param manuId
     * @param name
     * @param phone
     * @param province
     * @param types
     */
    public Manufacturer(String manuId, String name, String phone, String province,
            ArrayList<FurniturePart.Types> types) {
        this.manuId = manuId;
        this.name = name;
        this.phone = phone;
        this.province = province;
        this.types = types;
    }

    /**
     * Constructor without ArrayList Types
     * 
     * @param manuId
     * @param name
     * @param phone
     * @param province
     */
    public Manufacturer(String manuId, String name, String phone, String province) {
        this.manuId = manuId;
        this.name = name;
        this.phone = phone;
        this.province = province;
    }

    /**
     * a method to print the data in a manufacturer object to console
     */
    public String printManufacturer() {
        return this.manuId + " " + this.name + " " + this.phone + " " + this.province;
    }
}
