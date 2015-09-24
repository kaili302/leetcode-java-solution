/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
You should preserve the original relative order of the nodes in each of the two partitions.
For example, given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5
*/

//right.next一定要清零 不然会死循环！！！！！！！！！！
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head==null||head.next==null) return head;
        ListNode left=new ListNode(0), right=new ListNode(0), leftHead=left, rightHead=right;
        ListNode node=head; int count=0;
        while(node!=null){
            if(node.val<x){
                left.next=node;
                left=left.next;
            }else{
                right.next=node;
                right=right.next;
            }
            node=node.next;
        }
        right.next=null;
        left.next=rightHead.next;
        return leftHead.next;
    }
}