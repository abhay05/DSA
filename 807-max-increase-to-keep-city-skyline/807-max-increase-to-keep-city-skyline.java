class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n=grid.length;
        int[] horimax=new int[grid[0].length];
        for(int i=0;i<n;i++){
            int ans=0;
            for(int j=0;j<n;j++){
               ans= Math.max(ans,grid[i][j]);
            }
            horimax[i]=ans;
        }
        
        int[] vertmax=new int[grid.length];
        for(int i=0;i<n;i++){
            int ans=0;
            for(int j=0;j<n;j++){
               ans= Math.max(ans,grid[j][i]);
            }
            vertmax[i]=ans;
        }
        
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                ans+=(Math.min(horimax[i],vertmax[j])-grid[i][j]);
            }
        }
        return ans;
        
    }
}