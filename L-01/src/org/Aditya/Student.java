package org.Aditya;

public class Student extends Person {
    private Integer regNum;
//    private String name;
    String batch;
    protected  String certificate;

    public Student(Integer regNum, String name) {
        this.regNum = regNum;
        this.name = name;
    }

    public Integer getRegNum() {
        return regNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void study(){
        System.out.println(name + "is studying");
    }

    @Override
    public String toString() {
        return "Student{" +
                "regNum=" + regNum +
                ", batch='" + batch + '\'' +
                ", certificate='" + certificate + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public void walk(){
        System.out.println("Student "+name+" is walking.");
    }
}
