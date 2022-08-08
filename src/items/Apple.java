package items;

public class Apple extends Item {
   static int count = 0;//Для названий объектов

    public Apple(double weight, int size, String color){
        super("Яблоко " + ++count, weight, size, Shape.CIRCLE, color);
    }
}
