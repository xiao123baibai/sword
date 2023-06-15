package com.example.demo.stack;

import com.example.demo.bintree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 功能描述:
 *
 * @Author: qinlida
 * @Date: 2022/11/15
 */
public class RebuildBinaryTree {

    /**
     * 迭代法的本质是若这颗树是一颗只有左子树的树,相当于一条单链表 那中序遍历和先序遍历的结果是反过来的 利用栈来逆序存放 一旦遍历到最左下的地方
     * 就开始弹出栈 若过程中栈顶弹出的和中序遍历从左往右的不想等 则说明不是单链表而是多了个右孩子插在了最后一个弹出的结点的右边
     * @param preorder
     * @param inorder
     * @return
     */
    public static TreeNode buildBinary(int[] preorder, int[] inorder){
        if (preorder == null || preorder.length == 0){
            return null;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);
        int inorderindex = 0;
        for (int i = 1;i<preorder.length;i++){
            int preorderval = preorder[i];
            TreeNode node = stack.peek();
            if ((int)node.data != inorder[inorderindex]){
                node.left = new TreeNode(preorderval);
                stack.push(node.left);
            }else {
                while (!stack.isEmpty() && (int)stack.peek().data == inorder[inorderindex]){
                    node = stack.pop();
                    inorderindex++;
                }
                node.right = new TreeNode(preorderval);
                stack.push(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{3,9,5,6,20,15,7};
        int[] inorder = new int[]{5,9,6,3,15,20,7};
        TreeNode node = buildBinary(preorder,inorder);
        System.out.println(node);
    }

    public static TreeNode<Integer> buildBinary2(int[] preorder,int[] inorder){
        if (preorder == null || preorder.length == 0){
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode<Integer> root = new TreeNode<>(preorder[0]);
        stack.push(root);
        int inorderindex = 0;
        for (int i = 1;i < preorder.length;i++){
            int preorderval = preorder[i];
            TreeNode node = stack.peek();
            if ((int)node.data != inorder[inorderindex]){
                node.left = new TreeNode(preorder[i]);
                stack.push(node.left);
            }else {
                while (!stack.isEmpty() && (int)stack.peek().data == inorder[inorderindex]){
                    node = stack.pop();
                    inorderindex++;
                }
                node.right = new TreeNode(preorderval);
                stack.push(node.right);
            }
        }
        return root;
    }
}
