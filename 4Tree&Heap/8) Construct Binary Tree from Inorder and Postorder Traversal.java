public TreeNode buildTree(int[] inorder, int[] postorder) {
    int len=postorder.length;
    HashMap<Integer, Integer> mapIn=new HashMap();
    for (int i=0; i<len; i++) mapIn.put(inorder[i], i);
    return helper (0, len-1,0, len-1, inorder, postorder, mapIn);
}

public TreeNode helper(int inStart, int inEnd, int postStart, int postEnd, int[] in, int[] post, HashMap<Integer, Integer> mapIn){
    if (inStart>inEnd) return null;
    int inMidVal = post[postEnd];
    TreeNode node = new TreeNode (inMidVal);
    int inMidPos=mapIn.get(inMidVal);
    node.left=helper(inStart, inMidPos-1, postStart, inMidPos-inStart+postStart-1, in, post,mapIn);
    node.right=helper(inMidPos+1, inEnd, inMidPos-inStart+postStart, postEnd-1, in, post, mapIn);
    return node;
}