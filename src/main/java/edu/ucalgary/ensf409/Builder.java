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
    public ArrayList<String> items;
    private int cost; // cheapest cost of the arrangements
    private String typeName;

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
    // FOR CHEAPEST ID COMBINATIONS
    private ArrayList<String> idCombination = new ArrayList<>();

    // TODO: Documentation for the constructor
    public Builder(T toBuild) {
        this.object = toBuild;
        this.typeName = object.getClass().getSimpleName();
    }

    /**
     * Method to build required number of furniture
     * 
     * @param count number of furniture requested
     */
    public void BuildMultipleItems(int count) {
        while (count != 0) { // Calls depending on amount of
                             // requested furniture
            if (getCost() != -1) {
                BuildItem();
            }
            count--;
        }
    }

    /**
     * Method that builds the requested item in the cheapest combination. PROMISES:
     * Cheapest id combination that is required to make the furniture. PROMISES:
     * Cheapest cost that is required to make the furniture.
     */
    public void BuildItem() {
        HashMap<String, Integer> hash = new HashMap<String, Integer>();
        // reset the arraylists because the method may be
        // called multiple times.
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
        // FOR COMBINATIONS
        allCombinations = new ArrayList<>(); // contains all id combinations

        switch (FurniturePart.Types.fromString(this.typeName)) {
        case Lamp:
            getParts().forEach(item -> {

                // populate array bulb and base
                if (Lamp.class.cast(item).getBulb()) {
                    // adds ids that have a bulb to array bulb
                    bulb.add(Lamp.class.cast(item).getId());
                }
                if (Lamp.class.cast(item).getBase()) {
                    // adds ids that have a base to array base
                    base.add(Lamp.class.cast(item).getId());
                }
                // hashmap of ids and their corresponding price
                hash.put(Lamp.class.cast(item).getId(), Lamp.class.cast(item).getPrice());
            });
            ;
            // remove any ids that have been used already
            for (String val : idCombination) {
                bulb.remove(val);
                base.remove(val);
            }
            // if any of the arrays are empty,
            // the order cannot be completed
            if (bulb.isEmpty() || base.isEmpty()) {
                cost = -1;
                break;
            }
            // number of components in lamp
            // features[0] corresponds to Base
            // features[1] corresponds to Bulb
            boolean[] features = new boolean[items.size()];
            for (int i = 0; i < base.size(); i++) {
                String id = base.get(i);
                ArrayList<String> allIDs = new ArrayList<>();
                features[0] = true;
                for (String val : bulb) {
                    if (val.equals(id)) {
                        // checks if this id comes with a bulb
                        features[1] = true;
                        break;
                    }
                }
                // adds the cheapest component to construct the lamp
                // if needed
                for (int k = 0; k < items.size(); k++) {
                    if (!features[k]) {
                        String bulbID = "";
                        if (k == 1) {
                            bulbID = bulbID();
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

                // populate array legs, top, and drawer
                if (Desk.class.cast(item).getLegs()) {
                    // adds ids that have legs to array legs
                    legs.add(Desk.class.cast(item).getId());
                }
                if (Desk.class.cast(item).getTop()) {
                    // adds ids that have top to array tops
                    top.add(Desk.class.cast(item).getId());
                }
                if (Desk.class.cast(item).getDrawer()) {
                    // adds ids that have drawer to array drawer
                    drawer.add(Desk.class.cast(item).getId());
                }
                // hashmap of ids and their corresponding prices
                hash.put(Desk.class.cast(item).getId(), Desk.class.cast(item).getPrice());
            });
            ;
            // remove any ids that have been used already
            for (String val : idCombination) {
                legs.remove(val);
                top.remove(val);
                drawer.remove(val);
            }
            // if any of the arrays are empty,
            // the order cannot be completed
            if (top.isEmpty() || drawer.isEmpty() || legs.isEmpty()) {
                cost = -1;
                break;
            }
            // number of components in lamp
            // features[0] corresponds to Legs
            // features[1] corresponds to Top
            // features[2] corresponds to Drawer
            features = new boolean[items.size()];

            for (int i = 0; i < legs.size(); i++) {
                String id = legs.get(i);
                ArrayList<String> allIDs = new ArrayList<>();
                features[0] = true;
                for (String val : top) {
                    if (val.equals(id)) {
                        // checks if this id comes with a top
                        features[1] = true;
                        break;
                    }
                }
                for (String val : drawer) {
                    if (val.equals(id)) {
                        // checks if this id comes with a drawer
                        features[2] = true;
                        break;
                    }
                }
                // adds the cheapest components to construct the desk
                // if needed
                for (int k = 0; k < items.size(); k++) {
                    if (!features[k]) {
                        String topID = "";
                        String drawerID = "";
                        if (k == 1) {
                            topID = topID();
                            if (!topID.isEmpty()) {
                                allIDs.add(topID);
                            }
                        }
                        if (k == 2) {
                            drawerID = drawerID();
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

                // populate array chairLegs, arms, seat, and cushion
                if (Chair.class.cast(item).getLegs()) {
                    // adds ids that have legs to array chairLegs
                    chairLegs.add(Chair.class.cast(item).getId());
                }
                if (Chair.class.cast(item).getArms()) {
                    // adds ids that have arms to array arms
                    arms.add(Chair.class.cast(item).getId());
                }
                if (Chair.class.cast(item).getSeat()) {
                    // adds ids that have seat to array seat
                    seat.add(Chair.class.cast(item).getId());
                }
                if (Chair.class.cast(item).getCushion()) {
                    // adds ids that have cushion to array cushion
                    cushion.add(Chair.class.cast(item).getId());
                }
                // hashmap of ids and their corresponding prices
                hash.put(Chair.class.cast(item).getId(), Chair.class.cast(item).getPrice());
            });
            ;
            // remove any ids that have been used already
            for (String val : idCombination) {
                chairLegs.remove(val);
                arms.remove(val);
                seat.remove(val);
                cushion.remove(val);
            }
            // if any of the arrays are empty,
            // the order cannot be completed
            if (chairLegs.isEmpty() || arms.isEmpty() || seat.isEmpty() || cushion.isEmpty()) {
                cost = -1;
                break;
            }
            // number of components in chair
            // features[0] corresponds to Legs
            // features[1] corresponds to Arms
            // features[2] corresponds to Seat
            // features[3] corresponds to Cushion
            features = new boolean[items.size()];

            for (int i = 0; i < chairLegs.size(); i++) {
                String id = chairLegs.get(i);
                ArrayList<String> allIDs = new ArrayList<>();
                features[0] = true;
                for (String val : arms) {
                    if (val.equals(id)) {
                        // checks if this id comes with arms
                        features[1] = true;
                        break;
                    }
                }
                for (String val : seat) {
                    if (val.equals(id)) {
                        // checks if this id comes with seat
                        features[2] = true;
                        break;
                    }
                }
                for (String val : cushion) {
                    if (val.equals(id)) {
                        // checks if this id comes with cushion
                        features[3] = true;
                        break;
                    }
                }
                // adds the cheapest components to construct the chair
                // if needed
                for (int k = 0; k < items.size(); k++) {
                    if (!features[k]) {
                        String armsID = "";
                        String seatID = "";
                        String cushionID = "";
                        if (k == 1) {
                            armsID = armsID();
                            if (!armsID.isEmpty()) {
                                allIDs.add(armsID);
                            }
                        }
                        if (k == 2) {
                            seatID = seatID();
                            if (!seatID.isEmpty()) {
                                allIDs.add(seatID);
                            }
                        }
                        if (k == 3) {
                            cushionID = cushionID();
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

                // populate array rails, drawers, and cabinet
                if (Filing.class.cast(item).getRails()) {
                    // adds ids that have rails to array rails
                    rails.add(Filing.class.cast(item).getId());
                }
                if (Filing.class.cast(item).getDrawers()) {
                    // adds ids that have drawers to array drawers
                    drawers.add(Filing.class.cast(item).getId());
                }
                if (Filing.class.cast(item).getCabinet()) {
                    // adds ids that have a cabinet to array cabinet
                    cabinet.add(Filing.class.cast(item).getId());
                }
                // hashmap of ids and their corresponding prices
                hash.put(Filing.class.cast(item).getId(), Filing.class.cast(item).getPrice());
            });
            ;
            // remove any ids that have been used already
            for (String val : idCombination) {
                rails.remove(val);
                drawers.remove(val);
                cabinet.remove(val);
            }
            // if any of the arrays are empty,
            // the order cannot be completed
            if (rails.isEmpty() || drawers.isEmpty() || cabinet.isEmpty()) {
                cost = -1;
                break;
            }
            // number of components in filing
            // features[0] corresponds to Rails
            // features[1] corresponds to Drawers
            // features[2] corresponds to Cabinet
            features = new boolean[items.size()];

            for (int i = 0; i < rails.size(); i++) {
                String id = rails.get(i);
                ArrayList<String> allIDs = new ArrayList<>();
                features[0] = true;
                for (String val : drawers) {
                    if (val.equals(id)) {
                        // checks if this id comes with drawers
                        features[1] = true;
                        break;
                    }
                }
                for (String val : cabinet) {
                    if (val.equals(id)) {
                        // checks if this id comes with a cabinet
                        features[2] = true;
                        break;
                    }
                }
                // adds the cheapest components to construct the filing
                // if needed
                for (int k = 0; k < items.size(); k++) {
                    if (!features[k]) {
                        String drawersID = "";
                        String cabinetID = "";

                        if (k == 1) {
                            drawersID = drawersID();
                            if (!drawersID.isEmpty()) {
                                allIDs.add(drawersID);
                            }
                        }
                        if (k == 2) {
                            cabinetID = cabinetID();
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
        if (getCost() != -1) {
            // add all prices of the cheapest id combinations into a array
            ArrayList<Integer> finalPrice = new ArrayList<>();
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
            // cheapest cost out of the combinations
            cost += Collections.min(finalPrice);
            int index = 0;
            // get index of the the combination that has cheapest price
            for (Integer price : finalPrice) {
                if (price.equals(Collections.min(finalPrice))) {
                    break;
                }
                index++;
            }
            // add cheapest id combination
            idCombination.addAll(allCombinations.get(index));
        } else {
            idCombination = null;
        }
    }

    /**
     * Method that populates array items with all components in the requested
     * furniture
     */
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

    /**
     * @return final cost of requested furnitures
     */
    public int getCost() {
        return this.cost;
    }

    /**
     * @return components in the furniture
     */
    public ArrayList<String> getItems() {
        return this.items;
    }

    /**
     * @param parts first argument for setParts
     */
    public void setParts(ArrayList<T> parts) {
        this.parts = parts;
    }

    /**
     * @return object part
     */
    public ArrayList<T> getParts() {
        return this.parts;
    }

    /**
     * @return type of furniture
     */
    public String getTypeName() {
        return this.typeName;
    }

    /**
     * Returns object
     */
    public T getObject() {
        return this.object;
    }

    /**
     * @return cheapest ids that make the furniture(s)
     */
    public ArrayList<String> getidCombination() {
        return this.idCombination;
    }

    /**
     * PROMISES: Cheapest id that has a bulb in lamp
     * 
     * @return cheapest id
     */
    public String bulbID() {
        String id = "";
        ArrayList<Integer> prices = new ArrayList<>();
        getParts().forEach(item -> {
            if (Lamp.class.cast(item).getBulb()) {
                // add prices of ids that have a bulb
                prices.add(Lamp.class.cast(item).getPrice());
            }
        });
        ;
        // find cheapest price
        int price = Collections.min(prices);
        // find index of cheapest price
        int i;
        for (i = 0; i < bulb.size(); i++) {
            if (prices.get(i) == price) {
                break;
            }
        }
        id = bulb.get(i);
        return id;
    }

    /**
     * PROMISES: Cheapest id that has a top in desk
     * 
     * @return cheapest id
     */
    public String topID() {
        String id = "";
        ArrayList<Integer> prices = new ArrayList<>();
        getParts().forEach(item -> {
            if (Desk.class.cast(item).getTop()) {
                // add prices of ids that have a top
                prices.add(Desk.class.cast(item).getPrice());
            }
        });
        ;
        // find cheapest price
        int price = Collections.min(prices);
        // find index of cheapest price
        int i;
        for (i = 0; i < top.size(); i++) {
            if (prices.get(i) == price) {
                break;
            }
        }
        id = top.get(i);
        return id;
    }

    /**
     * PROMISES: Cheapest id that has a drawer in desk
     * 
     * @return cheapest id
     */
    public String drawerID() {
        String id = "";
        ArrayList<Integer> prices = new ArrayList<>();
        getParts().forEach(item -> {
            if (Desk.class.cast(item).getDrawer()) {
                // add prices of ids that have a drawer
                prices.add(Desk.class.cast(item).getPrice());
            }
        });
        ;
        // find cheapest price
        int price = Collections.min(prices);
        // find index of cheapest price
        int i;
        for (i = 0; i < drawer.size(); i++) {
            if (prices.get(i) == price) {
                break;
            }
        }
        id = drawer.get(i);
        return id;
    }

    /**
     * PROMISES: Cheapest id that has arms in chair
     * 
     * @return cheapest id
     */
    public String armsID() {
        String id = "";
        ArrayList<Integer> prices = new ArrayList<>();
        getParts().forEach(item -> {
            if (Chair.class.cast(item).getArms()) {
                // add prices of ids that have arms
                prices.add(Chair.class.cast(item).getPrice());
            }
        });
        ;
        // find cheapest price
        int price = Collections.min(prices);
        // find index of cheapest price
        int i;
        for (i = 0; i < arms.size(); i++) {
            if (prices.get(i) == price) {
                break;
            }
        }
        id = arms.get(i);
        return id;
    }

    /**
     * PROMISES: Cheapest id that has a seat in chair
     * 
     * @return cheapest id
     */
    public String seatID() {
        String id = "";
        ArrayList<Integer> prices = new ArrayList<>();
        getParts().forEach(item -> {
            if (Chair.class.cast(item).getSeat()) {
                // add prices of ids that have a seat
                prices.add(Chair.class.cast(item).getPrice());
            }
        });
        ;
        // find cheapest price
        int price = Collections.min(prices);
        // find index of cheapest price
        int i;
        for (i = 0; i < seat.size(); i++) {
            if (prices.get(i) == price) {
                break;
            }
        }
        id = seat.get(i);
        return id;
    }

    /**
     * PROMISES: Cheapest id that has a cushion in chair
     * 
     * @return cheapest id
     */
    public String cushionID() {
        String id = "";
        ArrayList<Integer> prices = new ArrayList<>();
        getParts().forEach(item -> {
            if (Chair.class.cast(item).getCushion()) {
                // add prices of ids that have cushion
                prices.add(Chair.class.cast(item).getPrice());
            }
        });
        ;
        // find cheapest price
        int price = Collections.min(prices);
        // find index of cheapest price
        int i;
        for (i = 0; i < cushion.size(); i++) {
            if (prices.get(i) == price) {
                break;
            }
        }
        id = cushion.get(i);
        return id;
    }

    /**
     * PROMISES: Cheapest id that has drawers in filing
     * 
     * @return cheapest id
     */
    public String drawersID() {
        String id = "";
        ArrayList<Integer> prices = new ArrayList<>();
        getParts().forEach(item -> {
            if (Filing.class.cast(item).getDrawers()) {
                // add prices of ids that have drawers
                prices.add(Filing.class.cast(item).getPrice());
            }
        });
        ;
        // find cheapest price
        int price = Collections.min(prices);
        // find index of cheapest price
        int i;
        for (i = 0; i < drawers.size(); i++) {
            if (prices.get(i) == price) {
                break;
            }
        }
        id = drawers.get(i);
        return id;
    }

    /**
     * PROMISES: Cheapest id that has a cabinet in filing
     * 
     * @return cheapest id
     */
    public String cabinetID() {
        String id = "";
        ArrayList<Integer> prices = new ArrayList<>();
        getParts().forEach(item -> {
            if (Filing.class.cast(item).getCabinet()) {
                // add prices of ids that have a cabinet
                prices.add(Filing.class.cast(item).getPrice());
            }
        });
        ;
        // find cheapest price
        int price = Collections.min(prices);
        // find index of cheapest price
        int i;
        for (i = 0; i < cabinet.size(); i++) {
            if (prices.get(i) == price) {
                break;
            }
        }
        id = cabinet.get(i);
        return id;
    }
}
