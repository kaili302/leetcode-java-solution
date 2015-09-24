public List<Integer> spiralOrder(int[][] matrix) {
    ArrayList<Integer> res=new ArrayList<Integer>();
    if(matrix.length==0) return res;
    int countR=matrix.length, countC=matrix[0].length;
    int left=0, up=0, right=countC-1, down=countR-1;
    while(left<right&&up<down){
        //up
        for (int i=left; i<=right; i++) res.add(matrix[up][i]);
        //right
        for (int i=up+1; i<=down; i++) res.add(matrix[i][right]);
        //down
        for (int i=right-1; i>=left; i--) res.add(matrix[down][i]);
        //left
        for (int i=down-1; i>up; i--) res.add(matrix[i][left]);
        left++; right--;
        up++; down--;
    }
    if (up==down&&right>left) {
        for(int i=left; i<=right; i++) res.add(matrix[up][i]);
    }else if(left==right&&down>up){
        for(int i=up; i<=down; i++) res.add(matrix[i][left]);
    }else if (up==down&&left==right) res.add(matrix[up][left]);
    return res;
}


/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
For example, given the following matrix:
*/