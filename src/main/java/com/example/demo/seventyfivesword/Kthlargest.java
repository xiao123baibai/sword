package com.example.demo.seventyfivesword;

public class Kthlargest {
    /**
     * 给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
     *
     *
     *
     * 示例 1:
     *
     * 输入: root = [3,1,4,null,2], k = 1
     *    3
     *   / \
     *  1   4
     *   \
     *    2
     * 输出: 4
     * 示例 2:
     *
     * 输入: root = [5,3,6,2,4,null,null,1], k = 3
     *        5
     *       / \
     *      3   6
     *     / \
     *    2   4
     *   /
     *  1
     * 输出: 4
     *
     *
     * 限制：
     *
     * 1 ≤ k ≤ 二叉搜索树元素个数
     */
//      Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(char x) {
            val = x;
        }
    }
    static int res,k;
    public static int kthLargest(TreeNode root) {
        //遍历，然后排序
        dfs(root);
        return 1;
    }

    private static void dfs(TreeNode root){
        if (root == null){
            return;
        }
        dfs(root.left);
        if (k == 0){
            return;
        }
        if (--k == 0){
            res = root.val;
            return;
        }
        dfs(root.right);
    }

    public static void main(String[] args) {
        k = 4;
        kthLargest(creatTree());
        System.out.println(res);
        inOrder(creatTree());
    }
    public static TreeNode creatTree () {
        TreeNode A = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');
        TreeNode H = new TreeNode('H');

        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        E.right = H;

        return A;
    }

    /**
     *  前后定根，中分左右
     *
     */

    //前序
    private static void preOrder(TreeNode root){
        if (root == null){
            return;
        }
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    //中序
    private static void inOrder(TreeNode root){
        if (root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }
    //后序
    private static void postOrder(TreeNode root){
        if (root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val+" ");
    }
}
