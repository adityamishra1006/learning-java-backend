package org.gfg;

public class Car {
    private String name;
    private Engine engine;

    public Car(){
        name = "Tata Nexon";
        engine = new Engine("Revetron", 1200);
    }

    public Car(String name, Engine engine) {
        this.name = name;
        this.engine = engine;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", engine=" + engine +
                '}';
    }
}
