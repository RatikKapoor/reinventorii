package edu.ucalgary.ensf409;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

@SpringBootTest
public class FilingTest {

    /**
     * Test: Filing_getManuID_SetWithConstructor
     * 
     * Description: Checks whether ManuId set through constructor can be accessed
     * through the getManuID method. Filing inherits the getManuID method from
     * abstract class FurniturePart. This test validates the inheritance property
     * for ManuID.
     */
    @Test
    public void Filing_getManuID_SetWithConstructor() {

        Filing aTestFiling = new Filing("F001", "Small", "Y", "Y", "N", 50, "005");
        String actual = aTestFiling.getManuID();
        String expect = "005";

        assertEquals("Cannot retrieve ManuID from Filing Parent", expect, actual);
    }

    /**
     * Test: Filing_getId_SetWithConstructor
     * 
     * Description: Checks whether id set through constructor can be accessed
     * through the getId method. Filing inherits the getId method from abstract
     * class FurniturePart. This test validates the inheritance property for id.
     */
    @Test
    public void Filing_getId_SetWithConstructor() {

        Filing aTestFiling = new Filing("F001", "Small", "Y", "Y", "N", 50, "005");
        String actual = aTestFiling.getId();
        String expect = "F001";

        assertEquals("Cannot retrieve id from Filing Parent", expect, actual);
    }

    /**
     * Test: Filing_getPrice_SetWithConstructor
     * 
     * Description: Checks whether price set through constructor can be accessed
     * through the getPrice method. Filing inherits the getPrice method from
     * abstract class FurniturePart. This test validates the inheritance property
     * for price.
     */
    @Test
    public void Filing_getPrice_SetWithConstructor() {

        Filing aTestFiling = new Filing("F001", "Small", "Y", "Y", "N", 50, "005");
        int actual = aTestFiling.getPrice();
        int expect = 50;

        assertEquals("Cannot retrieve price from Filing Parent", expect, actual);
    }

    /**
     * Test: Filing_getType_SetWithConstructor
     * 
     * Description: Checks whether type set through constructor can be accessed
     * through the getType method. Filing inherits the getType method from abstract
     * class FurniturePart. This test validates the inheritance property for type.
     */

    @Test
    public void Filing_getType_SetWithConstructor() {

        Filing aTestFiling = new Filing("F001", "Small", "Y", "Y", "N", 50, "005");
        String actual = aTestFiling.getType();
        String expect = "Small";

        assertEquals("Cannot retrieve type from Filing Parent", expect, actual);
    }

    /**
     * Test: Filing_QueryConstructor
     * 
     * Description: Checks whether query constructor with paramater type is
     * accepted.
     */

    @Test
    public void Filing_QueryConstructor() {

        Filing aTestFiling = new Filing("Small");
        String actual = aTestFiling.getType();
        String expect = "Small";

        assertEquals("Cannot retrieve type from Filing Parent", expect, actual);
    }

    /**
     * Test: FilingIllegal_QueryConstructor
     * 
     * Description: Checks whether query constructor with paramater type is
     * accepted. In this case, exception is thrown.
     */

    @Test
    public void FilingIllegal_QueryConstructor() {

        boolean err = false;
        try {
            Filing aTestFiling = new Filing("Enormous");
        } catch (IllegalFurnitureTypeException e) {
            err = true;
        }
        assertTrue("Enormous is not an accepted type in FurnitureType Enum. Must throw exception", err);
    }

    /**
     * Test: Filing_DatabaseConstructor
     * 
     * Description: Checks whether database constructor with paramater data as an
     * ArrayList<String> and price is accepted. This test checks only if manuID is
     * correct.
     */
    @Test
    public void Filing_DatabaseConstructor() {
        ArrayList<String> aTestList = new ArrayList<>();
        aTestList.add("F001");
        aTestList.add("Small");
        aTestList.add("005");
        aTestList.add("Y");
        aTestList.add("Y");
        aTestList.add("N");

        Filing aTestFiling = new Filing(aTestList, 50);
        String actual = aTestFiling.getManuID();
        String expect = "005";

        assertEquals("Cannot retrieve manuID from Filing Parent", expect, actual);
    }

