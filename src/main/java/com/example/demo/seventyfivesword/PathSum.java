package com.example.demo.seventyfivesword;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *二叉树中和为某一值的路径
 */
public class PathSum {
    /**
     * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
     *
     * 叶子节点 是指没有子节点的节点。
     *
     * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
     * 输出：[[5,4,11,2],[5,8,4,5]]
     *
     * 输入：root = [1,2,3], targetSum = 5
     * 输出：[]
     * 示例 3：
     *
     * 输入：root = [1,2], targetSum = 0
     * 输出：[]
     */

    //回溯算法
    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum){
        recur(root,sum);
        return res;
    }
    void recur(TreeNode root, int sum){
        if (root == null){
            return ;
        }
        path.add(root.val);
        sum -= root.val;
        if (sum == 0 && root.left == null && root.right == null){
            //path一直在被复用，递归结束后会删除节点，导致path为空
            res.add(new LinkedList(path));
        }
        recur(root.left,sum);
        recur(root.right,sum);
        path.removeLast();
    }

    public static void main(String[] args) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();
        path.add(5);
        path.add(4);
        path.add(11);
        path.add(2);
        System.out.println(path);
        path.removeLast();
        System.out.println(path.removeLast());
    }
}
class TreeNodeNew {
      int val;
     TreeNode left;
     TreeNode right;
    TreeNodeNew() {}
    TreeNodeNew(int val) { this.val = val; }
    TreeNodeNew(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
      }
  }

