package edu.ucalgary.ensf409;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

/**
 * Tests for Lamp Class and FurnitureType Methods used by Lamp
 * 
 * @version 1.1
 * @author Risat Haque
 */
@SpringBootTest
public class LampTest {

    /**
     * Test: Lamp_getManuID_SetWithConstructor
     * 
     * Description: Checks whether ManuId set through constructor can be accessed
     * through the getManuID method. Lamp inherits the getManuID method from
     * abstract class FurniturePart. This test validates the inheritance property
     * for ManuID.
     */
    @Test
    public void testLamp_getManuID_SetWithConstructor() {

        Lamp aTestLamp = new Lamp("L132", "Desk", "Y", "N", 18, "005");
        String actual = aTestLamp.getManuID();
        String expect = "005";

        assertEquals("Cannot retrieve ManuID from Lamp Parent", expect, actual);
    }

    /**
     * Test: Lamp_getId_SetWithConstructor
     * 
     * Description: Checks whether id set through constructor can be accessed
     * through the getId method. Lamp inherits the getId method from abstract class
     * FurniturePart. This test validates the inheritance property for id.
     */
    @Test
    public void testLamp_getId_SetWithConstructor() {

        Lamp aTestLamp = new Lamp("L132", "Desk", "Y", "N", 18, "005");
        String actual = aTestLamp.getId();
        String expect = "L132";

        assertEquals("Cannot retrieve id from Lamp Parent", expect, actual);
    }

    /**
     * Test: Lamp_getPrice_SetWithConstructor
     * 
     * Description: Checks whether price set through constructor can be accessed
     * through the getPrice method. Lamp inherits the getPrice method from abstract
     * class FurniturePart. This test validates the inheritance property for price.
     */
    @Test
    public void testLamp_getPrice_SetWithConstructor() {

        Lamp aTestLamp = new Lamp("L132", "Desk", "Y", "N", 18, "005");
        int actual = aTestLamp.getPrice();
        int expect = 18;

        assertEquals("Cannot retrieve price from Lamp Parent", expect, actual);
    }

    /**
     * Test: Lamp_getType_SetWithConstructor
     * 
     * Description: Checks whether type set through constructor can be accessed
     * through the getType method. Lamp inherits the getType method from abstract
     * class FurniturePart. This test validates the inheritance property for type.
     */

    @Test
    public void testLamp_getType_SetWithConstructor() {

        Lamp aTestLamp = new Lamp("L132", "Desk", "Y", "N", 18, "005");
        String actual = aTestLamp.getType();
        String expect = "Desk";

        assertEquals("Cannot retrieve type from Lamp Parent", expect, actual);
    }

    /**
     * Test: Lamp_QueryConstructor
     * 
     * Description: Checks whether query constructor with paramater type is
     * accepted.
     */

    @Test
    public void testLamp_QueryConstructor() {

        Lamp aTestLamp = new Lamp("Swing Arm");
        String actual = aTestLamp.getType();
        String expect = "Swing Arm";

        assertEquals("Cannot retrieve type from Lamp Parent", expect, actual);
    }

    /**
     * Test: LampIllegal_QueryConstructor
     * 
     * Description: Checks whether query constructor with paramater type is
     * accepted. In this case, exception is thrown.
     */

    @Test
    public void testLampIllegal_QueryConstructor() {

        boolean err = false;
        try {
            Lamp aTestLamp = new Lamp("Glass");
        } catch (IllegalFurnitureTypeException e) {
            err = true;
        }
        assertTrue("Glass is not an accepted type in FurnitureType Enum. Must throw exception", err);
    }

    /**
     * Test: Lamp_DatabaseConstructor
     * 
     * Description: Checks whether database constructor with paramater data as an
     * ArrayList<String> and price is accepted. This test checks only if manuID is
     * correct.
     */
    @Test
    public void testLamp_DatabaseConstructor() {
        ArrayList<String> aTestList = new ArrayList<>();
        aTestList.add("L132");
        aTestList.add("Desk");
        aTestList.add("014");
        aTestList.add("Y");
        aTestList.add("Y");

        Lamp aTestLamp = new Lamp(aTestList, 18);
        String actual = aTestLamp.getManuID();
        String expect = "014";

        assertEquals("Cannot retrieve manuID from Lamp Parent", expect, actual);
    }

