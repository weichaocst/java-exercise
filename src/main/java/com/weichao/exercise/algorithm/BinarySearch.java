package com.weichao.exercise.algorithm;

/**
 * 二分查找法
 */
public class BinarySearch {

    public static void main(String[] args) {

        int[] nums = {1,2,3,4,5,6,7,8,9};

        int index = search(nums,6);

        System.out.println(index);
    }

    public static int search(int[] nums, int target) {

        int left  = 0;
        int right = nums.length - 1;

        while (left <= right){
            int middle = (left + right) / 2;
            if(nums[middle] == target){
                return middle;
            }

            if(target > nums[middle]){
                left = middle + 1;
            }else {
                right = middle - 1;
            }
        }
        return -1;
    }
}


