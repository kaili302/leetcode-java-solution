/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        ListNode head=new ListNode(0);
        ListNode last=head;
        while (l1!=null ||l2!=null||carry!=0){
            carry+=(l1==null?0:l1.val)+(l2==null?0:l2.val);
            last.next=new ListNode(carry%10);
            carry/=10;
            last=last.next;
            l1=(l1==null?null:l1.next); l2=(l2==null?null:l2.next);
        }
        return head.next;
    }
}


/*
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
*/