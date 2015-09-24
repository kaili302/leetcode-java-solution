/*
A robot is located at the top-left corner of a m x n grid. 
It can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid.
*/
public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] sum=new int[n][m];
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if(i==0 || j==0) sum[i][j]=1;
                else sum[i][j]=sum[i][j-1]+sum[i-1][j];
            }
        }    
        return sum[n-1][m-1];
    }
}
