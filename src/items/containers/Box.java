package items.containers;

import drawing.ItemsTypes;
import drawing.SVGWriter;
import items.Apple;
import items.Item;
import items.Shape;

import java.io.IOException;
import java.util.*;

public class Box extends Container {
    //final static String color = "Black";
    static int count = 0;

    public Box(double weight, int size, String color) {
        super("Коробка " + ++count, weight, size, Shape.RECTANGLE, color);
        items = new HashSet<>();
    }

    public void addItem(Item item){
        if(!item.isItemSomewhere){
            items.add(item);
            item.isItemSomewhere = true;
//            if(item.getShape().equals(Shape.CIRCLE)){
//                writer.writeShape(writer.getCircleString(), String.valueOf(boxW+item.getR()*2), String.valueOf(boxH+this.getH()-item.getR()*2), String.valueOf(item.getR()), item.getColor(), "BLACK");
//                System.out.println("boxH = " + boxH + ", boxW = " + boxW + "; circle: cx = " + (boxW+item.getR()*2) + ", cy = " + (boxH+this.getH()-item.getR()*2) + ", r = " + item.getR());
//                boxW += item.getW()+10;
//            }
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

//    @Override
//    public void write(int x, int y, SVGWriter writer) throws IOException {
//        int xx = x;
//        writer.writeShape(writer.getRectString(),String.valueOf(x), String.valueOf(y), String.valueOf(getW()),String.valueOf(getH()), getColor(), "BLACK");
//        xx += 2;
//        y -= 10;
//        int yy = -1;
//        for (Item itemsForWrite: items){
//            if(xx + itemsForWrite.getW() >= this.getW()){
//                xx = x;
//                y -= yy;
//            }
//            itemsForWrite.write(xx, y+this.getH()-itemsForWrite.getH(), writer);
//            xx += itemsForWrite.getW();
//            if(itemsForWrite.getH() > yy){
//                yy = itemsForWrite.getH();
//            }
//        }
//    }
    public void write(int x, int y, SVGWriter writer) throws IOException {
        //y += this.getH();
        int xx = x;
        writer.writeShape(writer.getRectString(),String.valueOf(x), String.valueOf(y), String.valueOf(getW()),String.valueOf(getH()), getColor(), "BLACK");

        xx += 2;
        int yy = -1;
        for (Item itemsForWrite: items){
            if(xx + itemsForWrite.getW() >= this.getW()){
                xx = x;
                y -= yy;
            }
            itemsForWrite.write(xx, y+this.getH()-itemsForWrite.getH(), writer);
            xx += itemsForWrite.getW();
            if(itemsForWrite.getH() > yy){
                yy = itemsForWrite.getH();
            }
        }
    }
}
