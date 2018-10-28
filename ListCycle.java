public void hasCycle(ListNode head){
if(head==null || head.next==null)return false;
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null){
            fast = fast.next;
            slow = slow.next; 
            if(fast!=null){
                fast = fast.next;
            }
            if(fast == slow)return true;
        }
        return false;
}