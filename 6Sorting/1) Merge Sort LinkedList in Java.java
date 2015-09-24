class ListNode {
	int val;
	ListNode next;
 
	ListNode(int x) {
		val = x;
		next = null;
	}
}
public class Solution {
	public ListNode sortList(ListNode head) {
	    if(head==null||head.next==null) return head;
        ListNode end=head;
        while(end.next!=null) end=end.next;
        return sort(head, end);
    }
	
	public ListNode sort(ListNode head, ListNode end){
	    if (head==end) return head;
	    ListNode fast=head, mid=head;
	    while(fast!=end&&fast.next!=end){
	        fast=fast.next.next;
	        mid=mid.next;
	    }
	    ListNode l2=sort(mid.next, end);
        mid.next=null;
        ListNode l1=sort(head, mid);
	    return merge(l1, l2);
	}
	
	public ListNode merge(ListNode l1, ListNode l2){
	    ListNode head=new ListNode(0), node=head;
	    while(l1!=null&&l2!=null){
            if(l1.val<l2.val) {
                node.next=l1;
                l1=l1.next;
            }else{
                node.next=l2;
                l2=l2.next;
            }
	        node=node.next;
	    }
	    node.next=(l1==null)?l2:l1;
	    while(node.next!=null) node=node.next;
	    return head.next;
	}
}