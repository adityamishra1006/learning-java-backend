package org.Aditya;

public class FunctionalInterface {
    public static void main(String[] args) {
        Check<Integer> checkEven = (num) -> num%2 ==0;
        Check<Integer> checkOdd = (num) -> num%2 ==1;

        Integer num = 10;
        System.out.println(checkEven.check(num));
        System.out.println(checkOdd.check(num));


        Check<Person> checkAge = (person) -> person.age > 20;

    }
}

interface Check<T>{
    boolean check(T t);
}

class Person{

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    String name;
    int age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}


