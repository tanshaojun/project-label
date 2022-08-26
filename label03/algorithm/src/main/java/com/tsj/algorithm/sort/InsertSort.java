package com.tsj.algorithm.sort;

import com.tsj.algorithm.util.CommonUtil;

/**
 * 插入排序
 *
 * @Author tansj
 * @Date 2022/8/26 16:44
 * @Version 1.0
 */
public class InsertSort {

    public void insertSort(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                CommonUtil.swap(arr, j, j - 1);
            }
        }
    }

}
