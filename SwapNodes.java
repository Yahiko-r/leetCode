public class SwapNodes {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }

    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null)return head;
        ListNode p1=new ListNode(0);
        ListNode p2;
        p1.next=head;
        p2=head.next;

        while (head!=null&&head.next != null) {
            p1.next=head.next;
            head.next=p1.next.next;
            p1.next.next=head;
            p1=head;
            head=head.next;
        }
        return p2;
    }

    public static void main(String[] args) {
        SwapNodes sn = new SwapNodes();

    }
}
