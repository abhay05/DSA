// Alice - x , Bob - y
// if(x-y>0) Alice
// if(x-y<0) Bob
// if(x-y==0) Tie


class Solution {
    
    public String stoneGameIII(int[] stoneValue) {
        int n=stoneValue.length;
        int [] arr=stoneValue;
        int[] dp= new int[n+4];
        dp[n]=0;
        dp[n+2]=0;
        dp[n+1]=0;
        dp[n-1]=-1;
        for(int i=n-2;i>=0;i--){
            dp[i]=-1;
        }
        for(int ind=n-1;ind>=0;ind--){
            int x1=ind+1<=n?arr[ind]-dp[ind+1]:-1001;
            int x2=ind+2<=n?arr[ind]+arr[ind+1]-dp[ind+2]:-1001;
            int x3=ind+3<=n?arr[ind]+arr[ind+1]+arr[ind+2]-dp[ind+3]:-1001;
            int ans=Math.max(x1,Math.max(x2,x3));
            dp[ind]=ans;
        }
        int val=dp[0];
        if(val>0){
            return "Alice";
        }
        if(val==0){
            return "Tie";
        }
        return "Bob";
    }
}