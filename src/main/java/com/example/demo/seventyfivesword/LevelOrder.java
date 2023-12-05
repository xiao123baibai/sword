package com.example.demo.seventyfivesword;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 从上到下打印二叉树
 */
public class LevelOrder {
    /**
     * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
     *
     *
     *
     * 例如:
     * 给定二叉树: [3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回：
     *
     * [3,9,20,15,7]
     */

    public static int[] levelOrder(TreeNode root) {
        if(root == null) {
            return new int[0];}
        //LinkedList的有序性
        Queue<TreeNode> queue = new LinkedList<TreeNode>(){{ add(root); }};
        ArrayList<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            ans.add(node.val);
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
        }
        int[] res = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++)
            res[i] = ans.get(i);
        return res;
    }

    public int[] levelOrder1(TreeNode root){
        if (root == null){
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedList<>(){{add(root);}};
        List<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            ans.add(node.val);
            if (node.left != null){
                queue.add(node.left);
            }
            if (node.right != null){
                queue.add(node.right);
            }
        }
        int[] res = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++)
            res[i] = ans.get(i);
        return res;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(20);
        TreeNode treeNode4 = new TreeNode(15);
        TreeNode treeNode5 = new TreeNode(7);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;
        int[] ans = levelOrder(treeNode1);
    }
}


class TreeNode {
     int val;
    TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

