package com.example.demo.onehundredandfifty;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 */
public class BuildTree1 {
    /**
     * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
     *
     *
     *
     * 示例 1:
     *
     *
     * 输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
     * 输出：[3,9,20,null,null,15,7]
     * 示例 2:
     *
     * 输入：inorder = [-1], postorder = [-1]
     * 输出：[-1]
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder == null || postorder.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        int inorderIndex = postorder.length - 1;
        for(int i = postorder.length - 2; i >= 0; i--){
            int postValue = postorder[i];
            TreeNode node = stack.peek();
            if(node.val != inorder[inorderIndex]){
                node.right = new TreeNode(postValue);
                stack.push(node.right);
            }else{
                while(!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]){
                    node = stack.pop();
                    inorderIndex--;
                }
                node.left = new TreeNode(postValue);
                stack.push(node.left);
            }
        }
        return root;
    }
}
