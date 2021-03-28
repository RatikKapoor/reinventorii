package edu.ucalgary.ensf409;

import java.util.ArrayList;
import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JacksonInject.Value;

public class Builder<T extends FurniturePart> {
    private T object;
    private ArrayList<T> parts;
    public ArrayList<String> items;
    private int cost;
    private String typeName;

    private ArrayList<T> allCombinations = new ArrayList<T>();

    public Builder(T toBuild) {
        this.object = toBuild;
        this.typeName = object.getClass().getSimpleName();
    }

    public void BuildItem() {
        switch (FurniturePart.Types.fromString(this.typeName)) {
        case Lamp:
            Lamp lamp = Lamp.class.cast(object);

            break;

        case Desk:
            Desk desk = Desk.class.cast(object);

            break;

        case Chair:
            Chair chair = Chair.class.cast(object);
            break;

        case Filing:
            Filing filing = Filing.class.cast(object);
            break;

        default:
            break;
        }
        // this.items.forEach(item -> {
        // for (T t : parts) {
        // }
        // });
        // ;
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
