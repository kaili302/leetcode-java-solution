/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
*/
！！！如果只是一个一个遍历 可以只用一个LinkedList. （queue） 每出栈一个 就把它的le, ri分别入栈 这样下来 同样是lever by level


public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList();
        if (root==null) return res;
        LinkedList<TreeNode> prev; 
        LinkedList<TreeNode> curr=new LinkedList();
        curr.add(root);
        while(curr.size()!=0){
            res.add(BT2List(curr));
            prev=curr;
            curr=new LinkedList();
            while (prev.size()!=0){
                TreeNode node=prev.remove();
                if (node.left!=null) curr.add(node.left);
                if (node.right!=null) curr.add(node.right);                
            }
        }
        return res;
    }
    public LinkedList<Integer> BT2List(LinkedList<TreeNode> curr){
        Iterator iter=curr.iterator();
        LinkedList<Integer> list=new LinkedList();
        while(iter.hasNext()){
            TreeNode node=(TreeNode) iter.next();
            list.add(node.val);
        }
        return list;
    }
}