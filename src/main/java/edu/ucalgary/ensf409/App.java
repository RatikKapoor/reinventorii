package edu.ucalgary.ensf409;

import edu.ucalgary.ensf409.FurniturePart.Types;

public class App {
    public static void main(String[] args) throws Exception {
        Database test = new Database("jdbc:mysql://server.ratik.me:25565/INVENTORY", "root", "eNsF409");
        test.connect();
        // test.getListByType(Types.Lamp, "Study").forEach(item -> {
        // System.out.println(item.getId());
        // });
        // ;
        Lamp l = new Lamp("desk");
        Builder b = new Builder<FurniturePart>(l);
        b.setParts(test.getListByType(Types.Lamp, "Desk"));
        b.getParts().forEach(item -> {
            System.out.println(Lamp.class.cast(item).getId());
        });
        ;
        b.setItems();
        b.getItems().forEach(item -> {
            System.out.println(item.toString());
        });
        ;
    }
}
