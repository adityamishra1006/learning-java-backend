package org.Aditya;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(2, 4, 5, 7, 8, 10));

        List<String> stringList = new ArrayList<>(Arrays.asList("abc", "def", "weer", "pop", "ert", "abc", "def", "weer", "pop", "ert", "abc", "def", "weer", "pop", "ert", "abc", "def", "weer", "pop", "ert", "abc", "def", "weer", "pop", "ert", "abc", "def", "weer", "pop", "ert"));

        for(String str : stringList){
            System.out.println(str + " " + str.length());
        }

        Consumer<String> printLen = (str) -> { System.out.println(str + " : " + str.length());
            System.out.println(Thread.currentThread().getName());
        };
        stringList.forEach(printLen);

        Predicate<Integer> checkEven = (x) -> x%2==0;
        Function<Integer, Integer> sqFunc = (x) -> x*x;

        long evenCount = list.stream().filter((n)-> n%2==0).count();
        System.out.println("Even Count: "+evenCount);

        List<Integer> even = list.stream().filter((n)-> n%2==0).toList();
        System.out.println(even);

        Stream<Integer> integerStream = list.stream().filter(checkEven).map(sqFunc);

//        List<Integer> evenSq = list.stream().filter(checkEven).map(sqFunc).toList();
        List<Integer> evenSq = integerStream.toList();
        System.out.println(evenSq);


        stringList.parallelStream().forEach((printLen));
    }
}

//1:37
