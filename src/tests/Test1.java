package tests;

import customExeptions.ItemAlreadyPlacedExceptions;
import drawing.SVGWriter;
import items.Apple;
import items.Brick;
import items.Plate;
import items.containers.Bag;
import items.containers.Box;
import items.containers.Stack;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.PosixFileAttributes;
import java.util.*;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Test1 {
        //    Apple apple1 = new Apple(10, 2, "Green");
//    Apple apple2 = new Apple(20, 3, "Red");
//    Apple apple3 = new Apple(20, 3, "Yellow");
//    Brick brick1 = new Brick(50, 3, "Red");
//    Plate plate1 = new Plate(20,2, "White");
//
//    Bag bag1 = new Bag(5, 100);
//    Stack stack1 = new Stack(1, 50);
//    Box box1 = new Box(10, 300);
//    @Test
//    void test1 () throws ItemAlreadyPlacedExceptions {
//        bag1.addItem(apple1);
//        bag1.addItem(apple2);
//        System.out.println(bag1.getItemsString());
//        assertEquals(35, bag1.getWeight()); //Apple1 10, apple2 20, bag1 5
//    }
//    @Test
//    void test2(){
//        box1.addItem(plate1);
//        assertThrows(IllegalArgumentException.class,()->{ //Нельзя добавить один и тот же предмет 2 раза
//            box1.addItem(plate1);
//        } );
//        assertThrows(ItemAlreadyPlacedExceptions.class,()->{ //Нельзя добавить один и тот же предмет в 2 разных места
//            bag1.addItem(plate1);
//        } );
//        System.out.println(box1.getItemsString());
//    }
//
//    @Test
//    void test3(){
//        stack1.addItem(apple1);
//        //stack1.addItem(apple2);
//       assertThrows(IllegalArgumentException.class,()->{ //В стопку после круглого предмета ничего нельзя положить
//           stack1.addItem(apple2);
//       });
//        System.out.println(stack1.getItemsString());
//    }
//
//    @Test
//    void test4() throws ItemAlreadyPlacedExceptions {
//        bag1.addItem(apple1);
//        Bag bag2 = new Bag(30, 100);
//        bag2.addItem(apple2);
//        bag2.addItem(bag1);
//        System.out.println(bag2.getItemsString());
//        System.out.println("Bag1 weight = " + bag1.getWeight());
//        System.out.println("Bag2 weight = " + bag2.getWeight());
//
//        stack1.addItem(bag2);
//        System.out.println(stack1.getItemsString());
//    }
    @Test
    void createSVGFileTest() throws IOException, ItemAlreadyPlacedExceptions {
        SVGWriter svgWriter = new SVGWriter("test.svg");
        int x = 10, y = 300;
        Apple apple1 = new Apple(10, 2, "Green");
        Apple apple2 = new Apple(20, 3, "Red");
        Apple apple3 = new Apple(20, 3, "Yellow");
        Brick b1 = new Brick(50, 5, "Red");
        Brick b2 = new Brick(50, 3, "Yellow");
        Plate p1 = new Plate(50, 3, "White");
        Brick b3 = new Brick(50, 5, "tomato");
        Brick b4 = new Brick(50, 5, "purple");
        Apple apple4 = new Apple(20, 4, "plum");
        Apple apple5 = new Apple(10, 2, "white");
        Apple apple6 = new Apple(10, 2, "fuchsia");


        Bag bag1 = new Bag(10, 4);
        Apple apple7 = new Apple(10, 5, "white");
        Apple apple8 = new Apple(10, 3, "fuchsia");
        Brick b5 = new Brick(50, 5, "Red");
        Brick b6 = new Brick(50, 2, "fuchsia");
        Brick b7 = new Brick(50, 4, "salmon");
        bag1.addItem(apple7);
        bag1.addItem(apple8);
        bag1.addItem(b5);
        bag1.addItem(b6);
        bag1.addItem(b7);
        bag1.write(x, y, svgWriter);

        Box box2 = new Box(10, 4,"salmon");
        box2.addItem(apple5);
        Box box3 = new Box(10, 5,"salmon");
        box3.addItem(apple2);

        Stack stack1 = new Stack(10, 10);
        Brick b8 = new Brick(50, 5, "Red");
        Brick b9 = new Brick(50, 4, "fuchsia");
        Brick b10 = new Brick(50, 4, "salmon");
        Apple apple9 = new Apple(10, 3, "fuchsia");
        Plate plate1 = new Plate(10, 3, "salmon");
        stack1.addItem(box3);
        stack1.addItem(b8);
        stack1.addItem(b9);
        stack1.addItem(b10);
        stack1.addItem(plate1);
        stack1.addItem(apple9);
        //stack1.write(x,y+300,svgWriter);


        Box box1 = new Box(10, 10, "thistle");
        box1.addItem(b1);
        box1.addItem(b2);
        box1.addItem(apple1);
        box1.addItem(apple3);
        box1.addItem(p1);
        box1.addItem(b3);
        box1.addItem(b4);
        box1.addItem(apple4);
        box1.addItem(box2);
        box1.addItem(apple6);
        //.write(x, y, svgWriter);

        svgWriter.writeFooter();
    }


    @Test
    void regexTest() throws IOException {
        StringBuilder rectWriteString = new StringBuilder("<rect x=\"?\" y=\"?\" width=\"?\" height=\"?\" style=\"fill:?;stroke:?\"/>");
        Pattern pattern = Pattern.compile("[?]");
        Matcher matcher = pattern.matcher(rectWriteString);
        while (matcher.find()) {
            //System.out.println(matcher.start());
            rectWriteString.deleteCharAt(matcher.start());
            rectWriteString.insert(matcher.start(), "10");
        }
    }

    @Test
    void threadTest()  {
        for(int i = 0; i < 1000000; i++){
            new Thread().start();
        }
    }

    @Test
    void testtt() throws IOException{
        WatchService watchService = Paths.get("").getFileSystem().newWatchService();
        Paths.get("").register(watchService, ENTRY_MOFIFY);
    }
}
