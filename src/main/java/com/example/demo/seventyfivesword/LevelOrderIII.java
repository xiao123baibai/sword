package com.example.demo.seventyfivesword;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 从上到下打印二叉树 III
 */
public class LevelOrderIII {
    /**
     * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
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
