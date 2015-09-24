/*Reverse a linked list from position m to n. Do it in-place and in one-pass.
For example: given 1->2->3->4->5->NULL, m = 2 and n = 4, return 1->4->3->2->5->NULL.
*/
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null||head.next==null|| m>=n) return head;
        ListNode helper=new ListNode(0);
        helper.next=head;
        ListNode prev, curr, flag=helper;
        for (int i=1; i<=m-1 && flag!=null; i++) flag=flag.next;
        if (flag==null) return head;
        prev=flag.next;
        curr=prev.next;
        ListNode tmp;
        for (int i=m+1; i<=n &&curr!=null; i++){
            tmp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=tmp;
        }
        flag.next.next=curr;
        flag.next=prev;
        return helper.next;
    }
}