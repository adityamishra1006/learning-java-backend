package org.Aditya.exceptionDemo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErrorDemo {
    public static void main(String[] args) {
        System.out.println("Executing Main Method");
//        normalMethod();
            heapOutOfMemoryDemo();
    }

//    StackOVerflow
    private static void normalMethod() {
        System.out.println("Executing Normal Method");
        normalMethod();;
    }


//    HeapOutOfMemoryError
    private static void heapOutOfMemoryDemo(){
        List<Date> dates = new ArrayList<Date>();
        while(true){
            Date date = new Date();
            dates.add(date);
        }
    }
}
