package edu.ucalgary.ensf409;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.Assert.*;
import java.util.ArrayList;

/**
 * Tests for Chair Class and FurnitureType Methods used by Chair
 * 
 * @version 1.2
 * @author Ratik Kapoor, Robert Brown, Risat Haque, Anand Patel
 */
@SpringBootTest
public class ChairTest {

    /**
     * Test: Chair_getManuID_SetWithConstructor
     * 
     * Description: Checks whether ManuId set through constructor can be accessed
     * through the getManuID method. Chair inherits the getManuID method from
     * abstract class FurniturePart. This test validates the inheritance property
     * for ManuID.
     */
    @Test
    public void testChair_getManuID_SetWithConstructor() {

        Chair aTestChair = new Chair("C1320", "Kneeling", "Y", "N", "N", "N", 50, "002");
        String actual = aTestChair.getManuID();
        String expect = "002";

        assertEquals("Cannot retrieve ManuID from Chair Parent", expect, actual);
    }

    /**
     * Test: Chair_getId_SetWithConstructor
     * 
     * Description: Checks whether id set through constructor can be accessed
     * through the getId method. Chair inherits the getId method from abstract class
     * FurniturePart. This test validates the inheritance property for id.
     */
    @Test
    public void testChair_getId_SetWithConstructor() {

        Chair aTestChair = new Chair("C1320", "Mesh", "Y", "N", "N", "Y", 150, "001");
        String actual = aTestChair.getId();
        String expect = "C1320";

        assertEquals("Cannot retrieve id from Chair Parent", expect, actual);
    }

    /**
     * Test: Chair_getPrice_SetWithConstructor
     * 
     * Description: Checks whether price set through constructor can be accessed
     * through the getPrice method. Chair inherits the getPrice method from abstract
     * class FurniturePart. This test validates the inheritance property for price.
     */
    @Test
    public void testChair_getPrice_SetWithConstructor() {

        Chair aTestChair = new Chair("C1320", "Mesh", "Y", "N", "N", "Y", 150, "001");
        int actual = aTestChair.getPrice();
        int expect = 150;

        assertEquals("Cannot retrieve price from Chair Parent", expect, actual);
    }

    /**
     * Test: Chair_getType_SetWithConstructor
     * 
     * Description: Checks whether type set through constructor can be accessed
     * through the getType method. Chair inherits the getType method from abstract
     * class FurniturePart. This test validates the inheritance property for type.
     */

    @Test
    public void testChair_getType_SetWithConstructor() {

        Chair aTestChair = new Chair("C1320", "Executive", "Y", "N", "N", "Y", 150, "001");
        String actual = aTestChair.getType();
        String expect = "Executive";

        assertEquals("Cannot retrieve type from Chair Parent", expect, actual);
    }

    /**
     * Test: Chair_QueryConstructor
     * 
     * Description: Checks whether query constructor with paramater type is
     * accepted.
     */

    @Test
    public void testChair_QueryConstructor() {

        Chair aTestChair = new Chair("Executive");
        String actual = aTestChair.getType();
        String expect = "Executive";

        assertEquals("Cannot retrieve type from Chair Parent", expect, actual);
    }

    /**
     * Test: Chair_DatabaseConstructor
     * 
     * Description: Checks whether database constructor with paramater data as an
     * ArrayList<String> and price is accepted. This test checks only if manuID is
     * correct.
     */
    @Test
    public void testChair_DatabaseConstructor() {

        ArrayList<String> aTestList = new ArrayList<>();
        aTestList.add("C1320");
        aTestList.add("Executive");
        aTestList.add("001");
        aTestList.add("Y");
        aTestList.add("N");
        aTestList.add("N");
        aTestList.add("Y");

        Chair aTestChair = new Chair(aTestList, 150);
        String actual = aTestChair.getManuID();
        String expect = "001";

        assertEquals("Cannot retrieve manuID from Chair Parent", expect, actual);
    }

    /**
     * Test: ChairIllegal_DatabaseConstructor
     * 
     * Description: Checks whether database constructor with paramater data as an
     * ArrayList<String> and price is accepted. This test checks only if manuID is
     * correct. In this case, the ArrayList is too large.
     */
    @Test
    public void testChairIllegal_DatabaseConstructor() {
        ArrayList<String> aTestList = new ArrayList<>();
        aTestList.add("C1320");
        aTestList.add("Executive");
        aTestList.add("001");
        aTestList.add("Y");
        aTestList.add("N");
        aTestList.add("N");
        aTestList.add("Y");
        aTestList.add("N"); // Incorrect here

        Boolean err = false;

        try {
            Chair aTestChair = new Chair(aTestList, 50); // Fails here
        } catch (IllegalArgumentException e) {
            err = true;
        }
        assertTrue("Too many furniture types are passed into constructor using ArrayList", err);
    }

