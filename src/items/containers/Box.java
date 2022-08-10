package items.containers;

import drawing.ItemsTypes;
import drawing.SVGWriter;
import items.Apple;
import items.Item;
import items.Shape;

import java.io.IOException;
import java.util.*;

public class Box extends Container {
    final static String color = "Black";
    static int count = 0;
    static final ItemsTypes itemType = ItemsTypes.CONTAINERS;
    private final SVGWriter writer;
    private int boxW = -1;
    private int boxH = -1;

    public Box(double weight, int size, SVGWriter writer) throws IOException {
        super("Коробка " + ++count, weight, size, Shape.RECTANGLE, color);
        items = new HashSet<>();
        write(writer);
        this.writer = writer;
    }

    public void addItem(Item item) throws IOException {
        if(!item.isItemSomewhere){
            items.add(item);
            item.isItemSomewhere = true;
            if(item.getShape().equals(Shape.CIRCLE)){
                writer.writeShape(writer.getCircleString(), String.valueOf(boxW+item.getR()*2), String.valueOf(boxH+this.getH()-item.getR()*2), String.valueOf(item.getR()), item.getColor(), "BLACK");
                boxW += item.getW()+10;
            }
        }
        else {
            throw new IllegalArgumentException("Этот предмет уже лежит в другом месте!");
        }
    }

    public String getItemsString() {
        String s = "В коробке лежат: ";
        for(Item item : items){
            s += item.getName() + ", ";
        }
        return s.substring(0, s.length()-2);
    }

    @Override
    public int getH(){
        return this.getSize() * 30;
    }

    @Override
    public int getW(){
        return this.getSize() * 50;
    }

    public void write(SVGWriter writer) throws IOException {
        boxW = writer.containersWeight;
        boxH = writer.containersHeight;
        writer.writeShape(writer.getRectString(),String.valueOf(boxW), String.valueOf(boxH), String.valueOf(getW()),String.valueOf(getH()), getColor(), "BLACK");
        writer.containersWeight +=getW() + 10;

    }
}
