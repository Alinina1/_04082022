package items.containers;

import customExeptions.ItemAlreadyPlacedExceptions;
import items.Item;
import items.Shape;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

abstract class Container extends Item{

    protected Collection<Item> items;

    public Container(String name, double weigh, int size, Shape shape, String color) {
        super(name, weigh, size, shape, color);
    }

    public void addItem(Item item) throws ItemAlreadyPlacedExceptions, IOException {
        if(!item.isItemSomewhere){
            items.add(item);
            item.isItemSomewhere = true;
        }
        else {
            throw new ItemAlreadyPlacedExceptions("Этот предмет уже лежит в другом месте!");
        }
    }

    public void putAwayItem(Item item){
        items.remove(item);
    }

    @Override
    public double getWeight() {
        double totalWeight = super.getWeight();
        for (Item item : items){
            totalWeight += item.getWeight();
        }
        return totalWeight;
    }

    public Collection<Item> getItems(){
        return Collections.unmodifiableCollection(items);
    }
}