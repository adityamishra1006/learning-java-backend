package org.Aditya.exceptionDemo;

import java.io.*;
import java.util.Scanner;

public class ExceptionDemo {
    public static void main(String[] args) {
        System.out.println("Starting....");
        System.out.println("Executing 1....");

        System.out.println("Enter your name: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();

//        if(name.length() > 5){
//            System.out.println(name.charAt(5));
//        }


//        Using try catch block
        try{
            System.out.println(name.charAt(5));
        } catch(Exception e){
            System.out.println(e.getMessage());
        }


        System.out.println("Executing 2....");
        System.out.println("Executing 3....");
        System.out.println("Exiting....");

        readFromFile();
        try {
            readFromFile2();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void readFromFile(){
        FileReader fr = null;
        try {
            fr = new FileReader("/tmp/abc.txt");
            int a = fr.read();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        finally{
            if(fr != null){
                try {
                    fr.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        try(FileReader fr2 = new FileReader("/tmp/abc.txt")){
//            fr2 = new FileReader("/tmp/abc.txt");
            int a = fr2.read();
        }
        catch (FileNotFoundException e){
            throw new RuntimeException(e.getMessage());
        }
        catch (IOException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    private static void readFromFile2() throws IOException {
        FileReader fr = null;
        fr = new FileReader("/tmp/abc.txt");
        int a = fr.read();
    }
}

//42:00
