package edu.ucalgary.ensf409;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

@SpringBootTest
public class DeskTest {

    /**
     * Test: Desk_getManuID_SetWithConstructor
     * 
     * Description: Checks whether ManuId set through constructor can be accessed
     * through the getManuID method. Desk inherits the getManuID method from
     * abstract class FurniturePart. This test validates the inheritance property
     * for ManuID.
     */
    @Test
    public void Desk_getManuID_SetWithConstructor() {

        Desk aTestDesk = new Desk("D3820", "Standing", "Y", "N", "N", 150, "001");
        String actual = aTestDesk.getManuID();
        String expect = "001";

        assertEquals("Cannot retrieve ManuID from Desk Parent", expect, actual);
    }

    /**
     * Test: Desk_getId_SetWithConstructor
     * 
     * Description: Checks whether id set through constructor can be accessed
     * through the getId method. Desk inherits the getId method from abstract class
     * FurniturePart. This test validates the inheritance property for id.
     */
    @Test
    public void Desk_getId_SetWithConstructor() {

        Desk aTestDesk = new Desk("D3820", "Standing", "Y", "N", "N", 150, "001");
        String actual = aTestDesk.getId();
        String expect = "D3820";

        assertEquals("Cannot retrieve id from Desk Parent", expect, actual);
    }

    /**
     * Test: Desk_getPrice_SetWithConstructor
     * 
     * Description: Checks whether price set through constructor can be accessed
     * through the getPrice method. Desk inherits the getPrice method from abstract
     * class FurniturePart. This test validates the inheritance property for price.
     */
    @Test
    public void Desk_getPrice_SetWithConstructor() {

        Desk aTestDesk = new Desk("D3820", "Standing", "Y", "N", "N", 150, "001");
        int actual = aTestDesk.getPrice();
        int expect = 150;

        assertEquals("Cannot retrieve price from Desk Parent", expect, actual);
    }

    /**
     * Test: Desk_getType_SetWithConstructor
     * 
     * Description: Checks whether type set through constructor can be accessed
     * through the getType method. Desk inherits the getType method from abstract
     * class FurniturePart. This test validates the inheritance property for type.
     */

    @Test
    public void Desk_getType_SetWithConstructor() {

        Desk aTestDesk = new Desk("D3820", "Standing", "Y", "N", "N", 150, "001");
        String actual = aTestDesk.getType();
        String expect = "Standing";

        assertEquals("Cannot retrieve type from Desk Parent", expect, actual);
    }

    /**
     * Test: Desk_QueryConstructor
     * 
     * Description: Checks whether query constructor with paramater type is
     * accepted.
     */

    @Test
    public void Desk_QueryConstructor() {

        Desk aTestDesk = new Desk("Standing");
        String actual = aTestDesk.getType();
        String expect = "Standing";

        assertEquals("Cannot retrieve type from Desk Parent", expect, actual);
    }

    /**
     * Test: Desk_DatabaseConstructor
     * 
     * Description: Checks whether database constructor with paramater data as an
     * ArrayList<String> and price is accepted. This test checks only if manuID is
     * correct.
     */
    @Test
    public void Desk_DatabaseConstructor() {
        ArrayList<String> aTestList = new ArrayList<>();
        aTestList.add("D3820");
        aTestList.add("Standing");
        aTestList.add("001");
        aTestList.add("Y");
        aTestList.add("N");
        aTestList.add("N");

        Desk aTestDesk = new Desk(aTestList, 150);
        String actual = aTestDesk.getManuID();
        String expect = "001";

        assertEquals("Cannot retrieve manuID from Desk Parent", expect, actual);
    }

    /**
     * Test: DeskIllegal_DatabaseConstructor
     * 
     * Description: Checks whether database constructor with paramater data as an
     * ArrayList<String> and price is accepted. This test checks only if manuID is
     * correct. In this case, ArrayList is too large.
     */
    @Test
    public void DeskIllegal_DatabaseConstructor() {
        ArrayList<String> aTestList = new ArrayList<>();
        aTestList.add("D3820");
        aTestList.add("Standing");
        aTestList.add("005");
        aTestList.add("Y");
        aTestList.add("Y");
        aTestList.add("N");
        aTestList.add("N"); // Incorrect here

        Boolean err = false;

        try {
            Desk aTestDesk = new Desk(aTestList, 50); // Fails here
        } catch (IllegalArgumentException e) {
            err = true;
        }
        assertTrue("Too many furniture types are passed into constructor using ArrayList", err);
    }

