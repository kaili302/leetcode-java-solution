/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(i                                                                               nt x) { val = x; }
 * }
*/
public class Solution {
    /*recursive solution*/
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList();
        addNodeToList(root, list);
        return list;
    }
    public void addNodeToList(TreeNode node, List<Integer> list){
        if(node==null) return;
        list.add(node.val);
        addNodeToList(node.left, list);
        addNodeToList(node.right, list);
    }
    /*iterative solution*/
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList();
        if (root==null) return list;
        Stack<TreeNode> stack =new Stack();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node=stack.pop();
            list.add(node.val);
            if (node.right!=null) stack.push(node.right);
            if (node.left!=null) stack.push(node.left);
        }     
        return list;
    }
}
/*
Given a binary tree, return the preorder traversal of its nodes' values.
*/