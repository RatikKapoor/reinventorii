package edu.ucalgary.ensf409;

/**
 * a class for a manufacturer
 * 
 * @since 1.1
 */
public class Manufacturer {
    private String manuid;
    private String name;
    private String phone;
    private String province;

    public String getManuid() {
        return this.manuid;
    }

    public void setManuid(String manuid) {
        this.manuid = manuid;
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
     * a constructor for manufacturer
     * 
     * @param manuid
     * @param name
     * @param phone
     * @param province
     */
    public Manufacturer(String manuid, String name, String phone, String province) {
        this.manuid = manuid;
        this.name = name;
        this.phone = phone;
        this.province = province;
    }

    /**
     * a method to print the data in a manufacturer object to console
     */
    public void printManufacturer() {
        System.out.println(this.manuid + " " + this.name + " " + this.phone + " " + this.province);
    }

}
