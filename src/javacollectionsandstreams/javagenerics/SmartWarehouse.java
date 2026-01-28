package javacollectionsandstreams.javagenerics;

import java.util.*;

abstract class WarehouseItem {
    String name;

    WarehouseItem(String name) {
        this.name = name;
    }

    void display() {
        System.out.println(name);
    }
}

class Electronics extends WarehouseItem {
    Electronics(String name) {
        super(name);
    }
}

class Groceries extends WarehouseItem {
    Groceries(String name) {
        super(name);
    }
}

class Storage<T extends WarehouseItem> {
    List<T> items = new ArrayList<>();

    void addItem(T item) {
        items.add(item);
    }

    static void displayItems(List<? extends WarehouseItem> list) {
        for (WarehouseItem item : list) {
            item.display();
        }
    }
}

public class SmartWarehouse {
    public static void main(String[] args) {
        Storage<Electronics> storage = new Storage<>();
        storage.addItem(new Electronics("Laptop"));

        Storage.displayItems(storage.items);
    }
}
