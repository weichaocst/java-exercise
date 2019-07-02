package com.weichao.exercise.algorithm;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author weichao
 * @Description 42.接雨水问题
 * https://leetcode-cn.com/problems/trapping-rain-water/
 * @date 2019/7/2 18:00
 */
public class CatchRainwater {

    public static void main(String[] args) {

        int [] example =  {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println();
    }


    /**
     * 暴力解法：从当前点向左向右查找最大的值
     * 时间复杂度：o(n2)
     * 空间复杂度：o(1)
     * @param height
     * @return
     */
    public int trap(int[] height) {

        int sum = 0;
        for(int i = 1; i < height.length; i++){
            sum += total(height,i);
        }
        return sum;
    }

    public int total(int[] height ,int index){

        int startMax = 0;
        int endMax = 0;
        int water = 0;
        for(int i = index; i >= 0; i--){
            if(height[index] < height[i]){
                startMax = startMax < height[i] ? height[i]:startMax;
            }
        }
        for(int j = index; j < height.length; j++){
            if(height[index] < height[j]){
                endMax = endMax < height[j]?height[j]:endMax;
            }
        }
        if(startMax > endMax && startMax != 0 && endMax != 0){
            water = endMax - height[index];
        } else if(startMax <= endMax && startMax != 0 && endMax != 0){
            water = startMax - height[index];
        }
        return water;
    }

    /**
     * 动态规划解法
     * @param height
     * @return
     */
    public int trap2(int[] height) {

        int sum = 0;
        for(int i = 1; i < height.length; i++){
            sum += total(height,i);
        }
        return sum;
    }

    /**
     * 栈解法
     */

}
