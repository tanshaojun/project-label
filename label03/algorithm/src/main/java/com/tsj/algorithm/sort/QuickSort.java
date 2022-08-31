package com.tsj.algorithm.sort;

import com.tsj.algorithm.util.CommonUtil;

/**
 * 快速排序
 *
 * @Author tansj
 * @Date 2022/8/31 13:39
 * @Version 1.0
 */
public class QuickSort {

    public void quickSort(int[] arr) {
        process(arr, 0, arr.length - 1);

    }

    public void process(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int[] t = partition(arr, left, right);
        process(arr, left, t[0] - 1);
        process(arr, t[1] + 1, right);
    }


    private int[] partition(int[] arr, int left, int right) {
        int mid = left + ((right - left) >> 1);
        int L = left - 1;
        int R = right;
        int index = left;
        while (index <= R) {
            if (arr[index] < arr[mid]) {
                CommonUtil.swap(arr, index++, ++L);
            } else if (arr[index] > arr[mid]) {
                CommonUtil.swap(arr, index, R--);
            } else {
                index++;
            }
        }
        return new int[]{L + 1, R};
    }

}
