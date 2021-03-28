package edu.ucalgary.ensf409;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

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
