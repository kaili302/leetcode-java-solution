/*
Given a complete binary tree, count the number of nodes.
*/
//经典在else return!!!!!!!!!!!
public int countNodes(TreeNode root) {
    int countL=0, countR=0;
    TreeNode node=root;
    while (node!=null) {
        countL++;
        node=node.left;
    }
    node=root;
    while (node!=null) {
        countR++;
        node=node.right;
    }
    if (countL==countR) return (1<<countL)-1;
    else return 1+countNodes(root.left)+countNodes(root.right);
}