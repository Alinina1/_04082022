package items.containers;

import items.Item;

public class Plate extends Item {
    final static String name = "Тарелка";
    final static String shape = "FLAT";
    static int count = 1;//Для названий объектов

    public Plate(double weight, int size, String color){
        super(name + " " + count++, weight, size, shape, color);
    }
}
