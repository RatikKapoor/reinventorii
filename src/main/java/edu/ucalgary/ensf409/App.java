package edu.ucalgary.ensf409;

import java.util.ArrayList;

import edu.ucalgary.ensf409.FurniturePart.Types;
import io.github.cdimascio.dotenv.Dotenv;

public class App {
    public static void main(String[] args) throws Exception {
        Dotenv enviroment = Dotenv.load();
        Database test = new Database("jdbc:mysql://" + enviroment.get("DB_URL"), enviroment.get("DB_USER"),
                enviroment.get("DB_PASS"));
        // Database test = new Database("jdbc:mysql://server.ratik.me:25565", "root",
        // "eNsF409");
        test.connect();
        // test.getListByType(Types.Lamp, "Study").forEach(item -> {
        // System.out.println(item.getId());
        // });
        // ;
        Desk l = new Desk("Traditional");
        ArrayList<Desk> allLamps = test.getListByType(Types.Desk, "Traditional");
        Builder<Desk> b = new Builder<Desk>(l);
        b.setParts(allLamps);
        b.getParts().forEach(item -> {
            System.out.println(Desk.class.cast(item).getId());
        });
        ;
        b.setItems();
        // b.getItems().forEach(item -> {
        // System.out.println(item.toString());
        // });
        // ;
        b.BuildMultipleItems(4);
        System.out.println("Id Combinations : " + b.getidCombination());
        System.out.println("Total Cost : " + b.getCost());
        // b.BuildItem();
        // ArrayList<Lamp> temp = new ArrayList<>();
        // for (String id : b.getidCombination()) {
        // for (Lamp la : allLamps) {
        // if (la.getId().equals(id)) {
        // temp.add(la);
        // }
        // }
        // }
        // FileOutput fo = new FileOutput("Lamp", "Desk", "2", b.getidCombination(),
        // b.getCost());
        // System.out.println(fo.createReceipt());
        // fo.createFile();
        // System.out.println(b.getCost());
    }
}
// if (Desk.class.cast(item).getDrawer()) {
// drawer.add(Desk.class.cast(item).getId());
// }
