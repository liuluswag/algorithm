package com.liulu.leetcode;

public class reverseList {
    /**
     * 迭代(双指针)
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        ListNode cur = head;
        ListNode pre =null;
        while(cur != null){
            ListNode tmp = cur.next; // 暂存后继节点cur.next
            cur.next = pre;         // 修改next引用指向
            pre = cur;              // pre暂存cur
            cur = tmp;              // cur 访问下一节点
        }
        return pre;
    }

    /**
     * 递归
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        return recur(head,null); //调用递归并返回
    }

    private ListNode recur(ListNode cur, ListNode pre) {
        if (cur == null)
            return pre;  //终止条件
        ListNode res = recur(cur.next, cur); //递归后继节点
        cur.next = pre; //修改节点引用指向
        return res; //返回反转链表的头节点
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }



}
