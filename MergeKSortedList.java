import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedList {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {

        Queue<ListNode> que = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null)
                que.offer(lists[i]);

        }
        ListNode p = new ListNode(0);
        ListNode head = p;
        while (que.size()!=0) {
            p.next = que.poll();
            p = p.next;
            if (p.next != null) {
                que.offer(p.next);
            }
        }
        return head.next;

    }
}
