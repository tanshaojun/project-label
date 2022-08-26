package com.tsj.algorithm.util;

/**
 * @Author tansj
 * @Date 2022/8/26 16:42
 * @Version 1.0
 */
public class CommonUtil {

    /**
     * 交换
     *
     * @param arr
     * @param j
     * @param i
     */
    public static void swap(int[] arr, int j, int i) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

    /**
     * 随机数组生成
     *
     * @param maxSize
     * @param maxValue
     * @return
     */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) (Math.random() * (maxSize + 1))];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (maxValue + 1)) - (int) (Math.random() * maxValue);
        }
        return arr;
    }

}
