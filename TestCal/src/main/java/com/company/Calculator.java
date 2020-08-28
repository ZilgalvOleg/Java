package com.company;


import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

public class Calculator {
    public int add(int a, int b) {
        int sum = a + b;
        logger.error();
        return sum;
    }

    public int def(int a, int b) {
        int def = a - b;
        return def;
    }

    public int divide(int a, int b) {
        if (b == 0) throw new MyExpectedByZero("Делить на 0 нельзя");
        return a / b;
    }

    public int multiple(int a, int b) {
        return a * b;
    }

    private static Logger logger = LoggerFactory.getLogger(Calculator.class);


}
