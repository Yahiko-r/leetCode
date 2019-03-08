package list;

import node.ListNode;

public class IntersectionTwoLinkedList {
    public ListNode getIntersectionNode(ListNode headA,ListNode headB){
        if(headA==null||headB==null)return null;
        ListNode p1=headA;
        ListNode p2=headB;
        if(headA==headB)return headA;
        while(p1!=null&&p2!=null){
            p1=p1.next;
            p2=p2.next;
        }
        if(p1==null){
            p1=headB;
        }else{
            p2=headA;
        }
        while(p1!=null&&p2!=null){
            p1=p1.next;
            p2=p2.next;
        }
        if(p1==null){
            p1=headB;
        }else{
            p2=headA;
        }

        while(p1!=null&&p2!=null){
            if(p1==p2){
                return p1;
            }
            p1=p1.next;
            p2=p2.next;
        }
        return null;
    }
}