    /**
     * Test: Chair_StringToBoolean_Cushion_False
     * 
     * Description: Checks whether the String to Boolean conversion is accurate.
     * This test utilizes the getCushion method to test Cushion boolean statement.
     * All variables of similar nature include the same stringToBoolean method.
     * Tests a False Statement
     */
    @Test
    public void testChair_StringToBoolean_Cushion_False() {

        Chair aTestChair = new Chair("C1320", "Kneeling", "Y", "N", "N", "N", 50, "002");
        boolean actual = aTestChair.stringToBoolean("N");
        boolean expect = false;

        assertEquals("Chair String to Boolean Conversion Failed for Cushion", expect, actual);
    }

    /**
     * Test: Chair_StringToBoolean_Cushion_True
     * 
     * Description: Checks whether the String to Boolean conversion is accurate.
     * This test utilizes the getCushion method to test Cushion boolean statement.
     * All variables of similar nature include the same stringToBoolean method.
     * Tests a True Statement
     */
    @Test
    public void testChairIllegal_StringToBoolean_Cushion_True() {
        Chair aTestChair = new Chair("C2322", "Kneeling", "N", "Y", "N", "N", 50, "152");
        boolean actual = aTestChair.stringToBoolean("Y");
        boolean expect = true;
        assertEquals("Chair String to Boolean Conversion Failed for Cushion", expect, actual);

    }

    /**
     * Test: Chair_getLegs_SetWithConstructor
     * 
     * Description: Checks whether legs set through constructor can be accessed
     * through the getLegs method.
     */
    @Test
    public void testChair_getLegs_SetWithConstructor() {

        Chair aTestChair = new Chair("C1320", "Mesh", "Y", "N", "N", "Y", 150, "001");
        boolean actual = aTestChair.getLegs();
        boolean expect = true;

        assertEquals("Cannot retrieve legs from Chair", expect, actual);
    }

    /**
     * Test: Chair_getCushion_SetWithConstructor
     * 
     * Description: Checks whether cushion set through constructor can be accessed
     * through the getCushion method.
     */
    @Test
    public void testChair_getCushion_SetWithConstructor() {

        Chair aTestChair = new Chair("C1320", "Mesh", "Y", "N", "N", "Y", 150, "001");
        boolean actual = aTestChair.getCushion();
        boolean expect = false;

        assertEquals("Cannot retrieve cushion from Chair", expect, actual);
    }

    /**
     * Test: Chair_getArms_SetWithConstructor
     * 
     * Description: Checks whether arms set through constructor can be accessed
     * through the getArms method.
     */
    @Test
    public void testChair_getArms_SetWithConstructor() {

        Chair aTestChair = new Chair("C1320", "Mesh", "Y", "N", "N", "Y", 150, "001");
        boolean actual = aTestChair.getArms();
        boolean expect = false;

        assertEquals("Cannot retrieve arms from Chair", expect, actual);
    }

    /**
     * Test: Chair_getSeat_SetWithConstructor
     * 
     * Description: Checks whether seats set through constructor can be accessed
     * through the getSeat method.
     */
    @Test
    public void testChair_getSeat_SetWithConstructor() {

        Chair aTestChair = new Chair("C1320", "Mesh", "Y", "N", "N", "Y", 150, "001");
        boolean actual = aTestChair.getSeat();
        boolean expect = true;

        assertEquals("Cannot retrieve seat from Chair", expect, actual);
    }

    /**
     * Test: ChairLegalType_Constructor
     * 
     * Description: Checks if the furniture type is legal, as in matches the
     * predefined Enum in the FurniturePart abstract class. This test checks a valid
     * type: "Kneeling" for for furniture Chair.
     */
    @Test
    public void testChairLegalType_Constructor() {

        Chair aTestChair = new Chair("C1320", "Kneeling", "Y", "N", "N", "N", 50, "002");
        String actual = aTestChair.getType();
        String expect = "Kneeling";

        assertEquals("Kneeling Chair type defined through constructor", expect, actual);
    }

    /**
     * Test: ChairIllegalType_Constructor
     * 
     * Description: Checks if the furniture type is illegal, as in does not match
     * the predefined Enum in the FurniturePart abstract class. This test checks an
     * invalid type: "aFakeType" for for furniture Chair. A custom exception is
     * thrown.
     */
    @Test
    public void testChairIllegalType_Constructor() {
        String type = "aFakeType";
        Boolean err = false;
        try {
            Chair aTestChair = new Chair("C1320", type, "Y", "N", "N", "N", 50, "002");
        } catch (IllegalFurnitureTypeException e) {
            err = true;
        }
        assertTrue("IllegalFurnitureTypeException", err);
    }

    /**
     * Test: ChairIllegalType_DefaultConstructor
     * 
     * Description: Checks if the furniture type is illegal, as in does not match
     * the predefined Enum in the FurniturePart abstract class. This test checks an
     * invalid type: "aFakeType" for for furniture Chair. A custom exception is
     * thrown. This test specifically checks the Default Constructor where only the
     * furniture type (String) is required as a paramater.
     */
    @Test
    public void testChairIllegalType_DefaultConstructor() {
        String type = "aFakeType";
        Boolean err = false;
        try {
            Chair aTestChair = new Chair(type);
        } catch (IllegalFurnitureTypeException e) {
            err = true;
        }
        assertTrue("IllegalFurnitureTypeException", err);
    }

