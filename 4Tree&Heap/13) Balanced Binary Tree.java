/*
Given a binary tree, determine if it is height-balanced.
For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees 
of every node never differ by more than 1.
*/

public class Solution {
	public boolean isBalanced(TreeNode root) {
        return helper(root)!=-1;
	}
    public int helper(TreeNode node){
        if (node==null) return 0;
        int lh=helper (node.left);
        int rh=helper (node.right);
        if (lh<0||rh<0||lh-rh>1||rh-lh>1) return -1;
        return 1+Math.max(lh, rh);
    }
}