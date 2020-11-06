package common;

/**
 * 约瑟夫环问题
 */
public class Joseph {

    class Node{
        int date;
        Node next;

        public Node(int date) {
            this.date = date;
        }
    }

    public int solve(int n,int m){
        if (m == 1 || n < 2){
            return n;
        }
        // 创建环形链表
        Node head = createLinkedList(n);
        // 遍历删除
        int count = 1;
        Node cur = head;
        // 前驱节点
        Node pre = null;
        while (cur.next != cur){
            // 删除节点
            if (count == m){
                System.out.println(cur.date + "->");
                pre.next = cur.next;
                cur = pre.next;
                count = 1;
            }else{
                count++;
                pre = cur;
                cur = cur.next;
            }
        }
        return head.date;
    }

    private  Node createLinkedList(int n) {
        Node head = new Node(1);
        Node next = head;
        for (int i = 2; i <= n; i++){
            next.next = new Node(i);
            next = next.next;
        }
        // 头尾串联
        next.next = head;
        return head;
    }

    public static void main(String[] args) {
        Joseph joseph = new Joseph();
        int solve = joseph.solve(41, 3);
        System.out.println(solve);
    }

}
