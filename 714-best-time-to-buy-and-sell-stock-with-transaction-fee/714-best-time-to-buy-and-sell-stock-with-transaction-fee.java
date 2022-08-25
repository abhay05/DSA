class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n=prices.length;
        int dp[]=new int[n],dp1[]=new int[n];
        dp[0]=-prices[0];
        dp1[0]=0;
        for(int i=1;i<n;i++){
            dp[i]=Math.max(dp[i-1],dp1[i-1]-prices[i]);
            dp1[i]=Math.max(dp1[i-1],dp[i-1]+prices[i]-fee);
        }
        
        return dp1[n-1];
    }
}