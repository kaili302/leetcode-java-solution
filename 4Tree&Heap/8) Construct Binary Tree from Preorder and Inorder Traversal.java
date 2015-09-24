/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len=preorder.length;
        HashMap<Integer, Integer> mapIn=new HashMap();
        for (int i=0; i<len; i++) mapIn.put(inorder[i], i);
        return helper (0, len-1, 0, len-1, inorder, preorder, mapIn);
    }
    
    public TreeNode helper(int inStart, int inEnd, int preStart, int preEnd, int[] in, int[] pre, HashMap<Integer, Integer> mapIn){
        if (inStart>inEnd) return null;
        int inMidVal=pre[preStart];
        TreeNode node = new TreeNode (inMidVal);
        int k=mapIn.get(inMidVal);
        node.left=helper(inStart, k-1, preStart+1, k-inStart+preStart, in, pre,mapIn);
        node.right=helper(k+1, inEnd, k-inStart+preStart+1, preEnd, in, pre, mapIn);
        return node;
    }
}