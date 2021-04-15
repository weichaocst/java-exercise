package com.weichao.exercise.algorithm;

/**
 * @author AddTwoNumbers
 * @date: 2021.04.16
 * @Description: 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3, null)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4, null)));
        ListNode result = addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode cursor = root;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sumVal = l1Val + l2Val + carry;
            carry = sumVal / 10;

            ListNode sumNode = new ListNode(sumVal % 10);
            cursor.next = sumNode;
            cursor = sumNode;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        return root.next;
    }

    /**
     * 自己写的
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbersOneSelf(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cursor = head;
        int nextSum = 0;
        while (l1 != null || l2 != null || nextSum !=0) {
            ListNode sumNode;
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + nextSum;
            nextSum = sum / 10;
            sumNode = new ListNode(sum % 10);
            cursor.next = sumNode;
            cursor = sumNode;
            l1 = l1 == null?null:l1.next;
            l2 = l2 == null?null:l2.next;
        }
        return head.next;
    }

}



class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
