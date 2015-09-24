/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
For example, given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
the method returns the following:
[
   [5,4,11,2],
   [5,8,4,5]
]
*/

public List<List<Integer>> pathSum(TreeNode root, int sum) {
    ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
    if(root == null)    return res;
    ArrayList<Integer> l=new ArrayList();
    l.add(root.val);
    dfs (root, sum-root.val, res, l);
    return res;
}

public void dfs(TreeNode node, int sum, ArrayList<List<Integer>> res, ArrayList<Integer> l){
    if (node==null) return;
    if (sum==0 && node.left==null && node.right==null) {
        ArrayList<Integer> tmp=new ArrayList();
        tmp.addAll(l);
        res.add(tmp);
    }
    if (node.left!=null){
        l.add(node.left.val);
        dfs (node.left, sum-node.left.val, res, l);
        l.remove(l.size()-1);
    }
    if (node.right!=null){
        l.add(node.right.val);
        dfs (node.right, sum-node.right.val, res, l);
        l.remove(l.size()-1);
    }
}