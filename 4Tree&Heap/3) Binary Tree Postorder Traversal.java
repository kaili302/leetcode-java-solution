/*
The key to to iterative postorder traversal is the following:
The order of "Postorder" is: left child -> right child -> parent node.
Find the relation between the previously visited node and the current node
Use a stack to track nodes
*/
public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> list=new ArrayList();
    helper(root, list);
    return list;
}
public void helper(TreeNode node, List<Integer> list){
    if(node==null) return;
    helper(node.left, list);
    helper(node.right,list);
    list.add(node.val);
}
//postorder iteratively

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList();
        HashSet<TreeNode> set=new HashSet();
        Stack<TreeNode> stack=new Stack();
        TreeNode pointer=root;
        while (pointer!=null||!stack.isEmpty()){
            if (pointer!=null){
                stack.push(pointer);
                pointer=pointer.left;
            }else {
                TreeNode node=stack.peek();
                if (node.right!=null && !set.contains(node)){
                    set.add(node);
                    pointer=node.right; 
                }else {
                    list.add(node.val);
                    stack.pop();
                }
            }
        }
        return list;
    }
}

