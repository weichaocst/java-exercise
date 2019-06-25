package com.weichao.exercise.algorithm;

/**
 * 206.反转链表
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 参考博客：https://www.jianshu.com/p/bd6a64d36916
 */
public class ReverseList {

    /**
     * 迭代法
     * 时间复杂度：O(n)O(n)，假设 nn 是列表的长度，时间复杂度是 O(n)O(n)。
     * 空间复杂度：O(1)O(1)。
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        //上一个节点
       ListNode pre = null;
       //暂存当前节点的下一个节点
       ListNode next = null;
       while (head != null){
           //将当前节点的下一个节点暂存起来
           next = head.next;
           //将当前节点指向它的上一个节点，实现了反转
           head.next = pre;
           //将当前节点设置为上一个节点
           pre = head;
           //将head指向当前节点的下一个节点
           head = next;
       }
       //返回头结点
       return pre;
    }

    /**
     * 时间复杂度：O(n)O(n)，假设 nn 是列表的长度，那么时间复杂度为 O(n)O(n)。
     * 空间复杂度：O(n)O(n)，由于使用递归，将会使用隐式栈空间。递归深度可能会达到 nn 层。
     * 参考来源：https://leetcode-cn.com/problems/reverse-linked-list/solution/fan-zhuan-lian-biao-by-leetcode/
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        //将当前节点的下一个节点指向当前节点
        head.next.next = head;
        head.next = null;
        return p;
    }


    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
}
