/*
Given a singly linked list, determine if it is a palindrome.
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 //正常递归的方法 把后半部分直接反序就好了
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head==null|| head.next==null) return true;
        ListNode fast=head.next, slow=head;
        while (fast!=null && fast.next!=null) {
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode head2=slow.next;
        slow.next=null;
        head2=reverseList(head2);
        while (head2!=null){
            if (head2.val!=head.val) return false;
            head2=head2.next;
            head=head.next;
        }
        return true;
    }
    public ListNode reverseList(ListNode head){
        ListNode prev=head;
        ListNode curr=head.next;
        prev.next=null;
        while (curr!=null){
            ListNode tmp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=tmp;
        }    
        return prev;
    }
}