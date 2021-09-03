package com.wayne;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathCalculateTest {

    @Test
    void abs() {
        assertEquals(9,MathCalculate.abs(-9),"-9的绝对值");
    }

    @Test
    void testAbs() {
        assertEquals(2.5,MathCalculate.abs(2.5d),"2.5的绝对值");
    }

    @Test
    void isPrime() {
        assertTrue(MathCalculate.isPrime(7),"7是质数");
        assertFalse(MathCalculate.isPrime(6),"6不是质数");
    }

    @Test
    void sqrt() {
    }
}