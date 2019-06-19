package com.weichao.exercise.algorithm;

/**
 * 快速排序算法实现
 * 最坏时间复杂度：O(n2)
 * 平均时间复杂度：O(nlogn)
 * 辅助空间：O(n)
 */
public class QuickSort {


    public void quickSort(int [] arr, int start, int end){

        if(start < end){
            int q = partition(arr,start,end);
            //对左半段排序
            quickSort(arr,start,q-1);
            //对右半段排序
            quickSort(arr,q+1,end);
        }
    }

    /**
     * 划分方法
     * @param arr
     * @param start
     * @param end
     * @return
     */
    private int partition(int[] arr, int start, int end) {

        return 0;
    }
}
