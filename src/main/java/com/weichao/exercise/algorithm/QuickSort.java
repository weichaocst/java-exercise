package com.weichao.exercise.algorithm;

import java.util.Arrays;

/**
 * 快速排序算法实现
 * 最坏时间复杂度：O(n2)
 * 平均时间复杂度：O(nlogn)
 * 辅助空间：O(n)
 * 代码出处：https://www.jianshu.com/p/20257cf93cc1
 */
public class QuickSort {

    public static void main(String[] args) {

        int[] array = {6,1,2,7,9,7,4,5,10,8};

        quickSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }


    public static void quickSort(int [] arr, int left, int right){
        if(left > right){
            return ;
        }

        //左哨兵
        int i = left;
        //右哨兵
        int j = right;
        //基准数
        int base = arr[left];
        //临时交换变量
        int t;

        while (i != j){
            //先从右边开始找，找到右边小于基准数的数
            while (arr[j] >= base && i < j){
                j--;
            }
            //然后从左边开始找，找到左边大于基准数的数
            while (arr[i] <= base && i < j){
                i++;
            }
            //交换两个数在数组中的位置
            if(i < j){
                t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }

        //将基准数放到对应的位置
        //arr[i]一定是小于基准数的数，这也是为什么要从右边开始向左遍历
        arr[left] = arr[i];
        arr[i] = base;
        // 继续处理左边的，这里是一个递归的过程
        quickSort(arr, left, i - 1);
        // 继续处理右边的 ，这里是一个递归的过程
        quickSort(arr, i + 1, right);
    }
}
