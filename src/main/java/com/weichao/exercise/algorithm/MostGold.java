package com.weichao.exercise.algorithm;

import javax.validation.constraints.Max;

/**
 * 动态规划：工人-金矿问题
 *
 * 解法来源：https://zhuanlan.zhihu.com/p/31628866
 */
public class MostGold {

    /**
     *
     * @param n 金矿数量
     * @param w 工人数
     * @param g 金矿含金量
     * @param p 金矿用工量
     * @return
     */
    public int getMostGold(int n, int w, int[] g, int[] p){
        int [] preResults = new int[p.length];
        int [] results = new int[p.length];

        //填充边界格子的值
        for(int i=0; i<=n; i++ ){
            if(i < p[0]){
                preResults[i] = 0;
            } else {
                preResults[i]= g[0];
            }
        }

        //填充其余格子的值，外层循环是金矿数量，内层是工人数
        for(int i=0; i < n; i++){
            for(int j=0; j <= w; j++ ){
                if(j < p[i]) {
                    results[j] = preResults[j];
                } else {
                    results[j] = Math.max(preResults[j],preResults[j-p[i] + g[i]]);
                }
            }
            preResults = results;
        }
        return results[n];
    }
}

