/*
Given a string s, partition s such that every substring of the partition is a palindrome. Return the minimum cuts needed for a palindrome partitioning of s. 
For example, given s = "aab", return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
*/
public class Solution {
    public int minCut(String s) {
        int len=s.length();
        if (len<=1) return 0;
        boolean[][] dp=new boolean[len][len];
        //init dp dp[i][j] means isPal (i to j) j<=i
        for (int i=0; i<len; i++){
            for (int j=0; j<=i; j++){
                dp[j][i]=(s.charAt(i)==s.charAt(j))&&(i-j<=2||dp[j+1][i-1]);
            }
        }
        
        int[] cuts=new int[len];
        int min;
        for (int i=0; i<len; i++){
            min=i;
            for (int j=0; j<=i; j++){
                if (dp[j][i]){
                    min=Math.min(min, j==0?0:cuts[j-1]+1);
                }
            }
            cuts[i]=min;
        }
        return cuts[len-1];
    }
}