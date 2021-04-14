package edu.ucalgary.ensf409;

import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvException;
import edu.ucalgary.ensf409.FurniturePart.Types;

/**
 * IllegalFurnitureTypeException: Custom Exception for better testing and future
 * implementation.
 * 
 * @author Ratik Kapoor, Robert Brown, Risat Haque, Anand Patel
 * @since 1.1
 */
@RestController
public class RESTManager {
    public Database database = null;

    /**
     * Constructor for RESTManager, connects to database
     */
    public RESTManager() {
        try {
            Dotenv environment = Dotenv.load();
            database = new Database("jdbc:mysql://" + environment.get("DB_URL"), environment.get("DB_USER"),
                    environment.get("DB_PASS"));
            database.connect();
            database.storeManufacturers();
        } catch (DotenvException e) {
            System.err.println("Could not load .env file in root folder!");
            System.err.println("Create or move .env file with DB_URL, DB_USER, DB_PASS");
            System.exit(1);
        } catch (SQLException e) {
            System.err.println("Error connecting to database!");
            System.exit(1);
        } catch (Exception e) {
            System.err.println("Unknown RESTManager error");
            e.printStackTrace();
        }
    }

    /**
     * Gets chairs
     * 
     * @param type - Type of chair to filter by
     * @return ArrayList of chairs
     */
    @CrossOrigin
    @GetMapping("/chairs")
    @RequestMapping(value = "/chairs", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<Chair> chairs(@RequestParam(value = "type", defaultValue = "") String type) {
        return type.length() == 0 ? database.getList(Types.CHAIR) : database.getListByType(Types.CHAIR, type);
    }

    /**
     * Gets desks
     * 
     * @param type - Type of desk to filter by
     * @return ArrayList of desks
     */
    @CrossOrigin
    @GetMapping("/desks")
    @RequestMapping(value = "/desks", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<Desk> desks(@RequestParam(value = "type", defaultValue = "") String type) {
        return type.length() == 0 ? database.getList(Types.DESK) : database.getListByType(Types.DESK, type);
    }

    /**
     * Gets desks
     * 
     * @param type - Type of desks to filter by
     * @return ArrayList of desks
     */
    @CrossOrigin
    @GetMapping("/filings")
    @RequestMapping(value = "/filings", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<Filing> filings(@RequestParam(value = "type", defaultValue = "") String type) {
        return type.length() == 0 ? database.getList(Types.FILING) : database.getListByType(Types.FILING, type);
    }

    /**
     * Gets lamps
     * 
     * @param type - Type of lamps to filter by
     * @return ArrayList of lamps
     */
    @CrossOrigin
    @GetMapping("/lamps")
    @RequestMapping(value = "/lamps", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<Lamp> lamps(@RequestParam(value = "type", defaultValue = "") String type) {
        return type.length() == 0 ? database.getList(Types.LAMP) : database.getListByType(Types.LAMP, type);
    }

    /**
     * Gets manufacturers
     * 
     * @param type - Item that manufacturer makes
     * @return ArrayList of manufacturers
     */
    @CrossOrigin
    @GetMapping("/manufacturers")
    @RequestMapping(value = "/manufacturers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<Manufacturer> manufacturers(@RequestParam(value = "type", defaultValue = "") String type) {
        if (type == "") {
            return database.getManufacturers();
        } else {
            try {
                return database.getManufacturersByType(FurniturePart.Types.fromString(type));
            } catch (Exception e) {
                return null;
            }
        }

    }

    /**
     * Builds chair
     * 
     * @param type   - Type of chair
     * @param number - Number of chair
     * @return - ArrayList of chair IDs used
     */
    @CrossOrigin
    @GetMapping("/builder/chair")
    @RequestMapping(value = "/builder/chair", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<Chair> chairBuilder(@RequestParam(value = "type", defaultValue = "") String type,
            @RequestParam(value = "number", defaultValue = "1") String number) {

        Chair l = new Chair(type);
        ArrayList<Chair> allLamps = database.getListByType(Types.CHAIR, type);
        Builder<Chair> b = new Builder<Chair>(l);
        b.setParts(allLamps);
        b.setItems();
        b.buildMultipleItems(Integer.parseInt(number));
        if (b.getCost() == -1) {
            return new ArrayList<Chair>();
        }
        ArrayList<Chair> temp = new ArrayList<>();
        for (String id : b.getIdCombination()) {
            for (Chair la : allLamps) {
                if (la.getId().equals(id)) {
                    temp.add(la);
                }
            }
        }
        return temp;
    }

    /**
     * Builds desks
     * 
     * @param type   - Type of desks
     * @param number - Number of desks
     * @return - ArrayList of desk IDs used
     */
    @CrossOrigin
    @GetMapping("/builder/desk")
    @RequestMapping(value = "/builder/desk", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<Desk> deskBuilder(@RequestParam(value = "type", defaultValue = "") String type,
            @RequestParam(value = "number", defaultValue = "1") String number) {
        Desk l = new Desk(type);
        ArrayList<Desk> allDesks = database.getListByType(Types.DESK, type);
        Builder<Desk> b = new Builder<Desk>(l);
        b.setParts(allDesks);
        b.setItems();
        b.buildMultipleItems(Integer.parseInt(number));
        if (b.getCost() == -1) {
            return new ArrayList<Desk>();
        }
        ArrayList<Desk> temp = new ArrayList<>();
        for (String id : b.getIdCombination()) {
            for (Desk la : allDesks) {
                if (la.getId().equals(id)) {
                    temp.add(la);
                }
            }
        }
        return temp;
    }

    /**
     * Builds filings
     * 
     * @param type   - Type of filings
     * @param number - Number of filings
     * @return - ArrayList of filing IDs used
     */
    @CrossOrigin
    @GetMapping("/builder/filing")
    @RequestMapping(value = "/builder/filing", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<Filing> filingBuilder(@RequestParam(value = "type", defaultValue = "") String type,
            @RequestParam(value = "number", defaultValue = "1") String number) {
        Filing f = new Filing(type);
        ArrayList<Filing> allFiling = database.getListByType(Types.FILING, type);
        Builder<Filing> b = new Builder<Filing>(f);
        b.setParts(allFiling);
        b.setItems();
        b.buildMultipleItems(Integer.parseInt(number));
        if (b.getCost() == -1) {
            return new ArrayList<Filing>();
        }
        ArrayList<Filing> temp = new ArrayList<>();
        for (String id : b.getIdCombination()) {
            for (Filing la : allFiling) {
                if (la.getId().equals(id)) {
                    temp.add(la);
                }
            }
        }
        return temp;
    }

    /**
     * Builds lamps
     * 
     * @param type   - Type of lamps
     * @param number - Number of lamps
     * @return - ArrayList of lamp IDs used
     */
    @CrossOrigin
    @GetMapping("/builder/lamp")
    @RequestMapping(value = "/builder/lamp", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<Lamp> lampBuilder(@RequestParam(value = "type", defaultValue = "") String type,
            @RequestParam(value = "number", defaultValue = "1") String number) {
        Lamp l = new Lamp(type);
        ArrayList<Lamp> allLamps = database.getListByType(Types.LAMP, type);
        Builder<Lamp> b = new Builder<Lamp>(l);
        b.setParts(allLamps);
        b.setItems();
        b.buildMultipleItems(Integer.parseInt(number));
        if (b.getCost() == -1) {
            return new ArrayList<Lamp>();
        }
        ArrayList<Lamp> temp = new ArrayList<>();
        for (String id : b.getIdCombination()) {
            for (Lamp la : allLamps) {
                if (la.getId().equals(id)) {
                    temp.add(la);
                }
            }
        }
        return temp;
    }

    /**
     * Removes item from database
     * 
     * @param type  - Part name (also name of table)
     * @param items - Array of items
     * @return Boolean indicating success
     */
    @CrossOrigin
    @GetMapping("/remove")
    @RequestMapping(value = "/remove", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean removeByID(@RequestParam(value = "type", defaultValue = "") String type,
            @RequestParam(value = "items", defaultValue = "") String[] items) {
        FurniturePart.Types partType = Types.fromString(type);

        boolean result = true;
        for (String item : items) {
            if (!database.removeItemByID(partType, item)) {
                result = false;
            }
        }
        return result;
    }
}
