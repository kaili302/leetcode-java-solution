/*
Merge k sorted linked lists and return it as one sorted list.
Analyze and describe its complexity.
The simplest solution is using PriorityQueue. 
The elements of the priority queue are ordered according to their natural ordering,
or by a comparator provided at the construction time (in this case).
*/

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length==0) return null;
        ListNode head=new ListNode(0), p=head;
        PriorityQueue<ListNode> heap =new PriorityQueue(lists.length, new Comparator<ListNode>(){
            public int compare(ListNode n1, ListNode n2 ){
                return n1.val-n2.val;
            }
        });
        for (ListNode node : lists) {
            if (node!=null) heap.add(node);
        }
        while(!heap.isEmpty()){
            ListNode node=heap.remove();
            if (node.next!=null) heap.add(node.next);
            p.next=node;
            p=p.next;
        }
        return head.next;
    }
}

//复杂度从k*n变成了log(k)*n
/*
I have seen lots of solutions confuse priority queue with heap. I find a good link and list the talk below.
Concept:
1.Heap is a kind of data structure. It is a name for a particular way of storing data that makes certain operations very efficient. We can use a tree or array to describe it.
   18
  / \
 10  16
/ \   / \
9  5  8  12
18, 10, 16, 9, 5, 8, 12
2.Priority queue is an abstract datatype. It is a shorthand way of describing a particular interface and behavior, and says nothing about the underlying implementation.
A heap is a very good data structure to implement a priority queue. The operations which are made efficient by the heap data structure are the operations that the priority queue interface needs.

*/