    /**
     * Test: LampIllegal_DatabaseConstructor
     * 
     * Description: Checks whether database constructor with paramater data as an
     * ArrayList<String> and price is accepted. This test checks only if manuID is
     * correct. In this case, ArrayList is too large.
     */
    @Test
    public void testLampIllegal_DatabaseConstructor() {
        ArrayList<String> aTestList = new ArrayList<>();
        aTestList.add("L132");
        aTestList.add("Desk");
        aTestList.add("005");
        aTestList.add("Y");
        aTestList.add("Y");
        aTestList.add("N"); // Incorrect

        Boolean err = false;

        try {
            Lamp aTestLamp = new Lamp(aTestList, 50); // Fails here
        } catch (IllegalArgumentException e) {
            err = true;
        }
        assertTrue("Too many furniture types are passed into constructor using ArrayList", err);
    }

    /**
     * Test: Lamp_StringToBoolean_Base_False
     * 
     * Description: Checks whether the String to Boolean conversion is accurate.
     * variables of similar nature include the same stringToBoolean method. Tests a
     * False Statement
     */
    @Test
    public void testLamp_StringToBoolean_Base_False() {

        Lamp aTestLamp = new Lamp("L132", "Desk", "N", "N", 18, "005");
        boolean actual = aTestLamp.stringToBoolean("N");
        boolean expect = false;

        assertEquals("Lamp String to Boolean Conversion Failed for Base", expect, actual);
    }

    /**
     * Test: Lamp_StringToBoolean_Base_True
     * 
     * Description: Checks whether the String to Boolean conversion is accurate. All
     * variables of similar nature include the same stringToBoolean method. Tests a
     * True Statement
     */
    @Test
    public void testLampIllegal_StringToBoolean_Cushion_True() {
        Lamp aTestLamp = new Lamp("L132", "Desk", "Y", "N", 18, "005");
        boolean actual = aTestLamp.stringToBoolean("Y");
        boolean expect = true;
        assertEquals("Lamp String to Boolean Conversion Failed for Base", expect, actual);

    }

    /**
     * Test: Lamp_getBase_SetWithConstructor
     * 
     * Description: Checks whether legs set through constructor can be accessed
     * through the getBase method.
     */
    @Test
    public void testLamp_getCabinet_SetWithConstructor() {

        Lamp aTestLamp = new Lamp("L132", "Desk", "Y", "N", 18, "005");
        boolean actual = aTestLamp.getBase();
        boolean expect = true;

        assertEquals("Cannot retrieve base from Lamp", expect, actual);
    }

    /**
     * Test: Lamp_getBulb_SetWithConstructor
     * 
     * Description: Checks whether cushion set through constructor can be accessed
     * through the getBulb method.
     */
    @Test
    public void testLamp_getRails_SetWithConstructor() {

        Lamp aTestLamp = new Lamp("L132", "Desk", "Y", "N", 18, "005");
        boolean actual = aTestLamp.getBulb();
        boolean expect = false;

        assertEquals("Cannot retrieve rails from bulb", expect, actual);
    }

    /**
     * Test: LampLegalType_Constructor
     * 
     * Description: Checks if the furniture type is legal, as in matches the
     * predefined Enum in the FurniturePart abstract class. This test checks a valid
     * type: "Desk" for for furniture Lamp.
     */
    @Test
    public void testLampLegalType_Constructor() {

        Lamp aTestLamp = new Lamp("L132", "Desk", "Y", "N", 18, "005");
        String actual = aTestLamp.getType();
        String expect = "Desk";

        assertEquals("Desk Lamp type defined through constructor", expect, actual);
    }

    /**
     * Test: LampIllegalType_Constructor
     * 
     * Description: Checks if the furniture type is illegal, as in does not match
     * the predefined Enum in the FurniturePart abstract class. This test checks an
     * invalid type: "aFakeType" for for furniture Lamp. A custom exception is
     * thrown.
     */
    @Test
    public void testLampIllegalType_Constructor() {
        String type = "aFakeType";
        Boolean err = false;
        try {
            Lamp aTestLamp = new Lamp("L132", type, "Y", "N", 18, "005");
        } catch (IllegalFurnitureTypeException e) {
            err = true;
        }
        assertTrue("IllegalFurnitureTypeException", err);
    }

