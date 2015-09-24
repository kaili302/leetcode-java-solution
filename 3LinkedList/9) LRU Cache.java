import java.util.*;
public class LRUCache {
    int capacity;
    HashMap<Integer, ListNode> map;
    ListNode head, foot;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        map=new HashMap();
        head=new ListNode(0, 0);
        foot=new ListNode(0, 0);
        head.next=foot;
        foot.prev=head;
    }
    
    public void set(int key, int value) {
    	if (map.containsKey(key)){
    		ListNode node=map.get(key);
    		node.value=value;
    		moveToFirst(node);
    	}else{
    		if (isFull()){
    			deleteLast();
    		}
    		ListNode node=new ListNode(key, value);
    		map.put(key, node);
    		moveToFirst(node);
    	}
    }
    
    public int get(int key) {
    	if (map.containsKey(key)){
    		ListNode node=map.get(key);
    		moveToFirst(node);
    		return node.value;
    	}else return -1;
    }
    
    public void moveToFirst(ListNode node){
    	if (node.next==null &&node.prev==null){ // new created node
    		ListNode oldHeadNext=head.next;
    		head.next=node;
    		node.prev=head;
    		node.next=oldHeadNext;
    		oldHeadNext.prev=node;
    	}else{//existed node
    		ListNode oldNodeNext=node.next;
    		ListNode oldNodePrev=node.prev;
    		oldNodePrev.next=oldNodeNext;
    		oldNodeNext.prev=oldNodePrev;
    		//move to head
    		ListNode oldHeadNext=head.next;
    		head.next=node;
    		node.prev=head;
    		node.next=oldHeadNext;
    		oldHeadNext.prev=node;
    	}
    }
    public void deleteLast(){
    	if (foot.prev==null||foot.prev==head) return;
    	ListNode node=foot.prev;
    	map.remove(node.key);
    	foot.prev=foot.prev.prev;
    	foot.prev.next=foot;
    }
    public boolean isFull(){
    	return map.size()==capacity;
    }
}

class ListNode{
	int key;
	int value;
	ListNode prev;
	ListNode next;
	public ListNode(int key, int value){
		this.key=key;
		this.value=value;
		prev=null;
		next=null;
	}
}
/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity,
it should invalidate the least recently used item before inserting a new item.

*/

/*
	Design and implement a data structure for Least Recently Used (LRU) cache. 
	It should support the following operations: get and set. get(key) - 
	Get the value (will always be positive) of the key if the key exists in the cache, 
	otherwise return -1. set(key, value) - Set or insert the value if the key is not already present. 
	When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
*/