package com.example.demo.bintree;

import java.util.LinkedList;

/**
 * 功能描述:
 *
 * @Author: qinlida
 * @Date: 2022/10/17
 */
public class TestBinaryTree {

    public static void main(String[] args) {
        BinaryTree<Character> binaryTree = new BinaryTree<>();
        LinkedList<Character> tree = new LinkedList<>();
        tree.add('A');tree.add('B');tree.add('D');
        tree.add('H');tree.add(null);tree.add(null);
        tree.add('I');tree.add(null);tree.add(null);
        tree.add('E');tree.add(null);tree.add(null);
        tree.add('C');tree.add('F');tree.add(null);
        tree.add('J');tree.add(null);tree.add(null);
        tree.add('G');tree.add(null);tree.add(null);

        TreeNode<Character> root = binaryTree.createBinaryTree(tree);
//        binaryTree.PrintBinaryTreePreRecur(root);
//        System.out.println();
//        binaryTree.PrintBinaryTreeMidRecur(root);
//        System.out.println();
//        binaryTree.PrintBinaryTreeBacRecur(root);
//        System.out.println();
        binaryTree.PrintBinaryTreePreUnrecur(root);

    }
}
