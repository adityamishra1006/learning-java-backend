package org.Aditya;

import java.util.function.Function;

public class FunctionDemo {
    public static void main(String[] args) {
        Function<Person, Student> register = (person -> {
            Student student = new Student(person.name, 10, "Computer Science");
            return student;
        });

        Person p1 = new Person("Aditya", 25);
//        Student student = register.apply(p1);

        Function<Student, IdCard> issudeCard = (student1 -> {
            IdCard idCard = new IdCard();
            return idCard;
        });

        IdCard card = register.andThen(issudeCard).apply(p1);
    }
}


class IdCard{

}

class Student{
    String name;
    int roll;
    String subject;

    public Student(String name, int roll, String subject) {
        this.name = name;
        this.roll = roll;
        this.subject = subject;
    }
}