    /**
     * Test: Desk_StringToBoolean_Legs_False
     * 
     * Description: Checks whether the String to Boolean conversion is accurate.
     * Tests a False Statement, "N".
     */
    @Test
    public void Desk_StringToBoolean_Legs_False() {

        Desk aTestDesk = new Desk("D2311", "Standing", "N", "N", "N", 150, "001");
        boolean actual = aTestDesk.stringToBoolean("N");
        boolean expect = false;

        assertEquals("Desk String to Boolean Conversion Failed for Legs", expect, actual);
    }

    /**
     * Test: Desk_StringToBoolean_Cushion_True
     * 
     * Description: Checks whether the String to Boolean conversion is accurate.
     * Tests a True Statement, "Y".
     */
    @Test
    public void DeskIllegal_StringToBoolean_Cushion_True() {
        Desk aTestDesk = new Desk("D3820", "Standing", "Y", "N", "N", 150, "001");
        boolean actual = aTestDesk.stringToBoolean("Y");
        boolean expect = true;
        assertEquals("Desk String to Boolean Conversion Failed for Legs", expect, actual);

    }

    /**
     * Test: Desk_getLegs_SetWithConstructor
     * 
     * Description: Checks whether legs set through constructor can be accessed
     * through the getLegs method.
     */
    @Test
    public void Desk_getLegs_SetWithConstructor() {

        Desk aTestDesk = new Desk("D3820", "Standing", "Y", "N", "N", 150, "001");
        boolean actual = aTestDesk.getLegs();
        boolean expect = true;

        assertEquals("Cannot retrieve legs from Desk", expect, actual);
    }

    /**
     * Test: Desk_getTop_SetWithConstructor
     * 
     * Description: Checks whether cushion set through constructor can be accessed
     * through the getTop method.
     */
    @Test
    public void Desk_getTop_SetWithConstructor() {

        Desk aTestDesk = new Desk("D3820", "Standing", "Y", "N", "N", 150, "001");
        boolean actual = aTestDesk.getTop();
        boolean expect = false;

        assertEquals("Cannot retrieve cushion from Desk", expect, actual);
    }

    /**
     * Test: Desk_getDrawer_SetWithConstructor
     * 
     * Description: Checks whether drawer set through constructor can be accessed
     * through the getDrawer method.
     */
    @Test
    public void Desk_getDrawer_SetWithConstructor() {

        Desk aTestDesk = new Desk("D3820", "Standing", "Y", "N", "N", 150, "001");
        boolean actual = aTestDesk.getDrawer();
        boolean expect = false;

        assertEquals("Cannot retrieve drawer from Desk", expect, actual);
    }

    /**
     * Test: DeskLegalType_Constructor
     * 
     * Description: Checks if the furniture type is legal, as in matches the
     * predefined Enum in the FurniturePart abstract class. This test checks a valid
     * type: "Standing" for for furniture Desk.
     */
    @Test
    public void DeskLegalType_Constructor() {

        Desk aTestDesk = new Desk("D3820", "Standing", "Y", "N", "N", 150, "001");
        String actual = aTestDesk.getType();
        String expect = "Standing";

        assertEquals("Standing Desk type defined through constructor", expect, actual);
    }

    /**
     * Test: DeskIllegalType_Constructor
     * 
     * Description: Checks if the furniture type is illegal, as in does not match
     * the predefined Enum in the FurniturePart abstract class. This test checks an
     * invalid type: "aFakeType" for for furniture Desk. A custom exception is
     * thrown.
     */
    @Test
    public void DeskIllegalType_Constructor() {
        String type = "aFakeType";
        Boolean err = false;
        try {
            Desk aTestDesk = new Desk("D3820", type, "Y", "N", "N", 150, "001");
        } catch (IllegalFurnitureTypeException e) {
            err = true;
        }
        assertTrue("IllegalFurnitureTypeException", err);
    }

