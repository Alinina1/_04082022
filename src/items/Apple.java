package items;

import drawing.ItemsTypes;
import drawing.SVGWriter;

import java.io.IOException;

public class Apple extends Item {
    static int count = 0;//Для названий объектов

    public Apple(double weight, int size, String color) {
        super("Яблоко " + ++count, weight, size, Shape.CIRCLE, color);
    }

    @Override
    public int getH(){
        return this.getSize()* 10;
    }
    @Override
    public int getW(){
        return this.getSize()* 10;
    }

    @Override
    public void write(int x, int y, SVGWriter writer) throws IOException {
        x += this.getH()/2;
        y += this.getH()/2;
        writer.writeShape(writer.getCircleString(),String.valueOf(x), String.valueOf(y), String.valueOf(getH()/2), getColor(), "BLACK");
    }
}
