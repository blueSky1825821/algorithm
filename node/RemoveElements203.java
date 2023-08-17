package node;

public class RemoveElements203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new RemoveElements203().removeElements(new ListNode(2, new ListNode(3)), 2);
        System.out.println(listNode);
    }
}
