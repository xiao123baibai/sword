package com.example.demo.seventyfivesword;

/**
 * 平衡二叉树
 */
public class IsBalanced {
    /**
     * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
     *
     *
     *
     * 示例 1:
     *
     * 给定二叉树 [3,9,20,null,null,15,7]
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回 true 。
     *
     * 示例 2:
     *
     * 给定二叉树 [1,2,2,3,3,null,null,4,4]
     *
     *        1
     *       / \
     *      2   2
     *     / \
     *    3   3
     *   / \
     *  4   4
     * 返回 false
     */
    //这应该不是一道简单题吧  使用递归法

    //自顶向下递归 先序遍历，深度判断
    public boolean isBalanced1(TreeNode root) {
        if (root == null){
            return true;
        }
        return Math.abs(depth1(root.right)-depth1(root.left)) <= 1 && isBalanced1(root.left) && isBalanced1(root.right);
    }

    private int depth1(TreeNode root){
        if (root == null){
            return 0;
        }
        return Math.max(depth1(root.left), depth1(root.right)) + 1;
    }
    public boolean isBalanced11(TreeNode root){
        if (root == null){
            return true;
        }
        return Math.abs(depth11(root.left)-depth11(root.right)) <= 1 && isBalanced11(root.left) && isBalanced11(root.right);
    }
    private int depth11(TreeNode root){
        if (root == null){
            return 0;
        }
        return Math.max(depth11(root.left),depth11(root.right)) + 1;
    }

    //后续遍历 + 剪枝
    public boolean isBalanced(TreeNode root){
        return height(root) > 0;
    }

    private int height(TreeNode root){
        if (root == null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight-rightHeight) > 1){
            return -1;
        }else {
            return Math.max(leftHeight,rightHeight) + 1;
        }
    }
    public boolean isBalanced2(TreeNode root){
        return height1(root) > 0;
    }
    private int height1(TreeNode root){
        if (root == null){
            return 0;
        }
        int leftHeight = height1(root.left);
        int rightHeight = height1(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight-rightHeight) > 1){
            return -1;
        }else {
            return Math.max(leftHeight,rightHeight) + 1;
        }
    }

}
