package com.example.demo.bintree;





import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 功能描述:
 *
 * @Author: qinlida
 * @Date: 2022/10/17
 */

public class BinaryTree<T> {

    /**
     * 创建二叉树
     * @param treeData
     * @return
     */
    public TreeNode<T> createBinaryTree(LinkedList<T> treeData){
        TreeNode<T> root = null;
        T data = treeData.removeFirst();
        if (data != null){
            root = new TreeNode<>(data,null,null);
            root.left = createBinaryTree(treeData);
            root.right = createBinaryTree(treeData);
        }
        return root;
    }

    /**
     * 递归先序遍历
     * @param root
     */
    public void PrintBinaryTreePreRecur(TreeNode<T> root){
//        if (root != null){
//            System.out.println(root.data);
//            PrintBinaryTreePreRecur(root.left);
//            PrintBinaryTreePreRecur(root.right);
//        }
        if (root != null){
            System.out.println(root.data);
            PrintBinaryTreePreUnrecur(root.left);
            PrintBinaryTreePreUnrecur(root.right);
        }
    }

    /**
     * 递归中序遍历
     * @param root
     */
    public void PrintBinaryTreeMidRecur(TreeNode<T> root){
        if (root != null){
            PrintBinaryTreeMidRecur(root.left);
            System.out.println(root.data);
            PrintBinaryTreeMidRecur(root.right);
        }
    }

    /**
     * 递归后序遍历
     * @param root
     */
    public void PrintBinaryTreeBacRecur(TreeNode<T> root){
        if (root != null){
            PrintBinaryTreeBacRecur(root.left);
            PrintBinaryTreeBacRecur(root.right);
            System.out.println(root.data);
        }
    }

    /**
     * 先序遍历二叉树（非递归）
     */
    public void PrintBinaryTreePreUnrecur(TreeNode<T> root){
        //当前节点
        TreeNode<T> p = root;
        LinkedList<TreeNode> stack = new LinkedList<>();
        //栈不为空。或者p不为空
        while (p != null || !stack.isEmpty()){
            if (p != null){
                stack.push(p);
                System.out.println(p.data);
                p = p.left;
            }else {
                p = stack.pop();
                p = p.right;
            }
        }
    }

    public void PrintBinaryTreeMidUnrecur(TreeNode<T> root){
        TreeNode<T> p = root;
        LinkedList<TreeNode<T>> stack = new LinkedList<>();

        //栈不为空，或者p不为空时循环
        while (p != null || !stack.isEmpty()){
            if (p != null){
                stack.push(p);
                p = p.left;
            }else {
                p = stack.pop();
                System.out.println(p.data);
                p = p.right;
            }

        }
    }

    public List<Character> PrintBinaryTreeBacUnrecur(TreeNode<Character> root){
        List<Character> res = new ArrayList<Character>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev) {
                res.add(root.data);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }

    public List<Character> myBacUnrecurBinartTree(TreeNode<Character> root){
        List<Character> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        TreeNode prev = null;
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right != null && root.right == prev){
                res.add(root.data);
                prev = root;
                root = null;
            }else {
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }
}

