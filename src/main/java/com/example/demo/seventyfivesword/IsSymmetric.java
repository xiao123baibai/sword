package com.example.demo.seventyfivesword;

/**
 * 对称的二叉树
 */
public class IsSymmetric {
    /**
     * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
     *
     * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
     *
     *     1
     *
     *    / \
     *
     *   2   2
     *
     *  / \ / \
     *
     * 3  4 4  3
     * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
     *
     *     1
     *
     *    / \
     *
     *   2   2
     *
     *    \   \
     *
     *    3    3
     *
     *
     *
     * 示例 1：
     *
     * 输入：root = [1,2,2,3,4,4,3]
     * 输出：true
     * 示例 2：
     *
     * 输入：root = [1,2,2,null,3,null,3]
     * 输出：false
     */
    public boolean isSymmetric(TreeNode root){
        if (root == null){
            return true;
        }
        return recur(root.left,root.right);
    }

    private boolean recur(TreeNode A1,TreeNode A2){
        if (A1 == null && A2 == null){
            return true;
        }
        if (A1 == null || A2 == null || A1.val != A2.val){
            return false;
        }
        return recur(A1.left,A2.right) && recur(A1.right,A2.left);
    }
}
