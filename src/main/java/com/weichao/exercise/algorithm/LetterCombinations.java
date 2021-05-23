package com.weichao.exercise.algorithm;

import java.util.*;

/**
 * @author weichao
 * @date: 2021.05.23
 * @Description: https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinations {
    static final Map<String, List<String>> initMap = new HashMap<String, List<String>>() {{
        put("1", new ArrayList<>());
        put("2", new ArrayList<String>() {{
            add("a");
            add("b");
            add("c");
        }});
        put("3", new ArrayList<String>() {{
            add("d");
            add("e");
            add("f");
        }});
        put("4", new ArrayList<String>() {{
            add("g");
            add("h");
            add("i");
        }});
        put("5", new ArrayList<String>() {{
            add("j");
            add("k");
            add("l");
        }});
        put("6", new ArrayList<String>() {{
            add("m");
            add("n");
            add("o");
        }});
        put("7", new ArrayList<String>() {{
            add("p");
            add("q");
            add("r");
            add("s");
        }});
        put("8", new ArrayList<String>() {{
            add("t");
            add("u");
            add("v");
        }});
        put("9", new ArrayList<String>() {{
            add("w");
            add("x");
            add("y");
            add("z");
        }});
    }};


    public static void main(String[] args) {
        List<String> res = letterCombinations("23");
        res.forEach(v -> {
            System.out.println(v);
        });

    }

    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || "".equals(digits)) {
            return res;
        }
        LinkedList<String> track = new LinkedList<>();
        backtrack(initMap, digits, 0, track, res);

        return res;
    }

    /**
     * @param initMap
     * @param digits
     * @param index
     * @param track
     * @param res
     */
    private static void backtrack(Map<String, List<String>> initMap, String digits,
                                  int index, LinkedList<String> track, List<String> res) {
        if (track.size() == digits.length()) {
            res.add(String.join("", track));
            return;
        }
        List<String> nums = initMap.get(String.valueOf(digits.charAt(index)));
        for (String num : nums) {
            track.add(num);
            int indexTemp = index + 1;
            backtrack(initMap, digits, indexTemp, track, res);
            track.removeLast();
        }
    }
}
