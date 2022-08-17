class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int[] dp=new int[nums.length];
        int[] dp1=new int[nums.length];
        int n=nums.length;
        
        int sum=0;
        
        for(int i=0;i<n;i++){
            dp1[i]=30001;
            dp[i]=-30001;
            sum+=nums[i];
        }
        dp[0]=nums[0];
        dp1[n-1]=nums[n-1];
        
        for(int i=1;i<n;i++){
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
        }
        
        for(int i=n-2;i>=0;i--){
            dp1[i]=Math.min(dp1[i+1]+nums[i],nums[i]);
        }
        
        int ans=-30001;
        for(int i=0;i<n;i++){
          //  System.out.println(i+" "+ans+" "+dp[i]+" "+(sum-dp1[i]));
            if(sum-dp1[i]>0){
            ans=Math.max(ans,Math.max(dp[i],sum-dp1[i]));
            }else{
                ans=Math.max(ans,dp[i]);
            }
           // System.out.println(i+" "+ans);
        }
        return ans;
    }
}