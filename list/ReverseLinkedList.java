package list;

import node.ListNode;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head){
        if(head==null)return null;
        ListNode pre=null;
        ListNode now=head;
        ListNode next=head;
        while(now!=null){
            next=now.next;
            now.next=pre;
            pre=now;
            now=next;
        }
        return pre;

    }
}
