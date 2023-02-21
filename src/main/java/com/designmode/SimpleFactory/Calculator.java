package com.designmode.SimpleFactory;

/**
 * @Author wanglz
 * @create 2022/3/5 16:12
 */
public interface Calculator {

    /**
     * 加法
     * @param a
     * @param b
     * @return
     */
    Double addition(Double a, Double b);

    /**
     * 加法
     * @param a
     * @param b
     * @return
     */
    Double subtraction(Double a, Double b);

    /**
     * 加法
     * @param a
     * @param b
     * @return
     */
    Double multiplication(Double a, Double b);

    /**
     * 加法
     * @param a
     * @param b
     * @return
     */
    Double division(Double a, Double b);
}


