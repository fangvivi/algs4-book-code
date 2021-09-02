package com.wayne;

/**
 * 欧几里得算法，求两个非负整数的最大公约数
 * @author wayne
 */
public class Euclid {

    /**
     * 计算两个整数的最大公约数
     * @param a 整数a
     * @param b 整数b
     * @return 两个整数的最大公约数
     */
    public int gcd(int a, int b){
        if(b == 0 ){
            return a;
        }
        int r = a % b;
        return gcd(b, r);
    }
}
