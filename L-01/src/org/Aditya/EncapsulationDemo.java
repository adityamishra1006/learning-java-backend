package org.Aditya;

public class EncapsulationDemo {
    public static void main(String[] args) {
        Student s1 = new Student(1, "Aditya");
//        s1.regNum = 1;
//        s1.name = "Aditya";
        s1.setName("Aditya Mishra");
        s1.batch = "85";

        
//        System.out.println(s1.getRegNum()+" "+s1.getName());
        System.out.println(s1.toString());
        Student s2 = new Student(2, "Ayush");
//        s2.regNum = 2;
//        s2.name = "Ayush";

        System.out.println(s2);
//        Prints the same as above

    }
}
