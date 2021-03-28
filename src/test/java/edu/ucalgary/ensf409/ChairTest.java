package edu.ucalgary.ensf409;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

import java.sql.SQLException;

@SpringBootTest
public class ChairTest {
    Chair aTestChair = new Chair("C1320", "Kneeling", "Y", "N", "N", "N", 50, "002");

    @Test
    public void ChairConstructorInheritance() {

        String actual = aTestChair.getManuID();
        String expect = "002";

        assertEquals("Cannot retrieve ManuID from Chair Parent", expect, actual);
    }

    @Test
    public void ChairCushionStringToBoolean() {

        boolean actual = aTestChair.getCushion();
        boolean expect = false;

        assertEquals("Chair String to Boolean Conversion Failed for Cushion", expect, actual);
    }
}
