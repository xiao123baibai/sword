package com.example.demo.onehundredandfifty;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 226. 翻转二叉树
 */
public class InvertTree {
    /**
     * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
     * 示例 1：
     * 输入：root = [4,2,7,1,3,6,9]
     * 输出：[4,7,2,9,6,3,1]
     * 示例 2：
     * 输入：root = [2,1,3]
     * 输出：[2,3,1]
     * 示例 3：
     * 输入：root = []
     * 输出：[]
     * 提示：
     * 树中节点数目范围在 [0, 100] 内
     * -100 <= Node.val <= 100
     */
    //广度搜索
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.left != null){
                queue.offer(node.left);
            }
            if (node.right != null){
                queue.offer(node.right);
            }
        }
        return root;
    }
    //深度搜索
    public TreeNode invertTree1(TreeNode root){
        if (root == null){
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
