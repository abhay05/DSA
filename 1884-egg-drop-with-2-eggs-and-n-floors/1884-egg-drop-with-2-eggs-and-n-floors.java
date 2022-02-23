class Solution {
    
    int[][] dp= new int[1001][2];
    
    public int getEggs(int n,int i,int eggs){
        if(i==n && eggs==1){
            return 0;
        }
        if(eggs==0){
            return 0;
        }
        if(dp[i][eggs]!=-1){return dp[i][eggs];}
        int maxi=1000000000;
        for(int j=i+1;j<=n;j++){
           maxi=Math.min(maxi,Math.max(getEggs(n,j,1)+1,getEggs(n,j,0)+j-i));
            
        }
        dp[i][eggs]=maxi;
        return maxi;
    }
    
    public int twoEggDrop(int n) {
        for(int i=0;i<1001;i++){
            dp[i][0]=-1;
            dp[i][1]=-1;
        }
        //return getEggs(n,0,1);
        int ans=0;
        while((ans*(ans+1))/2<n){
            ans++;
        }
        return ans;
    }
}