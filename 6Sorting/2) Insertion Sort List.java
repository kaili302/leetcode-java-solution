class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode curr=head, node, toInsert;
        while(curr.next!=null){
            toInsert=curr.next;
            node=head;
            if(toInsert.val<=node.val){
                curr.next=toInsert.next;
                toInsert.next=node;
                head=toInsert;
                continue;
            }     
            while(node!=curr&&node.next.val<=toInsert.val)  node=node.next;
            if(node==curr) curr=curr.next;
            else{
                curr.next=toInsert.next;
                toInsert.next=node.next;            
                node.next=toInsert;
            }
        }
        return head;
    }
}