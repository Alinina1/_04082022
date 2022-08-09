package items;

import drawing.ItemsTypes;
import items.Item;

public class Plate extends Item {
    static int count = 0;//Для названий объектов
    static final ItemsTypes itemType = ItemsTypes.SUBJECTS;

    public Plate(double weight, int size, String color){
        super("Тарелка " + ++count, weight, size, Shape.FLAT, color);
    }
    public int getH(){
        return 20;
    }

    public int getW(){
        return this.getSize()*100;
    }

}
