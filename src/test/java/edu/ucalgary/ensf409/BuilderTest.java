package edu.ucalgary.ensf409;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.sql.SQLException;
import edu.ucalgary.ensf409.FurniturePart.Types;

@SpringBootTest
public class BuilderTest {
    /**
     * Requests one lamp of type desk to be built. Tests if the cheapest cost is
     * correct.
     */
    @Test
    public void LampBuildCostTest() {
        Database test = new Database("jdbc:mysql://server.ratik.me:25565/INVENTORY", "root", "eNsF409");
        try {
            test = new Database("jdbc:mysql://server.ratik.me:25565/INVENTORY", "root", "eNsF409");
            test.connect();

        } catch (SQLException e) {
            System.out.println("SQL Exception");
        }

        Lamp l = new Lamp("Desk");
        ArrayList<Lamp> allLamps = test.getListByType(Types.Lamp, "Desk");
        Builder<Lamp> b = new Builder<Lamp>(l);
        b.setParts(allLamps);
        b.setItems();
        b.BuildMultipleItems(1);

        int actual = b.getCost();
        int expect = 20;
        test.disconnect();
        assertEquals("Lamp cost is wrong", expect, actual);
    }

    /**
     * Requests one lamp of type desk to be built. Tests if the cheapest id
     * combination is correct.
     */
    @Test
    public void LampBuildIdTest() {
        Database test = new Database("jdbc:mysql://server.ratik.me:25565/INVENTORY", "root", "eNsF409");
        try {
            test = new Database("jdbc:mysql://server.ratik.me:25565/INVENTORY", "root", "eNsF409");
            test.connect();

        } catch (SQLException e) {
            System.out.println("SQL Exception");
        }

        Lamp l = new Lamp("Desk");
        ArrayList<Lamp> allLamps = test.getListByType(Types.Lamp, "Desk");
        Builder<Lamp> b = new Builder<Lamp>(l);
        b.setParts(allLamps);
        b.setItems();
        b.BuildMultipleItems(1);

        ArrayList<String> actual = b.getidCombination();
        ArrayList<String> expect = new ArrayList<>();
        expect.add("L208");
        expect.add("L013");
        test.disconnect();
        assertEquals("Lamp id combinations is wrong", expect, actual);
    }

    /**
     * Requests six lamp of type desk to be built; should not be able to build six
     * lamps of type desk. Tests if the correct cost is returned. Should be -1
     * indicating that the lamps cannot be built.
     */
    @Test
    public void LampBuildCostTestFail() {
        Database test = new Database("jdbc:mysql://server.ratik.me:25565/INVENTORY", "root", "eNsF409");
        try {
            test = new Database("jdbc:mysql://server.ratik.me:25565/INVENTORY", "root", "eNsF409");
            test.connect();

        } catch (SQLException e) {
            System.out.println("SQL Exception");
        }

        Lamp l = new Lamp("Desk");
        ArrayList<Lamp> allLamps = test.getListByType(Types.Lamp, "Desk");
        Builder<Lamp> b = new Builder<Lamp>(l);
        b.setParts(allLamps);
        b.setItems();
        b.BuildMultipleItems(6);

        int expect = b.getCost();
        int actual = -1;
        test.disconnect();
        assertEquals("Lamp cost is wrong, shouldn't be able to build this lamp", expect, actual);
    }

    /**
     * Requests six lamp of type of desk to be built; should not be able to build
     * six lamps of type desk. Tests if the correct combination of ids is returned.
     * Should be null, indicating that the lamps cannot be built.
     */
    @Test
    public void LampBuildIdTestFail() {
        Database test = new Database("jdbc:mysql://server.ratik.me:25565/INVENTORY", "root", "eNsF409");
        try {
            test = new Database("jdbc:mysql://server.ratik.me:25565/INVENTORY", "root", "eNsF409");
            test.connect();

        } catch (SQLException e) {
            System.out.println("SQL Exception");
        }

        Lamp l = new Lamp("Desk");
        ArrayList<Lamp> allLamps = test.getListByType(Types.Lamp, "Desk");
        Builder<Lamp> b = new Builder<Lamp>(l);
        b.setParts(allLamps);
        b.setItems();
        b.BuildMultipleItems(6);

        ArrayList<String> actual = b.getidCombination();

        ArrayList<String> expect = new ArrayList<>();
        expect = null;
        test.disconnect();
        assertEquals("Lamp id combinations is wrong, shouldn't be able to build this lamp", expect, actual);
    }

