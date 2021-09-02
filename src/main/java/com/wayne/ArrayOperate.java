package com.wayne;

/**
 * 一些数组元素的操作方法
 * @author wayne
 */
public class ArrayOperate {


    /**
     * 获取数组中最大的元素
     * @param arr 需要操作的数组
     * @return 数组中最大的元素最大的元素
     */
    public double getMax(double[] arr){
        double max = arr[0];
        for (int i = 1; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }

    /**
     * 计算数组的平均数
     * @param arr 需要操作的数组
     * @return 数组所有元素的平均数
     */
    public double getAvg(double[] arr){
        double sum = 0.0;
        int len = arr.length;
        for (double v : arr) {
            sum += v;
        }
        return sum / len;
    }

    /**
     * 复制一个数组
     * @param arr 需要复制的数组
     * @return 新复制的数组
     */
    public double[] copyArr(double[] arr){
        int len = arr.length;
        double[] copyArr = new double[len];
        for (int i = 0; i < len; i++) {
            copyArr[i] = arr[i];
        }
        return copyArr;
    }


    /**
     * 颠倒数组，把参数数组进行颠倒，颠倒完以后再把这个数组返回
     * @param arr 需要操作的数组
     * @return 颠倒完的数组
     */
    public double[] reverseArr(double[] arr){
        int len = arr.length;
        for (int i = 0; i < len/2; i++) {
            double temp = arr[i];
            arr[i] = arr[len-1-i];
            arr[len-1-i] = temp;
        }
        return arr;
    }

}
