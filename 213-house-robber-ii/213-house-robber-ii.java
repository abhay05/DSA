class Solution {
    public int rob(int[] nums) {
        int[][] dp=new int[nums.length][2];
        dp[0][0]=0;
        dp[0][1]=nums[0];
        if(nums.length>1){
            dp[1][0]=nums[1];
            dp[1][1]=Math.max(nums[1],dp[0][1]);   
        }else{
            return dp[0][1];
        }
        if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        for(int i=2;i<nums.length;i++){
            for(int j=0;j<2;j++){
                dp[i][j]=Math.max(dp[i-1][j],dp[i-2][j]+nums[i]);
            }
        }
        return Math.max(dp[nums.length-2][1],dp[nums.length-1][0]);
    }
}