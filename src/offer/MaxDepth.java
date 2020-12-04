package offer;

import common.TreeBFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaxDepth {

    /**
     * 后序遍历 DFS
     * @param root
     * @return
     */
    public int maxDepth1(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth1(root.left), maxDepth1(root.right)) + 1;
    }

    public int maxDepth2(TreeNode root) {
        //如果为空直接返回
        if (root == null)
            return 0;
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        //首先把根节点加入队列中
        queue.add(root);
        //如果队列不为空则继续循环
        while(!queue.isEmpty()){
            Queue<TreeNode> tmp = new LinkedList<>();
            for(TreeNode node : queue) {
                if(node.left != null) tmp.add(node.left);
                if(node.right != null) tmp.add(node.right);
            }
            queue = tmp;
            res++;
        }
        return res;
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
