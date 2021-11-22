package com.weichao.exercise.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20. 有效的括号
 * https://leetcode-cn.com/problems/valid-parentheses/submissions/
 * @author weichao
 */
public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("["));
    }

    private static final Map<String, String> leftMap = new HashMap<String, String>(){{
        put("(", ")");
        put("{", "}");
        put("[", "]");
    }};

    public static boolean isValid(String s) {
        char[] array = s.toCharArray();
        Stack<String> stringStack = new Stack<>();
        for (char c : array) {
            String cs = String.valueOf(c);
            if (leftMap.containsKey(cs)) {
                stringStack.push(cs);
            } else {
                if (!stringStack.empty() && cs.equals(leftMap.get(stringStack.peek()))) {
                    stringStack.pop();
                } else {
                    return false;
                }
            }
        }
       return stringStack.empty();
    }
}
