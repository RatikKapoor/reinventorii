package edu.ucalgary.ensf409;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Tests for RESTManagerTest Class. Checking constructors. Cannot create unit
 * tests for other methods since they are end-to-end tests between frontend and
 * backend.
 * 
 * @version 1.1
 * @author Ratik Kapoor, Robert Brown, Risat Haque, Anand Patel
 */
@SpringBootTest
public class RESTManagerTest {
    @Test
    public void testCreateConstructor() {
        RESTManager restManager = new RESTManager();
        restManager.chairs("");
        restManager.desks("");
        restManager.filings("");
        restManager.lamps("");
    }
}
