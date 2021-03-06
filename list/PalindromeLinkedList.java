package list;

import node.ListNode;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            fast = fast.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        slow = reverse(slow);
        fast = head;
        while(slow!=null){
            if(fast.val!=slow.val){
                return false;
            }
            fast=fast.next;
            slow=slow.next;
        }
        return true;
    }
        private ListNode reverse(ListNode head){
            ListNode pre=null;
            while(head!=null){
                ListNode next=head.next;
                head.next=pre;
                pre=head;
                head=next;
            }
            return pre;
        }

}
