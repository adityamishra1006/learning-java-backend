package org.gfg;

public class DIDemo {
    public static void main(String[] args) {
        Car c1 = new Car();
        Car c2 = new Car();

        System.out.println("c1 = " + c1);
        System.out.println("c2 = " + c2);

        Engine engine = new Engine("Revetron", 1200);
        Car c3 = new Car("Tata Punch", engine); // Constructor based Dependency Injection
        // c3 is dependent on engine object
        System.out.println("c3 = " + c3);

        Car c4 = new Car("Suzuki Fronks", engine);
        System.out.println("c4 = " + c4);

        c2.setName("BMW");
        c2.setEngine(new Engine("BMW Engine", 2000)); // Setter based Dependency Injection
        System.out.println("c2 = " + c2);
    }
}
