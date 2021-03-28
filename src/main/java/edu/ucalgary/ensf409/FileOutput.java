package edu.ucalgary.ensf409;

import java.util.ArrayList;

/**
 * NOTE: This class has not been tested, when Builder is complete, complete this
 * class!
 * 
 * Implementation of FileOuput To Utilize class, send in relevent parts
 * information from input and output. Call createReceipt - returns a String
 */
public class FileOutput {
    private String inputFurniture;
    private String inputFurnitureType;
    private String inputQuantity;

    private ArrayList<String> partsList;
    private ArrayList<String> manuNameList;
    private int cost;

    private StringBuilder receipt;

    public FileOutput(String inputFurniture, String inputFurnitureType, String inputQuantity,
            ArrayList<String> partsList, int cost) {
        this.inputFurniture = inputFurniture;
        this.inputFurnitureType = inputFurnitureType;
        this.inputQuantity = inputQuantity;
        this.partsList = partsList;
        this.cost = cost;
    }

    public FileOutput(String inputFurniture, String inputFurnitureType, String inputQuantity,
            ArrayList<String> partList, ArrayList<String> manuNameList, int cost) {
        this(inputFurniture, inputFurnitureType, inputQuantity, partList, cost);
        this.manuNameList = manuNameList;
    }

    public String createReceipt() {
        receipt.append("Furniture Order Form: \n\n");
        receipt.append(
                "Original Request: " + inputFurnitureType + " " + inputFurniture + ", " + inputQuantity + "\n\n");
        receipt.append("Items Ordered\n");

        if (!partsList.isEmpty()) {
            for (int i = 0; i < partsList.size(); i++) {
                receipt.append("ID: " + partsList.get(i) + "\n");
            }
            receipt.append("Final Cost: " + cost);
        } else {
            /**
             * [Optional] - Add a Dynamic implementation of manufacturers Calling the
             * getManufacturers method from the Database class will return a list of
             * manufacturers stored in the database. It will return an arrayList, convert to
             * String for print
             */
            receipt.append("Order cannot be fulfilled based on current inventory. Suggested manufacturers are: ");
            for (int i = 0; i < manuNameList.size(); i++) {
                receipt.append(manuNameList.get(i) + ", ");
            }
        }
        return receipt.toString();
    }

}