package com.example.demo.onehundredandfifty;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 100. 相同的树
 */
public class IsSameTree {
    /**
     * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
     *
     * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
     *
     *
     *
     * 示例 1：
     *
     *
     * 输入：p = [1,2,3], q = [1,2,3]
     * 输出：true
     * 示例 2：
     *
     *
     * 输入：p = [1,2], q = [1,null,2]
     * 输出：false
     * 示例 3：
     *
     *
     * 输入：p = [1,2,1], q = [1,1,2]
     * 输出：false
     *
     *
     * 提示：
     *
     * 两棵树上的节点数目都在范围 [0, 100] 内
     * -104 <= Node.val <= 104
     */
    //广度搜索
    public boolean isSameTree1(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }
        Deque<TreeNode> pdeque = new LinkedList<>();
        Deque<TreeNode> qdeque = new LinkedList<>();
        pdeque.add(p);
        qdeque.add(q);
        while (!pdeque.isEmpty() && !qdeque.isEmpty()){
           TreeNode pNode = pdeque.poll();
           TreeNode qNode = qdeque.poll();
           if (pNode.val != qNode.val){
               return false;
           }
            if (pNode.left == null && qNode.left != null){
                return false;
            }
            if (pNode.left != null && qNode.left == null){
                return false;
            }
            if (pNode.right == null && qNode.right != null){
                return false;
            }
            if (pNode.right != null && qNode.right == null){
                return false;
            }
            if (pNode.left != null){
                pdeque.add(pNode.left);
            }
            if (pNode.right != null){
                pdeque.add(pNode.right);
            }
            if (qNode.left != null){
                qdeque.add(qNode.left);
            }
            if (qNode.right != null){
                qdeque.add(qNode.right);
            }
        }
        return qdeque.isEmpty() && pdeque.isEmpty();
    }
    //深度搜索
    public boolean isSameTree(TreeNode p, TreeNode q){
        if (p == null && q == null){
            return true;
        } else if (p == null || q == null) {
            return false;
        }else if (p.val != q.val){
            return false;
        }else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}
