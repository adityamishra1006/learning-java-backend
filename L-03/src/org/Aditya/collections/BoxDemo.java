package org.Aditya.collections;

import java.lang.reflect.Type;
import java.util.Vector;

public class BoxDemo {
    public static void main(String[] args) {
        Box box = new Box();
        box.put(1234);
        box.put("aascas");
        box.put(123);
        box.put(new Box());


        TypeSafeBox<String> tb1 = new TypeSafeBox<>();
        tb1.put("jsdida");


        TypeSafeBox<Integer> tb2 = new TypeSafeBox<>();
        tb2.put(1234);

        TypeSafeBox<Object> tb3 = new TypeSafeBox<>();
        tb3.put(123);
        tb3.put("kjasxa");
        tb3.put(new Box());
    }

//    this is not typesafe
}
