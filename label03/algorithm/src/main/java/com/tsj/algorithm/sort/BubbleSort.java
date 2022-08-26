package com.tsj.algorithm.sort;

import com.tsj.algorithm.util.CommonUtil;

/**
 * 冒泡排序
 *
 * @Author tansj
 * @Date 2022/8/26 16:28
 * @Version 1.0
 */
public class BubbleSort {

    public void bubbleSort(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] > arr[j - 1]) {
                    CommonUtil.swap(arr, j, j - 1);
                }
            }
        }
    }

}
