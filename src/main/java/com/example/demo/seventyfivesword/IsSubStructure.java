package com.example.demo.seventyfivesword;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 树的子结构
 */
public class IsSubStructure {
    /**
     * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
     *
     * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
     *
     * 例如:
     * 给定的树 A:
     *
     *      3
     *
     *     / \
     *
     *    4   5
     *
     *   / \
     *
     *  1   2
     * 给定的树 B：
     *
     *    4
     *
     *   /
     *
     *  1
     * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
     *
     * 示例 1：
     *
     * 输入：A = [1,2,3], B = [3,1]
     * 输出：false
     * 示例 2：
     *
     * 输入：A = [3,4,5,1,2], B = [4,1]
     * 输出：true
     */
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode9 = new TreeNode(9);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;
        treeNode4.left = treeNode8;
        treeNode4.right = treeNode9;

        TreeNode treeNodeA = new TreeNode(4);
        TreeNode treeNodeB = new TreeNode(8);
        TreeNode treeNodeC = new TreeNode(9);
        treeNodeA.left = treeNodeB;
        treeNodeA.right = treeNodeC;
        boolean res = isSubStructure1(treeNode1,treeNodeA);
    }

    //思路整理：1、循环整个A数  2、B树第一次和A树第一次相同的的节点为开始，
    public static boolean isSubStructure1(TreeNode A,TreeNode B){
        TreeNode subA = findSub(A,B);
        if (subA == null){
            return false;
        }
        Queue<TreeNode> queueA = new LinkedList<TreeNode>(){{add(subA);}};
        Queue<TreeNode> queueB = new LinkedList<TreeNode>(){{add(B);}};
        while (!queueA.isEmpty()){
            int n = queueA.size();
            for (int i = 0; i < n;i++){
                TreeNode tempA = queueA.poll();
                TreeNode tempB = queueA.poll();
                if (tempA.val != tempB.val){
                    return false;
                }
                if (tempA.left != null){
                    queueA.add(tempA.left);
                }
                if (tempA.right != null){
                    queueA.add(tempA.right);
                }
                if (tempB.left != null){
                    queueB.add(tempB.left);
                }
                if (tempB.right != null){
                    queueB.add(tempB.right);
                }
            }
        }
        return true;
    }

    //寻找子节点
    private static TreeNode findSub(TreeNode A,TreeNode B){
        Queue<TreeNode> queue = new LinkedList<TreeNode>(){{add(A);}};
        while (!queue.isEmpty()){
            int n = queue.size();
            for (int i = 0; i < n;i++){
                TreeNode temp = queue.poll();
                if (temp.val == B.val){
                    return temp;
                }
                if (temp.left != null){
                    queue.add(temp.left);
                }
                if (temp.right != null){
                    queue.add(temp.right);
                }
            }
        }
        return null;
    }

    //递归迭代法，寻找对应的节点信息

    public boolean isSubStructure2(TreeNode A,TreeNode B){
        //边界判断
        if (A == null || B == null){
            return false;
        }
        //true成立需要满足的条件

        //判断下面的节点是否满足
        return helper(A,B) || isSubStructure2(A.left,B) || isSubStructure2(A.right,B);
    }

    private boolean helper(TreeNode A1,TreeNode B1){
        //子节点可以随意终止
        if (B1 == null){
            return true;
        }
        //父节点A必须大于B，才能形成包含关系
        if (A1 == null){
            return false;
        }
        //递归判断
        if (A1.val == B1.val &&(helper(A1.left, B1.left) && helper(A1.right,B1.right))){
            return true;
        }else {
            return false;
        }
    }

    private boolean help(TreeNode A1,TreeNode B1){
        if (B1 == null){
            return true;
        }
        if (A1 == null){
            return false;
        }
        if (A1.val == B1.val && (help(A1.left,B1.left) && help(A1.right,B1.right))){
            return true;
        }else {
            return false;
        }
    }
    public boolean isSubStructure(TreeNode A,TreeNode B){
        if (A == null || B == null){
            return false;
        }
        return help(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }

    public boolean isSubStructure3(TreeNode A,TreeNode B){
        if (A == null || B == null){
            return false;
        }
        return help1(A,B) || isSubStructure3(A.left,B) || isSubStructure3(A.right,B);
    }

    private boolean help1(TreeNode A1,TreeNode B1){
        if (B1 == null){
            return true;
        }
        if (A1 == null){
            return false;
        }
        if (A1.val == B1.val && help1(A1.left,B1.left) && help1(A1.right,B1.right)){
            return true;
        }else {
            return false;
        }
    }
}
