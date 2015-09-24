/*
Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete at most two transactions.
Note:
*/

public class Solution {
    public int maxProfit(int[] prices) {
        int len=prices.length;
        if (len<2) return 0;
        int[] max_left=new int[len];
        int[] max_right=new int[len];
        max_right[len-1]=max_right[len-2]=max_left[0]=0;
        int min=prices[0];
        for (int i=1; i<len; i++){
            max_left[i]=Math.max(max_left[i-1], prices[i]-min);
            min=Math.min(min, prices[i]);
        }
        int max=prices[len-1];
        for (int i=len-3; i>=0; i-- ){
            max_right[i]=Math.max(max_right[i+1], max-prices[i+1]);
            max=Math.max(max, prices[i+1]);
        }
        max=0;
        for (int i=0; i<len; i++)   max=Math.max(max, max_right[i]+max_left[i])  ;          
        return max;
    }
}