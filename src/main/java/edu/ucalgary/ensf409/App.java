package edu.ucalgary.ensf409;

import java.util.ArrayList;
import edu.ucalgary.ensf409.FurniturePart.Types;
import io.github.cdimascio.dotenv.Dotenv;

/**
 * Class App used to run program through main Note: this class is not used in
 * the implementation
 * 
 * @author Anand Patel, Robert Brown, Ratik Kapoor, Risat Haque
 * @since 1.3
 */
public class App {
    public static void main(String[] args) throws Exception {
        Dotenv enviroment = Dotenv.load();
        Database test = new Database("jdbc:mysql://" + enviroment.get("DB_URL"), enviroment.get("DB_USER"),
                enviroment.get("DB_PASS"));
        test.connect();

        Filing l = new Filing("Medium");
        ArrayList<Filing> allLamps = test.getListByType(Types.FILING, "Medium");
        Builder<Filing> b = new Builder<Filing>(l);
        b.setParts(allLamps);

        b.setItems();

        b.buildMultipleItems(6);

        System.out.println("Id Combinations : " + b.getIdCombination());
        System.out.println("Total Cost : " + b.getCost());
    }
}
