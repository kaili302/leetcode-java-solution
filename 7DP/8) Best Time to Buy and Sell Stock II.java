/*
Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. 
You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times).
However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==0) return 0;
        int profit=0, i=0;
        while (i<prices.length-1 && prices[i]>=prices[i+1]) i++;
        if (i==prices.length-1) return 0;
        int buy=i;
        while (i<prices.length-1){
            if (prices[i]>prices[i+1]) {
                profit+=prices[i]-prices[buy];
                buy=i+1;
            }
            i++;
        }
        if (prices[i]>prices[buy]) profit+=prices[i]-prices[buy];
        return profit;
    }
}
public class Solution {
    public int maxProfit(int[] prices) {
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