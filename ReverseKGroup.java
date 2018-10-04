
public class ReverseKGroup {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode next, newHead, tail;
        ListNode pre = new ListNode(0);
        newHead = pre;
        pre.next = head;
        tail = head;
        int length = 1;
        while (head.next != null) {
            length++;
            head = head.next;
        }
        for (int j = 0; j < length / k; j++) {
            for (int i = 1; i < k; i++) {
                next = tail.next.next;
                tail.next.next = pre.next;
                pre.next = tail.next;
                tail.next = next;
            }
            pre = tail;
            tail = tail.next;

        }
        return newHead.next;

    }
}
