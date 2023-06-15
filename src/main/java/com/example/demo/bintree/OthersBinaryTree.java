package com.example.demo.bintree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 功能描述:
 *
 * @Author: qinlida
 * @Date: 2022/10/20
 */
public class OthersBinaryTree {
    public List<Character> postorderTraversal(TreeNode<Character> root) {
        // 初始化结果集
        List<Character> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        // 创建栈
        Deque<TreeNode> stack = new LinkedList<>();
        // 标识:上一次处理的节点
        TreeNode prev = null;
        // 如果当前处理节点不为空或者栈中有数据则继续处理
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                // 如果当前处理节点不为空则入栈
                stack.push(root);
                // 寻找左子树
                root = root.left;
            }
            // 拿取栈顶节点
            root = stack.pop();
            // if逻辑
            // root.right == null 表示当前节点为根节点
            // root.right == prev 如果右子树是上一次处理的节点则处理根节点
            // else逻辑
            // 右子树不为空，左子树找到根,根找到右子树，先处理右子树
            if (root.right == null || root.right == prev) {
                res.add(root.data);
                // 打标
                prev = root;
                root = null;
            } else {
                // 重新把根节点入栈，处理完右子树还要回来处理根节点
                stack.push(root);
                // 当前节点为右子树
                root = root.right;
            }
        }
        return res;
    }
}
