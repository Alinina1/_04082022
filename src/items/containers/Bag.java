package items.containers;

import drawing.ItemsTypes;
import drawing.SVGWriter;
import items.Item;
import items.Shape;

import java.io.IOException;
import java.util.*;

public class Bag extends Container {
    final static String color = "Gray";
    static int count = 0;

    public Bag(double weight, int size) {
        super("Мешок " + ++count, weight, size, Shape.CIRCLE, color);
        items = new HashSet<>();
    }
    public String getItemsString() {
        String s = "В мешке лежат: ";
        for(Item item : items){
            s += item.getName() + ", ";
        }
        return s.substring(0, s.length()-2);

    }
    @Override
    public int getRX(){
        return this.getSize()* 40;
    }

    @Override
    public int getRY(){
        return this.getSize()* 50;
    }

    @Override
    public void write(int x, int y, SVGWriter writer) throws IOException {
        writer.writeShape(writer.getEllipseString(),String.valueOf(writer.containersWeight+getRX()), String.valueOf(writer.containersWeight-getRY()),String.valueOf(getRX()), String.valueOf(getRY()), getColor(), "BLACK");
        writer.subjectsWeight +=getRX()*2 + 10;
        for (Item itemsForWrite: items){
            itemsForWrite.write(x, y, writer);
        }
    }
}
