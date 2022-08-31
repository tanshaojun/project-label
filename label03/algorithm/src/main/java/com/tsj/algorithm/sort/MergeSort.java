package com.tsj.algorithm.sort;

/**
 * 归并排序
 *
 * @Author tansj
 * @Date 2022/8/30 16:39
 * @Version 1.0
 */
public class MergeSort {

    public void mergeSort(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    private void process(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        process(arr, left, mid);
        process(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int ol = left;
        int tl = mid + 1;
        int idx = 0;
        while (ol <= mid && tl <= right) {
            if (arr[ol] < arr[tl]) {
                tmp[idx++] = arr[ol++];
            } else {
                tmp[idx++] = arr[tl++];
            }
        }
        for (int i = ol; i <= mid; i++) {
            tmp[idx++] = arr[i];
        }
        for (int i = tl; i <= right; i++) {
            tmp[idx++] = arr[i];
        }
        for (int i = 0; i < tmp.length; i++) {
            arr[left + i] = tmp[i];
        }
    }

}
