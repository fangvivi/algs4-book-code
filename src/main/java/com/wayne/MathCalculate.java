package com.wayne;

/**
 * 一些数值计算的简单算法
 * @author wayne
 */
public class MathCalculate {

    private MathCalculate() {
    }

    /**
     * 计算一个整数的绝对值
     * @param x 需要计算的整数
     * @return 绝对值
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
     * @param x 需要计算的浮点数
     * @return 绝对值
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
     * @param n 需要判断的数
     * @return 是否为质数，是-true，否-false
     */
    public static boolean isPrime(int n){
        if(n < 2){
            return false;
        }
        // 如果n为合数，必定存在一个n的约数小于或者等于n的平方根 i<= Math.sqrt(N)
        for (int i = 2; i*i <= n; i++) {
        // for (int i = 2; i < n; i++) {
            if(n % i ==0 ){
                return false;
            }
        }
        return true;
    }

    /**
     * 计算平方根（牛顿迭代法）
     * @param c 需要进行开方的数字
     * @return 平方根
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

    /**
     * 计算指定范围的调和级数
     * @param n 范围
     * @return 调和级数
     */
    public static double H(int n) {
        double sum = 0.0;
        for (int i = 1; i <= n; i++) {
            sum += 1.0/i;
        }
        return sum;
    }


}
