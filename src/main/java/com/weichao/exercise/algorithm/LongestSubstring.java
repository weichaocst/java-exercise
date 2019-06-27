package com.weichao.exercise.algorithm;

import com.alibaba.druid.sql.visitor.functions.Char;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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

    /**
     * 滑动窗口法
     * @param s
     * @return
     * 当输入" "时，应该输出1
     */
    public int lengthOfLongestSubstring2(String s) {

       int n = s.length();
       int ans = 0, i = 0, j = 0;
       Set<Character> set = new HashSet<>();
       while (i < n && j < n){
           if(!set.contains(s.charAt(j))){
               set.add(s.charAt(j++));
               ans = Math.max(ans,j - i);
           } else {
               set.remove(s.charAt(i++));
           }
       }
       return ans;
    }
}
