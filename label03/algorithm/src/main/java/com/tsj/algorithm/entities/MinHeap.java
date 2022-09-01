package com.tsj.algorithm.entities;

import com.tsj.algorithm.util.CommonUtil;

/**
 * 最小堆
 *
 * @Author tansj
 * @Date 2022/9/1 14:53
 * @Version 1.0
 */
public class MinHeap {

    int[] arr;

    int size = 0;

    public MinHeap(int count) {
        arr = new int[count];
    }

    public void push(int val) {
        if (size >= arr.length) {
            return;
        }
        arr[size] = val;
        heapInsert(arr, size++);
    }

    public int pop() {
        if (0 == size) {
            return -1;
        }
        int res = arr[0];
        CommonUtil.swap(arr, 0, --size);
        heapify(arr, 0, size);
        return res;
    }

    public int getSize() {
        return size;
    }

    private void heapify(int[] arr, int idx, int size) {
        int leftIdx = 2 * idx + 1;
        while (leftIdx < size) {
            int rightIdx = leftIdx + 1;
            int maxIdx = rightIdx < size && arr[rightIdx] < arr[leftIdx] ? rightIdx : leftIdx;
            maxIdx = arr[maxIdx] < arr[idx] ? maxIdx : idx;
            if (maxIdx == idx) {
                break;
            }
            CommonUtil.swap(arr, idx, maxIdx);
            idx = maxIdx;
            leftIdx = 2 * idx + 1;
        }
    }

    private void heapInsert(int[] arr, int idx) {
        while (arr[idx] < arr[(idx - 1) / 2]) {
            CommonUtil.swap(arr, (idx - 1) / 2, idx);
            idx = (idx - 1) / 2;
        }
    }

}
