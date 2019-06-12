package com.weichao.exercise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author weichao
 * @Description
 * @date 2019/6/3 15:59
 */
public class Solution {

    public static void main(String[] args) {
        String s = "2";
        int a = Integer.valueOf(s);
        System.out.println(2 == a);

        List<String> ss = null;
        ss.stream().forEach(s1 -> System.out.println(s1));
    }
}
