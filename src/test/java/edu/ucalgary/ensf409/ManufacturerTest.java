package edu.ucalgary.ensf409;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

@SpringBootTest
public class ManufacturerTest {

    /**
     * Test: Manufacturer_getManuID_SetWithConstructor
     * 
     * Description: Checks whether ManuId set through constructor can be accessed
     * through the getManuID method.
     */
    @Test
    public void testManufacturer_getManuID_SetWithConstructor() {

        Manufacturer aTestManufacturer = new Manufacturer("001", "Academic Desks", "236-145-2542", "BC");
        String actual = aTestManufacturer.getManuid();
        String expect = "001";

        assertEquals("Cannot retrieve ManuID from Manufacturer", expect, actual);
    }

    /**
     * Test: Manufacturer_getName_SetWithConstructor
     * 
     * Description: Checks whether Name set through constructor can be accessed
     * through the getName method.
     */
    @Test
    public void testManufacturer_getName_SetWithConstructor() {

        Manufacturer aTestManufacturer = new Manufacturer("001", "Academic Desks", "236-145-2542", "BC");
        String actual = aTestManufacturer.getName();
        String expect = "Academic Desks";

        assertEquals("Cannot retrieve Name from Manufacturer", expect, actual);
    }

    /**
     * Test: Manufacturer_getPhone_SetWithConstructor
     * 
     * Description: Checks whether Name set through constructor can be accessed
     * through the getPhone method.
     */
    @Test
    public void testManufacturer_getPhone_SetWithConstructor() {

        Manufacturer aTestManufacturer = new Manufacturer("001", "Academic Desks", "236-145-2542", "BC");
        String actual = aTestManufacturer.getPhone();
        String expect = "236-145-2542";

        assertEquals("Cannot retrieve Phone from Manufacturer", expect, actual);
    }

    /**
     * Test: Manufacturer_getProvince_SetWithConstructor
     * 
     * Description: Checks whether Name set through constructor can be accessed
     * through the getPhone method.
     */
    @Test
    public void testManufacturer_getProvince_SetWithConstructor() {

        Manufacturer aTestManufacturer = new Manufacturer("001", "Academic Desks", "236-145-2542", "BC");
        String actual = aTestManufacturer.getProvince();
        String expect = "BC";

        assertEquals("Cannot retrieve Province from Manufacturer", expect, actual);
    }

    /**
     * Test: Manufacturer_printManufacturer
     * 
     * Description: Checks whether printManufacturer formatting is correct with
     * given paramaters in constructor.
     */
    @Test
    public void testManufacturer_printManufacturer() {

        Manufacturer aTestManufacturer = new Manufacturer("001", "Academic Desks", "236-145-2542", "BC");
        String actual = aTestManufacturer.printManufacturer();
        String expect = "001" + " " + "Academic Desks" + " " + "236-145-2542" + " " + "BC";

        assertEquals("Incorrect Formatting Found in printManufacturers", expect, actual);
    }
}
