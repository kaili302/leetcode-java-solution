Given a binary tree, find its minimum depth.
The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
Thoughts
LinkedList is a queue in Java. The add() and remove() methods are used to manipulate the queue.
Java Solution

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int minDepth(TreeNode root) {
        if (root=null) return 0;
        LinkedList<TreeNode> prev;
        LinkedList<TreeNode> curr=new LinkedList();
        curr.add(root);
        int count=1;
        while(curr.size()!=0){
            prev=curr;
            curr=new LinkedList();
            while (prev.size()!=0){
                TreeNode node= prev.remove();
                if (node.left==null && node.right==null) return count;
                if (node.left!=null) curr.add(node.left);
                if (node.right!=null) curr.add(node.right);
            }
            count++;
        }
        return count;
    }
}