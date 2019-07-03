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
     * 解法来源：https://leetcode-cn.com/problems/trapping-rain-water/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-8/
     *
     * 我们注意到，解法二中。对于每一列，我们求它左边最高的墙和右边最高的墙，都是重新遍历一遍所有高度，这里我们可以优化一下。
     *
     * 首先用两个数组，max_left [ i ] 代表第 i 列左边最高的墙的高度，max_right [ i ] 代表第 i 列右边最高的墙的高度。（一定要注意下，第 i 列左（右）边最高的墙，是不包括自身的，和 leetcode 上边的讲的有些不同）
     *
     * 对于 max_left 我们其实可以这样求。
     *
     * max_left [ i ] = Max ( max_left [ i - 1] , height [ i - 1]) 。它前边的墙的左边的最高高度和它前边的墙的高度选一个较大的，就是当前列左边最高的墙了。
     *
     * 对于 max_right我们可以这样求。
     *
     * max_right[ i ] = Max ( max_right[ i + 1] , height [ i + 1]) 。它后边的墙的右边的最高高度和它后边的墙的高度选一个较大的，就是当前列右边最高的墙了。
     *
     * 这样，我们再利用解法二的算法，就不用在 for 循环里每次重新遍历一次求 max_left 和 max_right 了。
     *
     */
    public int trap2(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }

        int sum = 0;
        int [] maxLeft = new int[height.length];
        int [] maxRight = new int[height.length];
        maxLeft[0] = height[0];
        for(int i = 1; i < height.length-1; i++){
            maxLeft[i] = Math.max(maxLeft[i-1],height[i-1]);
        }
        for(int i = height.length-2; i >= 0; i--){
            maxRight[i] = Math.max(maxRight[i+1],height[i+1]);
        }
        for(int i = 1; i < height.length-1; i++){
            int min = Math.min(maxLeft[i],maxRight[i]);
            if(min > height[i]){
                sum += min - height[i];
            }
        }
        return sum;
    }

    /**
     * 栈解法
     */

}
