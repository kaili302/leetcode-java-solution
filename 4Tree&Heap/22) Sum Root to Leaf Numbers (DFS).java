int sum=0;
public int sumNumbers(TreeNode root) {
    if (root!=null) dfs(root, root.val);
    return sum;
}
public void dfs (TreeNode node, int curr){
    if (node==null) return;
    if (node.left==null&&node.right==null)  sum +=curr;
    if (node.left!=null)    dfs(node.left, curr*10+node.left.val);
    if (node.right!=null)   dfs(node.right, curr*10+node.right.val);
}

//*******************************
public int sumNumbers(TreeNode root) {
    if(root==null) return 0;
    return dfs(root, 0, 0);
}
public int dfs (TreeNode node, int prev, int sum){
    if (node==null) return 0;
    if (node.left==null&&node.right==null)  {
        sum +=prev*10+node.val;
        return sum;
    }
    return dfs(node.left, prev*10+node.val, sum)+dfs(node.right, prev*10+node.val, sum);
}

/*
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number. Find the total sum of all root-to-leaf numbers.
For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Return the sum = 12 + 13 = 25.
*/
int sum=0;
public int sumNumbers(TreeNode root) {
    if (root!=null) helper(root, sum);
    return sum;
}
public void helper(TreeNode node, int num){
    num=num*10+node.val;
    if(node.left!=null) helper(node.left, num);
    if(node.right!=null) helper(node.right, num);
    if (node.left==null&&node.right==null) sum+=num;
}

