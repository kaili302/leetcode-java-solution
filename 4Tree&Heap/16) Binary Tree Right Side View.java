/*
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom. For example, given the following binary tree,
   1            <---
  /   \
 2     3         <---
  \     
   5             <---
 
You can see [1, 3, 5].
*/

由于用到了queue其实不需要两个linkedlist. 只需要记住每一层node个数 然后前面remove掉这些 后面加入的都是下层的元素

public List<Integer> rightSideView(TreeNode root) {
    ArrayList<Integer> res = new ArrayList<Integer>();
    if(root==null) return res;
    LinkedList<TreeNode> curr=new LinkedList();
    LinkedList<TreeNode> prev;
    curr.add(root); 
    while(curr.size()!=0){
        res.add((curr.get(curr.size()-1)).val);
        prev=curr;
        curr=new LinkedList();
        while(prev.size()!=0){
            TreeNode node=prev.remove();
            if(node.left!=null) curr.add(prev.left);
            if(node.right!=null) curr.add(prev.right);
        }
    }
    return res;
}