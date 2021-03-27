package edu.ucalgary.ensf409;

import java.sql.*;
import java.util.ArrayList;

/**
 * a class for connecting to the Database
 * 
 * @author Robert Brown
 */
public class Database {
    public final String DBURL;
    public final String USERNAME;
    public final String PASSWORD;

    private Connection dbConnect;
    private ResultSet results;

    /**
     * constructor fo the database class
     * 
     * @param DBURL    url of the database
     * @param USERNAME username for access to the database
     * @param PASSWORD password for access to the database
     */
    public Database(String DBURL, String USERNAME, String PASSWORD) {
        this.DBURL = DBURL;
        this.USERNAME = USERNAME;
        this.PASSWORD = PASSWORD;
    }

    /**
     * a method to connect to the database
     */
    public void connect() throws SQLException {
        DriverManager.setLoginTimeout(5);
        dbConnect = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
    }

    public void getManufacturers() {
        ArrayList<Manufacturer> m = new ArrayList<Manufacturer>();
        try {
            Statement queryStatment = dbConnect.createStatement();
            results = queryStatment.executeQuery("SELECT * FROM MANUFACTURER");
            while (results.next()) {
                m.add(new Manufacturer(results.getString("ManuID"), results.getString("Name"),
                        results.getString("Phone"), results.getString("Province")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Manufacturer manufacturer : m) {
            manufacturer.printManufacturer();
        }
    }

    public void getLamps() {
        ArrayList<Lamp> l = new ArrayList<Lamp>();
        try {
            Statement queryStatment = dbConnect.createStatement();
            results = queryStatment.executeQuery("SELECT * FROM LAMP");
            while (results.next()) {
                l.add(new Lamp(results.getString("ID"), results.getString("Type"), results.getString("Base"),
                        results.getString("Bulb"), results.getInt("Price"), results.getString("ManuID")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Lamp lamp : l) {
            lamp.printLamp();
        }
    }

}
