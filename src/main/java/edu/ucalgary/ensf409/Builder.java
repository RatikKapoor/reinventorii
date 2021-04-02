package edu.ucalgary.ensf409;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.HashMap;

import com.fasterxml.jackson.annotation.JacksonInject.Value;

public class Builder<T extends FurniturePart> {
    private T object;
    private ArrayList<T> parts;
    private List castedParts;
    public ArrayList<String> items;
    private int cost;
    private String typeName;
    private boolean[] features;

    // private ArrayList<T> allCombinations = new ArrayList<T>();
    ArrayList<ArrayList<String>> allCombinations = new ArrayList<>();
    // FOR BULB
    private ArrayList<String> bulb;
    private ArrayList<String> base;
    // FOR DESK
    private ArrayList<String> legs;
    private ArrayList<String> top;
    private ArrayList<String> drawer;
    // FOR CHAIR
    private ArrayList<String> chairLegs;
    private ArrayList<String> arms;
    private ArrayList<String> seat;
    private ArrayList<String> cushion;
    // FOR FILING
    private ArrayList<String> rails;
    private ArrayList<String> drawers;
    private ArrayList<String> cabinet;
    // FOR IDCOMBINATION
    private ArrayList<String> idCombination;
    //
    private ArrayList<String> oneD = new ArrayList<>();

    public Builder(T toBuild) {
        this.object = toBuild;
        this.typeName = object.getClass().getSimpleName();
    }

    public void BuildMultipleItems(int count) {
        while (count != 0) {
            BuildItem();
            count--;
        }
    }

