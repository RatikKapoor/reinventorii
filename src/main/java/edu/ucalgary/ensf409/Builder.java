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
    private ArrayList<String> bulb = new ArrayList<>();
    private ArrayList<String> base = new ArrayList<>();
    // FOR DESK
    private ArrayList<String> legs = new ArrayList<>();
    private ArrayList<String> top = new ArrayList<>();
    private ArrayList<String> drawer = new ArrayList<>();
    // FOR CHAIR
    private ArrayList<String> chairLegs = new ArrayList<>();
    private ArrayList<String> arms = new ArrayList<>();
    private ArrayList<String> seat = new ArrayList<>();
    private ArrayList<String> cushion = new ArrayList<>();
    // FOR FILING
    private ArrayList<String> rails = new ArrayList<>();
    private ArrayList<String> drawers = new ArrayList<>();
    private ArrayList<String> cabinet = new ArrayList<>();
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
        BuildItem(count);
    }

    /**
     * Method that builds the requested item in the cheapest combination. PROMISES:
     * Cheapest id combination that is required to make the furniture. PROMISES:
     * Cheapest cost that is required to make the furniture.
     */
    public void BuildItem(int count) {
        HashMap<String, Integer> hash = new HashMap<String, Integer>();

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

                int featureCount1 = 0;
                for (String val : bulb) {
                    if (val.equals(id)) {
                        // checks if this id comes with a bulb
                        features[1] = true;
                        featureCount1++;
                        break;
                    }
                }

                ArrayList<String> baseID = getarrayID(count - 1, id, "base");
                ArrayList<String> bulbID = getarrayID(count - featureCount1, id, "bulb");

                if (baseID == null || bulbID == null) {
                    cost = -1;
                    break;
                }
                allIDs.addAll(baseID);
                allIDs.addAll(bulbID);
                allIDs.add(id);

                for (int k = 0; k < items.size(); k++) {
                    features[k] = false;
                }

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

                int featureCount1 = 0;
                int featureCount2 = 0;
                for (String val : top) {
                    if (val.equals(id)) {
                        // checks if this id comes with a top
                        features[1] = true;
                        featureCount1++;
                        break;
                    }
                }
                for (String val : drawer) {
                    if (val.equals(id)) {
                        // checks if this id comes with a drawer
                        features[2] = true;
                        featureCount2++;
                        break;
                    }
                }
                // adds the cheapest components to construct the desk
                // if needed
                ArrayList<String> legsID = getarrayID(count - 1, id, "legs");
                ArrayList<String> topID = getarrayID(count - featureCount1, id, "top");
                ArrayList<String> drawerID = getarrayID(count - featureCount2, id, "drawer");
                if (legsID == null || topID == null || drawerID == null) {
                    cost = -1;
                    break;
                }
                allIDs.addAll(legsID);
                allIDs.addAll(topID);
                allIDs.addAll(drawerID);
                allIDs.add(id);
                for (int k = 0; k < items.size(); k++) {
                    features[k] = false;
                }

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

                int featureCount1 = 0;
                int featureCount2 = 0;
                int featureCount3 = 0;
                for (String val : arms) {
                    if (val.equals(id)) {
                        // checks if this id comes with arms
                        features[1] = true;
                        featureCount1++;
                        break;
                    }
                }
                for (String val : seat) {
                    if (val.equals(id)) {
                        // checks if this id comes with seat
                        features[2] = true;
                        featureCount2++;
                        break;
                    }
                }
                for (String val : cushion) {
                    if (val.equals(id)) {
                        // checks if this id comes with cushion
                        features[3] = true;
                        featureCount3++;
                        break;
                    }
                }

                // adds the cheapest components to construct the chair
                // if needed
                ArrayList<String> legsID = getarrayID(count - 1, id, "chairLegs");
                ArrayList<String> armsID = getarrayID(count - featureCount1, id, "arms");
                ArrayList<String> seatID = getarrayID(count - featureCount2, id, "seat");
                ArrayList<String> cushionID = getarrayID(count - featureCount3, id, "cushion");
                if (legsID == null || armsID == null || seatID == null || cushionID == null) {
                    cost = -1;
                    break;
                }
                allIDs.addAll(legsID);
                allIDs.addAll(armsID);
                allIDs.addAll(seatID);
                allIDs.addAll(cushionID);
                allIDs.add(id);
                for (int k = 0; k < items.size(); k++) {
                    features[k] = false;
                }
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

                int featureCount1 = 0;
                int featureCount2 = 0;
                for (String val : drawers) {
                    if (val.equals(id)) {
                        // checks if this id comes with drawers
                        features[1] = true;
                        featureCount1++;
                        break;
                    }
                }
                for (String val : cabinet) {
                    if (val.equals(id)) {
                        // checks if this id comes with a cabinet
                        features[2] = true;
                        featureCount2++;
                        break;
                    }
                }
                // adds the cheapest components to construct the filing
                // if needed
                ArrayList<String> railsID = getarrayID(count - 1, id, "rails");
                ArrayList<String> drawersID = getarrayID(count - featureCount1, id, "drawers");
                ArrayList<String> cabinetID = getarrayID(count - featureCount2, id, "cabinet");
                if (railsID == null || drawersID == null || cabinetID == null) {
                    cost = -1;
                    break;
                }
                allIDs.addAll(railsID);
                allIDs.addAll(drawersID);
                allIDs.addAll(cabinetID);
                allIDs.add(id);

                for (int k = 0; k < items.size(); k++) {
                    features[k] = false;
                }
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

    public ArrayList<String> basearrayID(int count, String id) {
        ArrayList<String> basearray = new ArrayList<>();
        if (count == 0) {
            basearray.add(id);
        } else {
            ArrayList<Integer> prices = new ArrayList<>();
            ArrayList<Integer> finalPrices = new ArrayList<>();
            HashMap<String, Integer> priceAndIds = new HashMap<String, Integer>();
            getParts().forEach(item -> {
                if (Lamp.class.cast(item).getBase()) {
                    // add prices of ids that have a bulb
                    if (!Lamp.class.cast(item).getId().equals(id)) {
                        prices.add(Lamp.class.cast(item).getPrice());
                        priceAndIds.put(Lamp.class.cast(item).getId(), Lamp.class.cast(item).getPrice());
                    }
                }
            });
            ;

            if (prices.size() < count) {
                return null;
            }
            // find cheapest prices
            for (int i = 0; i < count; i++) {
                Integer price = Collections.min(prices);
                prices.remove(price);
                finalPrices.add(price);
            }
            int counter = 0;
            for (String i : priceAndIds.keySet()) {
                for (Integer value : finalPrices) {
                    if (priceAndIds.get(i) == value) {
                        basearray.add(i);
                        counter++;
                        break;
                    }
                }
                if (counter == count) {
                    break;
                }
            }
            basearray.add(id);
        }
        return basearray;
    }

    public ArrayList<String> getarrayID(int count, String id, String componentType) {
        ArrayList<String> basearray = new ArrayList<>();
        if (count == 0) {
            basearray.add(id);
        } else {
            ArrayList<Integer> prices = new ArrayList<>();
            ArrayList<Integer> finalPrices = new ArrayList<>();
            HashMap<String, Integer> priceAndIds = new HashMap<String, Integer>();
            getParts().forEach(item -> {
                if (componentType.equals("bulb")) {
                    if (Lamp.class.cast(item).getBulb()) {
                        // add prices of ids that have a bulb
                        if (!Lamp.class.cast(item).getId().equals(id)) {
                            prices.add(Lamp.class.cast(item).getPrice());
                            priceAndIds.put(Lamp.class.cast(item).getId(), Lamp.class.cast(item).getPrice());
                        }
                    }
                }
                if (componentType.equals("base")) {
                    if (Lamp.class.cast(item).getBase()) {
                        // add prices of ids that have a bulb
                        if (!Lamp.class.cast(item).getId().equals(id)) {
                            prices.add(Lamp.class.cast(item).getPrice());
                            priceAndIds.put(Lamp.class.cast(item).getId(), Lamp.class.cast(item).getPrice());
                        }
                    }
                }
                if (componentType.equals("legs")) {
                    if (Desk.class.cast(item).getLegs()) {
                        // add prices of ids that have a bulb
                        if (!Desk.class.cast(item).getId().equals(id)) {
                            prices.add(Desk.class.cast(item).getPrice());
                            priceAndIds.put(Desk.class.cast(item).getId(), Desk.class.cast(item).getPrice());
                        }
                    }
                }
                if (componentType.equals("top")) {
                    if (Desk.class.cast(item).getTop()) {
                        // add prices of ids that have a bulb
                        if (!Desk.class.cast(item).getId().equals(id)) {
                            prices.add(Desk.class.cast(item).getPrice());
                            priceAndIds.put(Desk.class.cast(item).getId(), Desk.class.cast(item).getPrice());
                        }
                    }
                }
                if (componentType.equals("drawer")) {
                    if (Desk.class.cast(item).getDrawer()) {
                        // add prices of ids that have a bulb
                        if (!Desk.class.cast(item).getId().equals(id)) {
                            prices.add(Desk.class.cast(item).getPrice());
                            priceAndIds.put(Desk.class.cast(item).getId(), Desk.class.cast(item).getPrice());
                        }
                    }
                }
                if (componentType.equals("chairLegs")) {
                    if (Chair.class.cast(item).getLegs()) {
                        // add prices of ids that have a bulb
                        if (!Chair.class.cast(item).getId().equals(id)) {
                            prices.add(Chair.class.cast(item).getPrice());
                            priceAndIds.put(Chair.class.cast(item).getId(), Chair.class.cast(item).getPrice());
                        }
                    }
                }
                if (componentType.equals("arms")) {
                    if (Chair.class.cast(item).getArms()) {
                        // add prices of ids that have a bulb
                        if (!Chair.class.cast(item).getId().equals(id)) {
                            prices.add(Chair.class.cast(item).getPrice());
                            priceAndIds.put(Chair.class.cast(item).getId(), Chair.class.cast(item).getPrice());
                        }
                    }
                }
                if (componentType.equals("seat")) {
                    if (Chair.class.cast(item).getSeat()) {
                        // add prices of ids that have a bulb
                        if (!Chair.class.cast(item).getId().equals(id)) {
                            prices.add(Chair.class.cast(item).getPrice());
                            priceAndIds.put(Chair.class.cast(item).getId(), Chair.class.cast(item).getPrice());
                        }
                    }
                }
                if (componentType.equals("cushion")) {
                    if (Chair.class.cast(item).getCushion()) {
                        // add prices of ids that have a bulb
                        if (!Chair.class.cast(item).getId().equals(id)) {
                            prices.add(Chair.class.cast(item).getPrice());
                            priceAndIds.put(Chair.class.cast(item).getId(), Chair.class.cast(item).getPrice());
                        }
                    }
                }
                if (componentType.equals("rails")) {
                    if (Filing.class.cast(item).getRails()) {
                        // add prices of ids that have a bulb
                        if (!Filing.class.cast(item).getId().equals(id)) {
                            prices.add(Filing.class.cast(item).getPrice());
                            priceAndIds.put(Filing.class.cast(item).getId(), Filing.class.cast(item).getPrice());
                        }
                    }
                }
                if (componentType.equals("drawers")) {
                    if (Filing.class.cast(item).getDrawers()) {
                        // add prices of ids that have a bulb
                        if (!Filing.class.cast(item).getId().equals(id)) {
                            prices.add(Filing.class.cast(item).getPrice());
                            priceAndIds.put(Filing.class.cast(item).getId(), Filing.class.cast(item).getPrice());
                        }
                    }
                }
                if (componentType.equals("cabinet")) {
                    if (Filing.class.cast(item).getCabinet()) {
                        // add prices of ids that have a bulb
                        if (!Filing.class.cast(item).getId().equals(id)) {
                            prices.add(Filing.class.cast(item).getPrice());
                            priceAndIds.put(Filing.class.cast(item).getId(), Filing.class.cast(item).getPrice());
                        }
                    }
                }

            });
            ;

            if (prices.size() < count) {
                return null;
            }
            // find cheapest prices
            for (int i = 0; i < count; i++) {
                Integer price = Collections.min(prices);
                prices.remove(price);
                finalPrices.add(price);
            }
            // find the ids that correspond to cheapest prices
            int counter = 0;
            for (String i : priceAndIds.keySet()) {
                for (Integer value : finalPrices) {
                    if (priceAndIds.get(i).equals(value)) {
                        basearray.add(i);
                        counter++;
                        break;
                    }
                }
                if (counter == count) {
                    break;
                }
            }

        }
        return basearray;
    }

}
