package edu.ucalgary.ensf409;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

import java.sql.SQLException;

@SpringBootTest
public class DeskTest {

    @Test
    public void DeskConstructorInheritance() {
        Desk aTestDesk = new Desk("D3820", "Standing", "Y", "N", "N", 150, "001");

        String actual = aTestDesk.getType();
        String expect = "Standing";

        assertEquals("Cannot retrieve type from Desk Parent", expect, actual);
    }

    @Test
    public void DeskGetPrice() {
        Desk aTestDesk = new Desk("D3820", "Standing", "Y", "N", "N", 150, "001");

        int actual = aTestDesk.getPrice();
        int expect = 150;

        assertEquals("Desk getPrice failed", expect, actual);
    }
}
