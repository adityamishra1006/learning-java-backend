package org.Aditya;

import java.security.Key;

public class Laptop {
    private String name;
    private OS os;

    private Keyboard keyboard;

    public Laptop(){
        this.name = "ASUS Notebook 15";
        this.os = new OS("Windows");
        this.keyboard = new Keyboard();

    }


    public Laptop(String name, OS os, Keyboard keyboard) {
        this.name = name;
        this.os = os;
        this.keyboard = keyboard;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "name='" + name + '\'' +
                ", os=" + os +
                ", keyboard=" + keyboard +
                '}';
    }
}