    // if id doesnt equal one of these then add it
    public void BuildItem() {
        HashMap<String, Integer> hash = new HashMap<String, Integer>();
        // FOR BULB
        bulb = new ArrayList<>();
        base = new ArrayList<>();
        // FOR DESK
        legs = new ArrayList<>();
        top = new ArrayList<>();
        drawer = new ArrayList<>();
        // FOR CHAIR
        chairLegs = new ArrayList<>();
        arms = new ArrayList<>();
        seat = new ArrayList<>();
        cushion = new ArrayList<>();
        // FOR FILING
        rails = new ArrayList<>();
        drawers = new ArrayList<>();
        cabinet = new ArrayList<>();

        idCombination = new ArrayList<>();
        allCombinations = new ArrayList<>();

        switch (FurniturePart.Types.fromString(this.typeName)) {
        case Lamp:
            getParts().forEach(item -> {

                // populate array bulb and base
                if (Lamp.class.cast(item).getBulb()) {
                    bulb.add(Lamp.class.cast(item).getId());
                }
                if (Lamp.class.cast(item).getBase()) {
                    base.add(Lamp.class.cast(item).getId());
                }

                hash.put(Lamp.class.cast(item).getId(), Lamp.class.cast(item).getPrice());
            });
            ;
            for (String val : oneD) {
                bulb.remove(val);
                base.remove(val);
            }
            // System.out.println("Bulb" + bulb);
            if (bulb.isEmpty() || base.isEmpty()) {
                System.out.println("Cannot be completed");
                cost = -1;
                break;
            }
            boolean[] features = new boolean[items.size()];
            for (int i = 0; i < base.size(); i++) {
                String id = base.get(i);
                ArrayList<String> allIDs = new ArrayList<>();
                // System.out.println(id);
                features[0] = true;
                for (String val : bulb) {
                    if (val.equals(id)) {
                        features[1] = true;
                        break;
                    }
                }

                for (int k = 0; k < items.size(); k++) {
                    if (!features[k]) {
                        String bulbID = "";
                        if (k == 1) {
                            bulbID = bulbID();
                            // System.out.println("Reached");
                            if (!bulbID.isEmpty()) {
                                allIDs.add(bulbID);
                            }
                        }
                    }
                    features[k] = false;
                }
                allIDs.add(id);
                allIDs = (ArrayList<String>) allIDs.stream().distinct().collect(Collectors.toList());
                allCombinations.add(allIDs);
            }
            break;

        case Desk:

            getParts().forEach(item -> {

                // populate array bulb and base
                if (Desk.class.cast(item).getTop()) {
                    legs.add(Desk.class.cast(item).getId());
                }
                if (Desk.class.cast(item).getLegs()) {
                    top.add(Desk.class.cast(item).getId());
                }
                if (Desk.class.cast(item).getDrawer()) {
                    drawer.add(Desk.class.cast(item).getId());
                }
                hash.put(Desk.class.cast(item).getId(), Desk.class.cast(item).getPrice());
            });
            ;
            for (String val : oneD) {
                legs.remove(val);
                top.remove(val);
                drawer.remove(val);
            }
            if (top.isEmpty() || drawer.isEmpty() || legs.isEmpty()) {
                System.out.println("Cannot be completed");
                cost = -1;
                break;
            }
            features = new boolean[items.size()];

            for (int i = 0; i < legs.size(); i++) {
                String id = legs.get(i);
                ArrayList<String> allIDs = new ArrayList<>();
                // System.out.println(id);
                features[0] = true;
                for (String val : top) {
                    if (val.equals(id)) {
                        features[1] = true;
                        break;
                    }
                }
                for (String val : drawer) {
                    if (val.equals(id)) {
                        features[2] = true;
                        break;
                    }
                }

                for (int k = 0; k < items.size(); k++) {
                    if (!features[k]) {
                        String topID = "";
                        String drawerID = "";
                        if (k == 1) {
                            topID = topID();
                            // System.out.println("Reached");
                            if (!topID.isEmpty()) {
                                allIDs.add(topID);
                            }
                        }
                        if (k == 2) {
                            drawerID = drawerID();
                            // System.out.println("Reached");
                            if (!drawerID.isEmpty()) {
                                allIDs.add(drawerID);
                            }
                        }
                    }
                    features[k] = false;
                }
                allIDs.add(id);
                allIDs = (ArrayList<String>) allIDs.stream().distinct().collect(Collectors.toList());
                allCombinations.add(allIDs);

            }

            break;

        case Chair:
            getParts().forEach(item -> {

                // populate array bulb and base
                if (Chair.class.cast(item).getLegs()) {
                    chairLegs.add(Chair.class.cast(item).getId());
                }
                if (Chair.class.cast(item).getArms()) {
                    arms.add(Chair.class.cast(item).getId());
                }
                if (Chair.class.cast(item).getSeat()) {
                    seat.add(Chair.class.cast(item).getId());
                }
                if (Chair.class.cast(item).getCushion()) {
                    cushion.add(Chair.class.cast(item).getId());
                }
                hash.put(Chair.class.cast(item).getId(), Chair.class.cast(item).getPrice());
            });
            ;
            for (String val : oneD) {
                chairLegs.remove(val);
                arms.remove(val);
                seat.remove(val);
                cushion.remove(val);
            }
            if (chairLegs.isEmpty() || arms.isEmpty() || seat.isEmpty() || cushion.isEmpty()) {
                System.out.println("Cannot be completed");
                cost = -1;
                break;
            }
            features = new boolean[items.size()];

            for (int i = 0; i < chairLegs.size(); i++) {
                String id = chairLegs.get(i);
                ArrayList<String> allIDs = new ArrayList<>();
                // System.out.println(id);
                features[0] = true;
                for (String val : arms) {
                    if (val.equals(id)) {
                        features[1] = true;
                        break;
                    }
                }
                for (String val : seat) {
                    if (val.equals(id)) {
                        features[2] = true;
                        break;
                    }
                }
                for (String val : cushion) {
                    if (val.equals(id)) {
                        features[3] = true;
                        break;
                    }
                }

                for (int k = 0; k < items.size(); k++) {
                    if (!features[k]) {
                        String armsID = "";
                        String seatID = "";
                        String cushionID = "";
                        if (k == 1) {
                            armsID = armsID();
                            // System.out.println("Reached");
                            if (!armsID.isEmpty()) {
                                allIDs.add(armsID);
                            }
                        }
                        if (k == 2) {
                            seatID = seatID();
                            // System.out.println("Reached");
                            if (!seatID.isEmpty()) {
                                allIDs.add(seatID);
                            }
                        }
                        if (k == 3) {
                            cushionID = cushionID();
                            // System.out.println("Reached");
                            if (!cushionID.isEmpty()) {
                                allIDs.add(cushionID);
                            }
                        }
                    }
                    features[k] = false;
                }
                allIDs.add(id);
                allIDs = (ArrayList<String>) allIDs.stream().distinct().collect(Collectors.toList());
                allCombinations.add(allIDs);

            }

            break;

        case Filing:
            getParts().forEach(item -> {

                // populate array bulb and base
                if (Filing.class.cast(item).getRails()) {
                    rails.add(Filing.class.cast(item).getId());
                }
                if (Filing.class.cast(item).getDrawers()) {
                    drawers.add(Filing.class.cast(item).getId());
                }
                if (Filing.class.cast(item).getCabinet()) {
                    cabinet.add(Filing.class.cast(item).getId());
                }
                hash.put(Filing.class.cast(item).getId(), Filing.class.cast(item).getPrice());
            });
            ;
            for (String val : oneD) {
                rails.remove(val);
                drawers.remove(val);
                cabinet.remove(val);

            }
            if (rails.isEmpty() || drawers.isEmpty() || cabinet.isEmpty()) {
                System.out.println("Cannot be completed");
                cost = -1;
                break;
            }

            features = new boolean[items.size()];

            for (int i = 0; i < rails.size(); i++) {
                String id = rails.get(i);
                ArrayList<String> allIDs = new ArrayList<>();
                // System.out.println(id);
                features[0] = true;
                for (String val : drawers) {
                    if (val.equals(id)) {
                        features[1] = true;
                        break;
                    }
                }
                for (String val : cabinet) {
                    if (val.equals(id)) {
                        features[2] = true;
                        break;
                    }
                }

                for (int k = 0; k < items.size(); k++) {
                    if (!features[k]) {
                        String drawersID = "";
                        String cabinetID = "";

                        if (k == 1) {
                            drawersID = drawersID();
                            // System.out.println("Reached");
                            if (!drawersID.isEmpty()) {
                                allIDs.add(drawersID);
                            }
                        }
                        if (k == 2) {
                            cabinetID = cabinetID();
                            // System.out.println("Reached");
                            if (!cabinetID.isEmpty()) {
                                allIDs.add(cabinetID);
                            }
                        }
                    }
                    features[k] = false;
                }
                allIDs.add(id);
                allIDs = (ArrayList<String>) allIDs.stream().distinct().collect(Collectors.toList());
                allCombinations.add(allIDs);

            }
            break;

        default:
            break;
        }

        ArrayList<Integer> finalPrice = new ArrayList<>();
        // System.out.println("All Combinations: " + allCombinations);
        for (ArrayList<String> combination : allCombinations) {
            int price = 0;
            for (String s : combination) {
                for (String id : hash.keySet()) {
                    if (id.equals(s)) {
                        price += hash.get(id);
                    }
                }
            }
            finalPrice.add(price);
        }
        cost += Collections.min(finalPrice);
        int index = 0;
        for (Integer price : finalPrice) {
            if (price.equals(Collections.min(finalPrice))) {
                break;
            }
            index++;
        }
        idCombination.addAll(allCombinations.get(index));
        // System.out.println("ID Combinations" + idCombination);
        for (String combinations : idCombination) {
            oneD.add(combinations);
        }
    }

