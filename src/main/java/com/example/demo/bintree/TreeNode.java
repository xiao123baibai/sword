package com.example.demo.bintree;

/**
 * 功能描述:
 *
 * @Author: qinlida
 * @Date: 2022/11/16
 */
public class TreeNode<T>{
    public T data;
    public TreeNode<T> left;
    public TreeNode<T> right;

    public TreeNode(T data,TreeNode<T> left,TreeNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public TreeNode(T data) {
        this.data = data;
    }
}