/*
Follow up for "Unique Paths":
Now consider if some obstacles are added to the grids. How many unique paths would there be?
An obstacle and empty space is marked as 1 and 0 respectively in the grid.
For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.
Note: m and n will be at most 100.
*/

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int h=obstacleGrid.length;
        int w=obstacleGrid[0].length;
        int[][] total =new int[h][w];
        for (int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if(obstacleGrid[i][j]==1) total[i][j]=0;
                else{
                    if (i==0&&j==0) total[i][j]=1;
                    else if (i==0) total[i][j]=total[i][j-1];
                    else if (j==0) total[i][j]=total[i-1][j];
                    else total[i][j]=total[i-1][j]+total[i][j-1];
                }
            }
        }
        return total[h-1][w-1];
    }
}