package items;

import drawing.ItemsTypes;
import drawing.SVGWriter;
import items.Item;

import java.io.IOException;

public class Plate extends Item {
    static int count = 0;//Для названий объектов
    static final ItemsTypes itemType = ItemsTypes.SUBJECTS;

    public Plate(double weight, int size, String color){
        super("Тарелка " + ++count, weight, size, Shape.FLAT, color);
    }
    @Override
    public int getH(){
        return 5;
    }

    @Override
    public int getW(){
        return this.getSize()*20;
    }

    public void write(int x, int y, SVGWriter writer) throws IOException {

        writer.writeShape(writer.getRectString(),String.valueOf(x), String.valueOf(y), String.valueOf(getW()),String.valueOf(getH()), getColor(), "BLACK");
    }
}
