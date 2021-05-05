package com.weichao.exercise.algorithm;

import java.util.LinkedList;
import java.util.List;

/**
 * @author weichao
 * @date: 2021.05.05
 * @Description: https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 */
public class FindMedianSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = new int[]{2};
        int[] nums2 = {};
        System.out.println(findMedianSortedArrays(nums1, nums2));

    }

    /**
     * 时间复杂度：O(m+n)  空间复杂度：O(m+n)
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> nums = new LinkedList<>();
        int i = 0, j = 0;
        while (i < nums1.length || j < nums2.length) {
            if (i == nums1.length && j < nums2.length) {
                nums.add(nums2[j]);
                j++;
            } else if (i < nums1.length && j == nums2.length) {
                nums.add(nums1[i]);
                i++;
            } else if (nums1[i] > nums2[j]) {
                nums.add(nums2[j]);
                j++;
            } else if (nums1[i] < nums2[j]) {
                nums.add(nums1[i]);
                i++;
            } else if (nums1[i] == nums2[j]) {
                nums.add(nums2[j]);
                nums.add(nums1[i]);
                i++;
                j++;
            }
        }
        if (nums.size() % 2 == 0) {
            return ((double) nums.get(nums.size() / 2) + nums.get(nums.size() / 2 - 1)) / 2;
        }
        return nums.get(nums.size() / 2);
    }
}