    /**
     * Requests one Desk of type Traditional to be built. Tests if the cheapest cost
     * is correct.
     */
    @Test
    public void DeskBuildCostTest() {
        Database test = new Database("jdbc:mysql://server.ratik.me:25565/INVENTORY", "root", "eNsF409");
        try {
            test = new Database("jdbc:mysql://server.ratik.me:25565/INVENTORY", "root", "eNsF409");
            test.connect();

        } catch (SQLException e) {
            System.out.println("SQL Exception");
        }

        Desk d = new Desk("Traditional");
        ArrayList<Desk> allDesks = test.getListByType(Types.Desk, "Traditional");
        Builder<Desk> b = new Builder<Desk>(d);
        b.setParts(allDesks);
        b.setItems();
        b.BuildMultipleItems(1);

        int actual = b.getCost();
        int expect = 100;
        test.disconnect();
        assertEquals("Lamp cost is wrong", expect, actual);
    }

    /**
     * Requests one Desk of type Traditional to be built. Tests if the cheapest id
     * combination is correct.
     */
    @Test
    public void DeskBuildIdTest() {
        Database test = new Database("jdbc:mysql://server.ratik.me:25565/INVENTORY", "root", "eNsF409");
        try {
            test = new Database("jdbc:mysql://server.ratik.me:25565/INVENTORY", "root", "eNsF409");
            test.connect();

        } catch (SQLException e) {
            System.out.println("SQL Exception");
        }

        Desk d = new Desk("Traditional");
        ArrayList<Desk> allDesks = test.getListByType(Types.Desk, "Traditional");
        Builder<Desk> b = new Builder<Desk>(d);
        b.setParts(allDesks);
        b.setItems();
        b.BuildMultipleItems(1);

        ArrayList<String> actual = b.getidCombination();
        ArrayList<String> expect = new ArrayList<>();
        expect.add("D0890");
        expect.add("D8675");
        test.disconnect();
        assertEquals("Desk id combination is wrong", expect, actual);
    }

    /**
     * Requests six Desks of type Traditional to be built; should not be able to
     * build six Desks of type Traditional. Should be null, indicating that the
     * lamps cannot be built.
     */
    @Test
    public void DeskBuildIdTestFail() {
        Database test = new Database("jdbc:mysql://server.ratik.me:25565/INVENTORY", "root", "eNsF409");
        try {
            test = new Database("jdbc:mysql://server.ratik.me:25565/INVENTORY", "root", "eNsF409");
            test.connect();

        } catch (SQLException e) {
            System.out.println("SQL Exception");
        }

        Desk d = new Desk("Traditional");
        ArrayList<Desk> allDesks = test.getListByType(Types.Desk, "Traditional");
        Builder<Desk> b = new Builder<Desk>(d);
        b.setParts(allDesks);
        b.setItems();
        b.BuildMultipleItems(6);

        ArrayList<String> actual = b.getidCombination();
        ArrayList<String> expect = new ArrayList<>();
        expect = null;
        test.disconnect();
        assertEquals("Desk id combinations is wrong, shouldn't be able to build this desk", expect, actual);
    }

    /**
     * Requests six Desks of type Traditional to be built; should not be able to
     * build six Desks of type Traditional. Tests if the correct cost is returned.
     * Should be -1 indicating that the lamps cannot be built.
     */
    @Test
    public void DeskBuildCostTestFail() {
        Database test = new Database("jdbc:mysql://server.ratik.me:25565/INVENTORY", "root", "eNsF409");
        try {
            test = new Database("jdbc:mysql://server.ratik.me:25565/INVENTORY", "root", "eNsF409");
            test.connect();

        } catch (SQLException e) {
            System.out.println("SQL Exception");
        }

        Desk d = new Desk("Traditional");
        ArrayList<Desk> allDesks = test.getListByType(Types.Desk, "Traditional");
        Builder<Desk> b = new Builder<Desk>(d);
        b.setParts(allDesks);
        b.setItems();
        b.BuildMultipleItems(6);

        int actual = b.getCost();
        int expect = -1;
        test.disconnect();
        assertEquals("Desk cost is wrong, shouldn't be able to build this Desk", expect, actual);
    }

    /**
     * Requests one Chair of type Mesh to be built. Test if the cheapest cost is
     * correct.
     */
    @Test
    public void ChairBuildCostTest() {
        Database test = new Database("jdbc:mysql://server.ratik.me:25565/INVENTORY", "root", "eNsF409");
        try {
            test = new Database("jdbc:mysql://server.ratik.me:25565/INVENTORY", "root", "eNsF409");
            test.connect();

        } catch (SQLException e) {
            System.out.println("SQL Exception");
        }

        Chair c = new Chair("Mesh");
        ArrayList<Chair> allChairs = test.getListByType(Types.Chair, "Mesh");
        Builder<Chair> b = new Builder<Chair>(c);
        b.setParts(allChairs);
        b.setItems();
        b.BuildMultipleItems(1);

        int actual = b.getCost();
        int expect = 150;
        test.disconnect();
        assertEquals("Chair cost is wrong", expect, actual);
    }

