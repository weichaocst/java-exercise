package com.weichao.exercise.algorithm;

/**
 * 53.最大连续子段和问题
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class MaxSubArray {

    /**
     * 动态规划解法
     * @param nums
     * @return
     */
    public int maxSubArray(int [] nums){
        //sum保存的是当前连续几个数的和的最大值，只是记录目前算得得最大值
        int sum = Integer.MIN_VALUE;
        //tem表示决策第i个数时所保存的第i-1个数决策状态。
        int tem = 0;
        for(int i = 0; i < nums.length; i++){
            //如果tem>0，说明tem可继续累加，有可能比当前sum要大
            if(tem > 0){
                tem = tem + nums[i];
            } else {  //tem小于零，会让后面的累加值变小，说明重新计算最大字段和，记下开始位置
                tem = nums[i];
            }
            //如果tem>sum，说明刷新了最大子段和的值，记下结束位置
            if(tem > sum){
                sum = tem;
            }
        }
        return sum;
    }
}
