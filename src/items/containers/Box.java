package items.containers;

import items.Item;
import items.Shape;

import java.util.*;

public class Box extends Container {
    final static String color = "Black";
    static int count = 0;

    public Box(double weight, int size){
        super("Коробка " + ++count, weight, size, Shape.RECTANGLE, color);
        items = new HashSet<>();
    }


    public void addItem(Item item){
        if(!item.isItemSomewhere){
            items.add(item);
            item.isItemSomewhere = true;
        }
        else {
            throw new IllegalArgumentException("Этот предмет уже лежит в другом месте!");
        }
    }

    public String getItemsString() {
        String s = "В коробке лежат: ";
        for(Item item : items){
            s += item.getName() + ", ";
        }
        return s.substring(0, s.length()-2);
    }

}
