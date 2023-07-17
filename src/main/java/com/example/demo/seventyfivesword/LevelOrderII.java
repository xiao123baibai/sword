package com.example.demo.seventyfivesword;

import java.util.*;

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
        while (queue.isEmpty()){
            int n = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < n; i++){
                TreeNode t = queue.poll();
                temp.add(queue.poll().val);
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
}
