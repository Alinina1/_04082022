package items;

public class Apple extends Item {
    final static String name = "Яблоко";
    final static String shape = "CIRCLE";
    static int count = 1;//Для названий объектов

    public Apple(double weight, int size, String color){
        super(name + " " + count++, weight, size, shape, color);
    }

}
