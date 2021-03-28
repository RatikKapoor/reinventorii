package edu.ucalgary.ensf409;

import edu.ucalgary.ensf409.FurniturePart.Types;

public class App {
    public static void main(String[] args) throws Exception {
        Database test = new Database("jdbc:mysql://server.ratik.me:25565/INVENTORY", "root", "eNsF409");
        test.connect();
        test.getListByType(Types.Lamp, "Study").forEach(item -> {
            System.out.println(item.getId());
        });
        ;
    }
}
