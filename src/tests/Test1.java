package tests;

import items.Apple;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test1 {
    @Test
    void test1 (){
        Apple a = new Apple(10, 2, "Green");
        assertEquals("Яблоко", a.getName());
    }
}
