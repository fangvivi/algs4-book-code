package com.wayne;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EuclidTest {

    @Test
    void gcd() {
        Euclid euclid = new Euclid();
        int a = 16, b = 14;
        int c = 12, d = 24;
        int e = -12, f = -24;
        assertEquals(2,euclid.gcd(a,b));
        assertEquals(2,euclid.gcd(b,a));
        assertEquals(12,euclid.gcd(c,d));
        assertEquals(-12,euclid.gcd(e,f));
    }
}