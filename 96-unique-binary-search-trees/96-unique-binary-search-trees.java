class Solution {
    
    int[][] dp = new int[20][20];
    
    public int countTrees(int lo,int up){
        if(lo>=up)return 1;
        if(dp[lo][up]!=-1)return dp[lo][up];
        int ans=0;
        for(int i=lo;i<=up;i++){
            ans+=countTrees(lo,i-1)*countTrees(i+1,up);
        }
        dp[lo][up]=ans;
        return ans;
    }
    
    public int numTrees(int n) {
        if(n==1)return 1;
        for(int i=0;i<20;i++){
            for(int j=0;j<20;j++){
                dp[i][j]=-1;
            }
        }
        return countTrees(1,n); 
    }
}