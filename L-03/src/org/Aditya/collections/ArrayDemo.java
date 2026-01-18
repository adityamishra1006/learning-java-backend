package org.Aditya.collections;

import java.util.ArrayList;
import java.util.List;

public class ArrayDemo {
    public static void main(String[] args) {
//        arrayDemo();
        collectionDemo();
    }

    private static void collectionDemo(){
        List<String> list = new ArrayList<String>();
        list.add("Aditya");
        list.add("Alex");
        list.add("Bob");
        System.out.println(list);
    }

    private static void arrayDemo(){
        String[] students = new String[2];
        students[0] = "Aditya";
        students[1] = "Ayush";
        System.out.println(students);
        printarray(students);

        System.out.println();

        String[] temp = new String[3];
        for(int i = 0; i<students.length; i++){
            temp[i] = students[i];
        }
        temp[2] = "Harshit";
        students = temp;
        printarray(students);
    }

    private static void printarray(String[] students) {
        for(String student : students){
            System.out.print(student+" ");
        }
    }
}
