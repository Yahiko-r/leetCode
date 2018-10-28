public class ReverseNodesInK_Group {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val=x;}

    }
    public ListNode reverseKGroup(ListNode head,int k){
        if(head==null||head.next==null)return head;

        ListNode pro,next,cur;

        pro=head;
        cur=head.next;
        int len=0;
        while(head.next!=null){
            len++;
        }
        int j=0;
        while(j<100) {
            for (int i = 1; i < k; i++) {
                next = cur.next;

                cur.next = pro;
                pro = cur;
                cur = next;
            }
        }
        head.next=cur;
        return pro;
    }
}
