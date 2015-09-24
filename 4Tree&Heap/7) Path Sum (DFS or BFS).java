/*
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
*/
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //BFS
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        LinkedList<TreeNode> nodeQ=new LinkedList();
        LinkedList<Integer> sumQ=new LinkedList();
        if (root==null) return false;
        nodeQ.add(root); sumQ.add(root.val);
        while (nodeQ.size()!=0){
            int N=nodeQ.size();
            for (int i=0; i<N; i++){
                TreeNode node=nodeQ.remove();
                int s=sumQ.remove();
                if (node.left!=null){
                    nodeQ.add(node.left);
                    sumQ.add(s+node.left.val);
                }
                if (node.right!=null){
                    nodeQ.add(node.right);
                    sumQ.add(s+node.right.val);
                }
                if (node.left==null&&node.right==null && s==sum) return true;
            }
        }
        return false;
    }
}
//Java Solution 2 - Recursion DFS
public boolean hasPathSum(TreeNode root, int sum) {
    if (root==null) return false;
    if (root.val==sum && root.left==null && root.right==null) return true;
    return hasPathSum(root.left, sum-root.val)||hasPathSum(root.right, sum-root.val);
}