    /**
     * Test: LampIllegalType_DefaultConstructor
     * 
     * Description: Checks if the furniture type is illegal, as in does not match
     * the predefined Enum in the FurniturePart abstract class. This test checks an
     * invalid type: "aFakeType" for for furniture Lamp. A custom exception is
     * thrown. This test specifically checks the Default Constructor where only the
     * furniture type (String) is required as a paramater.
     */
    @Test
    public void testLampIllegalType_DefaultConstructor() {
        String type = "aFakeType";
        Boolean err = false;
        try {
            Lamp aTestLamp = new Lamp(type);
        } catch (IllegalFurnitureTypeException e) {
            err = true;
        }
        assertTrue("IllegalFurnitureTypeException", err);
    }

    /**
     * Test: LampIllegalType_CheckType_False1
     * 
     * Description: Checks whether the CheckType abstract method returns a False
     * when an incorrect type is tested (that does not match the Types Enum in the
     * FurniturePart class). The tested paramater is "aFakeType"
     */
    @Test
    public void testLampIllegalType_CheckType_False1() {
        String type = "aFakeType";
        Boolean expect = false;

        // The following statement is correct since we are specifically checking if the
        // checkType method is valid not the constructor.
        Lamp aTestLamp = new Lamp("L132", "Desk", "Y", "N", 18, "005");

        Boolean actual = aTestLamp.checkType(type);
        assertEquals(expect, actual);
    }

    /**
     * Test: LampIllegalType_CheckType_False2
     * 
     * Description: Checks whether the CheckType abstract method returns a False
     * when an incorrect type is tested (that does not match the Types Enum in the
     * FurniturePart class). The tested paramater is "desk" This checks that the
     * tests are in fact case SENSITIVE
     */
    @Test
    public void testLampIllegalType_CheckType_False2() {
        String type = "desk";
        Boolean expect = false;
        Lamp aTestLamp = new Lamp("L132", "Desk", "Y", "N", 18, "005");

        Boolean actual = aTestLamp.checkType(type);
        assertEquals(expect, actual);
    }

    /**
     * Test: LampIllegalType_CheckType_False3
     * 
     * Description: Checks whether the CheckType abstract method returns a False
     * when an incorrect type is tested (that does not match the Types Enum in the
     * FurniturePart class). The tested paramater is "Ergonomic" This type is
     * accepted for Chair not Lamp. Ergonomic is put into the constructor since this
     * test is specifically for the checkType method and not the constructor
     */
    @Test
    public void testLampIllegalType_CheckType_False3() {
        String type = "Ergonomic";
        Boolean expect = false;
        Lamp aTestLamp = new Lamp("L132", "Desk", "Y", "N", 18, "005");

        Boolean actual = aTestLamp.checkType(type);
        assertEquals(expect, actual);
    }

    /**
     * Test: LamplegalType_CheckType_Desk
     * 
     * Description: Checks whether the CheckType abstract method returns a True when
     * a correct type is tested (that does not match the Types Enum in the
     * FurniturePart class). The tested paramater is "Desk" which is in fact a Type
     * in Desk.
     */
    @Test
    public void testLamplegalType_CheckType_Desk() {
        String type = "Desk";
        Lamp aTestLamp = new Lamp("L132", type, "Y", "N", 18, "005");

        Boolean expect = true;
        Boolean actual = aTestLamp.checkType(type);
        assertEquals(expect, actual);
    }

    /**
     * Test: LamplegalType_CheckType_SwingArm
     * 
     * Description: Same Test as above, however, it is now matched with "Swing Arm"
     * as a type.
     */
    @Test
    public void testLamplegalType_CheckType_SwingArm() {
        String type = "Swing Arm";
        Lamp aTestLamp = new Lamp("L132", type, "Y", "N", 18, "005");

        Boolean expect = true;
        Boolean actual = aTestLamp.checkType(type);
        assertEquals(expect, actual);
    }

    /**
     * Test: LamplegalType_CheckType_Study
     * 
     * Description: Same Test as above, however, it is now matched with "Study" as a
     * type.
     */
    @Test
    public void testLamplegalType_CheckType_Study() {
        String type = "Study";
        Lamp aTestLamp = new Lamp("L132", type, "Y", "N", 18, "005");

        Boolean expect = true;
        Boolean actual = aTestLamp.checkType(type);
        assertEquals(expect, actual);
    }
}
