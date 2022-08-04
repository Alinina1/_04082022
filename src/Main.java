import items.Apple;
import items.Brick;
import items.containers.Bag;

public class Main {
    public static void main(String[] args) {
        try {
            Brick b = new Brick(100, 3, "Green");
            //System.out.println(b.toString());
        }
        catch (IllegalArgumentException e){
            e.printStackTrace();
        }

        Brick b2 = new Brick(200, 4, "Red");
        //System.out.println(b2.toString());


        Bag bag1 = new Bag(10, 100);
        Apple a1 = new Apple(100, 2, "Green");
        Apple a2 = new Apple(200, 3, "Green");
        Apple a3 = new Apple(30, 1, "Green");
        bag1.addItem(a1);
        bag1.addItem(a2);
        bag1.addItem(a3);

        System.out.println(bag1.getItems());
        System.out.println("Общий вес внутри предмета " + bag1.getName() + " = " + bag1.getWeight() + " г.");
       // System.out.println(bag1.toString());
    }
}
