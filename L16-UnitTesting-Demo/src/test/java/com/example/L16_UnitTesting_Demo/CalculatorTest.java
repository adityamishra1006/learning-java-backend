package com.example.L16_UnitTesting_Demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {

    private Calculator calc;

    @BeforeEach
    public void setup(){
        calc = new Calculator();
    }

    @Test
    public void testAddPositiveNum(){
        Integer a = 8;
        Integer b = 3;
        Integer expected = a+b;
        assertThat(calc.add(a,b)).isEqualTo(expected); 
    }


    @Test
    public void testAddNegativeNum(){
        Integer a = -4;
        Integer b = -3;
        Integer expected = a+b;
        assertThat(calc.add(a,b)).isEqualTo(expected);
    }


    @Test
    public void testMultiplyPositiveNum(){
        Integer a = 8;
        Integer b = 3;
        Integer expected = a*b;
        assertThat(calc.multiply(a,b)).isEqualTo(expected);
    }




//    public static void main(String[] args) {
//        Calculator calc = new Calculator();
//
//        Integer a = 8;
//        Integer b = 3;
//
//        if(calc.add(a, b) != (a+b)){
//            System.out.println("Test Failed");
//        } else{
//            System.out.println("Add Test Passed");
//        }
//
//        if(calc.multiply(a, b) != (a*b)){
//            System.out.println("Test Failed");
//        }
//        else{
//            System.out.println("Multiply Test Passed");
//        }
//
//    }
}
