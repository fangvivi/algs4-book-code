package com.wayne;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 一些数值计算的简单算法
 * @author wayne
 */
public class MathCalculate {
    /**
     * 计算一个整数的绝对值
     * @param x
     * @return
     */
    public static int abs(int x){
        if(x >= 0){
            return x;
        } else {
            return -x;
        }
    }

    /**
     * 计算一个浮点数的绝对值
     * @param x
     * @return
     */
    public static double abs(double x){
        if(x < 0.0){
            return -x;
        } else {
            return x;
        }
    }

    /**
     * 判断一个数是否为素数
     * 素数：大于1，只能被1和本身整除
     * @param N
     * @return
     */
    public static boolean isPrime(int N){
        if(N < 2){
            return false;
        }
        // 如果N为合数，必定存在一个值小于或者等于N的平方根 i<= Math.sqrt(N)
        for (int i = 2; i*i <= N; i++) {
        // for (int i = 2; i < N; i++) {
            if(N % i ==0 ){
                return false;
            }
        }
        return true;
    }

    /**
     * 计算平方根（牛顿迭代法）
     * @param c
     * @return
     */
    public static double sqrt(double c)
    {
        if (c < 0) {
            return Double.NaN;
        }
        double err = 1e-15;
        double t = c;
        while (Math.abs(t - c/t) > err * t) {
            t = (c/t + t) / 2.0;
        }
        return t;
    }

    @Test
    public void isPrimeTest(){
        int a = 10;
        int b = 5;
        int c = 1;

        assertEquals(true,isPrime(b));
        assertEquals(false,isPrime(a));
        assertEquals(false,isPrime(c));
    }

    @Test
    public void absTest(){
        int a = 10;
        double b = -5.5;
        int c = -6;
        assertEquals(10,abs(a));
        assertEquals(5.5,abs(b));
        assertEquals(6,abs(c));
    }

    @Test
    public void sqrtTest(){
        double sqrt = sqrt(7);
        System.out.println(sqrt);
    }

}
