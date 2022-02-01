class Solution {
    int[] dp = new int[10002];
    int recur(int[] nums, int ind,int cnt){
        if(ind>=nums.length){
            return 1000000000;
        }
        if(ind==nums.length-1){
            return cnt;
        }
        if(dp[ind]!=-1)return dp[ind];
        int ans=1000000000;
        for(int i=1;i<=nums[ind];i++){
            ans=Math.min(ans,recur(nums,ind+i,0));
        }
        dp[ind]=ans+1;
        return ans+1;
    }
    
    public int jump(int[] nums) {
        for(int i=0;i<=10000;i++){
            dp[i]=-1;
        }
        return recur(nums,0,0);
    }
}