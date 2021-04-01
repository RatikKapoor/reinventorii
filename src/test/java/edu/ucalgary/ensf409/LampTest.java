package edu.ucalgary.ensf409;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

import java.sql.SQLException;

@SpringBootTest
public class LampTest {

    @Test
    public void lampConstructorInheritance() {
        Lamp aTestLamp = new Lamp("L132", "Desk", "Y", "N", 18, "005");

        String actual = aTestLamp.getManuID();
        String expect = "005";

        assertEquals("Cannot retrieve ManuID from Lamp Parent", expect, actual);
    }

    @Test
    public void lampBaseStringToBoolean() {
        Lamp aTestLamp = new Lamp("L132", "Desk", "Y", "N", 18, "005");

        boolean actual = aTestLamp.getBase();
        boolean expect = true;

        assertEquals("Lamp String to Boolean Conversion Failed for Base", expect, actual);
    }
}
