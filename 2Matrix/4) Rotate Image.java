public static void rotate(int[][] matrix) {
    int n=matrix.length;
    if(n<=1) return;
    for(int i=0; i<n/2; i++){
        for(int j=i; j<n-1-i; j++){
            int swap =matrix[j][i];
            matrix[j][i]=matrix[n-1-i][j];
            matrix[n-1-i][j]=matrix[n-1-j][n-1-i];
            matrix[n-1-j][n-1-i]=matrix[i][n-1-j];
            matrix[i][n-1-j]=swap;
        }
    }
}