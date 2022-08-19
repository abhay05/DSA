class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int[][] dp=new int[values.length][2];
        int n=values.length;
        dp[0][0]=0;
        dp[0][1]=values[0]-0;
        int ans=dp[0][1];
        for(int i=1;i<n;i++){
            dp[i][0]=Math.max(dp[i-1][0],values[i-1]+i-1);
            dp[i][1]=values[i]-i;
            ans=Math.max(ans,dp[i][1]+dp[i][0]);
        }
        return ans;
    }
}