/*
Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
*/
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val>q.val) {
            TreeNode tmp=p;
            p=q;
            q=tmp;
        }
        if (root.val==p.val) return p;
        else if (root.val==q.val) return q;
        else if (root.val>p.val){
            if (root.val<q.val) return root;
            else return lowestCommonAncestor(root.left, p, q);
        }else return lowestCommonAncestor(root.right, p, q);
    }
}