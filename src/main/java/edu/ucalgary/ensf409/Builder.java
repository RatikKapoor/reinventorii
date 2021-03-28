package edu.ucalgary.ensf409;

import java.util.ArrayList;

public class Builder<T extends FurniturePart> {
    private T object;
    private ArrayList<T> parts;
    private ArrayList<String> items;
    private int cost;
    private String typeName;

    public Builder(T toBuild) {
        this.object = toBuild;
        this.typeName = object.getType();
    }

    // private void getParts() {
    // if(this.typeName != null) {

    // }
    // }

}
