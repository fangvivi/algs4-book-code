package com.wayne;

import org.junit.jupiter.api.Test;

/**
 * 欧几里得算法，求两个非负整数的最大公约数
 * @author wayne
 */
public class Euclid {
    public int gcd(int a, int b){
        if(b == 0 ){
            return a;
        }
        int r = a % b;
        return gcd(b, r);
    }
    @Test
    public void testGcd(){
        int a = 16, b = 14;
        System.out.println(gcd(b, a));

    }
}
