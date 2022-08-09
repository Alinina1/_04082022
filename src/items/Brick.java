package items;

import drawing.ItemsTypes;
import drawing.SVGWriter;

import java.io.IOException;

public class Brick extends Item{
    static int count = 0;//Для названий объектов
    static final ItemsTypes itemType = ItemsTypes.SUBJECTS;

    public Brick(double weight, int size, String color, SVGWriter writer) throws IOException {
        super(" Кирпич " + ++count, weight, size, Shape.RECTANGLE, color);
        write(writer);
    }
    public int getH(){
        return this.getSize() * 10;
    }

    public int getW(){
        return this.getSize() * 20;
    }

    public void write(SVGWriter writer) throws IOException {
        writer.writeShape(writer.getRectString(),String.valueOf(writer.subjectsWeight), String.valueOf(writer.subjectHeight), String.valueOf(getW()),String.valueOf(getH()), getColor(), "BLACK");
        writer.subjectsWeight +=getW() + 10;
    }
}
//7NsM2bbVgHP!JcL

