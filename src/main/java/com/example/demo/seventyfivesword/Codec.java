package com.example.demo.seventyfivesword;

import java.util.LinkedList;

/**
 * 序列化二叉树
 */
public class Codec {
    /**
     * 序列化二叉树
     * 困难
     * 409
     * 相关企业
     * 请实现两个函数，分别用来序列化和反序列化二叉树。
     *
     * 你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，
     * 你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
     *
     * 提示：输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。
     * 你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
     *
     *
     *
     * 示例：
     *
     *
     * 输入：root = [1,2,3,null,null,4,5]
     * 输出：[1,2,3,null,null,4,5]
     */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null){
            return null;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>(){{add(root);}};
        StringBuilder str = new StringBuilder("[");
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if (temp != null){
                str.append(temp.val + ",");
                queue.add(temp.left);
                queue.add(temp.right);
            }else {
                str.append("null,");
            }
        }
        str.deleteCharAt(str.length() - 1);
        str.append("]");
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("[]")) return null;
        String[] values = data.substring(1,data.length()-1).split(",");
        TreeNode root = new TreeNode(Integer.valueOf(values[0]));
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>(){{add(root);}};
        int i = 1;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(!values[i].equals("null")) {
                node.left = new TreeNode(Integer.valueOf(values[i]));
                queue.add(node.left);
            }
            i++;
            if(!values[i].equals("null")) {
                node.right = new TreeNode(Integer.valueOf(values[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }

}
