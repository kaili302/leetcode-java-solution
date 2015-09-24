/*
Follow up for problem "Populating Next Right Pointers in Each Node".
What if the given tree could be any binary tree? Would your previous solution still work?
You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
*/
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root==null) return;
        TreeLinkNode preHead=root, preLast=root, currHead=(root.left==null)?root.right:root.left, currLast=currHead;
        while (currHead!=null){
            while (preLast!=null){
                TreeLinkNode currNext=findNext(preLast);
                if (currNext==currLast){
                    if (preLast.left!=null &&preLast.right!=null) currNext=preLast.right;
                    else{
                        preLast=preLast.next;
                        continue;
                    }
                }
                currLast.next=currNext;
                currLast=currLast.next;
                if (preLast.left!=null && currLast==preLast.left && preLast.right!=null){
                    currLast.next=preLast.right;
                    currLast=currLast.next;
                }
                preLast=preLast.next;
            }            
            preHead=preLast=currHead;
            currLast=currHead=findNext(currHead);
        }
    }
    public TreeLinkNode findNext(TreeLinkNode node){
        if (node==null) return null;
        if (node.left!=null) return node.left;
        if (node.right!=null) return node.right;
        node=node.next;
        return findNext(node);
    }
}