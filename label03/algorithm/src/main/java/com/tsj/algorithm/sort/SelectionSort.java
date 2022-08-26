package com.tsj.algorithm.sort;

import com.tsj.algorithm.util.CommonUtil;

/**
 * 选择排序
 *
 * @Author tansj
 * @Date 2022/8/26 16:17
 * @Version 1.0
 */
public class SelectionSort {

    public void selectionSort(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIdx = arr[j] < arr[minIdx] ? j : minIdx;
            }
            CommonUtil.swap(arr, i, minIdx);
        }
    }

}
