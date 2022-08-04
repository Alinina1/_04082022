package items;

public class Brick extends Item{
    final static String name = "Кирпич";
    final static String shape = "RECTANGLE";
    static int count = 1;//Для названий объектов

    public Brick(double weight, int size, String color){
        super(name + " " + count++, weight, size, shape, color);
    }
}
