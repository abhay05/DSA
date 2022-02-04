class Solution {
    public boolean canJump(int[] nums) {
        int maxL=0;
        int n=nums.length;
        for(int i=0;i<n && i<=maxL;i++){
            maxL=Math.max(maxL,nums[i]+i);
        }
        return maxL>=n-1;
    }
}