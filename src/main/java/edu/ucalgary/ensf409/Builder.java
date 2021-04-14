package edu.ucalgary.ensf409;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.HashMap;

import com.fasterxml.jackson.annotation.JacksonInject.Value;

/**
 * Builder: Cheapest Algorithm calculator.
 * 
 * @author Anand Patel, Robert Brown, Ratik Kapoor, Risat Haque
 * @since 1.1
 */
public class Builder<T extends FurniturePart> {
    private T object;
    private ArrayList<T> parts;
    public ArrayList<String> items;
    private int cost; // cheapest cost of the arrangements
    private String typeName;

    public ArrayList<ArrayList<String>> allCombinations = new ArrayList<>();
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
        case LAMP:
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
            // check if any of the components are empty
            if (bulb.isEmpty() || base.isEmpty()) {
                cost = -1;
                break;
            }

            for (String id : base) {
                // all ids in one combination
                ArrayList<String> allIds = new ArrayList<>();
                // all ids that have already been picked
                ArrayList<String> ids = new ArrayList<>();
                ids.add(id);

                // used to count how many components we need
                int featureCount1 = 0; // bulb
                if (bulb.contains(id)) {
                    featureCount1++;
                }
                // adds the cheapest components to construct the Lamp
                // if needed
                ArrayList<String> baseId = getarrayID(count - 1, ids, "base");
                if (baseId == null) {
                    cost = -1;
                    break;
                }
                for (String val : baseId) {
                    if (bulb.contains(val) && !val.equals(id)) {
                        featureCount1++;
                        ids.add(val);
                    }
                }
                ArrayList<String> bulbId = getarrayID(count - featureCount1, ids, "bulb");
                if (bulbId == null) {
                    cost = -1;
                    break;
                }

                allIds.addAll(baseId);
                allIds.addAll(bulbId);
                allIds.add(id);
                // remove duplicate ids
                allIds = (ArrayList<String>) allIds.stream().distinct().collect(Collectors.toList());
                allCombinations.add(allIds);
            }
            break;

        case DESK:

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

            for (String id : legs) {
                // all ids in one combination
                ArrayList<String> allIds = new ArrayList<>();
                // all ids that have already been picked
                ArrayList<String> ids = new ArrayList<>();
                ids.add(id);

                // used to count how many components we need
                int featureCount1 = 0; // top
                int featureCount2 = 0; // drawer
                if (top.contains(id)) {
                    featureCount1++;
                }
                if (drawer.contains(id)) {
                    featureCount2++;
                }
                // adds the cheapest components to construct the Desk
                // if needed
                ArrayList<String> legsId = getarrayID(count - 1, ids, "legs");
                if (legsId == null) {
                    cost = -1;
                    break;
                }
                for (String val : legsId) {
                    if (top.contains(val) && !val.equals(id)) {
                        featureCount1++;
                        ids.add(val);
                    }
                    if (drawer.contains(val) && !val.equals(id)) {
                        featureCount2++;
                        ids.add(val);
                    }
                }
                ArrayList<String> topId = getarrayID(count - featureCount1, ids, "top");
                if (topId == null) {
                    cost = -1;
                    break;
                }
                for (String val : topId) {
                    if (drawer.contains(val) && !val.equals(id)) {
                        featureCount2++;
                        ids.add(val);
                    }
                }
                ArrayList<String> drawerId = getarrayID(count - featureCount2, ids, "drawer");
                if (drawerId == null) {
                    cost = -1;
                    break;
                }

                allIds.addAll(legsId);
                allIds.addAll(topId);
                allIds.addAll(drawerId);
                allIds.add(id);
                // remove duplicates
                allIds = (ArrayList<String>) allIds.stream().distinct().collect(Collectors.toList());
                allCombinations.add(allIds);

            }

            break;

        case CHAIR:
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

