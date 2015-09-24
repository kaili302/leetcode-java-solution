/*use m+n spaces*/
public void setZeroes(int[][] matrix) {
    HashSet<Integer> row=new HashSet();
    HashSet<Integer> col=new HashSet();
    for(int i=0; i<matrix.length; i++){
        for(int j=0; j<matrix[0].length; j++){
            if(matrix[i][j]==0){
                row.add(i);
                col.add(j);
            }
        }
    }
    for (int i: row){
        for(int j=0; j<matrix[0].length; j++){
            matrix[i][j]=0;
        }
    }
    for (int j: col){
        for(int i=0; i<matrix.length; i++){
            matrix[i][j]=0;
        }
    }
}

public class Solution {

public void setZeroes(int[][] matrix) {
    boolean firstRowZero=false, firstColZero=false;
    for(int i=0; i<matrix.length; i++){
        if (matrix[i][0]==0) firstColZero=true;
    }
    for(int i=0; i<matrix[0].length; i++){
        if (matrix[0][i]==0) firstRowZero=true;
    }
    for(int i=1; i<matrix.length; i++){
        for (int j=1; j<matrix[0].length; j++){
               if(matrix[i][j]==0){
                   matrix[i][0]=0;
                   matrix[0][j]=0;
               }     
        }
    }
    for (int i=1; i<matrix.length; i++){
        if(matrix[i][0]==0){
            for (int j=1; j<matrix[0].length; j++){
                matrix[i][j]=0;
            }
        }
    }
    for (int j=1; j<matrix[0].length; j++){
        if(matrix[0][j]==0){
            for (int i=1; i<matrix.length; i++){
                matrix[i][j]=0;
            }
        }
    }
    if(firstRowZero){
        for (int j=0; j<matrix[0].length; j++)  matrix[0][j]=0;
    }
    if(firstColZero){
        for (int i=0; i<matrix.length; i++)  matrix[i][0]=0;
    }
}
}


/*
Given a m x n matrix, if an element is 0,
set its entire row and column to 0. Do it in place.
*/