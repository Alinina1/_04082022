package items;

import drawing.ItemsTypes;
import drawing.SVGWriter;

import java.io.IOException;

public class Brick extends Item{
    static int count = 0;//Для названий объектов
    public Brick(double weight, int size, String color) {
        super(" Кирпич " + ++count, weight, size, Shape.RECTANGLE, color);
    }
    @Override
    public int getH(){
        return this.getSize() * 10;
    }

    @Override
    public int getW(){
        return this.getSize() * 20;
    }

    public void write(int x, int y, SVGWriter writer) throws IOException {
        writer.writeShape(writer.getRectString(),String.valueOf(x), String.valueOf(y), String.valueOf(getW()),String.valueOf(getH()), getColor(), "BLACK");
    }
}
//7NsM2bbVgHP!JcL

