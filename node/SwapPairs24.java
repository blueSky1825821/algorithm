package node;

public class SwapPairs24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy.next;


        while (cur != null && cur.next != null) {
            ListNode tmp = cur.next;
            cur.next = cur.next.next;
            tmp.next = cur;
            cur = cur.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new SwapPairs24().swapPairs(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));
        System.out.println(listNode);
    }
}
