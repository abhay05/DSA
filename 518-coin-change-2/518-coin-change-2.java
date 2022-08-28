class Solution {
    public int change(int amount, int[] coins1) {
        if(amount==0)return 1;
        int n=coins1.length;
        int dp[][]=new int[amount+1][n+1];
        dp[0][0]=1;
        for(int i=0;i<=n;i++){
            dp[0][i]=1;
            
        }
        int coins[]=new int[n+1];
        coins[0]=0;
        for(int i=1;i<=n;i++){
            coins[i]=coins1[i-1];
            
        }
        for(int i=1;i<=amount;i++){
            for(int j=1;j<=n;j++){
                int cnt=1;
                while(i-cnt*coins[j]>=0){
                    dp[i][j]+=dp[i-cnt*coins[j]][j-1];
                    
                   // System.out.println(i+" "+j+" "+dp[i][j]+" "+cnt+" "+coins[j]+" "+dp[i-cnt*coins[j]][j-1]);
                    cnt++;
                }
                dp[i][j]+=dp[i][j-1];
            }
            //System.out.println(dp[i]);
        }

        return dp[amount][n];
    }
}