class Solution {
    
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int [] dp=new int[amount+1];
        //dp[0][0]=1;
        for(int i=0;i<=amount;i++){
           // for(int j=0;j<=n;j++){
                dp[i]=1000000000;
           // }
        }
        for(int i=0;i<n;i++){
            dp[0]=0;
        }
        for(int i=1;i<=amount;i++){
            for(int j=0;j<n;j++){
                if(i>=coins[j]){
                dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
         //   System.out.println(i+" "+dp[i]);
        }
        int ans=dp[amount];
        // for(int i=0;i<=n;i++){
        //    // System.out.println()
        //     ans=Math.min(ans,dp[amount][i]);
        // }
        if(ans==1000000000) return -1;
        return ans;
    }
}