package com.weichao.exercise.algorithm;

/**
 * 21.合并两个有序链表
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class MergeOrderedLinkedList {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode header = new ListNode(0);
        ListNode temp = header;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    temp.next = l1;
                    temp = l1;
                    l1 = l1.next;
                } else {
                    temp.next = l2;
                    temp = l2;
                    l2 = l2.next;
                }
            } else if (l1 != null) {
                temp.next = l1;
                temp = l1;
                l1 = l1.next;
            } else if (l2 != null) {
                temp.next = l2;
                temp = l2;
                l2 = l2.next;
            }
        }
        return header.next;
    }


    class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
