package com.example.demo.onehundredandfifty;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 104. 二叉树的最大深度
 */
public class MaxDepth {
    /**
     * 给定一个二叉树 root ，返回其最大深度。
     *
     * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
     * 示例 1：
     * 输入：root = [3,9,20,null,null,15,7]
     * 输出：3
     * 示例 2：
     *
     * 输入：root = [1,null,2]
     * 输出：2
     *
     *
     * 提示：
     *
     * 树中节点的数量在 [0, 104] 区间内。
     * -100 <= Node.val <= 100
     */

    public int maxDepth(TreeNode root) {
        int depth = 0;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()){
            int num = deque.size();
            depth++;
            for (int i = 0; i < num; i++){
                TreeNode node = deque.poll();
                if (node.left != null){
                    deque.add(node.left);
                }
                if (node.right != null){
                    deque.add(node.right);
                }
            }
        }
        return depth;
    }


}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
