package com.example.demo.onehundredandfifty;

/**
 * 124. 二叉树中的最大路径和
 */
public class MaxPathSum {
    /**
     * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。
     * 同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
     *
     * 路径和 是路径中各节点值的总和。
     *
     * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
     *
     *
     *
     * 示例 1：
     *
     *
     * 输入：root = [1,2,3]
     * 输出：6
     * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
     * 示例 2：
     *
     *
     * 输入：root = [-10,9,20,null,null,15,7]
     * 输出：42
     * 解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
     *
     *
     * 提示：
     *
     * 树中节点数目范围是 [1, 3 * 104]
     * -1000 <= Node.val <= 1000
     */
    int maxValue = Integer.MAX_VALUE;
    public int maxPathSum(TreeNode root) {
//        maxValue = maxRoute(root);  错误代码的示范，递归只会返回每一层的数据，不会直接返回结果，需要使用全局变量来承接结果
        return maxValue;
    }
    private int maxRoute(TreeNode node){
        if (node == null){
            return 0;
        }
        //递归计算左右子节点的最大贡献值
        int leftRoute = Math.max(maxRoute(node.left),0);
        int rightRoute = Math.max(maxRoute(node.right),0);
        // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
        int nowPath = node.val + leftRoute + rightRoute;
        maxValue = Math.max(maxValue,nowPath);

        return node.val+ Math.max(leftRoute,rightRoute);
    }
}