    /**
     * Requests one Chair of type Mesh to be built. Tests if the cheapest id
     * combination is correct.
     */
    @Test
    public void ChairBuildIdTest() {
        Database test = new Database("jdbc:mysql://server.ratik.me:25565/INVENTORY", "root", "eNsF409");
        try {
            test = new Database("jdbc:mysql://server.ratik.me:25565/INVENTORY", "root", "eNsF409");
            test.connect();

        } catch (SQLException e) {
            System.out.println("SQL Exception");
        }

        Chair c = new Chair("Mesh");
        ArrayList<Chair> allChairs = test.getListByType(Types.Chair, "Mesh");
        Builder<Chair> b = new Builder<Chair>(c);
        b.setParts(allChairs);
        b.setItems();
        b.BuildMultipleItems(1);

        ArrayList<String> actual = b.getidCombination();
        ArrayList<String> expect = new ArrayList<>();
        expect.add("C9890");
        expect.add("C0942");
        test.disconnect();
        assertEquals("Chair id combination is wrong", expect, actual);
    }

    /**
     * Requests six Chairs of type Mesh to be built; should not be able to build six
     * Chairs of type Mesh. Tets if the correct cost is returned. Should be -1
     * indicating that the Chairs cannot be built.
     */
    @Test
    public void ChairBuildCostTestFail() {
        Database test = new Database("jdbc:mysql://server.ratik.me:25565/INVENTORY", "root", "eNsF409");
        try {
            test = new Database("jdbc:mysql://server.ratik.me:25565/INVENTORY", "root", "eNsF409");
            test.connect();

        } catch (SQLException e) {
            System.out.println("SQL Exception");
        }

        Chair c = new Chair("Mesh");
        ArrayList<Chair> allChairs = test.getListByType(Types.Chair, "Mesh");
        Builder<Chair> b = new Builder<Chair>(c);
        b.setParts(allChairs);
        b.setItems();
        b.BuildMultipleItems(6);

        int actual = b.getCost();
        int expect = -1;
        test.disconnect();
        assertEquals("Chair cost is wrong, shouldn't be able to build this Chair", expect, actual);
    }

    /**
     * Requests six Chairs of type Mesh to be built; should not be able to build six
     * Chairs. Tests if the correct combination of ids is returned. Should be null,
     * indicating that the Chairs cannot be built.
     */
    @Test
    public void ChairBuildIdTestFail() {
        Database test = new Database("jdbc:mysql://server.ratik.me:25565/INVENTORY", "root", "eNsF409");
        try {
            test = new Database("jdbc:mysql://server.ratik.me:25565/INVENTORY", "root", "eNsF409");
            test.connect();

        } catch (SQLException e) {
            System.out.println("SQL Exception");
        }

        Chair c = new Chair("Mesh");
        ArrayList<Chair> allChairs = test.getListByType(Types.Chair, "Mesh");
        Builder<Chair> b = new Builder<Chair>(c);
        b.setParts(allChairs);
        b.setItems();
        b.BuildMultipleItems(6);

        ArrayList<String> actual = b.getidCombination();
        ArrayList<String> expect = new ArrayList<>();
        expect = null;
        test.disconnect();
        assertEquals("Chair id combinations is wrong, shouldn't be able to build this Chair", expect, actual);
    }

    /**
     * Requests one Filing of type Medium to be built. Tests if the cheapest cost is
     * correct.
     */
    @Test
    public void FilingBuildCostTest() {
        Database test = new Database("jdbc:mysql://server.ratik.me:25565/INVENTORY", "root", "eNsF409");
        try {
            test = new Database("jdbc:mysql://server.ratik.me:25565/INVENTORY", "root", "eNsF409");
            test.connect();

        } catch (SQLException e) {
            System.out.println("SQL Exception");
        }

        Filing f = new Filing("Medium");
        ArrayList<Filing> allFilings = test.getListByType(Types.Filing, "Medium");
        Builder<Filing> b = new Builder<Filing>(f);
        b.setParts(allFilings);
        b.setItems();
        b.BuildMultipleItems(1);

        int actual = b.getCost();
        int expect = 200;
        test.disconnect();
        assertEquals("Filing cost is wrong", expect, actual);
    }

