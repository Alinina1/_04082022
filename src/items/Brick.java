package items;

public class Brick extends Item{
    static int count = 0;//Для названий объектов

    public Brick(double weight, int size, String color){
        super(" Кирпич " + ++count, weight, size, Shape.RECTANGLE, color);
    }
}
