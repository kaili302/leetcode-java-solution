/*
为了简化寻找mid时间 可以把LinkedList转换成ArrayList 这样会简单很多很多
或者 用HashMap 来存Hash与index的关系
*/
public class Solution {
	public TreeNode sortedListToBST(ListNode head) {
	    if (head==null) return null;
        ListNode end=head;
        while(end.next!=null) end=end.next;
        return helper (head, end);
	}
	public TreeNode helper(ListNode head, ListNode end){
        if (head==null||end==null) return null;
	    end.next=null;
	    ListNode slow=head, fast=head, prev=null;
	    while (fast.next!=null&&fast.next.next!=null){
	        fast=fast.next.next;
	        prev=slow;
	        slow=slow.next;
	    }
	    TreeNode node=new TreeNode (slow.val);
	    node.left=helper(head, prev);
	    node.right=helper(slow.next, end);
	    return node;
	}
}


/*
Runtime Error Message:
Line 17: java.lang.StackOverflowError
Last executed input:
[3,5,8]

*/