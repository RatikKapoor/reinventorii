package edu.ucalgary.ensf409;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/chairs")
    public ArrayList<Chair> chairs(@RequestParam(value = "type", defaultValue = "") String type) {
        return type.length() == 0 ? database.getList(Types.Chair) : database.getListByType(Types.Chair, type);
    }

    @GetMapping("/desks")
    public ArrayList<Chair> desks(@RequestParam(value = "type", defaultValue = "") String type) {
        return type.length() == 0 ? database.getList(Types.Desk) : database.getListByType(Types.Desk, type);
    }

    @GetMapping("/filings")
    public ArrayList<Chair> filings(@RequestParam(value = "type", defaultValue = "") String type) {
        return type.length() == 0 ? database.getList(Types.Filing) : database.getListByType(Types.Filing, type);
    }

    @GetMapping("/lamps")
    public ArrayList<Chair> lamps(@RequestParam(value = "type", defaultValue = "") String type) {
        return type.length() == 0 ? database.getList(Types.Lamp) : database.getListByType(Types.Lamp, type);
    }
}
