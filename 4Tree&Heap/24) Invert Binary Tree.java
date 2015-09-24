/*
Invert a binary tree.
     4
   /   \
  2     7
 / \   / \
1   3 6   9
to
     4
   /   \
  7     2
 / \   / \
9   6 3   1
*/

public class Solution {
    public TreeNode invertTree(TreeNode root){
        if (root==null) return null;
        TreeNode invertedLeft=invertTree(root.left);
        TreeNode invertedRight=invertTree(root.right);
        root.left=invertedRight;
        root.right=invertedLeft;
        return root;
    }
}

