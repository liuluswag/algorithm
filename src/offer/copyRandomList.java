package offer;

import java.util.HashMap;
import java.util.Map;

public class copyRandomList {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /**
     * 解法一：哈希表
     * @param head
     * @return
     */
    public Node copyRandomList1(Node head) {
        if (head == null)
            return null;
        Node cur = head;
        Map<Node,Node> map = new HashMap<>();
        while(cur!=null){
            map.put(cur,new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur !=null ){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    /**
     * 拼接 + 拆分
     * @param head
     * @return
     */
    public Node copyRandomList2(Node head) {
        if (head == null)
            return null;
        Node cur = head;
        //1.复制各节点并构建链表
        while(cur != null){
            Node tmp = new Node(cur.val);
            tmp.next = cur.next;
            cur.next = tmp;
            cur = tmp.next;
        }
        //构建各新节点的random指向
        cur = head;
        while(cur != null){
            if (cur.random != null)
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        //拆分为两链表
        cur = head.next;
        Node pre = head,res = head.next;
        while(cur.next!=null){
            pre.next = pre.next.next;
            cur.next = cur.next.next;
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = null;
        return res;
    }



}
