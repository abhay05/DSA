class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==1)return 0;
        int n=prices.length;
        int mini=prices[0];
        int ans=0;
        for(int i=1;i<n;i++){
            ans=Math.max(ans,prices[i]-mini);
            mini=Math.min(mini,prices[i]);
        }
        return ans;
    }
}