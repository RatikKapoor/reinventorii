package edu.ucalgary.ensf409;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import edu.ucalgary.ensf409.FurniturePart.Types;
import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvException;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

@SpringBootTest
public class DatabaseTest {
    @Test
    public void testDatabase_DBConnect() {
        Dotenv enviroment = Dotenv.load();
        Database testDb = testDb = new Database("jdbc:mysql://" + enviroment.get("DB_URL"), enviroment.get("DB_USER"),
                enviroment.get("DB_PASS"));

        try {
            testDb.connect();
            testDb.disconnect();
        } catch (SQLException e) {
            fail("Err");
        }
    }

    @Test
    public void testDatabase_DBConnect_Fail() {
        Database testDb = new Database("jdbc:mysql://server.ratik.me:12345/db", "ensf409", "java123");
        Boolean err = false;
        try {
            testDb.connect();
            testDb.disconnect();

        } catch (SQLException e) {
            err = true;
        }
        assertTrue(err);
    }

    /**
     * Test: Database_storeManufacturers
     * 
     * Description: Checks whether the the Database can successfully retrieve
     * manufacturers from mySQL. Utilizes the getManufacturers method to check if
     * the correct number of manufacturers have been added via manuID.
     * 
     */
    @Test
    public void testDatabase_storeManufacturers() {
        Dotenv enviroment = Dotenv.load();
        Database testDb = testDb = new Database("jdbc:mysql://" + enviroment.get("DB_URL"), enviroment.get("DB_USER"),
                enviroment.get("DB_PASS"));
        ArrayList<String> expect = new ArrayList();
        expect.add("001");
        expect.add("002");
        expect.add("003");
        expect.add("004");
        expect.add("005");

        ArrayList<String> actual = new ArrayList();

        try {
            testDb.connect();
            testDb.storeManufacturers(); // Checking This Method
            for (int i = 0; i < testDb.getManufacturers().size(); i++) {
                actual.add(testDb.getManufacturers().get(i).getManuid());
            }
            testDb.disconnect();
        } catch (SQLException e) {
            fail("Err");
        }

        assertEquals("Expected manufacturers list does not match what is retrieved", expect, actual);
    }

    /**
     * Test: Database_storeManufacturers_Fail
     * 
     * Description: Checks whether the the Database can successfully retrieve
     * manufacturers from mySQL. In this test, the order has been scrambled with
     * will cause a fail in match.
     * 
     */
    @Test
    public void testDatabase_storeManufacturers_Fail() {
        Dotenv enviroment = Dotenv.load();
        Database testDb = testDb = new Database("jdbc:mysql://" + enviroment.get("DB_URL"), enviroment.get("DB_USER"),
                enviroment.get("DB_PASS"));
        ArrayList<String> expect = new ArrayList();
        expect.add("005");
        expect.add("004");
        expect.add("006");
        expect.add("002");
        expect.add("001");

        Boolean err = false;

        ArrayList<String> actual = new ArrayList();

        try {
            testDb.connect();
            testDb.storeManufacturers(); // Checking This Method
            for (int i = 0; i < testDb.getManufacturers().size(); i++) {
                actual.add(testDb.getManufacturers().get(i).getManuid());
            }
            if (expect != actual) { // Check whether they don't match. Expecting this to pass
                err = true;
            }
            testDb.disconnect();
        } catch (SQLException e) {
            fail("Err");
        }
        assertTrue("Manufacturer may match in this Failed Test", err);
    }

    /**
     * Test: Database_getManufacturersByType_Chairs
     * 
     * Description: checks the GetManufacturerByTypes method. Ensures that the Chair
     * furniture type has according manufacturers as suggested by the Inventory
     * database. The Name variable for each manufacturer is matched.
     * 
     */
    @Test
    public void testDatabase_getManufacturersByType_Chairs() {
        Dotenv enviroment = Dotenv.load();
        Database testDb = testDb = new Database("jdbc:mysql://" + enviroment.get("DB_URL"), enviroment.get("DB_USER"),
                enviroment.get("DB_PASS"));
        ArrayList<String> expect = new ArrayList();
        expect.add("Office Furnishings");
        expect.add("Chairs R Us");
        expect.add("Furniture Goods");
        expect.add("Fine Office Supplies");

        ArrayList<String> actual = new ArrayList();
        FurniturePart.Types partType = Types.fromString("Chair"); // Checks for Chair Manufacturers

        try {
            testDb.connect();
            testDb.storeManufacturers(); // Checking This Method
            for (int i = 0; i < testDb.getManufacturersByType(partType).size(); i++) {
                actual.add(testDb.getManufacturersByType(partType).get(i).getName()); // Utilizing the getName method
            }
            testDb.disconnect();
        } catch (SQLException e) {
            fail("Err");
        }

        assertEquals("Expected manufacturers type name does not match what is retrieved", expect, actual);
    }

