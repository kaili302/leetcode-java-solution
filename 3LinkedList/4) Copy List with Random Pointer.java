//HashMap
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> map=new HashMap();
        RandomListNode copyHead=new RandomListNode(0), copyP=copyHead;
        while(head!=null){
            RandomListNode copy=new RandomListNode(head.label);
            copy.random=head.random;
            copyP.next=copy;
            copyP=copyP.next;
            map.put(head,copy);
            head=head.next;
        }
        copyP=copyHead.next;
        while(copyP!=null){
            if(copyP.random!=null) copyP.random=map.get(copyP.random);
            copyP=copyP.next;
        }
        return copyHead.next;
    }
}

/*
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
Return a deep copy of the list.
*/
class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
}