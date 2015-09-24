/*
 HashSet solution
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet <ListNode> set =new HashSet();
        while(headA!=null){
            set.add(headA);
            headA=headA.next;
        }
        while(headB!=null){
            if(set.contains(headB)) return headB;
            else headB=headB.next;
        }        
        return null;
    }
}

/*
 Inplace solution
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headB==null||headA==null) return null;
        ListNode pA=headA, pB=headB; 
        int countA=0, countB=0;
        while(pA!=null && pB!=null) {
            pA=pA.next;
            pB=pB.next;
        }
        int diff=0;
        ListNode countP=(pA==null?pB:pA);
        while(countP!=null){
            countP=countP.next;
            diff++;
        }
        if(diff>0){
            if(pA==null)
                for(int i=0; i<diff; i++) headB=headB.next;
            else
                for(int i=0; i<diff; i++) headA=headA.next;
        }
        while(headA!=null){
            if (headA==headB) break;
            else {
                headA=headA.next;
                headB=headB.next;
            }
        }
        return headA;
    }
}





/*
Write a program to find the node at which the intersection of two singly linked lists begins.
For example, the following two linked lists:

A:          a1 -> a2
                    ->
                      c1 -> c2 -> c3
                    ->           
B:     b1 -> b2 -> b3
begin to intersect at node c1.
*/