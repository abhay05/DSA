class Solution {
    int[] dp=new int[5001];
    int recur(int ind,int n,int[] prices){
        if(ind>=n){
            return 0;
        }
        if(dp[ind]!=-1)return dp[ind];
        int ans=0;
        int indn=ind;
        while(ind+1<n && prices[ind]>=prices[ind+1]){ind++;}
        int st=ind;
        while(ind+2<n && prices[ind]<prices[ind+2]){
           ans=Math.max(ans,recur(ind+2,n,prices)+prices[ind]-prices[st]);
            ind++;
        }
        ans=Math.max(ans,recur(ind+2,n,prices)+prices[ind]-prices[st]);
        if(ind+1<n){
        ans=Math.max(ans,recur(ind+3,n,prices)+prices[ind+1]-prices[st]);}
        dp[indn]=ans;
        return ans;
    }
    
    public int maxProfit(int[] prices) {
        int ans=0;
        int ind=0;
        for(int i=0;i<prices.length;i++){
            dp[i]=-1;
        }
       ans= recur(ind,prices.length,prices);
        return ans;
    }
}