package com.example.demo.seventyfivesword;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 二叉树的深度
 */
public class MaxDepth {
    /**
     * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
     *
     * 例如：
     *
     * 给定二叉树 [3,9,20,null,null,15,7]，
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回它的最大深度 3 。
     */
    //思路分析 1、按层进行循环🌲结构，每一层 计数，
    public int maxDepth(TreeNode root) {
        int depth = 0;
        if (root == null){
            return depth;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()){
            int num = deque.size();
            depth++;
            for (int i = 0; i < num;i++){
                TreeNode temp = deque.poll();
                if (temp.left != null){
                    deque.add(temp.left);
                }
                if (temp.right != null){
                    deque.add(temp.right);
                }
            }
        }
        return depth;
    }
}
