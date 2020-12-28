package com.liulu.offer;

public class IsSymmetrical {


    public boolean isSymmetrical(TreeNode pRoot){
        if(pRoot == null)
            return true;
        return sym(pRoot.left,pRoot.right);
    }

    private boolean sym(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val)
            return false;
        return sym(left.left,right.right) && sym(left.right,right.left);
    }


    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