            for (String id : chairLegs) {
                // all ids in one combination
                ArrayList<String> allIds = new ArrayList<>();
                // all ids that have already been picked
                ArrayList<String> ids = new ArrayList<>();
                ids.add(id);
                // used to count how many components we need
                int featureCount1 = 0; // arms
                int featureCount2 = 0; // seat
                int featureCount3 = 0; // cushion
                if (arms.contains(id)) {
                    featureCount1++;
                }
                if (seat.contains(id)) {
                    featureCount2++;
                }
                if (cushion.contains(id)) {
                    featureCount3++;
                }
                // adds the cheapest components to construct the Chair
                // if needed
                ArrayList<String> legsId = getarrayID(count - 1, ids, "chairLegs");
                if (legsId == null) {
                    cost = -1;
                    break;
                }
                for (String val : legsId) {
                    if (arms.contains(val) && !val.equals(id)) {
                        featureCount1++;
                        ids.add(val);
                    }
                    if (seat.contains(val) && !val.equals(id)) {
                        featureCount2++;
                        ids.add(val);
                    }
                    if (cushion.contains(val) && !val.equals(id)) {
                        featureCount3++;
                        ids.add(val);
                    }
                }
                ArrayList<String> armsId = getarrayID(count - featureCount1, ids, "arms");
                if (armsId == null) {
                    cost = -1;
                    break;
                }
                for (String val : armsId) {
                    if (seat.contains(val) && !val.equals(id)) {
                        featureCount2++;
                        ids.add(val);
                    }
                    if (cushion.contains(val) && !val.equals(id)) {
                        featureCount3++;
                        ids.add(val);
                    }
                }
                ArrayList<String> seatId = getarrayID(count - featureCount2, ids, "seat");
                if (seatId == null) {
                    cost = -1;
                    break;
                }
                for (String val : seatId) {
                    if (cushion.contains(val) && !val.equals(id)) {
                        featureCount3++;
                        ids.add(val);
                    }
                }
                ArrayList<String> cushionId = getarrayID(count - featureCount3, ids, "cushion");
                if (cushionId == null) {
                    cost = -1;
                    break;
                }
                allIds.addAll(legsId);
                allIds.addAll(armsId);
                allIds.addAll(seatId);
                allIds.addAll(cushionId);
                allIds.add(id);
                // remove duplicates
                allIds = (ArrayList<String>) allIds.stream().distinct().collect(Collectors.toList());
                allCombinations.add(allIds);

            }

            break;

