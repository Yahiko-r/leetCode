import node.ListNode;

public class RemoveDuplicatesFromList {
    public ListNode deleteDup(ListNode head){

        ListNode newHead=new ListNode(0);
        newHead.next=head;
        ListNode pre=newHead;
        while(head.next!=null){
            if(head.next.val!=head.val){
                head=head.next;
                if(pre.next!=head)
                    pre=pre.next;

            }else{
                head=head.next;
                pre.next=head.next;

            }
        }
        return newHead.next;
    }
}
