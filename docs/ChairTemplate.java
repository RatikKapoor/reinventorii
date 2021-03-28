import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.stream.Collectors;

public class FurniturePart {
    public Connection Connect;
    public ResultSet results;
    public final String dbURL = "jdbc:mysql://localhost/inventory";
    public final String Username = "ensfanand";
    public final String Password = "Schooltemp1009";
    public String myFurniture = "Chair";
    public String myFurnitureCategory = "Mesh";
    public int myQuantity = 1;
    public int totalPrice;

    public ArrayList<Furniture> legs = new ArrayList<>();
    public ArrayList<Furniture> arms = new ArrayList<>();
    public ArrayList<Furniture> cushion = new ArrayList<>();
    public ArrayList<Furniture> seat = new ArrayList<>();

    public FurniturePart() {

    }

    public void initializeConnection() {
        try {
            Connect = DriverManager.getConnection(dbURL, Username, Password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void Chair() {
        HashMap<String, Integer> hash = new HashMap<String, Integer>();
        try {
            Statement statement = Connect.createStatement();
            results = statement.executeQuery("Select * FROM chair");
            while (results.next()) {
                if (results.getString("Type").equals(myFurnitureCategory)) {
                    totalPrice += Integer.parseInt(results.getString("Price"));
                    if (results.getString("Legs").equals("Y")) {
                        legs.add(new Furniture(results.getString("Price"), results.getString("ID")));

                    }
                    if (results.getString("Arms").equals("Y")) {
                        arms.add(new Furniture(results.getString("Price"), results.getString("ID")));

                    }
                    if (results.getString("Cushion").equals("Y")) {
                        cushion.add(new Furniture(results.getString("Price"), results.getString("ID")));

                    }
                    if (results.getString("Seat").equals("Y")) {
                        seat.add(new Furniture(results.getString("Price"), results.getString("ID")));
                    }
                    hash.put(results.getString("ID"), Integer.parseInt(results.getString("Price")));
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        boolean[] features = new boolean[4]; // amount of columns in the furniture type
        ArrayList<ArrayList<String>> combinations = new ArrayList<>(); // list of possible combinations

        for (int i = 0; i < legs.size(); i++) {
            String id = legs.get(i).getId();
            // C0942
            ArrayList<String> allIDs = new ArrayList<>();
            features[0] = true;
            // Populate the features array
            // check if the id exists in other features
            for (Furniture value : seat) {
                if (value.getId().equals(id)) {
                    features[2] = true;
                    break;
                }
            }
            for (Furniture arm : arms) {
                if (arm.getId().equals(id)) {
                    features[1] = true;
                    break;
                }
            }
            for (Furniture furniture : cushion) {
                if (furniture.getId().equals(id)) {
                    features[3] = true;
                    break;
                }
            }
            // {true, false, true, true}
            // System.out.println(Arrays.toString(features));

            // Add what extra IDs that the chair needs to be complete
            // iterate through the features array
            for (int k = 0; k < 4; k++) {
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
            //
            allIDs.add(id);
            // remove duplicates
            allIDs = (ArrayList<String>) allIDs.stream().distinct().collect(Collectors.toList()); // change after just
                                                                                                  // found easy way rn
            // System.out.println(allIDs);
            // add the combination of ID's to the combinations array
            combinations.add(allIDs);

        }
        if (combinations.isEmpty()) {
            System.out.println("It is not possible to make this product..");
        }
        ArrayList<Integer> finalPrice = new ArrayList<>();
        System.out.println(combinations);
        for (ArrayList<String> combination : combinations) {
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
        System.out.println(Collections.min(finalPrice));
    }

    public String armsID() {
        // get the id that has the lowest price
        String id = "";
        int currentPrice = arms.get(0).getPrice();
        for (Furniture arm : arms) {
            if (arm.getPrice() <= currentPrice) {
                currentPrice = arm.getPrice();
                id = arm.getId();
            }
        }
        return id;
    }

    public String seatID() {
        String id = "";
        int currentPrice = seat.get(0).getPrice();
        for (Furniture furniture : seat) {
            if (furniture.getPrice() <= currentPrice) {
                currentPrice = furniture.getPrice();
                id = furniture.getId();
            }
        }
        return id;
    }

    public String cushionID() {
        String id = "";
        int currentPrice = cushion.get(0).getPrice();
        for (Furniture furniture : cushion) {
            if (furniture.getPrice() <= currentPrice) {
                currentPrice = furniture.getPrice();
                id = furniture.getId();
            }
        }
        return id;
    }

    public static void main(String[] args) {
        FurniturePart JDBC = new FurniturePart();
        JDBC.initializeConnection();
        JDBC.Chair();
    }

}

class Furniture {
    int price;
    String id;
    String FurnitureType;

    // Create ArrayList and add it everytime
    Furniture(String price, String id) {
        this.price = Integer.parseInt(price);
        this.id = id;
    }

    public int getPrice() {
        return this.price;
    }

    public String getId() {
        return this.id;
    }

}