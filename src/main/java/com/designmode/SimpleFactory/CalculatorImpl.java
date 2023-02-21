package com.designmode.SimpleFactory;

/**
 * @Author wanglz
 * @create 2022/3/5 16:14
 */
public class CalculatorImpl implements Calculator{

    @Override
    public Double addition(Double a, Double b) {

        return a + b;
    }

    @Override
    public Double subtraction(Double a, Double b) {

        return a - b;
    }

    @Override
    public Double multiplication(Double a, Double b) {

        return a * b;
    }

    @Override
    public Double division(Double a, Double b) {
        if (0 == b) {
            return 0D;
        }
        return a / b;
    }
}