        case FILING:
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
            if (rails.isEmpty() || drawers.isEmpty() || cabinet.isEmpty()) {
                cost = -1;
                break;
            }
            for (String id : rails) {
                // all ids in one combination
                ArrayList<String> allIds = new ArrayList<>();
                // all ids that have already been picked
                ArrayList<String> ids = new ArrayList<>();
                ids.add(id);
                // used to count how many components we need
                int featureCount1 = 0; // drawers
                int featureCount2 = 0; // cabinet
                if (drawers.contains(id)) {
                    featureCount1++;
                }
                if (cabinet.contains(id)) {
                    featureCount2++;
                }
                // adds the cheapest components to construct the Filing
                // if needed
                ArrayList<String> railsId = getarrayID(count - 1, ids, "rails");
                if (railsId == null) {
                    cost = -1;
                    break;
                }
                for (String val : railsId) {
                    if (drawers.contains(val) && !val.equals(id)) {
                        featureCount1++;
                        ids.add(val);
                    }
                    if (cabinet.contains(val) && !val.equals(id)) {
                        featureCount2++;
                        ids.add(val);
                    }
                }
                ArrayList<String> drawersId = getarrayID(count - featureCount1, ids, "drawers");
                if (drawersId == null) {
                    cost = -1;
                    break;
                }
                for (String val : drawersId) {
                    if (cabinet.contains(val) && !val.equals(id)) {
                        featureCount2++;
                        ids.add(val);
                    }
                }
                ArrayList<String> cabinetId = getarrayID(count - featureCount2, ids, "cabinet");
                if (cabinetId == null) {
                    cost = -1;
                    break;
                }

                allIds.addAll(railsId);
                allIds.addAll(drawersId);
                allIds.addAll(cabinetId);
                allIds.add(id);
                // remove duplicates
                allIds = (ArrayList<String>) allIds.stream().distinct().collect(Collectors.toList());
                allCombinations.add(allIds);

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
        case LAMP:
            for (LampParts type : LampParts.values()) {
                items.add(type.toString());
            }
            break;

        case CHAIR:
            for (ChairParts type : ChairParts.values()) {
                items.add(type.toString());
            }
            break;

        case FILING:
            for (FilingParts type : FilingParts.values()) {
                items.add(type.toString());
            }
            break;

        case DESK:
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
     * Method that returns an arraylist of the cheapest ids. PROMISES: Cheapest ids
     * for requested amount of components
     * 
     * @param count         how many components we need
     * @param ids           ids that have already been picked
     * @param componentType what component we need
     * @return a arraylist of cheapest ids
     */
    public ArrayList<String> getarrayID(int count, ArrayList<String> ids, String componentType) {
        ArrayList<String> basearray = new ArrayList<>();
        if (count == 0) {
            // if no components are needed return
            // the original id
            basearray.add(ids.get(0));
        } else {
            // used to get all eligible prices
            ArrayList<Integer> prices = new ArrayList<>();
            // used to get cheapest prices depending on the count
            ArrayList<Integer> finalPrices = new ArrayList<>();
            // used to keep track of ids and corresponding prices
            HashMap<String, Integer> priceAndIds = new HashMap<String, Integer>();
            // populate arrays
            getParts().forEach(item -> {
                if (componentType.equals("bulb")) {
                    if (Lamp.class.cast(item).getBulb()) {
                        // add prices of ids that have a bulb
                        if (!ids.contains(Lamp.class.cast(item).getId())) {
                            prices.add(Lamp.class.cast(item).getPrice());
                            priceAndIds.put(Lamp.class.cast(item).getId(), Lamp.class.cast(item).getPrice());
                        }
                    }
                }
                if (componentType.equals("base")) {
                    if (Lamp.class.cast(item).getBase()) {
                        // add prices of ids that have a bulb
                        if (!ids.contains(Lamp.class.cast(item).getId())) {
                            prices.add(Lamp.class.cast(item).getPrice());
                            priceAndIds.put(Lamp.class.cast(item).getId(), Lamp.class.cast(item).getPrice());
                        }
                    }
                }
                if (componentType.equals("legs")) {
                    if (Desk.class.cast(item).getLegs()) {
                        // add prices of ids that have a bulb
                        if (!ids.contains(Desk.class.cast(item).getId())) {
                            prices.add(Desk.class.cast(item).getPrice());
                            priceAndIds.put(Desk.class.cast(item).getId(), Desk.class.cast(item).getPrice());
                        }
                    }
                }
                if (componentType.equals("top")) {
                    if (Desk.class.cast(item).getTop()) {
                        // add prices of ids that have a bulb
                        if (!ids.contains(Desk.class.cast(item).getId())) {
                            prices.add(Desk.class.cast(item).getPrice());
                            priceAndIds.put(Desk.class.cast(item).getId(), Desk.class.cast(item).getPrice());
                        }
                    }
                }
                if (componentType.equals("drawer")) {
                    if (Desk.class.cast(item).getDrawer()) {
                        // add prices of ids that have a bulb
                        if (!ids.contains(Desk.class.cast(item).getId())) {
                            prices.add(Desk.class.cast(item).getPrice());
                            priceAndIds.put(Desk.class.cast(item).getId(), Desk.class.cast(item).getPrice());
                        }
                    }
                }
                if (componentType.equals("chairLegs")) {
                    if (Chair.class.cast(item).getLegs()) {
                        // add prices of ids that have a bulb
                        if (!ids.contains(Chair.class.cast(item).getId())) {
                            prices.add(Chair.class.cast(item).getPrice());
                            priceAndIds.put(Chair.class.cast(item).getId(), Chair.class.cast(item).getPrice());
                        }
                    }
                }
                if (componentType.equals("arms")) {
                    if (Chair.class.cast(item).getArms()) {
                        // add prices of ids that have a bulb
                        if (!ids.contains(Chair.class.cast(item).getId())) {
                            prices.add(Chair.class.cast(item).getPrice());
                            priceAndIds.put(Chair.class.cast(item).getId(), Chair.class.cast(item).getPrice());
                        }
                    }
                }
                if (componentType.equals("seat")) {
                    if (Chair.class.cast(item).getSeat()) {
                        // add prices of ids that have a bulb
                        if (!ids.contains(Chair.class.cast(item).getId())) {
                            prices.add(Chair.class.cast(item).getPrice());
                            priceAndIds.put(Chair.class.cast(item).getId(), Chair.class.cast(item).getPrice());
                        }
                    }
                }
                if (componentType.equals("cushion")) {
                    if (Chair.class.cast(item).getCushion()) {
                        // add prices of ids that have a bulb
                        if (!ids.contains(Chair.class.cast(item).getId())) {
                            prices.add(Chair.class.cast(item).getPrice());
                            priceAndIds.put(Chair.class.cast(item).getId(), Chair.class.cast(item).getPrice());
                        }
                    }
                }
                if (componentType.equals("rails")) {
                    if (Filing.class.cast(item).getRails()) {
                        // add prices of ids that have a bulb
                        if (!ids.contains(Filing.class.cast(item).getId())) {
                            prices.add(Filing.class.cast(item).getPrice());
                            priceAndIds.put(Filing.class.cast(item).getId(), Filing.class.cast(item).getPrice());
                        }
                    }
                }
                if (componentType.equals("drawers")) {
                    if (Filing.class.cast(item).getDrawers()) {
                        // add prices of ids that have a bulb
                        if (!ids.contains(Filing.class.cast(item).getId())) {
                            prices.add(Filing.class.cast(item).getPrice());
                            priceAndIds.put(Filing.class.cast(item).getId(), Filing.class.cast(item).getPrice());
                        }
                    }
                }
                if (componentType.equals("cabinet")) {
                    if (Filing.class.cast(item).getCabinet()) {
                        // add prices of ids that have a bulb
                        if (!ids.contains(Filing.class.cast(item).getId())) {
                            prices.add(Filing.class.cast(item).getPrice());
                            priceAndIds.put(Filing.class.cast(item).getId(), Filing.class.cast(item).getPrice());
                        }
                    }
                }

            });
            ;
            // return null if requested more ids
            // than available
            if (prices.size() < count) {
                return null;
            }
            // find cheapest prices
            for (int i = 0; i < count; i++) {
                Integer price = Collections.min(prices);
                prices.remove(price);
                finalPrices.add(price);
            }
            // find the ids that correspond to the cheapest prices
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