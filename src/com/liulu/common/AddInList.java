package com.liulu.common;

public class AddInList {
    public ListNode addInList(ListNode head1, ListNode head2) {
        ListNode l1 = reversr(head1);
        ListNode l2 = reversr(head2);

        ListNode head = new ListNode(0);
        ListNode prev = head;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0){
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
            carry = sum / 10;
            prev.next = new ListNode(sum % 10);
            prev = prev.next;
            l1 = l1 != null ? l1.next : l1;
            l2 = l2 != null ? l2.next : l2;
        }
        return reversr(head.next);
    }

    private ListNode reversr(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;

        while(cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
