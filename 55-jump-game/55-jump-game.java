class Solution {
    public boolean canJump(int[] nums) {
        int maxL=0;
        for(int i=0;i<nums.length;i++){
            if(i>maxL)return false;
            maxL=Math.max(maxL,nums[i]+i);
        }
        return true;
    }
}