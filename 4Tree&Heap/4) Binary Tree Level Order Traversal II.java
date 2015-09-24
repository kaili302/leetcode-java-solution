/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values.
*/
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Stack<ArrayList<Integer>> stack=new Stack();
        List<ArrayList<Integer>> res=new List();
        if (root==null) return res;
        ArrayList<TreeNode> curr=new ArrayList<TreeNode>();
        ArrayList<TreeNode> tmp =new ArrayList<TreeNode>();
        ArrayList<Integer> list=new ArrayList();
        curr.add(root);
        list.add(root.val);
        res.add(list);
        while(curr.size()!=0){
            tmp=new ArrayList(); 
            list=new ArrayList();
            Iterator iter= curr.iterator();
            while(iter.hasNext()){
                TreeNode node=(TreeNode)iter.next();
                if (node.left!=null) {
                    tmp.add(node.left);
                    list.add(node.left.val);                    
                }
                if (node.right!=null) {
                    tmp.add(node.right);
                    list.add(node.right.val);                    
                }
            }
            if (list.size()!=0) stack.push(list);
            curr=tmp;
        }
        while(!stack.isEmpty()) res.add(stack.pop());
        return res;
    }
}