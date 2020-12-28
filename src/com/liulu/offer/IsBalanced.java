package com.liulu.offer;

public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;

        return height(root) != -1;
    }

    private int height(TreeNode node) {
        if (node == null)
            return 0;

        // 如果左子树或者右子路返回的高度为-1，直接返回。不再继续向下递归
        int left = height(node.left);
        if (left == -1)
            return -1;

        int right = height(node.right);
        if (right == -1)
            return -1;

        //判断左右子树高度
        if (Math.abs(left - right) >= 2){
            return -1;
        }

        return Math.max(left,right) + 1;
    }

    public boolean isBalanced2(TreeNode root) {
        if(root==null)
            return true;
        return Math.abs(depth(root.left)-depth(root.right))<=1&&isBalanced(root.left)&&isBalanced(root.right);
    }

    public int depth(TreeNode root){
        if(root==null)
            return 0;
        return Math.max(depth(root.left),depth(root.right))+1;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
