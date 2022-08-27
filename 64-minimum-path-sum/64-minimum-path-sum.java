class Solution {
    public int minPathSum(int[][] grid) {
     int ans=0;
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0)continue;
                grid[i][j]=Math.min(((i-1)>=0?grid[i-1][j]:1000000000),((j-1)>=0?grid[i][j-1]:1000000000))+grid[i][j];
            }
        }
        return grid[n-1][m-1];
    }
}