    /**
     * Test: Database_getManufacturersByType_Desk
     * 
     * Description: checks the GetManufacturerByTypes method. Ensures that the Desk
     * furniture type has according manufacturers as suggested by the Inventory
     * database. The Name variable for each manufacturer is matched.
     * 
     */
    @Test
    public void testDatabase_getManufacturersByType_Desk() {
        Dotenv enviroment = Dotenv.load();
        Database testDb = testDb = new Database("jdbc:mysql://" + enviroment.get("DB_URL"), enviroment.get("DB_USER"),
                enviroment.get("DB_PASS"));
        ArrayList<String> expect = new ArrayList();
        expect.add("Academic Desks");
        expect.add("Office Furnishings");
        expect.add("Furniture Goods");
        expect.add("Fine Office Supplies");

        ArrayList<String> actual = new ArrayList();
        FurniturePart.Types partType = Types.fromString("Desk"); // Checks for Desk Manufacturers

        try {
            testDb.connect();
            testDb.storeManufacturers(); // Checking This Method
            for (int i = 0; i < testDb.getManufacturersByType(partType).size(); i++) {
                actual.add(testDb.getManufacturersByType(partType).get(i).getName()); // Utilizing the getName method
            }
            testDb.disconnect();
        } catch (SQLException e) {
            fail("Err");
        }

        assertEquals("Expected manufacturers type name does not match what is retrieved", expect, actual);
    }

    /**
     * Test: Database_getManufacturersByType_Lamp
     * 
     * Description: checks the GetManufacturerByTypes method. Ensures that the Lamp
     * furniture type has according manufacturers as suggested by the Inventory
     * database. The Name variable for each manufacturer is matched.
     * 
     */
    @Test
    public void testDatabase_getManufacturersByType_Lamp() {
        Dotenv enviroment = Dotenv.load();
        Database testDb = testDb = new Database("jdbc:mysql://" + enviroment.get("DB_URL"), enviroment.get("DB_USER"),
                enviroment.get("DB_PASS"));
        ArrayList<String> expect = new ArrayList();
        expect.add("Office Furnishings");
        expect.add("Furniture Goods");
        expect.add("Fine Office Supplies");

        ArrayList<String> actual = new ArrayList();
        FurniturePart.Types partType = Types.fromString("Lamp"); // Checks for Lamp Manufacturers

        try {
            testDb.connect();
            testDb.storeManufacturers(); // Checking This Method
            for (int i = 0; i < testDb.getManufacturersByType(partType).size(); i++) {
                actual.add(testDb.getManufacturersByType(partType).get(i).getName()); // Utilizing the getName method
            }
            testDb.disconnect();
        } catch (SQLException e) {
            fail("Err");
        }

        assertEquals("Expected manufacturers type name does not match what is retrieved", expect, actual);
    }

    /**
     * Test: Database_getManufacturersByType_Filing
     * 
     * Description: checks the GetManufacturerByTypes method. Ensures that the
     * Filing furniture type has according manufacturers as suggested by the
     * Inventory database. The Name variable for each manufacturer is matched.
     * 
     */
    @Test
    public void testDatabase_getManufacturersByType_Filing() {
        Dotenv enviroment = Dotenv.load();
        Database testDb = testDb = new Database("jdbc:mysql://" + enviroment.get("DB_URL"), enviroment.get("DB_USER"),
                enviroment.get("DB_PASS"));
        ArrayList<String> expect = new ArrayList();
        expect.add("Office Furnishings");
        expect.add("Furniture Goods");
        expect.add("Fine Office Supplies");

        ArrayList<String> actual = new ArrayList();
        FurniturePart.Types partType = Types.fromString("Filing"); // Checks for Filing Manufacturers

        try {
            testDb.connect();
            testDb.storeManufacturers(); // Checking This Method
            for (int i = 0; i < testDb.getManufacturersByType(partType).size(); i++) {
                actual.add(testDb.getManufacturersByType(partType).get(i).getName()); // Utilizing the getName method
            }
            testDb.disconnect();
        } catch (SQLException e) {
            fail("Err");
        }

        assertEquals("Expected manufacturers type name does not match what is retrieved", expect, actual);
    }

    /**
     * Test: Database_getManufacturersByType_Fail
     * 
     * Description: checks the GetManufacturerByTypes method. Ensures that the
     * Filing furniture type has according manufacturers as suggested by the
     * Inventory database. The Name variable for each manufacturer is matched.
     * 
     */
    @Test
    public void testDatabase_getManufacturersByType_Fail() {
        Dotenv enviroment = Dotenv.load();
        Database testDb = testDb = new Database("jdbc:mysql://" + enviroment.get("DB_URL"), enviroment.get("DB_USER"),
                enviroment.get("DB_PASS"));
        ArrayList<String> expect = new ArrayList();
        expect.add("Office Furnishings");
        expect.add("Furniture Goods");
        expect.add("Some Manufacturer"); // Incorrect
        Boolean err = false;

        ArrayList<String> actual = new ArrayList();
        FurniturePart.Types partType = Types.fromString("Filing"); // Checks for Filing Manufacturers

        try {
            testDb.connect();
            testDb.storeManufacturers(); // Checking This Method
            for (int i = 0; i < testDb.getManufacturersByType(partType).size(); i++) {
                actual.add(testDb.getManufacturersByType(partType).get(i).getName()); // Utilizing the getName method
            }
            if (expect != actual) { // Check whether they don't match. Expecting this to pass
                err = true;
            }
            testDb.disconnect();
        } catch (SQLException e) {
            fail("Err");
        }
        assertTrue("Correct Manufacturers were added. Expecting a fail", err);
    }

}