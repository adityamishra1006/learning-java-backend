package org.Aditya;

import java.util.function.Consumer;

public class ConsumerDemo {
    public static void main(String[] args) {
        Consumer<String> printLowerCase = (s) -> System.out.println(s.toLowerCase());
        Consumer<String> printLen = (s) -> System.out.println(s.length());

        printLowerCase.accept("HELLO WORLD!");
        printLowerCase.andThen(printLen).accept("HELLO WORLD!");

        printLen.andThen(printLowerCase).accept("HELLO WORLD!");


    }
}
