package org.Aditya;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class SupplierDemo {
    public static void main(String[] args) {
        Supplier<List<Person>> supplyPersonList =  () ->{
            List<Person> personList = new ArrayList<>();
            personList.add(new Person("Aditya", 25));
            personList.add(new Person("Harshit", 15));
            return personList;
        };

        Supplier<Double> supplyRandomNumber = () -> Math.random();
        System.out.println(supplyRandomNumber.get()*100);


        System.out.println(supplyPersonList.get());



    }

}
