/*
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
You must do this in-place without altering the nodes' values.
For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.

ListNode head=n1; 
		for (int i=2; i<=20; i++){
		    ListNode n = new ListNode(i);
		    n1.next=n;
		    n1=n1.next;
		}
 
*/

public void reorderList(ListNode head) {
    if(head==null||head.next==null) return head;
    //find middle node
    ListNode fast=head.next, slow=head;
    while(fast!=null&&fast.next!=null){
        fast=fast.next.next;
        slow=slow.next;
    }
    //reorder second list
    ListNode second=reverse(slow.next);
    slow.next=null;
    //merge 
    return merge(head, second);    
}

public ListNode reverse(ListNode node){
    if (node==null||node.next==null) return node;
    ListNode prev=node, curr=node.next;
    while (curr!=null){
        ListNode tmp =curr.next;
        curr.next=prev;
        prev=curr; 
        curr=tmp;
    }
    node.next=null;
    return prev;
}
public ListNode merge(ListNode l1, ListNode l2){
    //p longer than q
    if(l2==null) return l2;
    ListNode p1=l1, p2=l2;
    while(p2!=null){
        ListNode tmp1=p1.next, tmp2=p2.next;
        p1.next=p2;
        p2.next=tmp1;
        p1=tmp1;
        p2=tmp2;
    }
    return l1;
}


//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! time 2 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
public class Solution {
    public void reorderList(ListNode head) {
        if (head==null||head.next==null) return;
        ListNode slow=head, fast=head.next;
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode head2=slow.next; 
        slow.next=null;
        
        head2=reverseList(head2);
        mergeList(head, head2);    
    }
    
    public ListNode reverseList(ListNode head){
        ListNode prev=head, curr=head.next, tmp;
        head.next=null;
        while(curr!=null){
            tmp=curr.next; 
            curr.next=prev;
            prev=curr;
            curr=tmp;
        }
        return prev;
    }
    
    public void mergeList(ListNode head1, ListNode head2){
        ListNode p1=head1, p2=head2, tmp1, tmp2;
        while (p2!=null){
            tmp1=p1.next;
            tmp2=p2.next;
            p1.next=p2;
            p2.next=tmp1; 
            p1=tmp1; 
            p2=tmp2;
        }
    }
}



