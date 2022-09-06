class Solution {
public:
    int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int k) {
        int dp[101];
        int dp1[101];
        for(int i=0;i<101;i++){
            dp[i]=1000000000;
            dp1[i]=1000000000;
        }
        dp[src]=0;
        dp1[src]=0;
        for(int i=0;i<=k;i++){
            for(int j=0;j<flights.size();j++){
                int u=flights[j][0];
                int v=flights[j][1];
                int val=flights[j][2];
                if(dp1[v]>dp[u]+val){
                    dp1[v]=val+dp[u];
                }
            }
            for(int i=0;i<n;i++){
                dp[i]=dp1[i];
            }
        }
        return dp[dst]==1000000000?-1:dp[dst];
    }
};