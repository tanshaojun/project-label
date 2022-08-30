package com.tsj.algorithm.code;

/**
 * 在排序数组中找到大于n的最左侧索引
 *
 * @Author tansj
 * @Date 2022/8/29 10:04
 * @Version 1.0
 */
public class NearestIndex {

    public int nearestIndex(int[] arr, int value) {
        if (null == arr || arr.length == 0) {
            return -1;
        }
        int res = -1;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) >> 1;
            if (arr[mid] >= value) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }

}
