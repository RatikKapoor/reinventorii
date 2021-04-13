package edu.ucalgary.ensf409;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

/**
 * Tests for RESTManagerTest Class. Checking constructors. Cannot create unit
 * tests for other methods since they are end-to-end tests between frontend and
 * backend.
 * 
 * @version 1.1
 * @author Risat Haque, Ratik Kapoor, Robert Brown, Anand Patel
 * @since 1.0
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
