public class Solution {
    public int[][] generateMatrix(int n) {
        int res[][]=new int[n][n];
        if(n==0) return res;
        if(n==1) {
            res[0][0]=1;
            return res;
        }
        int left=0, up=0, right=n-1, down=n-1;
        int count=1;
        while(left<right&&up<down){
            //up
            for (int i=left; i<=right; i++) res[up][i]=count++;
            //right
            for (int i=up+1; i<=down; i++) res[i][right]=count++;
            //down
            for (int i=right-1; i>=left; i--) res[down][i]=count++;
            //left
            for (int i=down-1; i>up; i--) res[i][left]=count++;
            left++; right--;
            up++; down--;
        }
        
        if (up==down&&left==right) res[up][left]=count++;
        return res;
    }
}


/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
For example, given the following matrix:
*/