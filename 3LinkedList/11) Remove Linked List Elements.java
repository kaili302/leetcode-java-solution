public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        while(head!=null && head.val==val) head=head.next; 
        ListNode node=head;
        while(node!=null){
            while(node.next!=null && node.next.val==val) node.next=node.next.next;
            node=node.next;
        }
        return head;
    }
}
/*
Remove all elements from a linked list of integers that have value val.
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5
*/