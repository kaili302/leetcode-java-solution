/*
Given a m x n grid filled with non-negative numbers, 
find a path from top left to bottom right which 
minimizes the sum of all numbers along its path.
*/
public class Solution {
    public int minPathSum(int[][] grid) {
        int h=grid.length, w= grid[0].length;
        int[][] minSum=new int[h][w];
        helper(minSum, grid, h-1, w-1);
        return minSum[h-1][w-1];
    }
    
    public int helper (int[][] minSum, int[][] grid, int i, int j){
        if (minSum[i][j]!=0) return minSum[i][j];
        int left, up;
        if (i==0 && j==0) minSum[i][j]=grid[i][j];
        else if(i==0) minSum[i][j]=grid[i][j]+helper(minSum, grid, i, j-1);
        else if(j==0) minSum[i][j]=grid[i][j]+helper(minSum, grid, i-1, j);
        else minSum[i][j]=grid[i][j]+Math.min(helper(minSum, grid, i, j-1), helper(minSum, grid, i-1, j));
        return minSum[i][j];
    }
    
    
    
    //non recurtion
    public int minPathSum(int[][] grid) {
        int h=grid.length, w= grid[0].length;
        int[][] minSum=new int[h][w];
        minSum[0][0]=grid[0][0];
        for (int j=1; j<w; j++)
            minSum[0][j]=minSum[0][j-1]+grid[0][j];
        for (int i=1; i<h; i++)
            minSum[i][0]=minSum[i-1][0]+grid[i][0];
            
        for (int i=1; i<h; i++){
            for(int j=1; j<w; j++){
                minSum[i][j]=grid[i][j]+Math.min(minSum[i-1][j],minSum[i][j-1]);
            }
        }
        return minSum[h-1][w-1];
    }
    
}
