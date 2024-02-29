package com.example.demo.seventyfivesword;

import java.util.*;

public class dfsAndbfs {
    //前序 dfs

    //递归
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> results = new ArrayList<>();
        preorderRecur(root, results);
        return results;
    }
    private void preorderRecur(TreeNode root, List <Integer> results){
        if (root == null){
            return;
        }
        results.add(root.val);
        preorderRecur(root.left, results);
        preorderRecur(root.right, results);
    }
    //迭代
    public List<Integer> preorderTraversal1(TreeNode root){
        List<Integer> results = new ArrayList<>();
        if (root == null){
            return results;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            results.add(node.val);
            if (node.right != null){
                stack.push(node.right);
            }
            if (node.left != null){
                stack.push(node.left);
            }
        }
        return results;
    }

    //中序 dfs
    // 递归
    public List <Integer> inorderTraversal(TreeNode root) {
        List < Integer > results = new ArrayList < > ();
        inorderRecur(root, results);
        return results;
    }

    private void inorderRecur(TreeNode root, List <Integer> results) {
        if(root == null) return;
        inorderRecur(root.left, results);
        results.add(root.val);
        inorderRecur(root.right, results);
    }

    public List <Integer> inorderTraversal1(TreeNode root){
        List<Integer> results = new ArrayList<>();
        if (root == null){
            return results;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            results.add(cur.val);
            cur = cur.right;
        }
        return results;
    }

    //后序
    //递归
    public List < Integer > postorderTraversal(TreeNode root) {
        List < Integer > results = new ArrayList < > ();
        postorderRecur(root, results);
        return results;
    }

    private void postorderRecur(TreeNode root, List < Integer > results) {
        if(root == null) return;
        postorderRecur(root.left, results);
        postorderRecur(root.right, results);
        results.add(root.val);
    }
    public List < Integer > postorderTraversal1(TreeNode root){
        List < Integer > results = new ArrayList < > ();
        if(root == null) return results;
        Stack < TreeNode > stack = new Stack < > ();
        TreeNode cur = root;
        TreeNode pre = null;
        while (!stack.isEmpty() || cur != null){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.right == null || cur.right == pre){
                results.add(cur.val);
                pre = cur;
                stack.pop();
                cur = null;
            }else {
                cur = cur.right;
            }
        }
        return results;
    }
    //广度遍历
    public List < List < Integer >> levelOrder(TreeNode root) {
        List < List < Integer >> res = new ArrayList < > ();
        if(root == null) return res;
        Queue< TreeNode > queue = new LinkedList< >();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List < Integer > list = new ArrayList < > ();
            while(size > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                size--;
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            res.add(list);
        }
        return res;
    }
}
