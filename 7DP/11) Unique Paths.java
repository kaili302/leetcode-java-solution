/*
A robot is located at the top-left corner of a m x n grid. 
It can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid.
How many possible unique paths are there?
*/
public int uniquePaths(int m, int n) {
    int[][] total=new int[m][n];
    for(int i=0; i<m; i++){
        for(int j=0; j<n; j++){
            if (i==0||j==0) total[i][j]=1;
            else total[i][j]=total[i-1][j]+total[i][j-1];
        }
    }
    return total[m-1][n-1];
}

