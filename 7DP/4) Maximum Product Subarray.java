/*
Find the contiguous subarray within an array (containing at least one number) which has the largest product.
For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has the largest product = 6.
*/
public class Solution {
    public int maxProduct(int[] A) {
        int thisMin=A[0], thisMax=A[0], max=A[0];
        for (int i=1; i<A.length; i++){
            int tmp=thisMin;
            thisMin=Math.min(Math.min(thisMin*A[i], thisMax*A[i]), A[i]);
            thisMax=Math.max(Math.max(tmp*A[i], thisMax*A[i]), A[i]);
            max=Math.max(thisMax, max);
        }
        return max;    
    }
}