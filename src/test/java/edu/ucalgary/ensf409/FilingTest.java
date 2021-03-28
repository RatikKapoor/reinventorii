package edu.ucalgary.ensf409;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

import java.sql.SQLException;

@SpringBootTest
public class FilingTest {
    Filing aTestFiling = new Filing("F001", "Small", "Y", "Y", "N", 50, "005");

    @Test
    public void FilingConstructorInheritance() {

        String actual = aTestFiling.getManuID();
        String expect = "005";

        assertEquals("Cannot retrieve ManuID from Filing Parent", expect, actual);
    }

    @Test
    public void FilingGetPrice() {

        int actual = aTestFiling.getPrice();
        int expect = 50;

        assertEquals("Filing getPrice failed", expect, actual);
    }
}
