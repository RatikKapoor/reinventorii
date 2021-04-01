package edu.ucalgary.ensf409;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

import java.sql.SQLException;

@SpringBootTest
public class FilingTest {
    @Test
    public void FilingConstructorInheritance() {
        Filing aTestFiling = new Filing("F001", "Small", "Y", "Y", "N", 50, "005");

        String actual = aTestFiling.getManuID();
        String expect = "005";

        assertEquals("Cannot retrieve ManuID from Filing Parent", expect, actual);
    }

    @Test
    public void FilingGetPrice() {
        Filing aTestFiling = new Filing("F001", "Small", "Y", "Y", "N", 50, "005");

        int actual = aTestFiling.getPrice();
        int expect = 50;

        assertEquals("Filing getPrice failed", expect, actual);
    }
}
