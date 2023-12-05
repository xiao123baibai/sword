package com.example.demo.seventyfivesword;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 从上到下打印二叉树 II
 */
public class LevelOrderII {
    /**
     * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
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
     *   [9,20],
     *   [15,7]
     * ]
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null){
            queue.add(root);
        }
        while (!queue.isEmpty()){
            int n = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < n; i++){
                TreeNode t = queue.poll();
                temp.add(t.val);
                if (t.left != null){
                    queue.add(t.left);
                }
                if (t.right != null){
                    queue.add(t.right);
                }
            }
            res.add(temp);
        }
        return res;
    }

    public List<List<Integer>> levelOrder1(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null){
            queue.add(root);
        }
        while (!queue.isEmpty()){
            int n = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < n; i++){
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
            result.add(temp);
        }
        return result;
    }
}
