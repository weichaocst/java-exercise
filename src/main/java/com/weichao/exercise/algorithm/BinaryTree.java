package com.weichao.exercise.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weichao
 * @Description 二叉树相关操作
 * @date 2019/7/4 17:02
 */
public class BinaryTree {

    public static void main(String[] args) {

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
        middleErgodicHelper(root,result);
        return result;
    }


}
