class Solution {
    
    int[] diri=new int[]{-1,1,0,0};
    int[] dirj=new int[]{0,0,-1,1};
    
    void zero(int[][] visited,int n,int m){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                visited[i][j]=0;
            }
        }
    }
    
    int countIslands(int[][] grid, int[][] visited,int n,int m){
        zero(visited,n,m);
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && visited[i][j]==0){
                    dfs(grid,visited,i,j,n,m);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    
    void dfs(int[][] grid,int[][] visited,int i,int j,int n,int m){
        visited[i][j]=1;
        for(int ind=0;ind<4;ind++){
            int newi=i+diri[ind];
            int newj=j+dirj[ind];
            if(newi>=0 && newi<n && newj>=0 && newj<m && grid[newi][newj]==1 && visited[newi][newj]==0){
                dfs(grid,visited,newi,newj,n,m);
            }
        }
    }
    
    public int minDays(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int cnt=0;
        int[][] visited = new int[n][m];
        zero(visited,n,m);
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && visited[i][j]==0){
                 //   zero(visited,n,m);
                    
                    dfs(grid,visited,i,j,n,m);
                    cnt++;
                }
            }
        }
        if(cnt>1 || cnt==0)return 0;
        cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    grid[i][j]=0;
                    int islandscnt=countIslands(grid,visited,n,m);
                    if(islandscnt>1 || islandscnt==0){
                        return 1;
                    }
                    grid[i][j]=1;
                }
            }
        }
        
        return 2;
        
    }
}