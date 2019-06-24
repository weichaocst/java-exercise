package com.weichao.exercise.algorithm;

/**
 * @author weichao
 * @Description 字符串编辑距离问题
 * 优秀博客 https://www.dreamxu.com/books/dsa/dp/edit-distance.html
 * @date 2019/6/19 17:38
 */
public class EditorialDistance {


    /**
     * 不使用动态规划的递归解法
     * 优点：便于理解，逻辑清晰
     * 缺点：性能低下，时间复杂度和空间复杂度高，重复计算较多
     * @param a 被改造的字符串
     * @param b 参考字符串
     * @param i a开始比较位置
     * @param j b数组开始比较位置
     * @return 最小编辑距离
     */
    public int editDistance(String [] a,String [] b, int i, int j){

        if(i == 0){
            return j;
        } else if (j == 0){
            return i;
        } else if (a[i-1] == b[j-1]){
            return editDistance(a,b,i-1,j-1);
        } else {
            return minOfThree(
                    editDistance(a,b,i-1,j) + 1,
                    editDistance(a,b,i,j-1) + 1,
                    editDistance(a,b,i-1,j-1) + 1
            );
        }
    }

    /**
     * 基于动态规划的自底向上的解法
     * @param word1 被改造的字符串
     * @param word2 参考字符串
     * @return 最小编辑距离
     */
    public int editDistance2(String word1, String word2){
        char [] a = word1.toCharArray();
        char [] b = word2.toCharArray();
        int aLen = a.length;
        int bLen = b.length;

        //保存编辑距离
        int [][] d = new int[aLen+1][bLen+1];

        int i ,j;

        //处理边界
        for (i = 0; i <= aLen; i++){
            d[i][0] = i;
        }
        for(j = 0; j <= bLen; j++){
            d[0][j] = j;
        }
        for(i = 1; i <= aLen; i++){
            for (j = 1;j <= bLen; j++){
                if(a[i-1] == b[j-1]){
                    d[i][j] = d[i-1][j-1];
                } else {
                    d[i][j] = minOfThree(d[i-1][j]+1, d[i][j-1]+1,d[i-1][j-1]+1);
                }
            }

        }
        return d[aLen][bLen];

    }

    /**
     * 求三个数中的最小数
     * @param a
     * @param b
     * @param b
     * @return 最小值
     */
    private int minOfThree(int a, int b, int c) {
        int min = (a < b) ? a : b;
        return (min < c) ? min : c;
    }

}
/**
 * 问题描述
 * 给定 2 个字符串 a, b. 编辑距离是将 a 转换为 b 的最少操作次数，操作只允许如下 3 种：
 *
 * 插入一个字符，例如：fj -> fxj
 * 删除一个字符，例如：fxj -> fj
 * 替换一个字符，例如：jxj -> fyj
 * 思路
 * 用分治的思想解决比较简单，将复杂的问题分解成相似的子问题
 *
 * 假设字符串 a, 共 m 位，从 a[1] 到 a[m]
 * 字符串 b, 共 n 位，从 b[1] 到 b[n]
 * d[i][j] 表示字符串 a[1]-a[i] 转换为 b[1]-b[j] 的编辑距离
 *
 * 那么有如下递归规律（a[i] 和 b[j] 分别是字符串 a 和 b 的最后一位）：
 *
 * 当 a[i] 等于 b[j] 时，d[i][j] = d[i-1][j-1], 比如 fxy -> fay 的编辑距离等于 fx -> fa 的编辑距离
 * 当 a[i] 不等于 b[j] 时，d[i][j] 等于如下 3 项的最小值：
 * d[i-1][j] + 1（删除 a[i]）， 比如 fxy -> fab 的编辑距离 = fx -> fab 的编辑距离 + 1
 * d[i][j-1] + 1（插入 b[j])， 比如 fxy -> fab 的编辑距离 = fxyb -> fab 的编辑距离 + 1 = fxy -> fa 的编辑距离 + 1
 * d[i-1][j-1] + 1（将 a[i] 替换为 b[j]）， 比如 fxy -> fab 的编辑距离 = fxb -> fab 的编辑距离 + 1 = fx -> fa 的编辑距离 + 1
 * 递归边界：
 *
 * a[i][0] = i, b 字符串为空，表示将 a[1]-a[i] 全部删除，所以编辑距离为 i
 * a[0][j] = j, a 字符串为空，表示 a 插入 b[1]-b[j]，所以编辑距离为 j
 */