    /**
     * Test: DeskIllegalType_DefaultConstructor
     * 
     * Description: Checks if the furniture type is illegal, as in does not match
     * the predefined Enum in the FurniturePart abstract class. This test checks an
     * invalid type: "aFakeType" for for furniture Desk. A custom exception is
     * thrown. This test specifically checks the Default Constructor where only the
     * furniture type (String) is required as a paramater.
     */
    @Test
    public void DeskIllegalType_DefaultConstructor() {
        String type = "aFakeType";
        Boolean err = false;
        try {
            Desk aTestDesk = new Desk(type);
        } catch (IllegalFurnitureTypeException e) {
            err = true;
        }
        assertTrue("IllegalFurnitureTypeException", err);
    }

    /**
     * Test: DeskIllegalType_CheckType_False1
     * 
     * Description: Checks whether the CheckType abstract method returns a False
     * when an incorrect type is tested (that does not match the Types Enum in the
     * FurniturePart class). The tested paramater is "aFakeType"
     */
    @Test
    public void DeskIllegalType_CheckType_False1() {
        String type = "aFakeType";
        Boolean expect = false;
        Desk aTestDesk = new Desk("D3820", "Standing", "Y", "N", "N", 150, "001");

        Boolean actual = aTestDesk.checkType(type);
        assertEquals(expect, actual);
    }

    /**
     * Test: DeskIllegalType_CheckType_False2
     * 
     * Description: Checks whether the CheckType abstract method returns a False
     * when an incorrect type is tested (that does not match the Types Enum in the
     * FurniturePart class). The tested paramater is "standing" This checks that the
     * tests are in fact case SENSITIVE
     */
    @Test
    public void DeskIllegalType_CheckType_False2() {
        String type = "standing";
        Boolean expect = false;
        Desk aTestDesk = new Desk("D3820", "Standing", "Y", "N", "N", 150, "001");

        Boolean actual = aTestDesk.checkType(type);
        assertEquals(expect, actual);
    }

    /**
     * Test: DeskIllegalType_CheckType_False3
     * 
     * Description: Checks whether the CheckType abstract method returns a False
     * when an incorrect type is tested (that does not match the Types Enum in the
     * FurniturePart class). The tested paramater is "Ergonomic" This type is
     * accepted for Chair not Desk. Ergonomic is put into the constructor since this
     * test is specifically for the checkType method and not the constructor
     */
    @Test
    public void DeskIllegalType_CheckType_False3() {
        String type = "Ergonomic";
        Boolean expect = false;
        Desk aTestDesk = new Desk("D3820", "Standing", "Y", "N", "N", 150, "001");

        Boolean actual = aTestDesk.checkType(type);
        assertEquals(expect, actual);
    }

    /**
     * Test: DesklegalType_CheckType_Traditional
     * 
     * Description: Checks whether the CheckType abstract method returns a True when
     * a correct type is tested (that does not match the Types Enum in the
     * FurniturePart class). The tested paramater is "Traditional" which is in fact
     * a Type in Desk.
     */
    @Test
    public void DesklegalType_CheckType_Traditional() {
        String type = "Traditional";
        Desk aTestDesk = new Desk("D1111", type, "N", "N", "Y", 2, "101");

        Boolean expect = true;
        Boolean actual = aTestDesk.checkType(type);
        assertEquals(expect, actual);
    }

    /**
     * Test: DesklegalType_CheckType_Adjustable
     * 
     * Description: Same Test as above, however, it is now matched with "Adjustable"
     * as a type.
     */
    @Test
    public void DesklegalType_CheckType_Adjustable() {
        String type = "Adjustable";
        Desk aTestDesk = new Desk("D3820", type, "Y", "N", "N", 150, "001");

        Boolean expect = true;
        Boolean actual = aTestDesk.checkType(type);
        assertEquals(expect, actual);
    }

    /**
     * Test: DesklegalType_CheckType_Standing
     * 
     * Description: Same Test as above, however, it is now matched with "Standing"
     * as a type.
     */
    @Test
    public void DesklegalType_CheckType_Standing() {
        String type = "Standing";
        Desk aTestDesk = new Desk("D3820", type, "Y", "N", "N", 150, "001");

        Boolean expect = true;
        Boolean actual = aTestDesk.checkType(type);
        assertEquals(expect, actual);
    }

}
