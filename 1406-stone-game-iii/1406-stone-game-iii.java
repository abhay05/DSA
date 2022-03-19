class Solution {
    
    public String stoneGameIII(int[] stoneValue) {
        int n=stoneValue.length;
        int [] arr=stoneValue;
        int [] cumsum = new int[n+3];
        int[] dp= new int[n+4];
        cumsum[n]=-1001;
        cumsum[n+1]=-1001;
        cumsum[n+2]=-1001;
        cumsum[n-1]=stoneValue[n-1];
        dp[n]=-1001;
        dp[n+2]=-1001;
        dp[n+1]=-1001;
        dp[n-1]=-1;
        for(int i=n-2;i>=0;i--){
            cumsum[i]=(cumsum[i+1]+stoneValue[i]);
            dp[i]=-1;
        }
        for(int ind=n-1;ind>=0;ind--){
            int x1=ind+1<=n?arr[ind]+cumsum[ind+1]-dp[ind+1]:-1001;
            int x2=ind+2<=n?arr[ind]+arr[ind+1]+cumsum[ind+2]-dp[ind+2]:-1001;
            int x3=ind+3<=n?arr[ind]+arr[ind+1]+arr[ind+2]+cumsum[ind+3]-dp[ind+3]:-1001;
            int ans=Math.max(x1,Math.max(x2,x3));
            dp[ind]=ans;
        }
        int val=dp[0];
        int total=0;
        for(int i=0;i<stoneValue.length;i++){
            total+=stoneValue[i];
        }
        if(val>total-val){
            return "Alice";
        }
        if(val==total-val){
            return "Tie";
        }
        return "Bob";
    }
}