package edu.ucalgary.ensf409;

import java.sql.*;
import java.util.ArrayList;

/**
 * A class for connecting to the Database
 * 
 * @author Robert Brown, Ratik Kapoor, Risat Haque, Anand Patel
 * @since 1.0
 */
public class Database {
    public final String DBURL;
    public final String USERNAME;
    public final String PASSWORD;

    private Connection dbConnect;
    private ResultSet results;

    private ArrayList<Manufacturer> manufacturers;

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

    /**
     * a method to disconnect from the database by closing the connection
     */
    public void disconnect() {
        try {
            dbConnect.close();
        } catch (Exception e) {
            System.err.println("Could not disconnect from database!!");
            e.printStackTrace();
        }
    }

    public void storeManufacturers() {
        ArrayList<Manufacturer> m = new ArrayList<Manufacturer>();
        try {
            Statement queryStatement = dbConnect.createStatement();
            results = queryStatement.executeQuery("SELECT * FROM MANUFACTURER");
            while (results.next()) {
                m.add(new Manufacturer(results.getString("ManuID"), results.getString("Name"),
                        results.getString("Phone"), results.getString("Province"),
                        new ArrayList<FurniturePart.Types>()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        manufacturers = m;
        for (FurniturePart.Types type : FurniturePart.Types.values()) {
            try {
                Statement queryStatement = dbConnect.createStatement();
                results = queryStatement.executeQuery("SELECT ManuID FROM " + type.toString().toUpperCase());
                while (results.next()) {
                    addTypeToManufacturer(results.getString("ManuID"), type);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * a method to add a type to a specific manufacturer in the stored list
     * 
     * @param id   manufacturer id
     * @param type type to be added
     */
    public void addTypeToManufacturer(String id, FurniturePart.Types type) {
        for (Manufacturer manufacturer : manufacturers) {
            if (manufacturer.getManuId().contains(id)) {
                if (manufacturer.getTypes().isEmpty()) {
                    manufacturer.getTypes().add(type);
                } else {
                    if (!manufacturer.getTypes().contains(type)) {
                        manufacturer.getTypes().add(type);
                    }
                }
            }
        }
    }

    /**
     * a method to get the list of manufacturers from the database
     * 
     * @return
     */
    public ArrayList<Manufacturer> getManufacturers() {
        return this.manufacturers;
    }

    public ArrayList<Manufacturer> getManufacturersByType(FurniturePart.Types type) {
        ArrayList<Manufacturer> manByType = new ArrayList<Manufacturer>();
        for (Manufacturer manufacturer : manufacturers) {
            if (manufacturer.getTypes().contains(type)) {
                manByType.add(manufacturer);
            }
        }
        return manByType;
    }

    /**
     * Method getManufacturerNames creates an ArrayList of all MANUFACTURER names
     * from the Manufacturer Table in SQL Database.
     * 
     * @return returns arrayList
     */
    public ArrayList<String> getManufacturerNames() {
        ArrayList<String> m = new ArrayList<>();
        try {
            Statement queryStatement = dbConnect.createStatement();
            results = queryStatement.executeQuery("SELECT * FROM MANUFACTURER");
            while (results.next()) {
                m.add(results.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return m;
    }

    /**
     * a generic function for
     * 
     * @param <T>
     * @param item
     * @return
     */
    public <T extends FurniturePart> ArrayList<T> getList(FurniturePart.Types item) {
        return getListByType(item, "");
    }

    @SuppressWarnings("unchecked")
    public <T extends FurniturePart> ArrayList<T> getListByType(FurniturePart.Types item, String type)
            throws IllegalArgumentException {

        if (!type.equals("") && !item.hasType(type)) {
            throw new IllegalArgumentException("Item " + item.toString() + " does not have type " + type);
        }

        ArrayList<T> parts = new ArrayList<T>();
        try {
            Statement queryStatement = dbConnect.createStatement();
            results = queryStatement.executeQuery("SELECT * FROM " + item.toString().toUpperCase()
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
                case LAMP:
                    parts.add((T) new Lamp(params, price));
                    break;

                case CHAIR:
                    parts.add((T) new Chair(params, price));
                    break;

                case FILING:
                    parts.add((T) new Filing(params, price));
                    break;

                case DESK:
                    parts.add((T) new Desk(params, price));
                    break;

                default:
                    throw new IllegalArgumentException("Item type " + item.toString() + ", parser does not exist!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ArrayList.class.cast(parts);
    }

    /**
     * a method to remove
     * 
     * @author Robert Brown
     * @param item the name of the table the item is from
     * @param id   th id of the item
     */
    public boolean removeItemByID(FurniturePart.Types item, String id) {
        boolean result = true;
        try {
            String query = "DELETE FROM " + item.toString().toUpperCase() + " WHERE ID = ?";
            PreparedStatement delete = dbConnect.prepareStatement(query);
            delete.setString(1, id);

            if (delete.executeUpdate() < 1) {
                result = false;
            }
            delete.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return result;
    }
}
