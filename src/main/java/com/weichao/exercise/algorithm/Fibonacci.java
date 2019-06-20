package com.weichao.exercise.algorithm;

/**
 * @author weichao
 * @Description 斐波那契数列的几种解法
 * 首先介绍斐波那契数列，斐波那契数列的排列是：1，1，2，3，5，8，13，21，34，55，89，144……
 * 在数学上，斐波那契数列以如下被以递归的方法定义：F0=0，F1=1，Fn=Fn-1+Fn-2（n>=2，n∈N*），用文字来说，就是斐波那契数列由 0 和 1 开始，之后的斐波那契数列系数就由之前的两数相加。
 * 参考资料：https://zhuanlan.zhihu.com/p/31628866
 * @date 2019/6/19 16:43
 */
public class Fibonacci {

    public static void main(String[] args) {

    }


    /**
     * 递归解法
     */
    public int fibonacciRecursive(int n){

        if(n <= 0){
            return 1;
        }

        if(n == 1){
            return 1;
        }

        return fibonacciRecursive(n-1) + fibonacciRecursive(n-2);
    }

    /**
     * 自顶向下的备忘录法
     * 时间复杂度：o（N）
     * 空间复杂度：o(N)
     */
    public int fibonacciMemorandum(int n){

        if(n <= 0){
            return n;
        }

        int [] memo = new int[n + 1];
        for(int i = 0;i <= n;i++){
            memo[i] = -1;
        }
        return fibMemorandum(n,memo);
    }

    public int fibMemorandum(int n,int [] memo){
        if(memo[n] != -1){
            return memo[n];
        }
        if(n <= 2){
            memo[n] = 1;
        } else {
            memo[n] = fibMemorandum(n-1,memo) + fibMemorandum(n-2,memo);
        }
        return memo[n];
    }

    /**
     * 自底向上的动态规划求解(最简单的动态规划)
     * 时间复杂度：o(n)
     * 空间复杂度：o(1)
     */
    public int fibDynamicPlanning(int n){
        if(n <= 0){
            return n;
        }
        if(n <= 2){
            return 1;
        }
        int a = 1;
        int b = 1;
        int temp = 0;

        for(int i = 3; i <= n; i++){
            temp = a + b;
            a = b;
            b = temp;
        }

        return temp;
    }

}
