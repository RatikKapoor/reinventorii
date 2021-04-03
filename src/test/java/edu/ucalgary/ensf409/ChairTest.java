package edu.ucalgary.ensf409;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.*;
import static org.junit.Assert.*;

import java.sql.SQLException;

@SpringBootTest
public class ChairTest {

    @Test
    public void ChairConstructorInheritance() {

        Chair aTestChair = new Chair("C1320", "Kneeling", "Y", "N", "N", "N", 50, "002");
        String actual = aTestChair.getManuID();
        String expect = "002";

        assertEquals("Cannot retrieve ManuID from Chair Parent", expect, actual);
    }

    @Test
    public void ChairCushionStringToBoolean() {

        Chair aTestChair = new Chair("C1320", "Kneeling", "Y", "N", "N", "N", 50, "002");
        boolean actual = aTestChair.getCushion();
        boolean expect = false;

        assertEquals("Chair String to Boolean Conversion Failed for Cushion", expect, actual);
    }

    @Test
    public void ChairIllegalType() {
        String type = "aFakeType";
        Boolean err = false;
        try {
            Chair aTestChair = new Chair("C1320", type, "Y", "N", "N", "N", 50, "002");
        } catch (IllegalFurnitureTypeException e) {
            err = true;
        }
        assertTrue("IllegalFurnitureTypeException", err);
    }
}
