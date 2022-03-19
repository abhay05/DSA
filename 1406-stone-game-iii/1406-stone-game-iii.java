// Alice - x , Bob - y
// if(x-y>0) Alice
// if(x-y<0) Bob
// if(x-y==0) Tie


class Solution {
    
    public String stoneGameIII(int[] arr) {
        int n=arr.length;
        int[] dp= new int[4];
        dp[0]=0;
        dp[2]=0;
        dp[1]=0;
        dp[3]=0;
        // for(int i=n-2;i>=0;i--){
        //     dp[i]=-1;
        // }
        for(int ind=n-1;ind>=0;ind--){
            int x1=ind+1<=n?arr[ind]-dp[(ind+1)%4]:-1001;
            int x2=ind+2<=n?arr[ind]+arr[ind+1]-dp[(ind+2)%4]:-1001;
            int x3=ind+3<=n?arr[ind]+arr[ind+1]+arr[ind+2]-dp[(ind+3)%4]:-1001;
            int ans=Math.max(x1,Math.max(x2,x3));
            dp[ind%4]=ans;
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