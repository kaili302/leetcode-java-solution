/*
Now consider if some obstacles are added to the grids. How many unique paths would there be?
An obstacle and empty space is marked as 1 and 0 respectively in the grid. For example, there is one obstacle in the middle of a 3x3 grid as illustrated below,
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
the total number of unique paths is 2.
*/
public class Solution {
    public int uniquePathsWithObstacles(int[][] a) {
        int n=a.length, m=a[0].length;
        int[][] sum=new int[n][m];
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (a[i][j]==1) sum[i][j]=0;
                else {
                    if(i==0 && j==0) sum[i][j]=1;
                    else if (i==0 && j!=0) sum[i][j]=sum[i][j-1];
                    else if (i!=0 && j==0) sum[i][j]=sum[i-1][j]; 
                    else sum[i][j]=sum[i][j-1]+sum[i-1][j];
                }
            }
        }    
        return sum[n-1][m-1];
    }
}