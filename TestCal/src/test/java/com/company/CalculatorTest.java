package com.company;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    Calculator calculator = new Calculator();
    @Test
    public void testSum(){
        int resalt = calculator.add(12,20);
        assertEquals(resalt, 32);
    }

    @Test
    public void testDef(){
        int resalt = calculator.def(12,20);
        assertEquals(resalt, -8);
    }
    @Test
    public void testDivideByZero() {
        Assertions.assertThrows(MyExpectedByZero.class, ()-> calculator.divide(1,0));
    }

    @Test
    public void testDivide(){
        int resalt = calculator.divide(120,10);
        assertEquals(resalt, 12);
    }

    @Test
    public void testMultiple(){
        int resalt = calculator.multiple(12,20);
        assertEquals(resalt, 240);
    }
}
