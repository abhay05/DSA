class Solution {
    
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n=obstacleGrid.length;
        int m=obstacleGrid[0].length;
      for(int i=0;i<n;i++){
          for(int j=0;j<obstacleGrid[0].length;j++){
              if(obstacleGrid[i][j]==1){
                  obstacleGrid[i][j]=-1;
              }
          }
      }
        if(obstacleGrid[0][0]==-1){
            obstacleGrid[0][0]=0;
           // System.out.println("hello");
        }else{
          obstacleGrid[0][0]=1;}
        
          for(int j=1;j<m;j++){
              if(obstacleGrid[0][j]==-1)obstacleGrid[0][j]=0;
              else{
              obstacleGrid[0][j]=obstacleGrid[0][j-1];}
          }
          
          for(int j=1;j<n;j++){
              if(obstacleGrid[j][0]==-1)obstacleGrid[j][0]=0;
              else{
              obstacleGrid[j][0]=obstacleGrid[j-1][0];}
          }
          
          for(int i=1;i<n;i++){
              for(int j=1;j<m;j++){
                  if(obstacleGrid[i][j]==-1)obstacleGrid[i][j]=0;
                  else{
                  obstacleGrid[i][j]=obstacleGrid[i-1][j]+obstacleGrid[i][j-1];
                  }
              }
          }
          return obstacleGrid[n-1][m-1];
      
    }
}