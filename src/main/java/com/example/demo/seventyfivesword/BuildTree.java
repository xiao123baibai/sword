package com.example.demo.seventyfivesword;

import java.util.Stack;

/**
 * 重建二叉树
 */
public class BuildTree {
    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
     *
     * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     *
     *
     *
     * 示例 1:
     *
     *
     * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
     * Output: [3,9,20,null,null,15,7]
     * 示例 2:
     *
     * Input: preorder = [-1], inorder = [-1]
     * Output: [-1]
     */
    //战歌走起：前后定根，中分左右
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0){
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);
        int inorderindex = 0;
        for (int i = 1;i < preorder.length;i++){
            int preorderval = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderindex]){
                node.left = new TreeNode(preorder[i]);
                stack.push(node.left);
            }else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderindex]){
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