    public void setItems() {
        items = new ArrayList<String>();
        switch (FurniturePart.Types.fromString(this.typeName)) {
        case Lamp:
            for (LampParts type : LampParts.values()) {
                items.add(type.toString());
            }
            break;

        case Chair:
            for (ChairParts type : ChairParts.values()) {
                items.add(type.toString());
            }
            break;

        case Filing:
            for (FilingParts type : FilingParts.values()) {
                items.add(type.toString());
            }
            break;

        case Desk:
            for (DeskParts type : DeskParts.values()) {
                items.add(type.toString());
            }
            break;

        default:
            throw new IllegalArgumentException("Item type " + typeName + ", parser does not exist!");
        }
    }

    public int getCost() {
        return this.cost;
    }

    public ArrayList<String> getItems() {
        return this.items;
    }

    public void setParts(ArrayList<T> parts) {
        this.parts = parts;
    }

    public ArrayList<T> getParts() {
        return this.parts;
    }

    public String getTypeName() {
        return this.typeName;
    }

    public T getObject() {
        return this.object;
    }

    public ArrayList<String> getidCombination() {
        return this.oneD;
    }

    // FOR LAMP
    public String bulbID() {
        String id = "";
        ArrayList<Integer> prices = new ArrayList<>();
        getParts().forEach(item -> {
            // populate array bulb and base
            if (Lamp.class.cast(item).getBulb()) {
                prices.add(Lamp.class.cast(item).getPrice());
            }
        });
        ;
        int price = Collections.min(prices);
        int i = 0;
        for (i = 0; i < bulb.size(); i++) {
            if (prices.get(i) == price) {
                break;
            }
        }
        id = bulb.get(i);
        // System.out.println(prices);
        // System.out.println(id);
        return id;
    }

