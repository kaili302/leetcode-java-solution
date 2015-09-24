/*
Given tree and target, print all path with sum equals to target. The path doesn't need to start from root and end at leaf
*/

public void findSum(TreeNode root, int target){
    int depth=depth(root);
    helper();
}

public void helper(TreeNode node, int level, int[] path, int target){
    if (node==null) return;
    path[level]=node.val;
    
    int t=0;
    for (int i=level; i>=0; i--){
        t+=path[i];
        if (t==target){
            print(i, level, path);
        }
    }
    
    helper(node.left, level+1, path, target);
    helper(node.right, level+1, path, target);
}

public int depth(TreeNode node){
    if (node==null) return 0;
    return 1+Math.max(depth(node.left), depth(node.right));
}

public void print (int s, int e, int[] path){
    for (int i=s; i<=e; i++) System.out.print(path[i]+"\t");
    System.out.println();
}
