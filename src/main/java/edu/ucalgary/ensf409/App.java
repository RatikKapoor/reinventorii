package edu.ucalgary.ensf409;

public class App {
    public static void main(String[] args) throws Exception {
        Database test = new Database("jdbc:mysql://server.ratik.me:25565/INVENTORY", "root", "eNsF409");
        test.connect();
        test.getLamps();
    }
}