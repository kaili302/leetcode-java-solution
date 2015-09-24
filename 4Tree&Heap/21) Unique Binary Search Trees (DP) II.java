/*
Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
For example, Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }
    
    public ArrayList<TreeNode> helper (int start, int end) {
        ArrayList<TreeNode> list =new ArrayList();
        if (start>end){
            list.add(null);
            return list;
        }
        for (int i=start; i<=end; i++){
            ArrayList<TreeNode> lefts = helper (start, i-1);
            ArrayList<TreeNode> rights = helper (i+1, end);
            for (TreeNode left : lefts){
                for (TreeNode right : rights){
                    TreeNode node=new TreeNode(i);
                    node.left=left;
                    node.right=right;
                    list.add(node);
                }
            }
        }    
        return list;
    }
}