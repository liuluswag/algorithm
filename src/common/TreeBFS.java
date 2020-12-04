package common;

import java.util.LinkedList;
import java.util.Queue;

public class TreeBFS {

    public static void treeBFS(TreeNode root) {
        //如果为空直接返回
        if (root == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        //首先把根节点加入队列中
        queue.add(root);
        //如果队列不为空则继续循环
        while(!queue.isEmpty()){
            //poll方法移除队列元素
            TreeNode node = queue.poll();
            //打印当前节点
            System.out.println(node.val);
            //如果当前节点左子树节点不为空，则加入队列
            if (node.left != null)
                queue.add(node.left);
            //如果当前接节点右子树不为空，则加入队列
            if (node.right!=null)
                queue.add(node.right);
        }
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
