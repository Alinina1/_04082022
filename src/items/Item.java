package items;

public class Item {
    private final String name;
    private final double weight;
    private final int size;
    private final Shape shape;
    private final String color;

    public boolean isItemSomewhere = false;

    public Item (String name, double weigh, int size, Shape shape, String color){
        if(weigh <= 0){
            throw new IllegalArgumentException("Вес не может быть меньше 0");
        }
        if(!(name.contains("Мешок") || name.contains("Коробка") || name.contains("Стопка"))&& (size <= 0 || size > 5)){
            throw new IllegalArgumentException("Неверное значение размера! (Размер - целое число от 1 до 5)");
        }
        else if(size <= 0 || size >1000){
            throw new IllegalArgumentException("Неверное значение размера! (Размер контейнера не может быть больше 1000)");
        }
        if(color == null || color.equals("")){
            throw new IllegalArgumentException("Неверное значение цвета!");
        }
        this.name = name;
        this.weight = weigh;
        this.size = size;
        this.shape = shape;
        this.color = color;
    }

    public String  getName(){
        return this.name;
    }

    public double getWeight() {
        return weight;
    }

    public int getSize() {
        return size;
    }

    public Shape getShape() {
        return shape;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "\n" + this.color + " " + this.name + " " + this.weight + " г. (размер: " + this.size + ", форма: " + this.shape.name() + ")\n";
        //return "\nПредмет - " + this.name + "\nСвойства:\n- Вес: " + this.weight + " г.\n- Размер: " + this.size + "\n- Форма: " + this.shape + "\n- Цвет: " + this.color + "\n";
    }
}

