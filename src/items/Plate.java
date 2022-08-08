package items;

import items.Item;

public class Plate extends Item {
    static int count = 0;//Для названий объектов

    public Plate(double weight, int size, String color){
        super("Тарелка " + ++count, weight, size, Shape.FLAT, color);
    }
}
