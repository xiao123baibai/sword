package com.example.demo.onehundredandfifty;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 */
public class BuildTree {
    /**
     * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
     *
     *
     *
     * 示例 1:
     *
     *
     * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
     * 输出: [3,9,20,null,null,15,7]
     * 示例 2:
     *
     * 输入: preorder = [-1], inorder = [-1]
     * 输出: [-1]
     */
    //思路：先找到最左的节点，然后去寻找他的右节点，使用栈的特性向上逐层推
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        int inorderIndex = 0;
        for(int i = 1; i < preorder.length; i++){
            int preValue = preorder[i];
            TreeNode node = stack.peek();
            if(node.val != inorder[inorderIndex]){
                node.left = new TreeNode(preValue);
                stack.push(node.left);
            }else{
                while(!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]){
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preValue);
                stack.push(node.right);
            }
        }
        return root;
    }
}