    // FOR DESK
    public String topID() {
        String id = "";
        ArrayList<Integer> prices = new ArrayList<>();
        getParts().forEach(item -> {
            // populate array bulb and base
            if (Desk.class.cast(item).getTop()) {
                prices.add(Desk.class.cast(item).getPrice());
            }
        });
        ;
        int price = Collections.min(prices);
        int i = 0;
        for (i = 0; i < top.size(); i++) {
            if (prices.get(i) == price) {
                break;
            }
        }
        id = top.get(i);
        // System.out.println(prices);
        // System.out.println(id);
        return id;
    }

    public String drawerID() {
        String id = "";
        ArrayList<Integer> prices = new ArrayList<>();
        getParts().forEach(item -> {
            // populate array bulb and base
            if (Desk.class.cast(item).getDrawer()) {
                prices.add(Desk.class.cast(item).getPrice());
            }
        });
        ;
        int price = Collections.min(prices);
        int i = 0;
        for (i = 0; i < drawer.size(); i++) {
            if (prices.get(i) == price) {
                break;
            }
        }
        id = drawer.get(i);
        // System.out.println(prices);
        // System.out.println(id);
        return id;
    }

    // FOR CHAIR
    public String armsID() {
        String id = "";
        ArrayList<Integer> prices = new ArrayList<>();
        getParts().forEach(item -> {
            // populate array bulb and base
            if (Chair.class.cast(item).getArms()) {
                prices.add(Chair.class.cast(item).getPrice());
            }
        });
        ;
        int price = Collections.min(prices);
        int i = 0;
        for (i = 0; i < arms.size(); i++) {
            if (prices.get(i) == price) {
                break;
            }
        }
        id = arms.get(i);
        // System.out.println(prices);
        // System.out.println(id);
        return id;
    }

    public String seatID() {
        String id = "";
        ArrayList<Integer> prices = new ArrayList<>();
        getParts().forEach(item -> {
            // populate array bulb and base
            if (Chair.class.cast(item).getSeat()) {
                prices.add(Chair.class.cast(item).getPrice());
            }
        });
        ;
        int price = Collections.min(prices);
        int i = 0;
        for (i = 0; i < seat.size(); i++) {
            if (prices.get(i) == price) {
                break;
            }
        }
        id = seat.get(i);
        // System.out.println(prices);
        // System.out.println(id);
        return id;
    }

    public String cushionID() {
        String id = "";
        ArrayList<Integer> prices = new ArrayList<>();
        getParts().forEach(item -> {
            // populate array bulb and base
            if (Chair.class.cast(item).getCushion()) {
                prices.add(Chair.class.cast(item).getPrice());
            }
        });
        ;
        int price = Collections.min(prices);
        int i = 0;
        for (i = 0; i < cushion.size(); i++) {
            if (prices.get(i) == price) {
                break;
            }
        }
        id = cushion.get(i);
        // System.out.println(prices);
        // System.out.println(id);
        return id;
    }

    // FOR FILING
    public String drawersID() {
        String id = "";
        ArrayList<Integer> prices = new ArrayList<>();
        getParts().forEach(item -> {
            // populate array bulb and base
            if (Filing.class.cast(item).getDrawers()) {
                prices.add(Filing.class.cast(item).getPrice());
            }
        });
        ;
        int price = Collections.min(prices);
        int i = 0;
        for (i = 0; i < drawers.size(); i++) {
            if (prices.get(i) == price) {
                break;
            }
        }
        id = drawers.get(i);
        // System.out.println(prices);
        // System.out.println(id);
        return id;
    }

    public String cabinetID() {
        String id = "";
        ArrayList<Integer> prices = new ArrayList<>();
        getParts().forEach(item -> {
            // populate array bulb and base
            if (Filing.class.cast(item).getCabinet()) {
                prices.add(Filing.class.cast(item).getPrice());
            }
        });
        ;
        int price = Collections.min(prices);
        int i = 0;
        for (i = 0; i < cabinet.size(); i++) {
            if (prices.get(i) == price) {
                break;
            }
        }
        id = cabinet.get(i);
        // System.out.println(prices);
        // System.out.println(id);
        return id;
    }
}
