package com.payment;

import org.Aditya.Student;

public class ClassMonitor extends Student {
    public ClassMonitor(Integer regNum, String name) {
        super(regNum, name);
    }

    public void monitorclass(){

    }

    @Override
    public void walk(){
        System.out.println("Class Monitor " + super.getName() + " is walking with certificate "+certificate);
        super.walk();
    }
}
