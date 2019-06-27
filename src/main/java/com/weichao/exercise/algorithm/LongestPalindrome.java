package com.weichao.exercise.algorithm;

/**
 * @author weichao
 * @Description 5.最长回文串问题
 * 参考博客地址：https://blog.csdn.net/u013309870/article/details/70742315
 * @date 2019/6/25 10:11
 */
public class LongestPalindrome {


    /**
     * 中心扩展法解决最长回文串问题
     * 时间复杂度：o(n2)
     * 空间复杂度：o(1)
     * @param str
     */
    public int palindrome(String str){

        if(str == null || str.length() == 0){
            return 0;
        }
        StringBuffer sb = new StringBuffer(str);

        for(int i = 0; i < str.length(); i++){
            sb.append("#");
            sb.append(str.charAt(i));
        }
        sb.append("#");

        char [] chs = sb.toString().toCharArray();

        int maxLen = 0;
        for(int i = 0; i < chs.length; i++){
            //对i进行中心扩展
            maxLen = Math.max(subpalidromelen(chs,i),maxLen);
        }
        return maxLen;
    }

    /**
     * 中心扩展函数
     * @param chs
     * @param centralIndex 中心扩展点
     * @return
     */
    private int subpalidromelen(char[] chs, int centralIndex) {

        int maxLen = 0;
        for(int i = 0;i <= centralIndex && i < (chs.length - centralIndex); i++){
            if(chs[centralIndex - i] == chs[centralIndex +i]){
                maxLen ++;
            } else {
                break;
            }
        }
        //去掉填充长度
        return maxLen - 1;
    }


    /**
     * 动态规划解决最长回文串问题
     * 时间复杂度：
     * 空间复杂度：
     * @param str
     * @return
     */
    public int palindrome2(String str){

        if(str == null || str.length() == 0){
            return 0;
        }

        return 0;
    }
}
