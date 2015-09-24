/*
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null||l2==null) return (l1==null)?l2:l1;
        ListNode last=new ListNode(0), head=last;
        while(l1!=null&&l2!=null){
            if(l1.val<=l2.val) {
                last.next=l1;
                l1=l1.next;
            }else {
                last.next=l2;
                l2=l2.next;
            }
            last=last.next;
        }
        last.next=(l1==null)?l2: l1;
        return head.next;
    }
}



/*
Merge two sorted linked lists and return it as a new list. 
The new list should be made by splicing together the nodes of the first two lists.
*/