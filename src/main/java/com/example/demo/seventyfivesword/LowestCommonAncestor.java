package com.example.demo.seventyfivesword;

/**
 * 二叉搜索树的最近公共祖先
 */
public class LowestCommonAncestor {
    /**
     * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
     *
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先
     * 且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     *
     * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
     *
     *
     *
     *
     *
     * 示例 1:
     *
     * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
     * 输出: 6
     * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
     * 示例 2:
     *
     * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
     * 输出: 2
     * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
     *
     *
     * 说明:
     *
     * 所有节点的值都是唯一的。
     * p、q 为不同节点且均存在于给定的二叉搜索树中。
     */

    /**
     * 1、递归法
     * if(p.val > q.val) { // 保证 p.val < q.val
     *             TreeNode tmp = p;
     *             p = q;
     *             q = tmp;
     *         }
     *         while(root != null) {
     *             if(root.val < p.val) // p,q 都在 root 的右子树中
     *                 root = root.right; // 遍历至右子节点
     *             else if(root.val > q.val) // p,q 都在 root 的左子树中
     *                 root = root.left; // 遍历至左子节点
     *             else break;
     *         }
     *         return root;
     *
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        //保证p < q
        if(p.val > q.val){
            TreeNode temp = p;
            p = q;
            q = temp;
        }
        while (root != null){
            if (root.val > q.val){
                root = root.left;
            }else if (root.val < p.val){
                root = root.right;
            }else {
                break;
            }
        }
        return root;
    }
    /**
     * 2、迭代法
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        //保证p < q
        if(p.val > q.val){
            TreeNode temp = p;
            p = q;
            q = temp;
        }
        if (root.val > q.val){
            return lowestCommonAncestor2(root.left,p,q);
        }else if (root.val < p.val) {
            return lowestCommonAncestor2(root.right,p,q);
        }
        return root;
    }
}
