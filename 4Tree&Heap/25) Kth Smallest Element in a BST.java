/*
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it. (1 ≤ k ≤ BST's total elements)
*/

//use inorder
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack =new Stack();
        TreeNode p=root;
        while (p!=null||!stack.isEmpty()){
            if (p!=null) {
                stack.push(p);
                p=p.left;
            }else{
                TreeNode node = stack.pop();
                k--;
                if (k==0) return node.val;
                p=node.right;
            }
        }
        return -1;
    }
}