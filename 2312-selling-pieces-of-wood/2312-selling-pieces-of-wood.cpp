class Solution {
public:
    long long sellingWood(int m, int n, vector<vector<int>>& prices) {
        long long dp[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                dp[i][j]=0;
            }
        }
        dp[0][0]=(long long)0;
        long long ans=0;
        for(int i=0;i<prices.size();i++){
            int tempm=prices[i][0];
            int tempn=prices[i][1];
            int price=prices[i][2];
            dp[tempm][tempn]=(long long)price;
        }
            for(int k=0;k<=m;k++){
                for(int j=0;j<=n;j++){
                    for(int kk=0;kk<=k/2;kk++){
                        dp[k][j]=max(dp[k][j],dp[k-kk][j]+dp[kk][j]);
                    }
                    for(int jj=0;jj<=j/2;jj++){
                        dp[k][j]=max(dp[k][j],dp[k][j-jj]+dp[k][jj]);
                    }                   
                }
            }
        return dp[m][n];
    }
};