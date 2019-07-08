package com.weichao.exercise.algorithm;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author weichao
 * @Description 二叉树相关操作（前中后，层次遍历）
 * @date 2019/7/4 17:02
 * 非递归遍历原理资料：https://www.cnblogs.com/songwenjie/p/8955856.html 动画图解
 * 代码资料：https://www.yunaitong.cn/binary-tree-traverse.html
 */
public class BinaryTree {

    public static void main(String[] args) {

    }


    /**
     * 二叉树的前序遍历（递归）
     * @param root
     * @return
     */
    public List<Integer> frontErgodic(TreeNode root){
        List<Integer> result = new ArrayList<Integer>();
        frontErgodicHelper(root,result);
        return result;
    }

    /**
     * 二叉树递归前序遍历辅助函数
     * @param root
     * @param result
     */
    private void frontErgodicHelper(TreeNode root, List<Integer> result) {
        if(root != null){
            //根
            result.add(root.val);
            if(root.left != null){
                //左
                frontErgodicHelper(root.left,result);
            }
            if(root.right != null){
                //右
                frontErgodicHelper(root.right,result);
            }
        }
    }


    /**
     * 二叉树的前序遍历（非递归）
     * @param root
     * @return
     */
    public List<Integer> frontErgodic2(TreeNode root){

        List<Integer> result = new ArrayList<Integer>();

        if(root == null){
            return result;
        }

        Stack<TreeNode> treeNodeStack = new Stack<TreeNode>();
        treeNodeStack.push(root);

        while (!treeNodeStack.isEmpty()){
            TreeNode node = treeNodeStack.pop();
            result.add(node.val);
            if(node.right != null){
                treeNodeStack.push(node.right);
            }
            if(node.left != null){
                treeNodeStack.push(node.left);
            }
        }


        return result;
    }


    /**
     * 二叉树的中序遍历（递归）
     * 左根右
     * @param root
     * @return
     */
    public List<Integer> middleErgodic(TreeNode root){
        List<Integer> result = new ArrayList<Integer>();
        middleErgodicHelper(root,result);
        return result;
    }

    /**
     * 二叉树中序遍历辅助函数
     * @param root 当前节点
     * @param result 存储结果的数组
     */
    private void middleErgodicHelper(TreeNode root, List<Integer> result) {

        if(root != null){
            if(root.left != null){
                middleErgodicHelper(root.left,result);
            }
            result.add(root.val);
            if(root.right != null){
                middleErgodicHelper(root.right,result);
            }
        }
    }

    /**
     * 二叉树的中序遍历（非递归）
     * 左根右
     * @param root
     * @return
     */
    public List<Integer> middleErgodic2(TreeNode root){
        List<Integer> result = new ArrayList<Integer>();

        Stack<TreeNode> treeNodeStack = new Stack<TreeNode>();
        TreeNode node = root;

        // 当遍历到最后一个节点的时候，无论它的左右子树都为空，并且栈也为空
        // 所以，只要不同时满足这两点，都需要进入循环
        while (node != null || !treeNodeStack.isEmpty()){

            if (node != null) {
                treeNodeStack.push(node);
                node = node.left;
            } else {
                node = treeNodeStack.pop();
                result.add(node.val);
                node = node.right;
            }
        }
        return result;
    }


    /**}
     * 二叉树的后序遍历（递归）
     * @param root
     * @return
     */
    public List<Integer> rearErgodic(TreeNode root){

        List<Integer> result = new ArrayList<Integer>();
        rearErgodicHelper(root,result);
        return result;
    }

    private void rearErgodicHelper(TreeNode root, List<Integer> result) {
        if(root != null){
            if(root.left != null){
                rearErgodicHelper(root.left,result);
            }
            if(root.right != null){
                rearErgodicHelper(root.right,result);
            }
            result.add(root.val);
        }
    }

    /**
     * 二叉树的后续遍历 非递归
     * @param root
     * @return
     */
    public List<Integer> rearErgodic2(TreeNode root){

        List<Integer> result = new ArrayList<Integer>();

        if(root == null){
            return result;
        }
        Stack<TreeNode> treeNodeStack = new Stack<TreeNode>();
        TreeNode h = root;
        TreeNode c = null;
        while (h != null || !treeNodeStack.isEmpty()){
            if(h != null){
                treeNodeStack.push(h);
                h = h.left;
            }else {
                TreeNode peek = treeNodeStack.peek();
                if(peek.right != null && peek.right != c){
                    h = peek.right;
                } else {
                    peek = treeNodeStack.pop();
                    result.add(peek.val);

                }
            }
        }
        return result;
    }

    /**
     * 二叉树的层次遍历
     * @param root
     * @return
     */
    List<Integer> levelTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null)
            return result;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.addLast(root);
        while (queue.size() != 0) {
            TreeNode node = queue.pollFirst();
            result.add(node.val);
            if (node.left != null)
                queue.addLast(node.left);
            if (node.right != null)
                queue.addLast(node.right);
        }
        return result;
    }
}
