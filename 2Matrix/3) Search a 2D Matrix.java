public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int countR=matrix.length, countC=matrix[0].length; 
        int lo=0, hi=countR-1, line;
        while(lo<hi){
            int mid=(lo+hi)/2;
            if(matrix[mid][0]>target)   hi=mid-1;
            else if(matrix[mid][0]<target)  {
                if(lo!=mid) lo=mid;
                else if(matrix[hi][0]>target) hi=lo;
                else lo=hi;
            }else return true;
        }
        if(target<matrix[lo][0]||target>matrix[hi][countC-1]) return false;
        //lo==hi
        line=lo;
        lo=0; hi=countC-1;
        while(lo<=hi){
            int mid=(lo+hi)/2;
            if(matrix[line][mid]>target) hi=mid-1;
            else if(matrix[line][mid]<target)  lo=mid+1;    
            else return true;
        }
        return false;
    }
}



/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has properties:

1) Integers in each row are sorted from left to right. 2) The first integer of each row is greater than the last integer of the previous row.

For example, consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.

*/