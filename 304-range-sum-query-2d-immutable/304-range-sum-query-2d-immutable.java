class NumMatrix {
    int[][] matrixy=null;
    public NumMatrix(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                matrix[i][j]+=matrix[i][j-1];
            }
        }
        
        for(int j=0;j<matrix[0].length;j++){
            for(int i=1;i<matrix.length;i++){
                matrix[i][j]+=matrix[i-1][j];
            }
        }
        matrixy=matrix;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int x=0;
        int y=0;
        int z=0;
        if(row1-1>=0 && col1-1>=0){
            x=matrixy[row1-1][col1-1];
        }
        if(row1-1>=0){
            y=matrixy[row1-1][col2];
        }
        if(col1-1>=0){
            z=matrixy[row2][col1-1];
        }
        return matrixy[row2][col2]+x-y-z;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */