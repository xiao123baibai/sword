package com.example.demo.seventyfivesword;

/**
 * 二叉树的最近公共祖先
 */
public class LowestCommonAncestor2 {
    /**
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     *
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
     * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     *
     * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
     *
     *
     *
     *
     *
     * 示例 1:
     *
     * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
     * 输出: 3
     * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
     * 示例 2:
     *
     * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
     * 输出: 5
     * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
     */


    //递归法
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null; // 如果树为空，直接返回null
        if(root == p || root == q) return root; // 如果 p和q中有等于 root的，那么它们的最近公共祖先即为root（一个节点也可以是它自己的祖先）
        TreeNode left = lowestCommonAncestor(root.left, p, q); // 递归遍历左子树，只要在左子树中找到了p或q，则先找到谁就返回谁
        TreeNode right = lowestCommonAncestor(root.right, p, q); // 递归遍历右子树，只要在右子树中找到了p或q，则先找到谁就返回谁
        if(left == null) return right; // 如果在左子树中 p和 q都找不到，则 p和 q一定都在右子树中，右子树中先遍历到的那个就是最近公共祖先（一个节点也可以是它自己的祖先）
        else if(right == null) return left; // 否则，如果 left不为空，在左子树中有找到节点（p或q），这时候要再判断一下右子树中的情况，
            // 如果在右子树中，p和q都找不到，则 p和q一定都在左子树中，左子树中先遍历到的那个就是最近公共祖先（一个节点也可以是它自己的祖先）
        else return root; //否则，当 left和 right均不为空时，说明 p、q节点分别在 root异侧, 最近公共祖先即为 root
    }
    //递归法 自己理解
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q){
        if (root == null){//如果树为null，直接返回null
            return null;
        }
        if (root == q || root == p){//遍历中如果p和q有等于root的，那么他们的最近公共祖先即为root，(一个节点也可以是它自己的祖先)
            return root;
        }
        TreeNode left = lowestCommonAncestor1(root.left,p,q);//递归左子树，只要在左子树中找到了p或q，则先找到谁返回谁
        TreeNode right = lowestCommonAncestor1(root.right,p,q);//递归左子树，只要在左子树中找到了了p和q，则先找到谁返回谁
        if (left == null){//如果在左子树中找不到p和q，那么p和q一定都在右子树中，右子树中先遍历到谁，谁就是那个最近公共祖先（一个节点也可以是他自己的祖先）
            return right;
        }
        if (right == null){//否则，如果left不为空，在左子树中找到节点p或q，这时候要再判断一下右子树中的情况，
            //如果右子树中，p和q都找不到，则p和q一定都在左子树中，左子树中先遍历到谁，谁就是那个最近的公共祖先（一个节点也可以是他自己的祖先）
            return left;
        }
        return root;//否则，左右都不为空，说明p，q分别在root异侧，最近公共祖先为root
    }
}
