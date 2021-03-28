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

    public int countCols(String table) {
        int i = 0;
        try {
            String query = "DESCRIBE ?";
            PreparedStatement queryStatment = dbConnect.prepareStatement(query);
            queryStatment.setString(1, table.toUpperCase());
            results = queryStatment.executeQuery();
            while (results.next()) {
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    public ArrayList<FurniturePart> getList(FurniturePart.Types item) {
        return getListByType(item, "");
    }

    public ArrayList<FurniturePart> getListByType(FurniturePart.Types item, String type)
            throws IllegalArgumentException {

        if (!type.equals("") && !item.hasType(type)) {
            throw new IllegalArgumentException("Item " + item.toString() + " does not have type " + type);
        }

        ArrayList<FurniturePart> parts = new ArrayList<FurniturePart>();
        try {
            Statement queryStatment = dbConnect.createStatement();
            results = queryStatment.executeQuery("SELECT * FROM " + item.toString().toUpperCase()
                    + (type.equals("") ? "" : (" WHERE Type=\"" + type + "\"")));
            int j = 0;
            for (int i = 3; i < results.findColumn("Price"); i++) {
                j++;
            }
            while (results.next()) {
                ArrayList<String> params = new ArrayList<String>();
                params.add(results.getString("ID"));
                params.add(results.getString("Type"));
                params.add(results.getString("ManuID"));
                for (int i = 3; i < j + 3; i++) {
                    params.add(results.getString(i));
                }
                int price = results.getInt("Price");
                switch (item) {
                case Lamp:
                    parts.add(new Lamp(params, price));
                    break;

                case Chair:
                    parts.add(new Chair(params, price));
                    break;

                case Filing:
                    parts.add(new Filing(params, price));
                    break;

                case Desk:
                    parts.add(new Desk(params, price));

                default:
                    throw new IllegalArgumentException("Item type " + item.toString() + ", parser does not exist!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return parts;
    }

    // public void getLamps() {
    // ArrayList<Lamp> l = new ArrayList<Lamp>();
    // try {
    // Statement queryStatment = dbConnect.createStatement();
    // results = queryStatment.executeQuery("SELECT * FROM LAMP");
    // while (results.next()) {
    // l.add(new Lamp(results.getString("ID"), results.getString("Type"),
    // results.getString("Base"),
    // results.getString("Bulb"), results.getInt("Price"),
    // results.getString("ManuID")));
    // }
    // } catch (SQLException e) {
    // e.printStackTrace();
    // }
    // for (Lamp lamp : l) {
    // lamp.printLamp();
    // }
    // }

}
