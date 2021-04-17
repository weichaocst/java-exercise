package com.weichao.exercise.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class LongestSubstring {


    /**
     * 暴力解法
     * 时间复杂度：O(n^3)
     * 空间复杂度：O(min(n, m))O(min(n,m))
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {

        int n = s.length();
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(allUnique(s,i,j)){
                    ans = Math.max(ans,j-i);
                }
            }
        }
        return ans;
    }

    /**
     * 将已遍历过的存在集合中
     * @param s
     * @param start
     * @param end
     * @return
     */
    private boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for(int i = start; i < end; i++){
            Character ch = s.charAt(i);
            if(set.contains(ch)){
                return false;
            }
            set.add(ch);
        }
        return true;
     }


}
