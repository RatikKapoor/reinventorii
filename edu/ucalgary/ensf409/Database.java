package edu.ucalgary.ensf409;

import java.sql.*;

/**
 * a class for connecting to the Database
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
     * @param DBURL url of the database
     * @param USERNAME  username for access to the database
     * @param PASSWORD  password for access to the database
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
        try {
            Statement queryStatment = dbConnect.createStatement();
            results = queryStatment.executeQuery("SELECT * FROM MANUFACTURER");
            while (results.next()) {

                System.out.println(results.getString("ManuID"));
                System.out.print(results.getString("Name"));
                System.out.print(results.getString("Phone"));
                System.out.print(results.getString("Province"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } 

}
