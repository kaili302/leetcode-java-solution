public ListNode removeNthFromEnd(ListNode head, int n) {
    if(head==null) return head;
    ListNode fast=head, slow=head;
    while((n--)>0&&fast!=null)
        fast=fast.next;
    if(fast==null) return head.next;
    
    while(fast!=null&&fast.next!=null){
        fast=fast.next;
        slow=slow.next;
    }
    slow.next=slow.next.next;
    return head;
}

/*
Given a linked list, remove the nth node from the end of list and return its head.
For example, given linked list 1->2->3->4->5 and n = 2, the result is 1->2->3->5.
*/