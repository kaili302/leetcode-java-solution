/*
Given a binary tree, flatten it to a linked list in-place.
*/
public void flatten(TreeNode root) {
    Stack<TreeNode> stack=new Stack();
    TreeNode pointer=root;
    while(pointer!=null||!stack.isEmpty()){
        if (pointer.left!=null) {
            if (pointer.right!=null) stack.push(pointer.right);
            pointer.right=pointer.left;
            pointer.left=null;
        }else if(pointer.left==null&&pointer.right==null&&!stack.isEmpty()){
            pointer.right=stack.pop();
        }
        pointer=pointer.right;
    }
}
