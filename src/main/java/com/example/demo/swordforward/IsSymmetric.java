package com.example.demo.swordforward;

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
        //1、先判断头节点
        //2、翻转一个节点
        //3、是不是相等
        if (root == null){
            return true;
        }
        return MirrorTreeNode(root.left,root.right);
    }

    private Boolean MirrorTreeNode(TreeNode L,TreeNode R){
        if (L == null && R == null){
            return true;
        }
        if(L == null || R == null || L.val != R.val){
            return false;
        }
        return MirrorTreeNode(L.right,R.left) && MirrorTreeNode(L.left, R.right);
    }
}
