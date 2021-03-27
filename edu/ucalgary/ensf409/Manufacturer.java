package edu.ucalgary.ensf409;

/**
 * a class for a manufacturer
 */
public class Manufacturer {
    private String manuid;
    private String name;
    private String phone;
    private String province;

    /**
     * a constructor for manufacturer
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
