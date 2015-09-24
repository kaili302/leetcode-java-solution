public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> list=new ArrayList();
    helper(root, list);
    return list;
}
public void helper(TreeNode node, List<Integer> list){
    if (node==null) return;
    helper (node.left, list);
    list.add(node.val);
    helper (node.right, list);
}

public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> list=new ArrayList();
    TreeNode pointer=root;
    Stack<Integer> stack=new Stack();
    while(pointer!=null||!stack.isEmpty()){
        if(pointer!=null){
            stack.push(pointer);
            pointer=pointer.left;
        }else{
            TreeNode node =stack.pop();
            list.add(node.val);
            pointer=node.right;
        }
    }
}


