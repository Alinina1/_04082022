package items.containers;

import items.Item;
import items.Shape;

import java.util.*;

public class Bag extends Container {
    final static String color = "Gray";
    static int count = 0;

    public Bag(double weight, int size){
        super("Мешок " + ++count, weight, size, Shape.CIRCLE, color);
        items = new HashSet<>();
    }
    public String getItemsString() {
        String s = "В мешке лежат: ";
        for(Item item : items){
            s += item.getName() + ", ";
        }
        return s.substring(0, s.length()-2);
    }
}
