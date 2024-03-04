package com.example.demo.onehundredandfifty;

import java.util.PriorityQueue;

/**
 * 230. 二叉搜索树中第K小的元素
 */
public class KthSmallest {
    /**
     * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
     *
     *
     *
     * 示例 1：
     *
     *
     * 输入：root = [3,1,4,null,2], k = 1
     * 输出：1
     * 示例 2：
     *
     *
     * 输入：root = [5,3,6,2,4,null,null,1], k = 3
     * 输出：3
     */

     PriorityQueue<Integer> pq = new PriorityQueue<>();
    public  int kthSmallest(TreeNode root, int k) {
        int res = 0;
        dfs(root);
        for(int i = 0; i < k; i++){
            res = pq.poll();
        }
        return res;
    }
    public void dfs(TreeNode root){
        if(root == null){
            return ;
        }
        pq.offer(root.val);
        dfs(root.left);
        dfs(root.right);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(2);
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
//        kthSmallest(node1, 1);
    }
}
