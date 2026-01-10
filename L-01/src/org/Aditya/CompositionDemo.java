package org.Aditya;

public class CompositionDemo {
    public static void main(String[] args) {
        Laptop l1 = new Laptop();
        System.out.println(l1);

        OS os = new OS("Ubuntu");
        Keyboard k1 = new Keyboard();

        Laptop l2 = new Laptop("HP Pavillion", os, k1);
        System.out.println(l2);

        OS os2 = new OS("Mac OS X");
        Keyboard k2 = new Keyboard();

        Laptop l3 = new Laptop("Dell Model2", os2, k2);
        System.out.println(l3);
    }
}
