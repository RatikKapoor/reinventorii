package edu.ucalgary.ensf409;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JacksonInject.Value;

public class Builder<T extends FurniturePart> {
    private T object;
    private ArrayList<T> parts;
    private List castedParts;
    public ArrayList<String> items;
    private int cost;
    private String typeName;
    private boolean[] features;

    private ArrayList<T> allCombinations = new ArrayList<T>();

    public Builder(T toBuild) {
        this.object = toBuild;
        this.typeName = object.getClass().getSimpleName();
    }

    public void BuildItem() {
        switch (FurniturePart.Types.fromString(this.typeName)) {
        case Lamp:
            Lamp lamp = Lamp.class.cast(object);
            features = new boolean[2];
            break;

        case Desk:
            Desk desk = Desk.class.cast(object);
            features = new boolean[3];

            break;

        case Chair:
            Chair chair = Chair.class.cast(object);
            features = new boolean[4];
            break;

        case Filing:
            Filing filing = Filing.class.cast(object);
            features = new boolean[3];
            break;

        default:
            break;
        }
        for (int i = 0; i < items.size(); i++) {

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
}
