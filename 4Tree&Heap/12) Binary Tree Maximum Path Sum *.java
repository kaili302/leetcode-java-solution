/*
Given a binary tree, find the maximum path sum. The path may start and end at any node in the tree. For example, given the below binary tree
       1
      / \
     2   3
the result is 6.
*/

public class Solution {
    int max;
    public int maxPathSum(TreeNode root) {
        if (root==null) return 0;
        max=root.val;
        helper (root);
        return max;
    }
    
    public int helper(TreeNode node){
        if (node==null) return 0;
        int leftMax=helper(node.left);
        int rightMax=helper(node.right);
        int sum=node.val +Math.max(leftMax, 0)+Math.max(rightMax, 0);
        max=Math.max(sum, max);
        return node.val+Math.max((leftMax>0?leftMax:0), (rightMax>0?rightMax:0));
    }
}