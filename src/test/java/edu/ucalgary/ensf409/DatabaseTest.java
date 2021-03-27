package edu.ucalgary.ensf409;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

import java.sql.SQLException;

@SpringBootTest
public class DatabaseTest {
    @Test
    public void testDBConnect() {
        Database testDb = new Database("jdbc:mysql://server.ratik.me:25565/db", "ensf409", "java123");
        try {
            testDb.connect();
        } catch (SQLException e) {
            fail("Err");
        }
    }

    @Test
    public void testFailDBConnect() {
        Database testDb = new Database("jdbc:mysql://server.ratik.me:25565/db", "ensf409", "java123");
        Boolean err = false;
        try {
            testDb.connect();
        } catch (SQLException e) {
            err = true;
        }
        assertTrue(err);
    }
}
