public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode node=head, tmp, prev=new ListNode(0);
        head=prev;
        while(node!=null&&node.next!=null){
            tmp=node.next.next;
            prev.next=node.next;    
            node.next.next=node;
            node.next=tmp;
            prev=node;
            node =tmp;
        }
        return head.next;
    }
}


/*
Given a linked list, swap every two adjacent nodes and return its head.
For example, given 1->2->3->4, you should return the list as 2->1->4->3.
Your algorithm should use only constant space. 
You may not modify the values in the list, only nodes itself can be changed.
*/