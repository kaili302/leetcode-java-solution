/**
 * Definition for binary tree with next pointer.
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
 * 
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root==null) return;
        TreeLinkNode preHead=root, preLast=root, currHead=root.left, currLast=root.left;
        while (currHead!=null){
            while (preLast!=null){
                currLast.next=preLast.right;
                currLast=currLast.next;
                preLast=preLast.next;
                if (preLast!=null) {
                    currLast.next=preLast.left;
                    currLast=currLast.next;
                }
            }            
            preHead=preLast=currHead;
            currLast=currHead=currHead.left;
        }
    }
}