    /**
     * Requests one Filing of type Medium to be built. Tests if the cheapest id
     * combination is correct.
     */
    @Test
    public void FilingBuildIdTest() {
        Database test = new Database("jdbc:mysql://server.ratik.me:25565/INVENTORY", "root", "eNsF409");
        try {
            test = new Database("jdbc:mysql://server.ratik.me:25565/INVENTORY", "root", "eNsF409");
            test.connect();

        } catch (SQLException e) {
            System.out.println("SQL Exception");
        }

        Filing f = new Filing("Medium");
        ArrayList<Filing> allFilings = test.getListByType(Types.Filing, "Medium");
        Builder<Filing> b = new Builder<Filing>(f);
        b.setParts(allFilings);
        b.setItems();
        b.BuildMultipleItems(1);

        ArrayList<String> actual = b.getidCombination();
        ArrayList<String> expect = new ArrayList<>();
        expect.add("F014");
        test.disconnect();
        assertEquals("Filing id combination is wrong", expect, actual);
    }

    /**
     * Requests six Filings of type Medium to be built; should not be able to build
     * six Filings of type Medium. Tests if the correct cost is returned. Should be
     * -1 indicating that the lamps cannot be built.
     */
    @Test
    public void FilingBuildCostTestFail() {
        Database test = new Database("jdbc:mysql://server.ratik.me:25565/INVENTORY", "root", "eNsF409");
        try {
            test = new Database("jdbc:mysql://server.ratik.me:25565/INVENTORY", "root", "eNsF409");
            test.connect();

        } catch (SQLException e) {
            System.out.println("SQL Exception");
        }

        Filing f = new Filing("Medium");
        ArrayList<Filing> allFilings = test.getListByType(Types.Filing, "Medium");
        Builder<Filing> b = new Builder<Filing>(f);
        b.setParts(allFilings);
        b.setItems();
        b.BuildMultipleItems(6);

        int actual = b.getCost();
        int expect = -1;
        test.disconnect();
        assertEquals("Filing cost is wrong, shouldn't be able to build this Filing", expect, actual);
    }

    /**
     * Requests six Filings of type Medium; should not be able to build six Filing
     * of type Medium. Tests if the correct combination of ids is returned. Should
     * be null, indicating that the lamps cannot be built.
     */
    @Test
    public void FilingBuildIdTestFail() {
        Database test = new Database("jdbc:mysql://server.ratik.me:25565/INVENTORY", "root", "eNsF409");
        try {
            test = new Database("jdbc:mysql://server.ratik.me:25565/INVENTORY", "root", "eNsF409");
            test.connect();

        } catch (SQLException e) {
            System.out.println("SQL Exception");
        }

        Filing f = new Filing("Medium");
        ArrayList<Filing> allFilings = test.getListByType(Types.Filing, "Medium");
        Builder<Filing> b = new Builder<Filing>(f);
        b.setParts(allFilings);
        b.setItems();
        b.BuildMultipleItems(6);

        ArrayList<String> actual = b.getidCombination();
        ArrayList<String> expect = new ArrayList<>();
        expect = null;
        test.disconnect();
        assertEquals("Filing id combinations is wrong, shouldn't be able to build this Filing", expect, actual);
    }

    /**
     * Checks correct components in Desk are received.
     */
    @Test
    public void getItemsDesk() {
        Desk d = new Desk("Adjustable");
        Builder<Desk> b = new Builder<Desk>(d);

        b.setItems();
        ArrayList<String> actual = b.getItems();
        ArrayList<String> expect = new ArrayList<>();

        expect.add("Legs");
        expect.add("Top");
        expect.add("Drawer");
        assertEquals("Wrong components received.", expect, actual);
    }

    /**
     * Checks correct components in Chair are received.
     */
    @Test
    public void getItemsChair() {
        Chair c = new Chair("Mesh");
        Builder<Chair> b = new Builder<Chair>(c);

        b.setItems();
        ArrayList<String> actual = b.getItems();
        ArrayList<String> expect = new ArrayList<>();

        expect.add("Legs");
        expect.add("Cushion");
        expect.add("Arms");
        expect.add("Seat");
        assertEquals("Wrong components received.", expect, actual);
    }

    /**
     * Checks correct components in Lamp are received.
     */
    @Test
    public void getItemsLamp() {
        Lamp l = new Lamp("Study");
        Builder<Lamp> b = new Builder<Lamp>(l);

        b.setItems();
        ArrayList<String> actual = b.getItems();
        ArrayList<String> expect = new ArrayList<>();

        expect.add("Base");
        expect.add("Bulb");
        assertEquals("Wrong components received.", expect, actual);
    }

    /**
     * Checks correct components in Filing are received.
     */
    @Test
    public void getItemsFiling() {
        Filing f = new Filing("Small");
        Builder<Filing> b = new Builder<Filing>(f);

        b.setItems();
        ArrayList<String> actual = b.getItems();
        ArrayList<String> expect = new ArrayList<>();

        expect.add("Rails");
        expect.add("Drawers");
        expect.add("Cabinet");
        assertEquals("Wrong components received.", expect, actual);
    }
}