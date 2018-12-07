package list;

import node.ListNode;

public class RotateRight {
    public ListNode rotateRight(ListNode head, int k){
        if(head==null)return null;
        int length=1;
        ListNode tail=head;
        while(tail.next!=null){
            tail=tail.next;
            length++;
        }
        k=k%length;
        if(k==0)return head;
        ListNode p=head;
        for(int i=1;i<length-k;i++){
            p=p.next;
        }
        ListNode newHead=p.next;
        p.next=null;
        tail.next=head;

        return newHead;
    }

}
