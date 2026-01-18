package org.Aditya.collections;

public class Box {
    private Object obj;

    public void put(Object obj) {
        this.obj = obj;
    }
    public Object get(){
        return obj;
    }
}
