package com.example.demo.onehundredandfifty;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 101. 对称二叉树
 */
public class IsSymmetric {
    /**
     * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
     *
     *
     *
     * 示例 1：
     *
     *
     * 输入：root = [1,2,2,3,4,4,3]
     * 输出：true
     * 示例 2：
     *
     *
     * 输入：root = [1,2,2,null,3,null,3]
     * 输出：false
     *
     *
     * 提示：
     *
     * 树中节点数目在范围 [1, 1000] 内
     * -100 <= Node.val <= 100
     *
     *
     * 进阶：你可以运用递归和迭代两种方法解决这个问题吗？
     */
    //对称优先使用深度搜索，是靠这个题和判断两个二叉树是和相同的点
    public boolean isSymmetric(TreeNode root) {
        return recur(root,root);
    }

    private boolean recur(TreeNode p, TreeNode q){
        if (p == null && q == null){
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        }
        return recur(p.left, q.right) && recur(p.right, q.left);
    }
    //使用广度搜索算法
    public boolean isSymmetric1(TreeNode root){
        Deque<TreeNode> deque1 = new LinkedList<>();
        Deque<TreeNode> deque2 = new LinkedList<>();
        deque1.add(root);
        deque2.add(root);
        while (!deque1.isEmpty() && !deque2.isEmpty()){
            TreeNode node1 = deque1.poll();
            TreeNode node2 = deque2.poll();
            if (node1.val != node2.val){
                return false;
            }
            if (node1.left == null && node2.right != null){
                return false;
            }
            if (node1.right == null && node2.left != null){
                return false;
            }
            if (node1.left != null && node2.right == null){
                return false;
            }
            if (node1.right != null && node2.left == null){
                return false;
            }
            if (node1.left != null){
                deque1.offer(node1.left);
            }
            if (node1.right != null){
                deque1.offer(node1.right);
            }
            if (node2.right != null){
                deque2.offer(node2.right);
            }
            if (node2.left != null){
                deque2.offer(node2.left);
            }
        }
        return deque1.isEmpty() && deque2.isEmpty();
    }
}
