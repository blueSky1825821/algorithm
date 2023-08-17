package node;

public class ReverseList206 {
    static {
        System.out.println("====");
    }
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            //相当于cur.next指向新的地址，但是tmp还是指向原来的cur.next
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    public static void main(String[] args) {
        System.out.println("main");
        ListNode listNode = new ReverseList206().reverseList(new ListNode(1, new ListNode(2, new ListNode(3))));
        System.out.println(listNode);
    }
}
