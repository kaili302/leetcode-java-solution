/*
Given a binary tree, determine if it is a valid binary search tree (BST).
*/
public boolean isValidBST(TreeNode root) {
    Stack<TreeNode> stack=new Stack();
    TreeNode pointer =root;
    int prev=Integer.MIN_VALUE;
    boolean first=true;    
    while (pointer!=null||!stack.isEmpty()){
        if(pointer!=null){
            stack.push(pointer);
            pointer=pointer.left;
        }else{
            TreeNode node =stack.pop();
            if(node.val <= prev &&first!=true) return false;
            prev=node.val;
            pointer=node.right;
            first=false;
        }
    }
    return true;
}

//错误  无法检测重复情况
public boolean isValidBST(TreeNode root) {
    return helper (root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
}

//正确解法
public boolean helper (TreeNode node, double min, double max){
    if(node==null) return true;
    if (node.val<= min || node.val>=max) return false; 
    return helper (node.left, min, node.val) && helper (node.right, node.val, max);        
} 