    /**
     * Test: ChairIllegalType_CheckType_False1
     * 
     * Description: Checks whether the CheckType abstract method returns a False
     * when an incorrect type is tested (that does not match the Types Enum in the
     * FurniturePart class). The tested paramater is "aFakeType"
     */
    @Test
    public void testChairIllegalType_CheckType_False1() {
        String type = "aFakeType";
        Boolean expect = false;
        Chair aTestChair = new Chair("C1320", "Mesh", "Y", "N", "N", "N", 50, "002");

        Boolean actual = aTestChair.checkType(type);
        assertEquals(expect, actual);
    }

    /**
     * Test: ChairIllegalType_CheckType_False2
     * 
     * Description: Checks whether the CheckType abstract method returns a False
     * when an incorrect type is tested (that does not match the Types Enum in the
     * FurniturePart class). The tested paramater is "ergonomic" This checks that
     * the tests are in fact case SENSITIVE
     */
    @Test
    public void testChairIllegalType_CheckType_False2() {
        String type = "ergonomic";
        Boolean expect = false;
        Chair aTestChair = new Chair("C1320", "Ergonomic", "Y", "N", "N", "N", 50, "002");

        Boolean actual = aTestChair.checkType(type);
        assertEquals(expect, actual);
    }

    /**
     * Test: ChairIllegalType_CheckType_False3
     * 
     * Description: Checks whether the CheckType abstract method returns a False
     * when an incorrect type is tested (that does not match the Types Enum in the
     * FurniturePart class). The tested paramater is "Traditional" This type is
     * accepted for Desk not Chair. Ergonomic is put into the constructor since this
     * test is specifically for the checkType method and not the constructor
     */
    @Test
    public void testChairIllegalType_CheckType_False3() {
        String type = "Traditional";
        Boolean expect = false;
        Chair aTestChair = new Chair("C1320", "Ergonomic", "Y", "N", "N", "N", 50, "002");

        Boolean actual = aTestChair.checkType(type);
        assertEquals(expect, actual);
    }

    /**
     * Test: ChairlegalType_CheckType_Mesh
     * 
     * Description: Checks whether the CheckType abstract method returns a True when
     * a correct type is tested (that does not match the Types Enum in the
     * FurniturePart class). The tested paramater is "Mesh" which is in fact a Type
     * in Chair.
     */
    @Test
    public void testChairlegalType_CheckType_Mesh() {
        String type = "Mesh";
        Chair aTestChair = new Chair("C1320", type, "Y", "N", "N", "N", 50, "002");

        Boolean expect = true;
        Boolean actual = aTestChair.checkType(type);
        assertEquals(expect, actual);
    }

    /**
     * Test: ChairlegalType_CheckType_Task
     * 
     * Description: Same Test as above, however, it is now matched with "Task" as a
     * type.
     */
    @Test
    public void testChairlegalType_CheckType_Task() {
        String type = "Task";
        Chair aTestChair = new Chair("C1320", type, "Y", "N", "N", "N", 50, "002");

        Boolean expect = true;
        Boolean actual = aTestChair.checkType(type);
        assertEquals(expect, actual);
    }

    /**
     * Test: ChairlegalType_CheckType_Kneeling
     * 
     * Description: Same Test as above, however, it is now matched with "Kneeling"
     * as a type.
     */
    @Test
    public void testChairlegalType_CheckType_Kneeling() {
        String type = "Kneeling";
        Chair aTestChair = new Chair("C1320", type, "Y", "N", "N", "N", 50, "002");

        Boolean expect = true;
        Boolean actual = aTestChair.checkType(type);
        assertEquals(expect, actual);
    }

    /**
     * Test: ChairlegalType_CheckType_Executive
     * 
     * Description: Same Test as above, however, it is now matched with "Executive"
     * as a type.
     */
    @Test
    public void testChairlegalType_CheckType_Executive() {
        String type = "Executive";
        Chair aTestChair = new Chair("C1320", type, "Y", "N", "N", "N", 50, "002");

        Boolean expect = true;
        Boolean actual = aTestChair.checkType(type);
        assertEquals(expect, actual);
    }

    /**
     * Test: ChairlegalType_CheckType_Ergonomic
     * 
     * Description: Same Test as above, however, it is now matched with "Ergonomic"
     * as a type.
     */
    @Test
    public void testChairlegalType_CheckType_Ergonomic() {
        String type = "Ergonomic";
        Chair aTestChair = new Chair("C1320", type, "Y", "N", "N", "N", 50, "002");

        Boolean expect = true;
        Boolean actual = aTestChair.checkType(type);
        assertEquals(expect, actual);
    }

}
