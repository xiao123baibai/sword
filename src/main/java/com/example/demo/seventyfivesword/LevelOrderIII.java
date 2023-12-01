package com.example.demo.seventyfivesword;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 从上到下打印二叉树 III
 */
public class LevelOrderIII {
    /**
     * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，
     * 第三行再按照从左到右的顺序打印，其他行以此类推。
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
     * 返回其层次遍历结果：
     *
     * [
     *   [3],
     *   [20,9],
     *   [15,7]
     * ]
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null){
            queue.add(root);
        }
        int l = 0;
        while (!queue.isEmpty()){
            LinkedList<Integer> temp = new LinkedList<>();
            //每一层循环的时候都是要先划定每次的范围，所以要递减
            for (int i = queue.size();i > 0; i--){
                TreeNode treeNode = queue.poll();
                if (l%2 == 0){
                    temp.addLast(treeNode.val);
                }else {
                    temp.addFirst(treeNode.val);
                }
                if (treeNode.left != null){
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null){
                    queue.add(treeNode.right);
                }
            }
            res.add(temp);
            l++;
        }
        return res;
    }

    public static void main(String[] args) {
        LinkedList<Integer> temp1 = new LinkedList<>();
        LinkedList<Integer> temp2 = new LinkedList<>();
        temp2.addLast(1);
        temp2.addLast(2);
        temp2.addLast(3);
        temp2.addLast(4);
        temp1.addFirst(1);
        temp1.addFirst(2);
        temp1.addFirst(3);
        temp1.addFirst(4);
        System.out.println(temp1);
        System.out.println(temp2);
    }
}
