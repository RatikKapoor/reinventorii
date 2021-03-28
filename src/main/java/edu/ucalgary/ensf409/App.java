package edu.ucalgary.ensf409;

import java.util.ArrayList;

import edu.ucalgary.ensf409.FurniturePart.Types;

public class App {
    public static void main(String[] args) throws Exception {
        Database test = new Database("jdbc:mysql://server.ratik.me:25565/INVENTORY", "root", "eNsF409");
        test.connect();
        // test.getListByType(Types.Lamp, "Study").forEach(item -> {
        // System.out.println(item.getId());
        // });
        // ;
        Lamp l = new Lamp("Desk");
        ArrayList<Lamp> allLamps = test.getListByType(Types.Lamp, "Desk");
        Builder<Lamp> b = new Builder<Lamp>(l);
        b.setParts(allLamps);
        b.getParts().forEach(item -> {
            System.out.println(Lamp.class.cast(item).getId());
        });
        ;
        b.setItems();
        // b.getItems().forEach(item -> {
        // System.out.println(item.toString());
        // });
        ;
        b.BuildMultipleItems(2);
        // b.BuildItem();
        ArrayList<Lamp> temp = new ArrayList<>();
        for (String id : b.getidCombination()) {
            for (Lamp la : allLamps) {
                if (la.getId().equals(id)) {
                    temp.add(la);
                }
            }
        }
        FileOutput fo = new FileOutput("Lamp", "Desk", "2", b.getidCombination(), b.getCost());
        System.out.println(fo.createReceipt());
        fo.createFile();
        // System.out.println(b.getCost());
    }
}
// if (Desk.class.cast(item).getDrawer()) {
// drawer.add(Desk.class.cast(item).getId());
// }
