package com.example.demo.seventyfivesword;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的镜像
 */
public class MirrorTree {
    /**
     * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
     *
     * 例如输入：
     *
     *      4
     *
     *    /   \
     *
     *   2     7
     *
     *  / \   / \
     *
     * 1   3 6   9
     * 镜像输出：
     *
     *      4
     *
     *    /   \
     *
     *   7     2
     *
     *  / \   / \
     *
     * 9   6 3   1
     *
     *
     *
     * 示例 1：
     *
     * 输入：root = [4,2,7,1,3,6,9]
     * 输出：[4,7,2,9,6,3,1]
     */
    //递归法
    public TreeNode mirrorTree1(TreeNode root){
        if (root == null){
            return root;
        }
        TreeNode temp = root.right;
        root.right = mirrorTree1(root.left);
        root.left = mirrorTree1(temp);
        return root;
    }
    //循环遍历法
    public TreeNode mirrorTree(TreeNode root){
        if(root == null){
            return root;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode t = queue.poll();
            if (t.left != null){
                queue.add(t.left);
            }
            if (t.right != null){
                queue.add(t.right);
            }
            TreeNode temp = t.right;
            t.right = t.left;
            t.left = temp;
        }
        return root;
    }


}
