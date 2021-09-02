package com.wayne;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayOperateTest {

    ArrayOperate arrayOperate = null;
    @BeforeEach
    void setUp() {
        arrayOperate = new ArrayOperate();
    }

    @Test
    void getMax() {
        double[] arrA = {3.0, 5.0, 8.0, 9.0, 19.0, 20.0};
        double[] arrB = {2, 2.2, 8.8, 20.6};
        assertEquals(20.0, arrayOperate.getMax(arrA));
        assertEquals(20.6, arrayOperate.getMax(arrB),"取最大的值");
    }

    @Test
    void getAvg() {
        double[] arr = {2,4,8,10,14};
        assertEquals(7.6, arrayOperate.getAvg(arr));
    }

    @Test
    void copyArr() {
        double[] arr = {2,4,8,10,14};
        double[] copyArr = arrayOperate.copyArr(arr);
        // 两个数组长度应该一样
        assertEquals(arr.length,copyArr.length);
        for (int i = 0; i < arr.length-1; i++) {
            // 数组中的元素应该都相等
            assertEquals(copyArr[i],arr[i]);
        }

    }

    @Test
    void reverseArr() {
        double[] arr = {2,4,8,10,14};
        double[] reverseArr = arrayOperate.reverseArr(arr);
        // 两个数组长度应该一样
        assertEquals(arr.length,reverseArr.length);
        for (int i = 0; i < arr.length-1; i++) {
            // 数组中的元素应该都相等
            assertEquals(reverseArr[i], arr[i]);
        }
    }
}