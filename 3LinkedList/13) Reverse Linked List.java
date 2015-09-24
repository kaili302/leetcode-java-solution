/*Reverse a singly linked list.*/
public ListNode reverseList(ListNode head) {
    if(head==null||head.next==null) return head;
    ListNode prev=head, curr=head.next;
    while(curr!=null){
        ListNode tmp=curr.next;
        curr.next=prev;
        prev=curr;
        curr=tmp;
    }
    head.next=null;
    return prev;
}

//recursively
public ListNode reverseList(ListNode node) {
    if (node==null||node.next==null) 
        return node;
    ListNode second = node.next;
    node.next = null;
    ListNode rest = reverseList(second);
    second.next = node;
    return rest;
}