    /**
     * Test: FilingIllegal_DatabaseConstructor
     * 
     * Description: Checks whether database constructor with paramater data as an
     * ArrayList<String> and price is accepted. This test checks only if manuID is
     * correct. In this case, ArrayList is too large.
     */
    @Test
    public void FilingIllegal_DatabaseConstructor() {
        ArrayList<String> aTestList = new ArrayList<>();
        aTestList.add("F001");
        aTestList.add("Small");
        aTestList.add("005");
        aTestList.add("Y");
        aTestList.add("Y");
        aTestList.add("N");
        aTestList.add("N"); // Incorrect here

        Boolean err = false;

        try {
            Filing aTestFiling = new Filing(aTestList, 50); // Fails here
        } catch (IllegalArgumentException e) {
            err = true;
        }
        assertTrue("Too many furniture types are passed into constructor using ArrayList", err);
    }

    /**
     * Test: Filing_StringToBoolean_Cabinet_False
     * 
     * Description: Checks whether the String to Boolean conversion is accurate.
     * This test utilizes the getCabinet method to test Cabinet boolean statement.
     * All variables of similar nature include the same stringToBoolean method.
     * Tests a False Statement
     */
    @Test
    public void Filing_StringToBoolean_Cabinet_False() {

        Filing aTestFiling = new Filing("F001", "Small", "Y", "Y", "N", 50, "005");
        boolean actual = aTestFiling.stringToBoolean("N");
        boolean expect = false;

        assertEquals("Filing String to Boolean Conversion Failed for Cabinet", expect, actual);
    }

    /**
     * Test: Filing_StringToBoolean_Cabinet_True
     * 
     * Description: Checks whether the String to Boolean conversion is accurate.
     * This test utilizes the getCushion method to test Cushion boolean statement.
     * All variables of similar nature include the same stringToBoolean method.
     * Tests a True Statement
     */
    @Test
    public void FilingIllegal_StringToBoolean_Cushion_True() {
        Filing aTestFiling = new Filing("F001", "Small", "Y", "Y", "Y", 50, "005");
        boolean actual = aTestFiling.stringToBoolean("Y");
        boolean expect = true;
        assertEquals("Filing String to Boolean Conversion Failed for Cabinet", expect, actual);

    }

    /**
     * Test: Filing_getCabinet_SetWithConstructor
     * 
     * Description: Checks whether legs set through constructor can be accessed
     * through the getLegs method.
     */
    @Test
    public void Filing_getCabinet_SetWithConstructor() {

        Filing aTestFiling = new Filing("F001", "Small", "Y", "Y", "N", 50, "005");
        boolean actual = aTestFiling.getCabinet();
        boolean expect = false;

        assertEquals("Cannot retrieve cabinet from Filing", expect, actual);
    }

    /**
     * Test: Filing_getRails_SetWithConstructor
     * 
     * Description: Checks whether cushion set through constructor can be accessed
     * through the getCushion method.
     */
    @Test
    public void Filing_getRails_SetWithConstructor() {

        Filing aTestFiling = new Filing("F001", "Small", "Y", "Y", "N", 50, "005");
        boolean actual = aTestFiling.getRails();
        boolean expect = true;

        assertEquals("Cannot retrieve rails from Drawers", expect, actual);
    }

    /**
     * Test: FilingLegalType_Constructor
     * 
     * Description: Checks if the furniture type is legal, as in matches the
     * predefined Enum in the FurniturePart abstract class. This test checks a valid
     * type: "Small" for for furniture Filing.
     */
    @Test
    public void FilingLegalType_Constructor() {

        Filing aTestFiling = new Filing("F001", "Small", "Y", "Y", "N", 50, "005");
        String actual = aTestFiling.getType();
        String expect = "Small";

        assertEquals("Small Filing type defined through constructor", expect, actual);
    }

    /**
     * Test: FilingIllegalType_Constructor
     * 
     * Description: Checks if the furniture type is illegal, as in does not match
     * the predefined Enum in the FurniturePart abstract class. This test checks an
     * invalid type: "aFakeType" for for furniture Filing. A custom exception is
     * thrown.
     */
    @Test
    public void FilingIllegalType_Constructor() {
        String type = "aFakeType";
        Boolean err = false;
        try {
            Filing aTestFiling = new Filing("F001", type, "Y", "Y", "N", 50, "005");
        } catch (IllegalFurnitureTypeException e) {
            err = true;
        }
        assertTrue("IllegalFurnitureTypeException", err);
    }

