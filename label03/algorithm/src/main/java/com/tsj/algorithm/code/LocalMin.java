package com.tsj.algorithm.code;

/**
 * 在一个无序并且相邻不等的数组中找到任意一个i-1 > i && i+1 > i的值
 *
 * @Author tansj
 * @Date 2022/8/29 10:18
 * @Version 1.0
 */
public class LocalMin {

    public int localMin(int[] arr) {
        if (null == arr || arr.length == 0 || arr.length == 1) {
            return -1;
        }
        int len = arr.length;
        if (arr[0] < arr[1]) {
            return arr[0];
        }
        if (arr[len - 1] < arr[len - 2]) {
            return arr[len - 1];
        }
        int left = 1;
        int right = len - 2;
        while (left <= right) {
            int mid = left + (right - left) >> 1;
            if (arr[mid] > arr[mid - 1]) {
                right = mid - 1;
            } else if (arr[mid] > arr[mid + 1]) {
                left = mid + 1;
            } else {
                return arr[mid];
            }
        }
        return arr[left];
    }

}
