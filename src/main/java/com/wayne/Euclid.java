package com.wayne;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        int c = 12, d = 24;
        assertEquals(2,gcd(a,b));
        assertEquals(2,gcd(b,a));
        assertEquals(12,gcd(c,d));

    }
}
