class Solution {
    public int integerBreak(int n) {
        int []dp=new int[n+1];
        for(int i=1;i<=n;i++){
            int ans=1;
            for(int j=1;j<i;j++){
                ans=Math.max(ans,Math.max(j,dp[j])*Math.max(i-j,dp[i-j]));
            }
            dp[i]=ans;
        }
        return dp[n];
    }
}