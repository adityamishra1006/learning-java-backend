package org.Aditya;
import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {
        Predicate<Integer> checkEven = (num) -> num%2 ==0;
        Predicate<Integer> checkOdd = (num) -> num%2 ==1;

        Predicate<Integer> divisibleBy3 = (num) -> num%3 == 0;

        Predicate<Integer> divisibleBy6 = checkEven.and(divisibleBy3);


        Integer num = 18;
        System.out.println(checkEven.test(num));



        System.out.println("Divisible by 6: "+divisibleBy6.test(num));
        System.out.println("Not divisible by 6: "+divisibleBy6.negate().test(num));


        Predicate<Person> checkAge = (person) -> person.age > 20;
        Person p1 = new Person("Aditya", 25);
        Person p2 = new Person("Mishra", 15);
        System.out.println(checkAge.test(p1));
        System.out.println(checkAge.test(p2));
    }
}
