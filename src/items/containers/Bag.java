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
    public int getW(){
        return this.getSize()* 40;
    }

    @Override
    public int getH(){
        return this.getSize()* 50;
    }

    @Override
    public void write(int x, int y, SVGWriter writer) throws IOException {
        int xx = x;
        writer.writeShape(writer.getEllipseString(),String.valueOf(x+this.getW()), String.valueOf(y),String.valueOf(getW()), String.valueOf(getH()), getColor(), "BLACK");
        int yy = -1;
        for (Item itemsForWrite: items){
            int xxx = (int) Math.round(this.getW()*Math.sqrt(1-(double) y*y/(double)(this.getH()*this.getH())));
            if(xxx + itemsForWrite.getW() >= this.getW()){
                xx = x;
                y -= yy;
            }
            itemsForWrite.write(xxx, y+this.getH()-itemsForWrite.getH(), writer);
            xx -=itemsForWrite.getW();
            if(itemsForWrite.getH() > yy){
                yy = itemsForWrite.getH();
            }
        }
    }
}
