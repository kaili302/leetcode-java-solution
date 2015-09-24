/*
Given an array of non-negative integers, you are initially positioned at the first index of the array. 
Each element in the array represents your maximum jump length at that position.
Determine if you are able to reach the last index. For example: A = [2,3,1,1,4], return true. A = [3,2,1,0,4], return false.
*/

public class Solution {
    public boolean canJump(int[] A){
        if (A.length==0) return true;
        int max_i=0;
        for (int i=0; i<A.length; i++){
            if(A[i]!=0) max_i=Math.max(max_i, i+A[i]);
            else if(max_i<i ||(max_i==i&&max_i!=A.length-1)) return false;
            if(max_i>=A.length-1) return true;
        }
        return true;
    }
}
