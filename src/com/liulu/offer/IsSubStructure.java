package com.liulu.offer;

public class IsSubStructure {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A==null || B == null)
            return false;
        //先从根节点判断是不是A的子结构，如果不是分别从左右子树来判断
        //只要有一个为true，就说明B是A的子结构
        return isSub(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }

    private boolean isSub(TreeNode A, TreeNode B) {
        //这里如果B为空，说明B已经访问完了，确定是A的子结构
        if (B == null)
            return true;
        //如果B不为空A为空，或者这两个节点值不同，说明B树不是
        //A的子结构，直接返回fasle
        if (A == null || A.val != B.val)
            return false;
        //当前节点比较完还要判断左右子节点
        return isSub(A.left,B.left) && isSub(A.right,B.right);
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
