/*
Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete at most k transactions.
Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/

public class Solution {
    public int maxProfit(int k, int[] prices) {
        int len=prices.length;
        if (len<=1) return 0;
        if (k>=len/2) return maxProfitInf(prices);
        int [][] t=new int[k+1][len];
        for (int i=1; i<=k; i++){
            int tmpMax=-prices[0];
            for (int j=1; j<len; j++){
                t[i][j]=Math.max(t[i][j-1], tmpMax+prices[j]);
                tmpMax=Math.max(tmpMax, t[i-1][j-1]-prices[j]);
            }
        }
        return t[k][len-1];    
    }
    public int maxProfitInf(int[] prices) {
        int profit=0, buyAt=-1, i=0;
        for (; i<prices.length-1; i++){
            if (prices[i]<prices[i+1]&&buyAt==-1) buyAt=i;
            else if (prices[i]>prices[i+1]&&buyAt!=-1){
                profit+=prices[i]-prices[buyAt];
                buyAt=i+1;
            }
        }
        return (buyAt>=0&&prices[i]>prices[buyAt])? profit+prices[i]-prices[buyAt]: profit;
    }
}