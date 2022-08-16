class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] num10=new int[10001];
        int[] dp=new int[10001];
        for(int i=0;i<nums.length;i++){
            num10[nums[i]]++;
        }
        dp[0]=num10[0]*0;
        dp[1]=num10[1]*1;
        for(int i=2;i<=10000;i++){
            dp[i]=Math.max(dp[i-2]+i*num10[i],dp[i-1]);
            }
        return dp[10000];
    }
}