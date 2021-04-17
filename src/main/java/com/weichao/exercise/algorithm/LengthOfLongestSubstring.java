package com.weichao.exercise.algorithm;

import java.util.*;

/**
 * @author 魏超
 * @date: 2021.04.17
 * @Description: 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abbcabcda"));
    }

    /**
     * 滑动窗口法 (代码原创)
     * 例如：zxabcada
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int result = 0;
        //左指针
        int left = 0;
        //右指针
        int right = 0;
        //保存所有已遍历的元素以及对应的下标
        HashMap<Character, Integer> map = new HashMap<>();
        while (left < s.length() && right < s.length()) {
            char c = s.charAt(right);
            //判断当前遍历的元素是否在当前窗口期内已存在，存在的话直接将left指针跳到当前重复元素的下一个位置
            if (map.containsKey(c) && map.get(c) >= left) {
                result = Math.max(result, right - left);
                left = map.get(c) + 1;
            }
            //将本次遍历的元素和下标放入map中
            map.put(c, right);
            right++;
        }
        //最后一次的长度与当前result比较
        return Math.max(result, right - left);
    }


    /**
     * 滑动窗口法（来源于网络）
     * 该实现的缺点是每次发现重复元素要依次移除掉重复元素和之前的元素，与lengthOfLongestSubstringOneSelf类似
     *
     * @param s
     * @return 当输入" "时，应该输出1
     */
    public int lengthOfLongestSubstring2(String s) {

        int n = s.length();
        int ans = 0, i = 0, j = 0;
        Set<Character> set = new HashSet<>();
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }


    /**
     * 自己的解法，本质上是一种暴力解法，abcohomm, 当遇到第二个o时，移除掉第一个o之前的所有元素
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstringOneSelf(String s) {
        List<String> list = new LinkedList<>();
        int result = 0;
        String[] strings = s.split("");
        int index = 0;
        for (String c : strings) {
            if (c.equals("")) {
                continue;
            }
            if (list.contains(c)) {
                result = Math.max(result, list.size());
                Iterator<String> iterator = list.iterator();
                while (iterator.hasNext()) {
                    String element = iterator.next();
                    if (element.equals(c)) {
                        iterator.remove();
                        break;
                    }
                    iterator.remove();
                }
            }
            list.add(c);
        }
        result = Math.max(result, list.size());
        return result;
    }
}
