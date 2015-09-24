/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
*/
public class Solution {
    public int minPathSum(int[][] a) {
        int w=a[0].length, h=a.length;
        int[][] sum=new int[h][w];
        for (int i=0; i<h; i++){
            for (int j=0; j<w; j++){
                if(i==0 &&j==0) sum[i][j]=a[i][j];
                else if (i==0) sum[i][j]=a[i][j]+sum[i][j-1];
                else if (j==0) sum[i][j]=a[i][j]+sum[i-1][j];
                else sum[i][j]=a[i][j]+Math.min(sum[i][j-1],sum[i-1][j]);
            }
        }    
        return sum[h-1][w-1];
    }
}