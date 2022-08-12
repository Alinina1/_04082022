package items.containers;

import drawing.ItemsTypes;
import drawing.SVGWriter;
import items.Item;
import items.Shape;

import java.io.IOException;
import java.util.*;

public class Stack extends Container{
    final static String color = "White";
    static int count = 0;
    static final ItemsTypes itemType = ItemsTypes.CONTAINERS;

    static boolean isThereCircle = false;
    static Item prevItem = null;

    public Stack(double weight, int size){
        super("Стопка " + ++count, weight, size, Shape.FLAT, color);
        items = new ArrayDeque<>();
    }

    public void addItem(Item item){
        if(!item.isItemSomewhere){
            if (!isThereCircle ){
                if(Shape.CIRCLE.equals(item.getShape())){
                    items.add(item);
                    item.isItemSomewhere = true;
                    isThereCircle = true;
                    return;
                }
                if(prevItem == null || prevItem.getSize() >= item.getSize()){
                    items.add(item);
                    item.isItemSomewhere = true;
                    prevItem = item;
                }
                else {
                    throw new IllegalArgumentException("Размер верхнего предмета в стопке меньше чем размер текущего предмета!");
                }
            } else {
                throw new IllegalArgumentException("В стопке уже лежит круглый предмет, больше предметов добавлять нельзя!");
            }
        } else {
            throw new IllegalArgumentException("Этот предмет уже лежит в другом месте!");
        }
    }
    public void putAwayItem(){
        ((ArrayDeque<?>)items).removeLast();
    }

    public String getItemsString() {
        String s = "В стопке: ";
        for(Item item : items){
            s += item.getName() + ", ";
        }
        return s.substring(0, s.length()-2);
    }

    public void write(int x, int y, SVGWriter writer) throws IOException {
        for (Item itemsForWrite: items){
            itemsForWrite.write(x, y-itemsForWrite.getH(), writer);
            y-=itemsForWrite.getH();
        }
    }
}
