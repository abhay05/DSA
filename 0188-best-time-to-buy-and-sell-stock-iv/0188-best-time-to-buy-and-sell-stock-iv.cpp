class Solution {
public:
    int dp[1001][101][2];
    int recur(vector<int>&prices,int ind,int k,int n,int type){
      //   cout<<ind<<' '<<k<<' '<<type<<' '<<n<<' '<<'\n';
        if(k==0)return 0;
        if(ind>=n)return 0;
        if(dp[ind][k][type]!=-1)return dp[ind][k][type];
        int ans=0;
        ans=max(recur(prices,ind+1,k,n,type),recur(prices,ind+1,k-type,n,1-type)+prices[ind]*(type==0?-1:1));
     //   cout<<ind<<' '<<k<<' '<<type<<' '<<ans<<'\n';
        dp[ind][k][type]=ans;
        return ans;
        
    }
    int maxProfit(int k, vector<int>& prices) {
        int n=prices.size();
        for(int i=0;i<n;i++){
            for(int j=0;j<=k;j++){
                for(int k=0;k<2;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        return recur(prices,0,k,n,0);
    }
};