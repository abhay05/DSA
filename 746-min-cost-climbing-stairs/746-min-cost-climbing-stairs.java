class Solution {
    public int minCostClimbingStairs(int[] costn) {
        int[] dp=new int[costn.length+1];
        int[] cost=new int[costn.length+1];
        for(int i=0;i<costn.length;i++){
            cost[i]=costn[i];    
        }
        cost[costn.length]=0;
        dp[0]=cost[0];
        dp[1]=cost[1];
        for(int i=2;i<cost.length;i++){
            dp[i]=Math.min(dp[i-2],dp[i-1])+cost[i];
        }
        return dp[cost.length-1];
    }
}