    /**
     * Test: FilingIllegalType_DefaultConstructor
     * 
     * Description: Checks if the furniture type is illegal, as in does not match
     * the predefined Enum in the FurniturePart abstract class. This test checks an
     * invalid type: "aFakeType" for for furniture Filing. A custom exception is
     * thrown. This test specifically checks the Default Constructor where only the
     * furniture type (String) is required as a paramater.
     */
    @Test
    public void FilingIllegalType_DefaultConstructor() {
        String type = "aFakeType";
        Boolean err = false;
        try {
            Filing aTestFiling = new Filing(type);
        } catch (IllegalFurnitureTypeException e) {
            err = true;
        }
        assertTrue("IllegalFurnitureTypeException", err);
    }

    /**
     * Test: FilingIllegalType_CheckType_False1
     * 
     * Description: Checks whether the CheckType abstract method returns a False
     * when an incorrect type is tested (that does not match the Types Enum in the
     * FurniturePart class). The tested paramater is "aFakeType"
     */
    @Test
    public void FilingIllegalType_CheckType_False1() {
        String type = "aFakeType";
        Boolean expect = false;
        Filing aTestFiling = new Filing("F001", "Small", "Y", "Y", "N", 50, "005");

        Boolean actual = aTestFiling.checkType(type);
        assertEquals(expect, actual);
    }

    /**
     * Test: FilingIllegalType_CheckType_False2
     * 
     * Description: Checks whether the CheckType abstract method returns a False
     * when an incorrect type is tested (that does not match the Types Enum in the
     * FurniturePart class). The tested paramater is "small" This checks that the
     * tests are in fact case SENSITIVE
     */
    @Test
    public void FilingIllegalType_CheckType_False2() {
        String type = "small";
        Boolean expect = false;
        Filing aTestFiling = new Filing("F001", "Small", "Y", "Y", "N", 50, "005");

        Boolean actual = aTestFiling.checkType(type);
        assertEquals(expect, actual);
    }

    /**
     * Test: FilingIllegalType_CheckType_False3
     * 
     * Description: Checks whether the CheckType abstract method returns a False
     * when an incorrect type is tested (that does not match the Types Enum in the
     * FurniturePart class). The tested paramater is "Traditional" This type is
     * accepted for Chair not Filing. Ergonomic is put into the constructor since
     * this test is specifically for the checkType method and not the constructor
     */
    @Test
    public void FilingIllegalType_CheckType_False3() {
        String type = "Ergonomic";
        Boolean expect = false;
        Filing aTestFiling = new Filing("F001", "Small", "Y", "Y", "N", 50, "005");

        Boolean actual = aTestFiling.checkType(type);
        assertEquals(expect, actual);
    }

    /**
     * Test: FilinglegalType_CheckType_Small
     * 
     * Description: Same Test as above, however, it is now matched with "Small" as a
     * type.
     */
    @Test
    public void FilinglegalType_CheckType_Small() {
        String type = "Small";
        Filing aTestFiling = new Filing("F001", type, "Y", "Y", "N", 50, "005");

        Boolean expect = true;
        Boolean actual = aTestFiling.checkType(type);
        assertEquals(expect, actual);
    }

    /**
     * Test: FilinglegalType_CheckType_Medium
     * 
     * Description: Same Test as above, however, it is now matched with "Medium" as
     * a type.
     */
    @Test
    public void FilinglegalType_CheckType_Medium() {
        String type = "Medium";
        Filing aTestFiling = new Filing("F001", type, "Y", "Y", "N", 50, "005");

        Boolean expect = true;
        Boolean actual = aTestFiling.checkType(type);
        assertEquals(expect, actual);
    }

    /**
     * Test: FilinglegalType_CheckType_Large
     * 
     * Description: Same Test as above, however, it is now matched with "Large" as a
     * type.
     */
    @Test
    public void FilinglegalType_CheckType_Large() {
        String type = "Large";
        Filing aTestFiling = new Filing("F001", type, "Y", "Y", "N", 50, "005");

        Boolean expect = true;
        Boolean actual = aTestFiling.checkType(type);
        assertEquals(expect, actual);
    }
}
