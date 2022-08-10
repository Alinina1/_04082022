package items;

import drawing.ItemsTypes;
import drawing.SVGWriter;
import items.Item;

import java.io.IOException;

public class Plate extends Item {
    static int count = 0;//Для названий объектов
    static final ItemsTypes itemType = ItemsTypes.SUBJECTS;

    public Plate(double weight, int size, String color, SVGWriter writer) throws IOException {
        super("Тарелка " + ++count, weight, size, Shape.FLAT, color);
        write(writer);
    }
    @Override
    public int getH(){
        return 5;
    }

    @Override
    public int getW(){
        return this.getSize()*20;
    }

    public void write(SVGWriter writer) throws IOException {
        writer.writeShape(writer.getRectString(),String.valueOf(writer.subjectsWeight), String.valueOf(writer.subjectHeight), String.valueOf(getW()),String.valueOf(getH()), getColor(), "BLACK");
        writer.subjectsWeight +=getW() + 10;
    }
}
