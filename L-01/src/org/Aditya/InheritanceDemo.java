package org.Aditya;

import com.payment.ClassMonitor;

public class InheritanceDemo {
    public static void main(String[] args) {
        Student s1 = new Student(123, "Aditya");
//        System.out.println(s1);

        Person p1 = new Person();
        p1.name = "Ayush";
//        System.out.println();
        s1.walk();
        s1.study();
        p1.walk();

        ClassMonitor cm1 = new ClassMonitor(12, "Harshit");
        cm1.walk();

        Person p2 = new Student(5, "Anmol ");
        p2.walk();
//        p2.study();
        Student s2 = (Student)p2;
        s2.study();

        RegVehicle rv1 = new Bike();
        processFastag(rv1);

        Car c1 = new Car();
        processFastag(c1);



        Student s3 = new Student(56, "Srishti ");
        Person p3 = (Person) s3;
        p3.walk();

    }

    static void processFastag(RegVehicle vehicle){
        String fastagData = vehicle.getFastagDetails();
    }
}


class RegVehicle{
    public String getFastagDetails(){
        return "";
    }
}

class Bike extends RegVehicle{

}

class Car extends RegVehicle{
    void drive4wheels(){

    }
}