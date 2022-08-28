class Solution {
    public int combinationSum4(int[] nums, int target) {
        int amount=target;
        int[] coins=new int [nums.length];
        coins=nums;
        int n=coins.length;
        int dp[]=new int[amount+1];
        dp[0]=1;
        for(int i=1;i<=amount;i++){
            for(int j=0;j<n;j++){
                int cnt=1;
                if(i-cnt*coins[j]>=0){
                    dp[i]+=dp[i-cnt*coins[j]];
                 //   System.out.println(i+" "+dp[i]+" "+cnt+" "+coins[j]+" "+dp[i-cnt*coins[j]])
                //    cnt++;
                }
            }
           // System.out.println(dp[i]);
        }
        return dp[amount];
    }
}