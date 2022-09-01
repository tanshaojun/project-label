package com.tsj.algorithm.sort;

import com.tsj.algorithm.util.CommonUtil;

/**
 * 堆排序
 *
 * @Author tansj
 * @Date 2022/9/1 16:12
 * @Version 1.0
 */
public class HeapSort {


    public void heapSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            heapInsert(arr, i);
        }
        CommonUtil.swap(arr, 0, --len);
        while (len > 0) {
            heapify(arr, 0, len);
            CommonUtil.swap(arr, 0, --len);
        }
    }

    private void heapInsert(int[] arr, int idx) {
        while (arr[idx] > arr[(idx - 1) / 2]) {
            CommonUtil.swap(arr, (idx - 1) / 2, idx);
            idx = (idx - 1) / 2;
        }
    }

    private void heapify(int[] arr, int idx, int size) {
        int leftIdx = 2 * idx + 1;
        while (leftIdx < size) {
            int rightIdx = leftIdx + 1;
            int maxIdx = rightIdx < size && arr[rightIdx] > arr[leftIdx] ? rightIdx : leftIdx;
            maxIdx = arr[maxIdx] > arr[idx] ? maxIdx : idx;
            if (maxIdx == idx) {
                break;
            }
            CommonUtil.swap(arr, idx, maxIdx);
            idx = maxIdx;
            leftIdx = 2 * idx + 1;
        }
    }


}
