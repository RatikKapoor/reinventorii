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

    public void disconnect() {
        try {
            dbConnect.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
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

    /**
     * Method getManufacturerNames creates an ArrayList of all MANUFACTURER names
     * from the Manufacturer Table in SQL Database.
     * 
     * @return returns arrayList
     */
    public ArrayList<String> getManufacturerNames() {
        ArrayList<String> m = new ArrayList<>();
        try {
            Statement queryStatment = dbConnect.createStatement();
            results = queryStatment.executeQuery("SELECT * FROM MANUFACTURER");
            while (results.next()) {
                m.add(results.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return m;
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
                    parts.add((T) new Lamp(params, price));
                    break;

                case Chair:
                    parts.add((T) new Chair(params, price));
                    break;

                case Filing:
                    parts.add((T) new Filing(params, price));
                    break;

                case Desk:
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
    public void removeItemByID(FurniturePart.Types item, String id) {
        try {
            String query = "DELETE FROM " + item.toString().toUpperCase() + " WHERE ID = ?";
            PreparedStatement delete = dbConnect.prepareStatement(query);
            delete.setString(1, id);

            delete.executeUpdate();
            delete.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
