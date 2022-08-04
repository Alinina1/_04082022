package items.containers;

import items.Item;

import java.util.*;

public class Bag extends Item {
    final static String name = "Мешок";
    final static String shape = "CIRCLE";
    final static String color = "Gray";
    private double totalWeight = 0;
    static int count = 1;

    private final Set<Item> items = new HashSet<>();

    public Bag(double weight, int size){
        super(name + " " + count, weight, size, shape, color);
    }
    @Override
    public double getWeight() {
        for (Item item : items){
            totalWeight += item.getWeight();
        }
        return totalWeight;
    }

    public void addItem(Item item){
        items.add(item);
    }
    public Set<Item> getItems() {
        return items;
    }
}
