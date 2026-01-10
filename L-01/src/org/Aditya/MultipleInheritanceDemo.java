package org.Aditya;

public class MultipleInheritanceDemo {
    public static void main(String[] args) {
        C c = new C();
        c.method1();
    }
}

class A{
    public void method1(){
        System.out.println("A.method1");
    }
}

class B extends A{
    public void method1(){
        System.out.println("B.method1");
    }
}

class D extends B{
    public void method1(){
        System.out.println("D.method1");
//        super.method1();
        super.toString();
    }
}

class C extends B{

}
