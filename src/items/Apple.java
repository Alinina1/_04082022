package items;

import drawing.ItemsTypes;
import drawing.SVGWriter;

import java.io.IOException;

public class Apple extends Item {
    static int count = 0;//Для названий объектов
    static final ItemsTypes itemType = ItemsTypes.SUBJECTS;

    public Apple(double weight, int size, String color, SVGWriter svgWriter) throws IOException {
        super("Яблоко " + ++count, weight, size, Shape.CIRCLE, color);
        write(svgWriter);
    }

    public int getR(){
        return this.getSize()* 10;
    }

    public void write(SVGWriter writer) throws IOException {
        writer.writeShape(writer.getCircleString(),String.valueOf(writer.subjectsWeight+getR()), String.valueOf(writer.subjectHeight), String.valueOf(getR()), getColor(), "BLACK");
        writer.subjectsWeight +=getR()*2 + 10;
    }
}
