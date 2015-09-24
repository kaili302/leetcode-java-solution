public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head==null) return false;
        ListNode fast=head, slow=head;
        while (fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if (fast==slow) break;
        }
        return (fast.next==null||fast.next.next==null)? false: true;
    }
}