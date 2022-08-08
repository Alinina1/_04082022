import customExeptions.ItemAlreadyPlacedExceptions;
import items.Apple;
import items.Brick;
import items.containers.Bag;
import items.containers.Stack;

public class Main {
    public static void main(String[] args) throws ItemAlreadyPlacedExceptions {
        try {
            Brick b = new Brick(100, 3, "Красный");
            System.out.println(b.toString());
        }
        catch (IllegalArgumentException e){
            e.printStackTrace();
        }
        Brick b2 = new Brick(200, 4, "Оранжевый");
        //System.out.println(b2.toString());

        Bag bag1 = new Bag(10, 100);
        Apple a1 = new Apple(100, 2, "Зеленый");
        Apple a2 = new Apple(200, 3, "Зеленый");
        Apple a3 = new Apple(30, 1, "Зеленый");
        bag1.addItem(a1);
        bag1.addItem(a2);
        bag1.addItem(a3);
        bag1.addItem(b2);
        bag1.putAwayItem(a1);
        bag1.addItem(a1);

        Stack stack = new Stack(10, 50);
        stack.addItem(b2);
        stack.addItem(a2);
        System.out.println( stack.getItemsString());
        stack.putAwayItem();
        System.out.println( stack.getItemsString());
        System.out.println("Общий вес внутри предмета " + stack.getName() + " = " + stack.getWeight() + " г.");

        System.out.println(bag1.getItemsString());
        System.out.println("Общий вес внутри предмета " + bag1.getName() + " = " + bag1.getWeight() + " г.");

        System.out.println(bag1.getItems());
    }
}
