package org.Aditya.exceptionDemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class OutputDemo {
    public static void main(String[] args) {
//        readFromFile();
        System.out.println(readFromFileReturnValue());
        System.out.println("Done");
    }

    private static void readFromFile() {
        FileReader fr = null;
        try {
            fr = new FileReader("/tmp/abc.txt");
//            fr = new FileReader("C:\\Users\\mishr\\Desktop\\JDBL-85-Coding-Own\\L-03\\abc.txt");
            int a = fr.read();
        } catch (FileNotFoundException e) {
            System.out.println("Getting file not found exception");
        } catch (IOException e) {
            System.out.println("Getting IO exception");
        }
        finally {
            System.out.println("Executing finally block");
        }
    }

    private static int readFromFileReturnValue() {
        FileReader fr = null;
        int a = 0;
        try {
//            fr = new FileReader("/tmp/abc.txt");
            fr = new FileReader("C:\\Users\\mishr\\Desktop\\JDBL-85-Coding-Own\\L-03\\abc.txt");
            try {
                a = fr.read();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return a;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Getting file not found exception");
        }
        finally {
            System.out.println("Executing finally block");
            return 10;
        }
//        return 1;
    }

    public void methodThrowsRuntimeException() throws FileNotFoundException {
        System.out.println("methodThrowsRuntimeException");
        throw new FileNotFoundException();
    }
}

//1:04
