public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode node=head, prev=null;
    	while(node!=null){
    	    if (node.next!=null && node.next.val!=node.val) prev=node;
    	    else if (node.next!=null) {
    	        while(node.next!=null && node.next.val==node.val)
                    node.next=node.next.next;
                if (prev!=null) prev.next=node.next;
                else head=node.next;
    	    }
            node=node.next;
    	}
    	return head;
    }
}