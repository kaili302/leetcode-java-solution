public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode node=head;
    	while(node!=null){
    		while (node.next!=null && node.val ==node.next.val) node.next=node.next.next;
    		node=node.next;
    	}
    	return head;
    }
}

/*
Given a sorted linked list, delete all duplicates 
such that each element appear only once.
For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
*/

