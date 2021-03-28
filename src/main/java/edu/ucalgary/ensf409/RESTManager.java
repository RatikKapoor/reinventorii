package edu.ucalgary.ensf409;

import java.util.ArrayList;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.ucalgary.ensf409.FurniturePart.Types;

@RestController
public class RESTManager {
    Database database = null;

    public RESTManager() {
        database = new Database("jdbc:mysql://server.ratik.me:25565/INVENTORY", "root", "eNsF409");
        try {
            database.connect();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @CrossOrigin(origins = "http://localhost:8100")
    @GetMapping("/chairs")
    @RequestMapping(value = "/chairs", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<Chair> chairs(@RequestParam(value = "type", defaultValue = "") String type) {
        return type.length() == 0 ? database.getList(Types.Chair) : database.getListByType(Types.Chair, type);
    }

    @CrossOrigin(origins = "http://localhost:8100")
    @GetMapping("/desks")
    @RequestMapping(value = "/desks", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<Chair> desks(@RequestParam(value = "type", defaultValue = "") String type) {
        return type.length() == 0 ? database.getList(Types.Desk) : database.getListByType(Types.Desk, type);
    }

    @CrossOrigin(origins = "http://localhost:8100")
    @GetMapping("/filings")
    @RequestMapping(value = "/filings", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<Chair> filings(@RequestParam(value = "type", defaultValue = "") String type) {
        return type.length() == 0 ? database.getList(Types.Filing) : database.getListByType(Types.Filing, type);
    }

    @CrossOrigin(origins = "http://localhost:8100")
    @GetMapping("/lamps")
    @RequestMapping(value = "/lamps", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<Chair> lamps(@RequestParam(value = "type", defaultValue = "") String type) {
        return type.length() == 0 ? database.getList(Types.Lamp) : database.getListByType(Types.Lamp, type);
    }
}
