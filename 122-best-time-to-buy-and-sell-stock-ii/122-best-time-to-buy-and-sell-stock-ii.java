class Solution {
    public int maxProfit(int[] prices) {
        int ans=0;
        int i=0;
        int st=0;
        int end=0;
        int n=prices.length;
        while(i<n){
            while(i+1<n && prices[i]>=prices[i+1]){
                i++;
            }
            st=prices[i];
            while(i+1<n && prices[i]<prices[i+1]){
                i++;
            }
            end=prices[i];
            ans+=(end-st);
           // System.out.println(i);
            i++;
        }
        return ans;
    }
}