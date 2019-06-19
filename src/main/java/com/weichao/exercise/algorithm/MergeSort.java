package com.weichao.exercise.algorithm;

import java.util.Arrays;

/**
 * 归并算法实现
 */
public class MergeSort {

    public static void main(String[] args) {
        int []arr = {9,8,7,6,5,4,3,2,1};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int [] arr){
        int len = arr.length;
        int [] result = new int[len];
        mergeSortRecursive(arr,result,0,len);
    }

    /**
     * 归并排序递归实现
     * @param arr 原数组
     * @param result 存放结果的临时数组
     * @param start 数组开始位置
     * @param end 数组结束位置
     * 关于归并排序解释的比较好的教程： https://www.cnblogs.com/chengxiao/p/6194356.html
     */
    private static void mergeSortRecursive(int[] arr, int[] result, int start, int end) {

        if(start >= end){
            return;
        }
        //分
        int len = end - start;
        int middle = (end >> 1) + 1;
        int start1 = start,end1 = middle;
        int start2= middle + 1,end2 = end;
        mergeSortRecursive(arr,result,start1,end1);
        mergeSortRecursive(arr,result,start2,end2);

        //治（和）
        int k = start;
        while (start1 <= end1 && start2 <= end2){
            result[k++] = arr[start1] < arr[start2] ? arr[start1++]:arr[start2++];
        }
        while (start1 < end1){
            result[k++] = arr[k++];
        }
        while (start2 < end2){
            result[k++] = arr[k++];
        }
        //将排好序的结果拷贝到原数组
        for(k = start; k <= end; k++){
            arr[k] = result[k];
        }
    }

    /**
     * 迭代版归并排序（还没研究）
     * @param arr
     */
    public static void merge_sort(int[] arr) {
        int[] orderedArr = new int[arr.length];
        for (int i = 2; i < arr.length * 2; i *= 2) {
            for (int j = 0; j < (arr.length + i - 1) / i; j++) {
                int left = i * j;
                int mid = left + i / 2 >= arr.length ? (arr.length - 1) : (left + i / 2);
                int right = i * (j + 1) - 1 >= arr.length ? (arr.length - 1) : (i * (j + 1) - 1);
                int start = left, l = left, m = mid;
                while (l < mid && m <= right) {
                    if (arr[l] < arr[m]) {
                        orderedArr[start++] = arr[l++];
                    } else {
                        orderedArr[start++] = arr[m++];
                    }
                }
                while (l < mid)
                    orderedArr[start++] = arr[l++];
                while (m <= right)
                    orderedArr[start++] = arr[m++];
                System.arraycopy(orderedArr, left, arr, left, right - left + 1);
            }
        }
    }
}
