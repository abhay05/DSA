class Solution {
    public int jump(int[] nums) {
        int ans=0;
        int curr=0;
        int maxL=0;
        for(int i=0;i<nums.length;i++){
            if(i>curr){
                curr=maxL;
                ans++;
            }
            if(curr>nums.length)break;
            maxL=Math.max(maxL,i+nums[i]);
        }
        return ans;
    }
}