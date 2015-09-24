public class Solution {
	public TreeNode sortedArrayToBST(int[] num) {
        return helper (0, num.length-1, num);
	}
	public TreeNode helper (int lo, int hi, int[] num){
	    if(lo>hi) return null;
	    int mid=(lo+hi)/2;
	    TreeNode node =new TreeNode(num[mid]);
	    node.left=helper(lo, mid-1, num);
	    node.right=helper(mid+1, hi, num);
	    return node;
	}
}